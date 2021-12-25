package com.yasintorun.poolManagement.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yasintorun.poolManagement.business.abstracts.ImageService;
import com.yasintorun.poolManagement.business.abstracts.UserService;
import com.yasintorun.poolManagement.business.constants.Messages;
import com.yasintorun.poolManagement.core.business.BusinessRules;
import com.yasintorun.poolManagement.core.business.exceptions.EntityNotFound;
import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.ErrorDataResult;
import com.yasintorun.poolManagement.core.utilities.results.ErrorResult;
import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.core.utilities.results.SuccessDataResult;
import com.yasintorun.poolManagement.core.utilities.results.SuccessResult;
import com.yasintorun.poolManagement.dataAccess.abstracts.UserDao;
import com.yasintorun.poolManagement.entities.concretes.Image;
import com.yasintorun.poolManagement.entities.concretes.User;

@Service
public class UserManager implements UserService {
	private UserDao userDao;
	private ImageService imageService;

	@Autowired
	public UserManager(UserDao userDao, ImageService imageService) {
		super();
		this.userDao = userDao;
		this.imageService = imageService;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), Messages.userListed);
	}

	@Override
	public DataResult<User> add(User entity) {
		User addUser = this.userDao.save(entity);
		return new SuccessDataResult<User>(addUser, Messages.userAdded);
	}

	@Override
	public DataResult<User> update(User entity) {
		User updateUser = this.userDao.save(entity);
		return new SuccessDataResult<User>(updateUser, Messages.userUpdated);
	}

	@Override
	public Result delete(User entity) throws Exception {
		if(!this.userDao.existsByUserId(entity.getUserId())) {
			throw new EntityNotFound("user");
		}
		this.userDao.delete(entity);
		return new SuccessResult(Messages.userDeleted);
	}

	@Override
	public Result validate(User user) {
		Result result = BusinessRules.Run(isNull(user));
		if(result != null) {
			return result;
		}
		return new SuccessResult();
	}
	
	public Result isNull(User user) {
		if(user.getFirstname().isBlank() || user.getLastname().isBlank()) {
			return new ErrorResult("Tüm alanlar zorunludur");
		}
		return new SuccessResult();
	}

	@Override
	public DataResult<User> getById(int userId) {
		User user = this.userDao.getByUserId(userId);
		if(user == null) {
			return new ErrorDataResult<User>(Messages.userNotFound);
		}
		user.getAccount().setPassword(null);
		return new SuccessDataResult<User>(user, Messages.userGot);
	}

	@Override
	public DataResult<User> getByAccountId(int accountId) throws Exception {
		User user = this.userDao.getByAccount_AccountId(accountId);
		if(user == null) {
			return new ErrorDataResult<User>(Messages.userNotFound);
		}
		user.getAccount().setPassword(null);
		return new SuccessDataResult<User>(user, Messages.userGot);
	}

	@Override
	public int totalUserCount() {
		return this.userDao.findAll().size();
	}

	@Override
	public Result updateProfilePhoto(MultipartFile file, int userId) throws Exception {
		User user = this.userDao.findById(userId).get();
		if(user == null) {
			return new ErrorResult(Messages.userNotFound);
		}
		DataResult<Image> addedImage = this.imageService.UploadImage(file, "users");
		
		if(addedImage.isSuccess() && addedImage.getData() != null) {
			user.setImage(addedImage.getData());
			this.userDao.save(user);
			return new SuccessResult("Profil Fotoğrafı Güncellendi");
		}
		return addedImage;
		
	}
	
	
	
}

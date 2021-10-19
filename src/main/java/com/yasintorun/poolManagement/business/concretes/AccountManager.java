package com.yasintorun.poolManagement.business.concretes;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yasintorun.poolManagement.business.abstracts.AccountService;
import com.yasintorun.poolManagement.business.constants.Messages;
import com.yasintorun.poolManagement.core.business.BusinessRules;
import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.ErrorDataResult;
import com.yasintorun.poolManagement.core.utilities.results.ErrorResult;
import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.core.utilities.results.SuccessDataResult;
import com.yasintorun.poolManagement.core.utilities.results.SuccessResult;
import com.yasintorun.poolManagement.core.utilities.security.HashingHelper;
import com.yasintorun.poolManagement.dataAccess.abstracts.AccountDao;
import com.yasintorun.poolManagement.entities.concretes.Account;
import com.yasintorun.poolManagement.entities.dtos.ChangePasswordDto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service
public class AccountManager implements AccountService {
	private AccountDao accountDao;
	
	@Autowired
	public AccountManager(AccountDao accountDao) {
		super();
		this.accountDao = accountDao;
	}
	@Override
	public DataResult<List<Account>> getAll() {
		List<Account> accounts = null;
		accounts = this.accountDao.findAll();
		return new SuccessDataResult<List<Account>>(accounts, Messages.accountListed);
	}
	@Override
	public DataResult<Account> add(Account entity) {
		Account addedAccount = this.accountDao.save(entity);
		return new SuccessDataResult<Account>(addedAccount, Messages.accountAdded);
	}
	@Override
	public DataResult<Account> update(Account entity) {
		Account updatedAccount = this.accountDao.save(entity);
		return new SuccessDataResult<Account>(updatedAccount, Messages.accountUpdated);
	}
	@Override
	public Result delete(Account entity) {
		this.accountDao.delete(entity);
		return new SuccessResult(Messages.accountDeleted);
	}
	@Override
	public DataResult<Account> getByEmail(String email) throws Exception {
		Account account = this.accountDao.getByEmail(email);
		if(account != null) {
			return new SuccessDataResult<Account>(account, Messages.accountGetByEmail);			
		}
		return new ErrorDataResult<Account>(null, Messages.accountNotFound);
	}
	
	
	
	public Result emailCheck(String email) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if(!matcher.matches()) {
			return new ErrorResult("Email hatalı");
		}
		return new SuccessResult();
	}
	
	public Result isNull(Account account) {
		if(account.getEmail().isBlank() || account.getPassword().isBlank()) {
			return new ErrorResult("Tüm alanları doldurunuz.");
		}
		return new SuccessResult();
	}
	public Result isExists(String email) {
		if(this.accountDao.existsByEmail(email)) {
			return new ErrorResult(Messages.emailUsed);
		}
		return new SuccessResult();
	}
	@Override
	public Result validate(Account account) throws Exception {
		Result result = BusinessRules.Run(isNull(account), emailCheck(account.getEmail()), isExists(account.getEmail()));
		if(result != null) {
			return result;
		}
		return new SuccessResult();
	}
	@Override
	public Result changePassword(ChangePasswordDto changePasswordDto) throws Exception {
		if(!changePasswordDto.getNewPassword().equals(changePasswordDto.getNewPasswordRepeat())) {
			return new ErrorResult(Messages.passwordNotMatch);
		}
		
		Account currentAccount = this.accountDao.getById(changePasswordDto.getAccountId());
		
		if(currentAccount == null) {
			return new ErrorResult(Messages.accountNotFind);
		}
		
		if(!HashingHelper.VerifyPasswordHash(changePasswordDto.getOldPassword(), currentAccount.getPassword())) {
			return new ErrorResult(Messages.oldPasswordError);
		}
		
		currentAccount.setPassword(HashingHelper.CreatePasswordHash(changePasswordDto.getNewPassword()));
		
		this.accountDao.save(currentAccount);
		
		return new SuccessResult(Messages.passwordChangeSuccessFully);	
	}
}

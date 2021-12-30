package com.yasintorun.poolManagement.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yasintorun.poolManagement.business.abstracts.ImageService;
import com.yasintorun.poolManagement.business.abstracts.PoolImageService;
import com.yasintorun.poolManagement.business.abstracts.PoolService;
import com.yasintorun.poolManagement.business.constants.Messages;
import com.yasintorun.poolManagement.core.business.exceptions.EntityNotFound;
import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.ErrorDataResult;
import com.yasintorun.poolManagement.core.utilities.results.ErrorResult;
import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.core.utilities.results.SuccessDataResult;
import com.yasintorun.poolManagement.core.utilities.results.SuccessResult;
import com.yasintorun.poolManagement.dataAccess.abstracts.PoolDao;
import com.yasintorun.poolManagement.entities.concretes.Image;
import com.yasintorun.poolManagement.entities.concretes.Pool;
import com.yasintorun.poolManagement.entities.concretes.PoolImage;
import com.yasintorun.poolManagement.entities.dtos.PoolDto;

@Service
public class PoolManager implements PoolService {
	private PoolDao poolDao;
	private PoolImageService poolImageService;
	private ImageService imageService;
	
	@Autowired
	public PoolManager(PoolDao poolDao, PoolImageService poolImageService, ImageService imageService) {
		super();
		this.poolDao = poolDao;
		this.poolImageService = poolImageService;
		this.imageService = imageService;
	}

	@Override
	public DataResult<List<Pool>> getAll() throws Exception {
		Sort sort = Sort.by(Sort.Direction.ASC, "poolId");
		return new SuccessDataResult<List<Pool>>(this.poolDao.findAll(sort), Messages.poolListed);
	}

	@Override
	public DataResult<Pool> add(Pool entity) throws Exception {
		if(entity.getPoolAddress().isBlank() || entity.getPoolName().isBlank()) {
			return new ErrorDataResult<Pool>(Messages.allFieldRequired);
		}
		
		Pool addedPool = this.poolDao.save(entity);
		
		return new SuccessDataResult<Pool>(addedPool, Messages.poolAdded);
	}

	@Override
	public DataResult<Pool> update(Pool entity) throws Exception {
		if(!this.poolDao.existsByPoolId(entity.getPoolId())) {
			throw new EntityNotFound("pool");
		}
		
		Pool updatedPool = this.poolDao.save(entity);
		
		return new SuccessDataResult<Pool>(updatedPool, Messages.poolUpdated);
	}

	@Override
	public Result delete(Pool entity) throws Exception {
		if(!this.poolDao.existsByPoolId(entity.getPoolId())) {
			throw new EntityNotFound("pool");
		}
		this.poolDao.delete(entity);
		return new SuccessResult(Messages.poolDeleted);
	}

	@Override
	public DataResult<List<PoolDto>> getAllWithImages() throws Exception {
		List<PoolDto> poolDto = new ArrayList<PoolDto>();
		List<Pool> pools = this.getAll().getData();
		
		for(Pool p : pools) {
			List<PoolImage> poolImages = this.poolImageService.getByPool_PoolId(p.getPoolId()).getData();
			List<Image> imagePaths = new ArrayList<Image>();
			
			for(PoolImage pi : poolImages) {
				imagePaths.add(pi.getImage());
			}
			
			poolDto.add(new PoolDto(p, imagePaths));
		}
		
		return new SuccessDataResult<List<PoolDto>>(poolDto, "Havuzlar listelendi");
	}

	@Override
	public int getPoolCount() throws Exception {
		return this.poolDao.findAll().size();
	}

	@Override
	public Result uploadPoolImages(MultipartFile file, int poolId) throws Exception {
		Pool pool = this.poolDao.findById(poolId).get();
		if(pool == null) {
			return new ErrorResult("Havuz bulunamadı");
		}
		DataResult<Image> addedImage = this.imageService.UploadImage(file, "pools");
		if(addedImage.isSuccess() && addedImage.getData() != null) {
			poolImageService.add(new PoolImage(0, addedImage.getData(), pool));
			return new SuccessResult("Havuz fotoğrafı yüklendi");
		}
		return addedImage;
	}

	@Override
	public Result deletePoolImage(int poolId, int imageId) throws Exception {
		Pool pool = this.poolDao.findById(poolId).get();
		PoolImage pi = this.poolImageService.getByPoolIdAndImageId(poolId, imageId).getData();
		if(pool == null || pi == null) {
			return new ErrorResult("Hata Oluştu..");
		}
		this.poolImageService.delete(pi);
		this.imageService.deleteImage(imageId);
		return new SuccessResult("Havuz fotoğrafı silindi");
	}
}

package com.yasintorun.poolManagement.business.concretes;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yasintorun.poolManagement.business.adapters.abstracts.ImageService;
import com.yasintorun.poolManagement.core.utilities.helpers.DateHelper;
import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.ErrorDataResult;
import com.yasintorun.poolManagement.core.utilities.results.ErrorResult;
import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.core.utilities.results.SuccessDataResult;
import com.yasintorun.poolManagement.core.utilities.results.SuccessResult;
import com.yasintorun.poolManagement.dataAccess.abstracts.ImageDao;
import com.yasintorun.poolManagement.entities.concretes.Image;

@Service
public class ImageManager implements com.yasintorun.poolManagement.business.abstracts.ImageService{
	private ImageDao imageDao;
	private ImageService imageService;
	@Autowired
	public ImageManager(ImageDao imageDao, ImageService imageService) {
		super();
		this.imageDao = imageDao;
		this.imageService = imageService;
	}

	@Override
	public DataResult<Image> UploadImage(MultipartFile imageFile, String folderName) throws IOException {
		Map result = imageService.upload(imageFile, folderName);
		if(result != null) {
			try {
				
				Image image = new Image();
				image.setImagePath(result.get("url").toString());
				image.setImageName(result.get("original_filename").toString());
				image.setCreatedAt(DateHelper.GetDateTime());
				var addedImage = imageDao.save(image);
				return new SuccessDataResult<Image>(addedImage, "Fotoğraf yüklendi");
			} catch(Exception e) {
				return new ErrorDataResult<Image>("Fotoğraf yüklenirken hata oluştu");
			}
		}
		return new ErrorDataResult<Image>("Servis hatası");
	}

	@Override
	public DataResult<Image> getImage(int id) throws IOException {
		return new SuccessDataResult<Image>(this.imageDao.getById(id));
	}
	
}

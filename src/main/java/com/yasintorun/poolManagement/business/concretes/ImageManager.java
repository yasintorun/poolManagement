package com.yasintorun.poolManagement.business.concretes;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yasintorun.poolManagement.business.adapters.abstracts.ImageService;
import com.yasintorun.poolManagement.core.utilities.helpers.DateHelper;
import com.yasintorun.poolManagement.core.utilities.results.ErrorResult;
import com.yasintorun.poolManagement.core.utilities.results.Result;
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
	public Result UploadImage(MultipartFile imageFile) throws IOException {
		Map result = imageService.upload(imageFile, "pools");
		if(result != null) {
			try {
				
				Image image = new Image();
				image.setImagePath(result.get("url").toString());
				image.setImageName(result.get("original_filename").toString());
				image.setCreatedAt(DateHelper.GetDateTime());
				imageDao.save(image);
				return new SuccessResult("Fotoğraf yüklendi");
			} catch(Exception e) {
				return new ErrorResult("Fotoğraf yüklenirken hata oluştu");
			}
		}
		return new ErrorResult("Servis hatası");
	}
	
}

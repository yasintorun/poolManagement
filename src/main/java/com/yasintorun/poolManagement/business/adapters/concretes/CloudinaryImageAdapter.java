package com.yasintorun.poolManagement.business.adapters.concretes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.yasintorun.poolManagement.business.adapters.abstracts.ImageService;

@Service
public class CloudinaryImageAdapter implements ImageService{

	private Cloudinary cloudinary;
	
	
	@Autowired
	public CloudinaryImageAdapter() {
		this.cloudinary = new Cloudinary("cloudinary://786176693537948:gSrrVk-IWUOAWkR85lTMh2UxQyQ@dost");
	}



	@Override
	public Map upload(MultipartFile imageFile, String folderName) throws IOException {
		
		try {
			File file = new File(imageFile.getOriginalFilename());
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(imageFile.getBytes());
			fos.close();
			String folder = "PoolManagement/"+folderName;
			Map result = cloudinary.uploader().upload(file, ObjectUtils.asMap("folder", folder));
			file.delete();
			return result;
		} catch(Exception e) {
			return null;			
		}
		
	}
	
}

package com.yasintorun.poolManagement.business.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.entities.concretes.Image;

public interface ImageService{
	public Result UploadImage(MultipartFile imageFile, String folderName) throws IOException ;
	public DataResult<Image> getImage(int id) throws IOException ;
}

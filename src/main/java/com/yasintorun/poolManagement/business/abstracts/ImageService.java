package com.yasintorun.poolManagement.business.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.yasintorun.poolManagement.core.utilities.results.Result;

public interface ImageService{
	public Result UploadImage(MultipartFile imageFile) throws IOException ;
}

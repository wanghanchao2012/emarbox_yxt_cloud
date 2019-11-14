package com.emarbox.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/sdk/package/")
public class FileController {

	@Value("${file.package.upload.preview_domain}")
	private String imgDomain;
	@Value("${file.package.upload.local_path}")
	private String directory;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> uploadFile(@RequestParam("cuid") Long cuid,
			@RequestParam("file") MultipartFile multipartfile, HttpServletRequest request)
			throws IllegalStateException, IOException {
		log.info("getOriginalFilename:" + multipartfile.getOriginalFilename() + ",getName:" + multipartfile.getName());
		// 保存文件到临时目录
		String savePath = directory + multipartfile.getOriginalFilename();

		File saveFile = new File(savePath);
		if (!saveFile.getParentFile().exists()) {
			saveFile.getParentFile().mkdirs();
		}
		savePath = directory.concat(multipartfile.getOriginalFilename());
		multipartfile.transferTo(new File(savePath));
		log.info(savePath);
		String resultPath = "";
		if (StringUtils.isEmpty(resultPath)) {
			resultPath = imgDomain.concat(multipartfile.getOriginalFilename());
		}
		return new ResponseEntity<String>(resultPath, HttpStatus.OK);
	}

}

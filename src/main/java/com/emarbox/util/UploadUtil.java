package com.emarbox.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Objects;

public class UploadUtil {

	private static final String separator = "/";

	public static String getLocalPath() {
		String dockerImgPath = "/data/dsp/dd_img";
		String suffix = dockerImgPath.substring(dockerImgPath.length() - 1, dockerImgPath.length());
		if (!Objects.equal(suffix, separator)) {
			String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
			dockerImgPath = dockerImgPath.concat(separator).concat(currentDate).concat(separator);
		}
		return dockerImgPath;
	}

	public static String getRemoteUrl(String uploadPath) {
		int splitStartIndex = StringUtils.lastIndexOf(uploadPath, "/dd_img");
		String imgLastPart = StringUtils.substring(uploadPath, splitStartIndex);
		String url = "http://img.emarbox.com".concat(imgLastPart);
		return url;
	}

	/**
	 * 讲一个文件重新命名
	 * @param fileName
	 * @return
	 */
	public static String rename(String fileName) {
		//時分秒
		String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss"));
		//随机16位字符和数字组合的字符串
		return currentDate.concat(RandomStringUtils.randomAlphanumeric(16)).concat(".").concat(getFileSuffix(fileName));
	}

	/**
	 * 获取文件名称后缀
	 *
	 * @param fileContentType 根据file的文件类型
	 * @return
	 */
	public static String getFileSuffix(String fileContentType) {
		if (StringUtils.isEmpty(fileContentType)) {
			return null;
		}
		String postfix = fileContentType.substring(fileContentType.lastIndexOf(".") + 1, fileContentType.length());
		postfix = postfix.toLowerCase();
		return postfix;
	}
	
}

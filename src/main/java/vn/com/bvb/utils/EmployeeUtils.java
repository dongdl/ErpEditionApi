package vn.com.bvb.utils;

import org.apache.commons.lang3.RandomStringUtils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class EmployeeUtils {

	public static String generateEmployeeCode() {
		return RandomStringUtils.randomNumeric(10);
	}
}

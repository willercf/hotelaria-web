package br.fpu.tcc.hotelaria.utils;

import java.math.BigInteger;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.StringUtils;

public class CipherUtil {

	public static String encryptMd5(String value) throws NoSuchAlgorithmException {

		value = StringUtils.trimToEmpty(value);
		if (StringUtils.isBlank(value)) {
			throw new InvalidParameterException("Parameter value cannot be null.");
		}
		value = StringUtils.trimToEmpty(value);
		MessageDigest md = MessageDigest.getInstance("MD5");
		BigInteger hash = new BigInteger(1, md.digest(value.getBytes()));
		String s = hash.toString(16);
		if (s.length() % 2 != 0) {
			s = "0" + s;
		}
		return s;
	}
}

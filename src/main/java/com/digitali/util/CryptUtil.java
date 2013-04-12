package com.digitali.util;

import java.util.Date;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Utility class for Encryption/Description functionality.
 * 
 * @author vijitha Epa
 * @since October 9 2011
 */

public class CryptUtil {

	private final Logger logger = Logger.getLogger(this.getClass());

	private static CryptUtil criptHelperInstance;
	private SecretKeySpec keySpec;
	private byte[] key;
	private String algorithm;

	/**
	 * Creates a new default instance of Crypt
	 */
	public CryptUtil() {
		this(DESede_KEY, "DESede");
	}

	public static CryptUtil getInstance() {
		if (null == criptHelperInstance) {
			criptHelperInstance = new CryptUtil();
		}
		return criptHelperInstance;
	}

	/**
	 * Creates a new instance of Crypt
	 */
	public CryptUtil(byte[] key, String algorithm) {
		this.key = key;
		this.algorithm = algorithm;
		/*
		 * KeyGenerator kgen = KeyGenerator.getInstance(this.algorithm);
		 * SecretKey skey = kgen.generateKey(); byte[] raw = skey.getEncoded();
		 * this.keySpec = new SecretKeySpec(raw, this.algorithm);
		 */
		this.keySpec = new SecretKeySpec(this.key, this.algorithm);
	}

	/**
	 * Encrypts the give String to an array of bytes
	 */
	public byte[] encryptString(String text) {
		try {
			Cipher cipher = Cipher.getInstance(this.algorithm);
			cipher.init(Cipher.ENCRYPT_MODE, this.keySpec);
			return cipher.doFinal(text.getBytes());
		} catch (Exception e) {
			logger.error("Encryption failed! Returning empty string!", e);
		}
		return "".getBytes();
	}

	/**
	 * Decrypts the given array of bytes to a String
	 */
	public String decryptString(byte[] b) {
		try {
			Cipher cipher = Cipher.getInstance(this.algorithm);
			cipher.init(Cipher.DECRYPT_MODE, this.keySpec);
			return new String(cipher.doFinal(b));
		} catch (Exception e) {
			StringBuffer strSql = new StringBuffer(" ");
			String errMsg = "";
			errMsg = e.getMessage();
			strSql.append(" Exception in Trying to decrypt a invalid value, ");
			strSql.append(" at " + new Date().toString() + ", ");
			strSql.append(" Exception found in:" + errMsg + ", ");
			// strSql.append(" Schema - " +
			// CustomerContextManager.getInstance().getCustomerSchema() );
			strSql.append(" , reason could be Decryption failed! Returning empty string!");
			logger.error(strSql.toString());
		}
		return "";
	}

	/**
	 * Encrypts the given String to a hex representation of the array of bytes
	 */
	public String encryptHexString(String text) {
		return toHex(encryptString(text));
	}

	/**
	 * Encrypts the given String to a base64 representation of the array of
	 * bytes
	 */
	public String encryptBase64String(String text) {
		return new BASE64Encoder().encode(encryptString(text));
	}

	/**
	 * Decrypts the given hex representation of the array of bytes to a String
	 */
	public String decryptHexString(String text) {
		return decryptString(toByteArray(text));
	}

	/**
	 * Decrypts the given base64 representation of the array of bytes to a
	 * String
	 */
	public String decryptBase64String(String text) {
		try {
			return decryptString(new BASE64Decoder().decodeBuffer(text));
		} catch (Exception e) {
			logger.error("Base64 decode failed! Returning empty string! The encrypted string is: " + text, e);
		}
		return "";
	}

	/**
	 * Converts the given array of bytes to a hex String
	 */
	public static String toHex(byte[] buf) {
		char[] cbf = new char[buf.length * 2];
		for (int jj = 0, kk = 0; jj < buf.length; jj++) {
			cbf[kk++] = "0123456789ABCDEF".charAt((buf[jj] >> 4) & 0x0F);
			cbf[kk++] = "0123456789ABCDEF".charAt(buf[jj] & 0x0F);
		}
		return new String(cbf);
	}

	/**
	 * Converts a valid hex String to an array of bytes
	 */
	public static byte[] toByteArray(String hex) {
		byte[] result = new byte[hex.length() / 2];
		for (int jj = 0, kk = 0; jj < result.length; jj++) {
			result[jj] = (byte) (("0123456789ABCDEF".indexOf(hex.charAt(kk++)) << 4) + "0123456789ABCDEF".indexOf(hex
					.charAt(kk++)));
		}
		return result;
	}

	public static String encrypt(String value, byte[] key, String algorithm, String type) {
		CryptUtil helper = new CryptUtil(key, algorithm);
		if ("hex".equalsIgnoreCase(type)) {
			return helper.encryptHexString((String) value);
		}
		return helper.encryptBase64String((String) value);
	}

	public static Map encrypt(String[] cryptAttributes, Map valueMap) {
		CryptUtil helper = new CryptUtil();
		for (int i = 0; cryptAttributes != null && i < cryptAttributes.length; i++) {
			String column = cryptAttributes[i];
			Object value = valueMap.get(column);
			if (value != null) {
				if (value instanceof String) {
					valueMap.put(column, helper.encryptBase64String((String) value));
				}
			}
		}
		return valueMap;
	}

	public static Map decrypt(String[] cryptAttributes, Map valueMap) {
		CryptUtil helper = new CryptUtil();
		for (int i = 0; cryptAttributes != null && i < cryptAttributes.length; i++) {
			String column = cryptAttributes[i];
			Object value = valueMap.get(column);
			if (value != null) {
				if (value instanceof String) {
					valueMap.put(column, helper.decryptBase64String((String) value));
				}
			}
		}
		return valueMap;
	}

	public static String decrypt(String value, byte[] key, String algorithm, String type) {
		CryptUtil helper = new CryptUtil(key, algorithm);
		if ("hex".equalsIgnoreCase(type)) {
			return helper.decryptHexString((String) value);
		}
		return helper.decryptBase64String((String) value);
	}

	/*
	 * private static final byte[] DES_KEY = { (byte) 0x01, (byte) 0xE3, (byte)
	 * 0xA2, (byte) 0x19, (byte) 0x59, (byte) 0xBD, (byte) 0xEE, (byte) 0xAB };
	 */
	private static final byte[] DESede_KEY = { (byte) 0x01, (byte) 0xE3, (byte) 0xA2, (byte) 0x19, (byte) 0x59,
			(byte) 0xBD, (byte) 0xEE, (byte) 0xAB, (byte) 0x02, (byte) 0xE4, (byte) 0xA3, (byte) 0x20, (byte) 0x60,
			(byte) 0xBE, (byte) 0xEF, (byte) 0xAC, (byte) 0x03, (byte) 0xE5, (byte) 0xA4, (byte) 0x21, (byte) 0x61,
			(byte) 0xBF, (byte) 0xD0, (byte) 0xAD };

	public static void main(String[] args) {
		String toEncrypt = "This is a text to encrypt";
		byte[] key = DESede_KEY;
		String algorithm = "DESede";
		if (args.length > 0) {
			toEncrypt = args[0];
			key = args[1].getBytes();
			algorithm = args[2];
		}
		CryptUtil crypt = new CryptUtil(key, algorithm);
		// System.out.println("Ori [" + toEncrypt.length() + "] " + toEncrypt);
		//
		// System.out.println("**************** HEX **********************");
		// String encrypted = crypt.encryptHexString(toEncrypt);
		// String decrypted = crypt.decryptHexString(encrypted);
		// System.out.println("En [" + encrypted.length() + "] " + encrypted);
		// System.out.println("De [" + decrypted.length() + "] " + decrypted);
		// System.out.println("**************** Base64 *******************");
		// encrypted = crypt.encryptBase64String(toEncrypt);
		// decrypted = crypt.decryptBase64String(encrypted);
		// System.out.println("En [" + encrypted.length() + "] " + encrypted);
		// System.out.println("De [" + decrypted.length() + "] " + decrypted);
	}
}

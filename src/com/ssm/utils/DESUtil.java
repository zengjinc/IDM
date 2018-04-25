package com.ssm.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;


/**
 * DES加密和解密。
 * 
 * @author zengjinc
 */
public class DESUtil {

	/** 安全密钥 */
	private String keyData = "ABCDEFGHIJKLMNOPQRSTWXYZabcdefghijklmnopqrstwxyz0123456789-_.";

	/**
	 * 功能：构造
	 * 
	 * @author zengjinc
	 */
	public DESUtil() {
	}

	/**
	 * 功能：构造
	 * 
	 * @author zengjinc
	 * @param keyData
	 *  key
	 */
	public DESUtil(String key) {
		this.keyData = key;
	}

	/**
	 * 功能：加密 (UTF-8)
	 * 
	 * @author zengjinc
	 * @param source
	 *  源字符串
	 * @param charSet
	 *  编码
	 * @return String
	 * @throws UnsupportedEncodingException
	 *  编码异常
	 */
	public String encrypt(String source) throws UnsupportedEncodingException {
		return encrypt(source, "UTF-8");
	}

	/**
	 * 
	 * 功能：解密 (UTF-8)
	 * 
	 * @author zengjinc
	 * @param encryptedData
	 *  被加密后的字符串
	 * @return String
	 * @throws UnsupportedEncodingException
	 *  编码异常
	 */
	public String decrypt(String encryptedData)
			throws UnsupportedEncodingException {
		return decrypt(encryptedData, "UTF-8");
	}

	/**
	 * 功能：加密
	 * 
	 * @author zengjinc
	 * @param source
	 *  源字符串
	 * @param charSet
	 *  编码
	 * @return String
	 * @throws UnsupportedEncodingException
	 *  编码异常
	 */
	public String encrypt(String source, String charSet)
			throws UnsupportedEncodingException {
		String encrypt = null;
		byte[] ret = encrypt(source.getBytes(charSet));
		encrypt = new String(Base64.encode(ret));
		return encrypt;
	}

	/**
	 * 
	 * 功能：解密
	 * 
	 * @author zengjinc
	 * @param encryptedData
	 *  被加密后的字符串
	 * @param charSet
	 *  编码
	 * @return String
	 * @throws UnsupportedEncodingException
	 *  编码异常
	 */
	public String decrypt(String encryptedData, String charSet)
			throws UnsupportedEncodingException {
		String descryptedData = null;
		byte[] ret = descrypt(Base64.decode(encryptedData.toCharArray()));
		descryptedData = new String(ret, charSet);
		return descryptedData;
	}

	/**
	 * 加密数据 用生成的密钥加密原始数据
	 * 
	 * @param primaryData
	 *  原始数据
	 * @return byte[]
	 * @author zengjinc
	 */
	private byte[] encrypt(byte[] primaryData) {

		/** 取得安全密钥 */
		byte rawKeyData[] = getKey();

		/** DES算法要求有一个可信任的随机数源 */
		SecureRandom sr = new SecureRandom();

		/** 使用原始密钥数据创建DESKeySpec对象 */
		DESKeySpec dks = null;
		try {
			dks = new DESKeySpec(keyData.getBytes());
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}

		/** 创建一个密钥工厂 */
		SecretKeyFactory keyFactory = null;
		try {
			keyFactory = SecretKeyFactory.getInstance("DES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		/** 用密钥工厂把DESKeySpec转换成一个SecretKey对象 */
		SecretKey key = null;
		try {
			key = keyFactory.generateSecret(dks);
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}

		/** Cipher对象实际完成加密操作 */
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("DES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}

		/** 用密钥初始化Cipher对象 */
		try {
			cipher.init(Cipher.ENCRYPT_MODE, key, sr);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}

		/** 正式执行加密操作 */
		byte encryptedData[] = null;
		try {
			encryptedData = cipher.doFinal(primaryData);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}

		/** 返回加密数据 */
		return encryptedData;
	}

	/**
	 * 用密钥解密数据
	 * 
	 * @param encryptedData
	 *  加密后的数据
	 * @return byte[]
	 * @author zengjinc
	 */
	private byte[] descrypt(byte[] encryptedData) {

		/** DES算法要求有一个可信任的随机数源 */
		SecureRandom sr = new SecureRandom();

		/** 取得安全密钥 */
		byte rawKeyData[] = getKey();

		/** 使用原始密钥数据创建DESKeySpec对象 */
		DESKeySpec dks = null;
		try {
			dks = new DESKeySpec(keyData.getBytes());
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}

		/** 创建一个密钥工厂 */
		SecretKeyFactory keyFactory = null;
		try {
			keyFactory = SecretKeyFactory.getInstance("DES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		/** 用密钥工厂把DESKeySpec转换成一个SecretKey对象 */
		SecretKey key = null;
		try {
			key = keyFactory.generateSecret(dks);
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}

		/** Cipher对象实际完成加密操作 */
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("DES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}

		/** 用密钥初始化Cipher对象 */
		try {
			cipher.init(Cipher.DECRYPT_MODE, key, sr);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}

		/** 正式执行解密操作 */
		byte decryptedData[] = null;
		try {
			decryptedData = cipher.doFinal(encryptedData);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}

		return decryptedData;
	}

	/**
	 * 取得安全密钥 此方法作废,因为每次key生成都不一样导致解密加密用的密钥都不一样， 从而导致Given final block not
	 * properly padded错误.
	 * 
	 * @return byte数组
	 * @author zengjinc
	 */
	private byte[] getKey() {

		/** DES算法要求有一个可信任的随机数源 */
		SecureRandom sr = new SecureRandom();

		/** 为我们选择的DES算法生成一个密钥生成器对象 */
		KeyGenerator kg = null;
		try {
			kg = KeyGenerator.getInstance("DES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		kg.init(sr);

		/** 生成密钥工具类 */
		SecretKey key = kg.generateKey();

		/** 生成密钥byte数组 */
		byte rawKeyData[] = key.getEncoded();

		return rawKeyData;
	}

}

/**
 * Base64 编码和解码。
 * 
 * @author zengjinc
 */
class Base64 {

	public Base64() {
	}

	/**
	 * 功能：编码字符串
	 * 
	 * @author zengjinc
	 * @param data
	 *  源字符串
	 * @return String
	 */
	public static String encode(String data) {
		return new String(encode(data.getBytes()));
	}

	/**
	 * 功能：解码字符串
	 * 
	 * @author zengjinc
	 * @param data
	 *  源字符串
	 * @return String
	 */
	public static String decode(String data) {
		return new String(decode(data.toCharArray()));
	}

	/**
	 * 功能：编码byte[]
	 * 
	 * @author zengjinc
	 * @param data
	 *  源
	 * @return char[]
	 */
	public static char[] encode(byte[] data) {
		char[] out = new char[((data.length + 2) / 3) * 4];
		for (int i = 0, index = 0; i < data.length; i += 3, index += 4) {
			boolean quad = false;
			boolean trip = false;

			int val = (0xFF & (int) data[i]);
			val <<= 8;
			if ((i + 1) < data.length) {
				val |= (0xFF & (int) data[i + 1]);
				trip = true;
			}
			val <<= 8;
			if ((i + 2) < data.length) {
				val |= (0xFF & (int) data[i + 2]);
				quad = true;
			}
			out[index + 3] = alphabet[(quad ? (val & 0x3F) : 64)];
			val >>= 6;
			out[index + 2] = alphabet[(trip ? (val & 0x3F) : 64)];
			val >>= 6;
			out[index + 1] = alphabet[val & 0x3F];
			val >>= 6;
			out[index + 0] = alphabet[val & 0x3F];
		}
		return out;
	}

	/**
	 * 功能：解码
	 * 
	 * @author zengjinc
	 * @param data
	 *  编码后的字符数组
	 * @return byte[]
	 */
	public static byte[] decode(char[] data) {

		int tempLen = data.length;
		for (int ix = 0; ix < data.length; ix++) {
			if ((data[ix] > 255) || codes[data[ix]] < 0) {
				--tempLen; // ignore non-valid chars and padding
			}
		}
		// calculate required length:
		// -- 3 bytes for every 4 valid base64 chars
		// -- plus 2 bytes if there are 3 extra base64 chars,
		// or plus 1 byte if there are 2 extra.

		int len = (tempLen / 4) * 3;
		if ((tempLen % 4) == 3) {
			len += 2;
		}
		if ((tempLen % 4) == 2) {
			len += 1;

		}
		byte[] out = new byte[len];

		int shift = 0; // # of excess bits stored in accum
		int accum = 0; // excess bits
		int index = 0;

		// we now go through the entire array (NOT using the 'tempLen' value)
		for (int ix = 0; ix < data.length; ix++) {
			int value = (data[ix] > 255) ? -1 : codes[data[ix]];

			if (value >= 0) { // skip over non-code
				accum <<= 6; // bits shift up by 6 each time thru
				shift += 6; // loop, with new bits being put in
				accum |= value; // at the bottom.
				if (shift >= 8) { // whenever there are 8 or more shifted in,
					shift -= 8; // write them out (from the top, leaving any
					out[index++] = // excess at the bottom for next iteration.
					(byte) ((accum >> shift) & 0xff);
				}
			}
		}

		// if there is STILL something wrong we just have to throw up now!
		if (index != out.length) {
			throw new Error("Miscalculated data length (wrote " + index
					+ " instead of " + out.length + ")");
		}

		return out;
	}

	/**
	 * 功能：编码文件
	 * 
	 * @author zengjinc
	 * @param file
	 *  源文件
	 */
	public static void encode(File file) throws IOException {
		if (!file.exists()) {
			System.exit(0);
		}

		else {
			byte[] decoded = readBytes(file);
			char[] encoded = encode(decoded);
			writeChars(file, encoded);
		}
		file = null;
	}

	/**
	 * 功能：解码文件。
	 * 
	 * @author zengjinc
	 * @param file
	 *  源文件
	 * @throws IOException
	 */
	public static void decode(File file) throws IOException {
		if (!file.exists()) {
			System.exit(0);
		} else {
			char[] encoded = readChars(file);
			byte[] decoded = decode(encoded);
			writeBytes(file, decoded);
		}
		file = null;
	}

	//
	// code characters for values 0..63
	//
	private static char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/="
			.toCharArray();

	//
	// lookup table for converting base64 characters to value in range 0..63
	//
	private static byte[] codes = new byte[256];
	static {
		for (int i = 0; i < 256; i++) {
			codes[i] = -1;
			// LoggerUtil.debug(i + "&" + codes[i] + " ");
		}
		for (int i = 'A'; i <= 'Z'; i++) {
			codes[i] = (byte) (i - 'A');
			// LoggerUtil.debug(i + "&" + codes[i] + " ");
		}

		for (int i = 'a'; i <= 'z'; i++) {
			codes[i] = (byte) (26 + i - 'a');
			// LoggerUtil.debug(i + "&" + codes[i] + " ");
		}
		for (int i = '0'; i <= '9'; i++) {
			codes[i] = (byte) (52 + i - '0');
			// LoggerUtil.debug(i + "&" + codes[i] + " ");
		}
		codes['+'] = 62;
		codes['/'] = 63;
	}

	private static byte[] readBytes(File file) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] b = null;
		InputStream fis = null;
		InputStream is = null;
		try {
			fis = new FileInputStream(file);
			is = new BufferedInputStream(fis);
			int count = 0;
			byte[] buf = new byte[16384];
			while ((count = is.read(buf)) != -1) {
				if (count > 0) {
					baos.write(buf, 0, count);
				}
			}
			b = baos.toByteArray();

		} finally {
			try {
				if (fis != null)
					fis.close();
				if (is != null)
					is.close();
				if (baos != null)
					baos.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		return b;
	}

	private static char[] readChars(File file) throws IOException {
		CharArrayWriter caw = new CharArrayWriter();
		Reader fr = null;
		Reader in = null;
		try {
			fr = new FileReader(file);
			in = new BufferedReader(fr);
			int count = 0;
			char[] buf = new char[16384];
			while ((count = in.read(buf)) != -1) {
				if (count > 0) {
					caw.write(buf, 0, count);
				}
			}

		} finally {
			try {
				if (caw != null)
					caw.close();
				if (in != null)
					in.close();
				if (fr != null)
					fr.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		return caw.toCharArray();
	}

	private static void writeBytes(File file, byte[] data) throws IOException {
		OutputStream fos = null;
		OutputStream os = null;
		try {
			fos = new FileOutputStream(file);
			os = new BufferedOutputStream(fos);
			os.write(data);

		} finally {
			try {
				if (os != null)
					os.close();
				if (fos != null)
					fos.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private static void writeChars(File file, char[] data) throws IOException {
		Writer fos = null;
		Writer os = null;
		try {
			fos = new FileWriter(file);
			os = new BufferedWriter(fos);
			os.write(data);

		} finally {
			try {
				if (os != null)
					os.close();
				if (fos != null)
					fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// /////////////////////////////////////////////////
	// end of test code.
	// /////////////////////////////////////////////////

}
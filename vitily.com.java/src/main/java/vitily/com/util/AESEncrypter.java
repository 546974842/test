package vitily.com.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class AESEncrypter {
	private static byte[] iv = new byte[] { 82, 22, 50, 44, -16, 124, -40, -114,
			-87, -40, 37, 23, -56, 23, -33, 75 };

	private static AESEncrypter aes = null;
	
	private static byte[] key1 = new byte[] { -42, 35, 67, -86, 19, 29, -11, 84,
			94, 111, 75, -104, 71, 46, 86, -21, -119, 110, -11, -32, -28, 91,
			-33, -46, 99, 49, 2, 66, -101, -11, -8, 56 };

	private AESEncrypter() {

	}

	public static synchronized AESEncrypter getInstance() {
		if (aes == null) {
			aes = new AESEncrypter();
		}
		return aes;
	}

	public String encrypt(String msg) {

		String str = "";
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128, new SecureRandom(key1));
			AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
			SecretKey key = kgen.generateKey();
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
			str = asHex(cipher.doFinal(msg.getBytes()));
		} catch (BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException e) {
			e.printStackTrace();
		}
		return str;
	}

	public String decrypt(String value) {
		try {
			KeyGenerator kGen = KeyGenerator.getInstance("AES");
			kGen.init(128, new SecureRandom(key1));
			AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
			SecretKey key = kGen.generateKey();
			Cipher dcipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
			return new String(dcipher.doFinal(asBin(value)));
		} catch (BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException e) {
			e.printStackTrace();
		}
		return "";
	}

	private String asHex(byte buf[]) {
		StringBuilder strbuf = new StringBuilder(buf.length * 2);
		int i;

		for (i = 0; i < buf.length; i++) {
			if (((int) buf[i] & 0xff) < 0x10)
				strbuf.append("0");

			strbuf.append(Long.toString((int) buf[i] & 0xff, 16).toUpperCase());
		}

		return strbuf.toString();
	}

	private byte[] asBin(String src) {
		if (null == src || src.length() < 1)
			return null;
		byte[] encrypted = new byte[src.length() / 2];
		for (int i = 0; i < src.length() / 2; i++) {
			int high = Integer.parseInt(src.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(src.substring(i * 2 + 1, i * 2 + 2), 16);

			encrypted[i] = (byte) (high * 16 + low);
		}
		return encrypted;
	}

}
package com.chawran.core.util;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

public class RSAUtil {

	/**
	 * String to hold name of the encryption algorithm.
	 */
	public static final String ALGORITHM = "RSA";
	
	/**
	 * Size of the key.
	 */
	public static final int KEY_SIZE = 512;

	/**
	 * Generate key which contains a pair of private and public key using 1024 bytes.
	 */
	public static void generateKey() throws Exception {
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
		keyGen.initialize(KEY_SIZE, new SecureRandom());
		
		KeyPair keyPair = keyGen.generateKeyPair();
		
		PublicKey publicKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();
		
		String publicKeyStr = new Base64().encodeToString((publicKey.getEncoded()));
		String privateKeyStr = new Base64().encodeToString((privateKey.getEncoded()));
		
		System.out.println("PublicKey:");
		System.out.println(publicKeyStr);
		System.out.println("--------------------------------------------------");
		System.out.println("PrivateKey:");
		System.out.println(privateKeyStr);
		System.out.println("--------------------------------------------------");
	}

	/**
	 * 使用公钥进行加密
	 * @param text 原文
	 * @param key  公钥
	 */
	public static String encrypt(String text, String key) throws Exception {
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, getPublicKeyObject(key));
		return new Base64().encodeToString(cipher.doFinal(text.getBytes()));
	}

	/**
	 * 使用私钥进行解密
	 * @param text 原文
	 * @param key  私钥
	 */
	public static String decrypt(String text, String key) throws Exception {
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, getPrivateKeyObject(key));
		return new String(cipher.doFinal(new Base64().decode(text)));
	}

	/**
	 * 实例化公钥
	 */
	private static PublicKey getPublicKeyObject(String key) throws Exception {
		byte[] keyByteArr = new Base64().decode(key);
		X509EncodedKeySpec bobPubKeySpec = new X509EncodedKeySpec(keyByteArr);
		KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
		return keyFactory.generatePublic(bobPubKeySpec);
	}
	
	/**
	 * 实例化私钥
	 */
	private static PrivateKey getPrivateKeyObject(String key) throws Exception {
		byte[] keyByteArr = new Base64().decode(key);
		PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(keyByteArr);
		KeyFactory keyf = KeyFactory.getInstance(ALGORITHM);
		return keyf.generatePrivate(priPKCS8);
	} 
	
	public static void main(String[] args) throws Exception {
//		generateKey();
		
		String text = "welcome";
		String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAIkQ26YjJszmW+PuNsu7/ZGZWckRLyhomE7xv3kFWFIrFNKh3EznfvMi8KREOnjxexaKRBlHQ+C0iP019cCZ31kCAwEAAQ==";
		String privateKey = "MIIBUwIBADANBgkqhkiG9w0BAQEFAASCAT0wggE5AgEAAkEAiRDbpiMmzOZb4+42y7v9kZlZyREvKGiYTvG/eQVYUisU0qHcTOd+8yLwpEQ6ePF7FopEGUdD4LSI/TX1wJnfWQIDAQABAkA6Kig7yWD2xK6r+/PO4zjIp53dYGh1qmUv4xDQ537CZxzB0zn0gh2uqzOYD4C6fftUHiSEoetzTZsY9MISAcCBAiEAwQzig2u/KDKjd8TT1MLrfEUsGtlKZe7J5l2bEfyVrmkCIQC1wpl4fe1XozolntZosYi3lFpRGbWZ5k77/63JjVJrcQIgdpJwaiH6xjjcGIsnRM34D1r5LQB7ZsJU9g5WWaTXVskCIBuHW8M6H2Z0nGvyQLsemHxlhcBeyniCv1e/g8zRELihAiB9Kr4RoNGKu/cUfXbu5dnH4mYcBwLez/ASzGiegX8DXQ==";
	
		String encryptText = encrypt(text, publicKey);
		String decryptText = decrypt(encryptText, privateKey);
		
		System.out.println("原文：" + text);
		System.out.println("加密：" + encryptText);
		System.out.println("解密：" + decryptText);
	}
	
}
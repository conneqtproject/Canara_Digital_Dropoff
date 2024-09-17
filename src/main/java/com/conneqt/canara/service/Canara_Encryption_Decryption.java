package com.conneqt.canara.service;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Canara_Encryption_Decryption {


	public static String encrypt(String value, String secretKey, String initVector) {
        try {
            IvParameterSpec iv = new IvParameterSpec(Base64.getDecoder().decode(initVector));
            SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.getDecoder().decode(secretKey), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String encrypted, String secretKey, String initVector) {
        try {
            IvParameterSpec iv = new IvParameterSpec(Base64.getDecoder().decode(initVector));
            SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.getDecoder().decode(secretKey), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, iv);

            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));
            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

	
}

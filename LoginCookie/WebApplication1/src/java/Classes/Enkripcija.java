/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
/**
 *
 * @author Aleksa Kuzman
 */


public class Enkripcija {
    
    
  /*  private static final String Algoritam = "AES/CBC/NoPadding";*/
    private static final  byte[] Kljuc =  new byte[]{'N','e','k','i','K','l','u','c'};
     static String INITIALIZATIO_VECTOR = "AODVNUASDNVVAOVF";
    
    public static byte[] encrypt(String plainText, String encryptionKey) throws Exception {
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
    SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
    cipher.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(INITIALIZATIO_VECTOR.getBytes("UTF-8")));
    return cipher.doFinal(plainText.getBytes("UTF-8"));
  }
 
  public static String decrypt(byte[] cipherText, String encryptionKey) throws Exception{
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
    SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
    cipher.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(INITIALIZATIO_VECTOR.getBytes("UTF-8")));
    return new String(cipher.doFinal(cipherText),"UTF-8");
  }
  
    /*public static String encrypt(String data) throws Exception {
        KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = new SecureRandom();
        int keyBitSize = 256;
        keygenerator.init(keyBitSize, secureRandom);
        SecretKey sk = keygenerator.generateKey();
        Cipher c = Cipher.getInstance(Algoritam);
        c.init(Cipher.ENCRYPT_MODE, sk);
        byte[] encVal = c.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encVal);
    }
    
   
    
    
    private static Key generateKey() throws Exception{
        return new SecretKeySpec(Kljuc,Algoritam);
    }*/
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro;

/**
 *
 * @author RenownTechnologies
 */
 /* code for Decryption */
import java.io.File;
import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.ECParameterSpec;
import java.security.spec.EllipticCurve;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;



public class decryec {
 
 KeyPairGenerator kpg;
 EllipticCurve curve;
 ECParameterSpec ecSpec;
 KeyPair aKeyPair;
 static KeyAgreement aKeyAgree;
 KeyPair bKeyPair;
 KeyAgreement bKeyAgree;
 KeyFactory keyFac; 
 
 
 public static void main(String args[])
 {
  Security.addProvider(new BouncyCastleProvider());
  
  try{
   
   String path = "D:\\X";
   
   File filePublicKey = new File(path +"\\public.key");
   FileInputStream fis = new FileInputStream(path + "\\public.key");
   byte[] encodedPublicKey = new byte[(int) filePublicKey.length()];
   fis.read(encodedPublicKey);
   fis.close();
  
   // Read Private Key.
   File filePrivateKey = new File(path + "\\private.key");
   fis = new FileInputStream(path + "\\private.key");
   byte[] encodedPrivateKey = new byte[(int) filePrivateKey.length()];
   fis.read(encodedPrivateKey);
   fis.close();
  
   // Generate KeyPair.
   KeyFactory keyFactory = KeyFactory.getInstance("ECDH");
   X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(
     encodedPublicKey);
   PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
  
   PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(
     encodedPrivateKey);
   PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);   
   
   
   
     aKeyAgree = KeyAgreement.getInstance("ECDH", "BC");
     aKeyAgree.init(privateKey);
     aKeyAgree.doPhase(publicKey, true);     
   
 
     byte[] aBys = aKeyAgree.generateSecret(); 
     KeySpec aKeySpec = new DESKeySpec(aBys);
     SecretKeyFactory aFactory = SecretKeyFactory.getInstance("DES");
     Key aSecretKey = aFactory.generateSecret(aKeySpec);

     Cipher aCipher = Cipher.getInstance(aSecretKey.getAlgorithm());   
     aCipher.init(Cipher.DECRYPT_MODE, aSecretKey);  
     byte[] decText = aCipher.doFinal(Base64.decodeBase64("0wwerdjkHbVhYI+YPxUnmw==".getBytes()));
     String text = new String(decText);
     
     System.out.println("Decoded="+text);
     
   
  }
  catch(Exception e)
  {
   e.printStackTrace();
  }
 }
}
import java.io.*;
import java.security.*;
import javax.crypto.Cipher;

class Encryption
{
	
	public static KeyPair GenerateKey()throws NoSuchAlgorithmException
	{
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		kpg.initialize(2048);
		KeyPair kp = kpg.genKeyPair();
		return kp;
	}
	
	public static byte[] encryptMessage(String message, PublicKey pubKey)
	{
		byte[] encryptedMsg = null;
		try
		{
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, pubKey);
			encryptedMsg = cipher.doFinal(message.getBytes());
		}catch(Exception e){e.printStackTrace();}
		return encryptedMsg;
	}
	
	public static String decryptMessage(byte[] encryptedMsg, PrivateKey privKey)
	{
		byte[] decryptedMsg = null;
		try
		{
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privKey);
			decryptedMsg = cipher.doFinal(encryptedMsg);
		}catch(Exception e){e.printStackTrace();}
		String message = new String(decryptedMsg);
		return message;
	}
}
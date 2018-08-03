package Testing.framework;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import org.apache.commons.codec.binary.Base64;


public class Sample {
	
	 private static final String UNICODE_FORMAT = "UTF8";
	    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
	    private static KeySpec kesySpec;
	    private static SecretKeyFactory secretKeyFactory;
	    private static Cipher cipher;
	    static byte[] arrayBytes;
	    private static String myEncryptionKey;
	    private static String myEncryptionScheme;
	    static SecretKey key;

	    static {
	    	try {
	    		myEncryptionKey = "ThisIsSpartaThisIsSparta";
		        myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
		        arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
		        kesySpec = new DESedeKeySpec(arrayBytes);
		        secretKeyFactory = SecretKeyFactory.getInstance(myEncryptionScheme);
		        cipher = Cipher.getInstance(myEncryptionScheme);
		        key = secretKeyFactory.generateSecret(kesySpec);
	    	} catch(Exception e) {
	    		
	    	}
	    }


	    public static String encrypt(String unencryptedString) {
	        String encryptedString = null;
	        try {
	            cipher.init(Cipher.ENCRYPT_MODE, key);
	            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
	            byte[] encryptedText = cipher.doFinal(plainText);
	            encryptedString = new String(Base64.encodeBase64(encryptedText));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return encryptedString;
	    }


	    public static String decrypt(String encryptedString) {
	        String decryptedText=null;
	        try {
	            cipher.init(Cipher.DECRYPT_MODE, key);
	            byte[] encryptedText = Base64.decodeBase64(encryptedString);
	            byte[] plainText = cipher.doFinal(encryptedText);
	            decryptedText= new String(plainText);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return decryptedText;
	    }


//	    public static void main(String args []) throws Exception
//	    {
//	    	Sample td= new Sample();
//
//	        String target="imparator";
//	        String encrypted=td.encrypt(target);
//	        String decrypted=td.decrypt(encrypted);
//
//	        System.out.println("String To Encrypt: "+ target);
//	        System.out.println("Encrypted String:" + encrypted);
//	        System.out.println("Decrypted String:" + decrypted);
//
//	    }

}

test


package Testing.framework;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	
	public static void main(String[] args) {
		
		String encrypted = Sample.encrypt("Mahender");
		String decrypted =  Sample.decrypt(encrypted);
		
		System.out.println(encrypted+"@@@@@@"+decrypted);
	}
}

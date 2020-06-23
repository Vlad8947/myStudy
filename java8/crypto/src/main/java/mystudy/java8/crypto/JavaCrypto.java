package mystudy.java8.crypto;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

public class JavaCrypto {

    static String cryptType = "AES/CBC/PKCS5Padding";
    static String password = "maPass";
    static String text = "This is my test";

    public static void main(String[] args) {

        PBEKeySpec pbeKeySpec;
        SecretKeyFactory keyFac;
        PBEParameterSpec pbeParamSpec = initPBEParSpec();
        IvParameterSpec ivParameterSpec = initIvParamSpec();

        // Prompt user for encryption password.
        // Collect user password as char array, and convert
        // it into a SecretKey object, using a PBE key
        // factory.
        char[] passArray = password.toCharArray();
        pbeKeySpec = new PBEKeySpec(passArray);

        try {
            keyFac = SecretKeyFactory.getInstance("PBEWithHmacSHA256AndAES_256");
            SecretKey pbeKey = keyFac.generateSecret(pbeKeySpec);

            // Create PBE Cipher
            Cipher pbeCipher = Cipher.getInstance("PBEWithHmacSHA256AndAES_256");

            // Initialize PBE Cipher with key and parameters
            pbeCipher.init(Cipher.ENCRYPT_MODE, pbeKey, pbeParamSpec);

            // Our cleartext
            byte[] cleartext = "This is another example".getBytes();

            // Encrypt the cleartext
            byte[] ciphertext = pbeCipher.doFinal(cleartext);
            System.out.println("Encrypt: " + new String(ciphertext));

            pbeCipher.init(Cipher.DECRYPT_MODE, pbeKey, pbeParamSpec);
            byte[] decryptText = pbeCipher.doFinal(ciphertext);
            System.out.println("Decrypt: " + new String(decryptText));

        } catch (NoSuchAlgorithmException |
                InvalidKeySpecException |
                NoSuchPaddingException |
                InvalidKeyException |
                InvalidAlgorithmParameterException |
                IllegalBlockSizeException |
                BadPaddingException e) {
            e.printStackTrace();
        }


    }

    public static PBEParameterSpec initPBEParSpec() {
        // Salt
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);

        System.out.println("Salt: " + Arrays.toString(salt));

        // Iteration count
        int count = 1000;

        // Create PBE parameter set
        return new PBEParameterSpec(salt, count);
    }

    public static IvParameterSpec initIvParamSpec() {
        // Salt
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);

        // Create PBE parameter set
        return new IvParameterSpec(salt);
    }

}

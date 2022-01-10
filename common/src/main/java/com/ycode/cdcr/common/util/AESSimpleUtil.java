package com.ycode.cdcr.common.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;


public class AESSimpleUtil {
//    //cb84efdaeb87b25edac48bb23de6fbf2
//    public static void main(String[] args) {
//        String cb84efdaeb87b25edac48bb23de6fbf2 = AESSimpleUtil.encrypt(
//            "cb84efdaeb87b25edac48bb23de6fbf2");
//        System.out.println(cb84efdaeb87b25edac48bb23de6fbf2);
//    }
    private static final String DEFAULT_PUBLIC_KEY = "asdfghjkloiuytre"; //内容随便，16位

    public static String encrypt(String password) {
         if (password==null){
             return null;
         }
        try {
            SecretKey key = generateMySQLAESKey(DEFAULT_PUBLIC_KEY, "ASCII");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] cleartext = password.getBytes("UTF-8");
            byte[] ciphertextBytes = cipher.doFinal(cleartext);
            return new String(Hex.encodeHex(ciphertextBytes));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String newencrypt(String password,String scret) {
        if (password==null){
            return null;
        }
        try {
            SecretKey key = generateMySQLAESKey(scret, "ASCII");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] cleartext = password.getBytes("UTF-8");
            byte[] ciphertextBytes = cipher.doFinal(cleartext);
            return new String(Hex.encodeHex(ciphertextBytes));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String content) {
        try {
            if (content==null){
                return null;
            }
            SecretKey key = generateMySQLAESKey(DEFAULT_PUBLIC_KEY, "ASCII");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] cleartext = Hex.decodeHex(content.toCharArray());
            byte[] ciphertextBytes = cipher.doFinal(cleartext);
            return new String(ciphertextBytes, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (DecoderException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static SecretKeySpec generateMySQLAESKey(final String key, final String encoding) {
        try {
            final byte[] finalKey = new byte[16];
            int i = 0;
            for (byte b : key.getBytes(encoding)) {
                finalKey[i++ % 16] ^= b;
            }
            return new SecretKeySpec(finalKey, "AES");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }


//    public static void main(String[] args) {
//        String abc = "15868124749";
//        String aeskey = "dc58af43160ddf8cd776379c91cfde";
//        String a1 = encrypt(abc, aeskey);
//        System.out.println(a1);
//        System.out.println(decrypt(a1, aeskey));
//    }


}


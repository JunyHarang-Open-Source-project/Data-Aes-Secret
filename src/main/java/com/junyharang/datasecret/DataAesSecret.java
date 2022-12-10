package com.junyharang.datasecret;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Locale;

/**
 * <pre>
 * KOREAN : 특정 Data 암호화 하여 DB 저장 및 복호화 하여 출력 하기 위한 Class
 * English : Classes for printing and decrypting certain data by encrypting specific data
 * </pre>
 * @author 주니하랑(JunyHarang) - junyharang8592@gmail.com
 * @version 1.0.0
 * @see <a href="https://junyharang.tistory.com/364">JunyHarang Tech Blog - [JAVA - Spring Boot] 암호화/복호화 기능 만들기</a>
 * @see <a href="https://github.com/junyharang-coding-study/JunyHarang-JAVA-EncryptionDecryption">JunyHarang Git Hub Repository - JunyHarang-JAVA-EncryptionDecryption</a>
 *
 */

@Slf4j
public class DataAesSecret {
    static String cipherModeWrongMessage = "cipherMode Value are wrong / CipherMode 변수값이 잘못 입력 되었습니다.";

    /**
     * <pre>
     * KOREAN : 외부에서 특정 값을 base64로 Encoding하여 암/복호화 시 사용할 Key 생성 Method
     * English : METHOD, a key to be used for cancer/decryption by encoding certain values from outside to base64
     * </pre>
     * @param value base64로 Encoding 대상 value
     * @return String - Base64로 Encoding된 value
     * @author 주니하랑(JunyHarang) - junyharang8592@gmail.com
     * @since 1.0.0
     *
     */

    public static String base64Encoder(String value) {
        return Base64.getEncoder().encodeToString(value.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * <pre>
     * KOREAN : 주요 정보에 대해 AES-{길이} Algorithm으로 Data를 암호화하고, 특정 사용자나, 권한이 허용되는 인원에게 복호화 하여 출력하기 위한 Method
     * English : For major information, AES-{Length} Algorithm encrypts DATA, and decrypts and outputs certain users or permitted personnel.
     * </pre>
     * @param algorithmLength AES 길이값을 받아 initializationVector Array Length를 정하기 위한 매개 변수
     * @param cipherKey AES 암호화 알고리즘을 이용하여 특정 Data를 암/복호화 할 때 사용될 Key Value
     * @param data AES 암호화 알로리즘을 이용하여 암/복호화 할 대상 Message
     * @param cipherMode 1 = 암호화 Logic, 2 = 복호화 Logic 수행
     * @return String - AES 알고리즘을 이용하여 암/복호화된 Message
     * @author 주니하랑(JunyHarang) - junyharang8592@gmail.com
     * @since 1.0.0
     *
     */

    public static String aesSecret(int algorithmLength, String cipherKey, String data, int cipherMode) {
        String result = null;

        try {
            Cipher cipher = Cipher.getInstance("AES");

            if (cipherKey == null) {
                throw new cipherKeyNotNullException();
            }

            byte[] initializationVector = initializationVectorFactory(algorithmLength, cipherKey);

            SecretKeySpec keySpec = new SecretKeySpec(initializationVector, "AES");

            cipher.init(cipherMode, keySpec);

            if (cipherMode == Cipher.ENCRYPT_MODE) {
                result = new String(Hex.encodeHex(cipher.doFinal(data.getBytes(StandardCharsets.UTF_8)))).toUpperCase(Locale.ROOT);
            } else if (cipherMode == Cipher.DECRYPT_MODE) {
                result = new String(cipher.doFinal(Hex.decodeHex(data)), StandardCharsets.UTF_8);
            } else {
                throw new cipherModeIncorrectValueException();
            }
        } catch (NoSuchAlgorithmException |
                 NoSuchPaddingException |
                 DecoderException |
                 IllegalBlockSizeException |
                 BadPaddingException |
                 InvalidKeyException error) {

            error.printStackTrace();
        }
        return result;
    }

    /**
     * <pre>
     * KOREAN : initializationVector를 정하기 위한 Method
     * English : Method for setting InitializationVector
     * </pre>
     * @param algorithmLength AES 길이값을 받아 initializationVector Array Length를 정하기 위한 매개 변수
     * @param cipherKey AES 암호화 알고리즘을 이용하여 특정 Data를 암/복호화 할 때 사용될 Key Value
     * @return byte[] - initializationVector 값
     * @author 주니하랑(JunyHarang) - junyharang8592@gmail.com
     * @since 1.0.0
     *
     */

    private static byte[] initializationVectorFactory(int algorithmLength, String cipherKey) {
        int arrayLength = 0;

        if (algorithmLength == 192) {
            arrayLength = 24;
        } else if (algorithmLength == 256) {
            arrayLength = 32;
        } else {
            arrayLength = 16;
        }

        byte[] initializationVector = new byte[arrayLength];

        int index = 0;

        for (byte b : cipherKey.getBytes(StandardCharsets.UTF_8)) {
            initializationVector[index++ % arrayLength] ^= b;
        }
        return initializationVector;
    }
}

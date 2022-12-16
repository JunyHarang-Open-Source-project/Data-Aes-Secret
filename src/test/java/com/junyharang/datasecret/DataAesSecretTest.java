package com.junyharang.datasecret;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataAesSecretTest {

    @Test
    @DisplayName("주요 데이터 AES 암/복호화 확인")
    void majorDataAES128Check() {
        String encryptionKeyValue = "I Love Coding";
        String plainText = "JunyHarang's OpenSource Project";
        int[] algorithmLengthArray = {5, 128, 192, 256};

        String encryptionKey = DataAesSecret.base64Encoder(encryptionKeyValue);
        System.out.println("Base64 Encoding encryptionKeyValue : " + encryptionKey);

        for (int algorithmLength : algorithmLengthArray) {
            if (algorithmLength == 5 || algorithmLength == 128) {
                System.out.println("AES-128 Mode로 암/복호화 실시");
            } else if (algorithmLength == 192) {
                System.out.println("AES-192 Mode로 암/복호화 실시");
            } else {
                System.out.println("AES-256 Mode로 암/복호화 실시");
            }

            String encryptionContent = DataAesSecret.aesSecret(algorithmLength, encryptionKey, plainText, 1);
            System.out.println("암호화된 내용(Encrypted Value) : " + encryptionContent);

            String decryptionBoardContent = DataAesSecret.aesSecret(algorithmLength, encryptionKey, encryptionContent, 2);
            System.out.println("복호화된 내용(Decrypted Value) : " + decryptionBoardContent);
            assertEquals(plainText, decryptionBoardContent);
        }
    }

    @Test
    @DisplayName("Random 값을 이용한 주요 데이터 AES 암/복호화 확인")
    void usedRandomValueOfMajorDataAES128Check() {
        String encryptionKeyValue = RandomValue.createRandomValue();
        System.out.println("반환된 난수 값(Return Random Value) : " + encryptionKeyValue);

        String plainText = "JunyHarang's OpenSource Project";
        int[] algorithmLengthArray = {5, 128, 192, 256};

        String encryptionKey = DataAesSecret.base64Encoder(encryptionKeyValue);
        System.out.println("Base64 Encoding encryptionKeyValue : " + encryptionKey);

        for (int algorithmLength : algorithmLengthArray) {
            if (algorithmLength == 5 || algorithmLength == 128) {
                System.out.println("AES-128 Mode로 암/복호화 실시");
            } else if (algorithmLength == 192) {
                System.out.println("AES-192 Mode로 암/복호화 실시");
            } else {
                System.out.println("AES-256 Mode로 암/복호화 실시");
            }

            String encryptionContent = DataAesSecret.aesSecret(algorithmLength, encryptionKey, plainText, 1);
            System.out.println("암호화된 내용(Encrypted Value) : " + encryptionContent);

            String decryptionBoardContent = DataAesSecret.aesSecret(algorithmLength, encryptionKey, encryptionContent, 2);
            System.out.println("복호화된 내용(Decrypted Value) : " + decryptionBoardContent);
            assertEquals(plainText, decryptionBoardContent);
        }
    }
}

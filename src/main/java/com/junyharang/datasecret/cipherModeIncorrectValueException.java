package com.junyharang.datasecret;

public class cipherModeIncorrectValueException extends RuntimeException {

    private static final String MESSAGE = "Cipher Mode 매개 변수 값이 잘못 입력 되었습니다. \n Please Cipher Mode Value Check";

    public cipherModeIncorrectValueException() {
        super(MESSAGE);
    }
}

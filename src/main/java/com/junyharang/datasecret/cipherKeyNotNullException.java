package com.junyharang.datasecret;

public class cipherKeyNotNullException extends RuntimeException {

    private static final String MESSAGE = "Cipher Key 값은 Null 일 수 없습니다. \n Cipher Key can not be Not Null";

    public cipherKeyNotNullException() {
        super(MESSAGE);
    }

}

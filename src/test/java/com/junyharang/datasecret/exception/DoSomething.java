package com.junyharang.datasecret.exception;

import com.junyharang.datasecret.cipherModeIncorrectValueException;

public class DoSomething {
    public static void func() {
        throw new cipherModeIncorrectValueException();
    }
}

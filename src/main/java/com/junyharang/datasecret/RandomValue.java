package com.junyharang.datasecret;

import java.util.UUID;

public class RandomValue {

    public static String createRandomValue() {
         return UUID.randomUUID().toString().replace("-", "");
    }
}


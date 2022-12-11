package com.junyharang.datasecret;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomValueTest {

    @Test
    @DisplayName("Random값 만들기")
    void createRandomValue() {
        String randomValue = RandomValue.createRandomValue();

        System.out.println("반환된 난수 값(Return Random Value) : " + randomValue);
    }

}
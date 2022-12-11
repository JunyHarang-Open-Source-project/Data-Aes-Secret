package com.junyharang.datasecret;

import java.util.UUID;

/**
 * <pre>
 * KOREAN : 난수값 만들기 위한 Class
 * English : Create Random Value
 * </pre>
 * @author 주니하랑(JunyHarang) - junyharang8592@gmail.com
 * @version 1.0.0
 *
 */

public class RandomValue {

    /**
     * <pre>
     * KOREAN : UUID를 이용한 난수값 만드는 Method (-는 제거하고, 반환)
     * English : UUID를 이용한 난수값 만드는 Method (-는 제거하고, 반환)
     * </pre>
     * @return String - "-"가 제거된 UUID 값
     * @author 주니하랑(JunyHarang) - junyharang8592@gmail.com
     * @since 1.0.0
     *
     */

    public static String createRandomValue() {
         return UUID.randomUUID().toString().replace("-", "");
    }
}


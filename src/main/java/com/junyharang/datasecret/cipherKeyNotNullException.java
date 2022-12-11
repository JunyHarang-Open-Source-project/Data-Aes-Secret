package com.junyharang.datasecret;

/**
 * <pre>
 * KOREAN : cipher Key 값이 Null일 경우 발생하는 Exception
 * English : Exception that occurs when cipher key values are null
 * </pre>
 * @author 주니하랑(JunyHarang) - junyharang8592@gmail.com
 * @version 1.0.0
 *
 */

public class cipherKeyNotNullException extends RuntimeException {

    /**
     * Return Message
     */
    private static final String MESSAGE = "Cipher Key 값은 Null 일 수 없습니다. \n Cipher Key can not be Not Null";

    /**
     * <pre>
     * KOREAN : 해당 Exception이 발생했을 때, RuntimeException에 반환될 문자열을 보내 Exception 내용이 출력되도록 처리하는 생성자
     * English : When the Exception occurs, a constructor who sends a string to be returned to the RuntimeException so that the Exception contents are output
     * </pre>
     * @author 주니하랑(JunyHarang) - junyharang8592@gmail.com
     * @since 1.0.0
     *
     */

    public cipherKeyNotNullException() {
        super(MESSAGE);
    }

}

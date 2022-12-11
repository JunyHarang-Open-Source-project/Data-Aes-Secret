package com.junyharang.datasecret;

/**
 * <pre>
 * KOREAN : cipher Mode에 들어와야 하는 값이 다르면 발생하는 Exception
 * English : Exception occurs when the value that needs to be entered in cipher mode
 * </pre>
 * @author 주니하랑(JunyHarang) - junyharang8592@gmail.com
 * @version 1.0.0
 *
 */

public class cipherModeIncorrectValueException extends RuntimeException {

    /**
     * Return Message
     */

    private static final String MESSAGE = "Cipher Mode 매개 변수 값이 잘못 입력 되었습니다. \n 사용 방법 : 1 = 암호화, 2 = 복호화 \n Please Cipher Mode Value Check \n 1 = Encryption Mode, 2 = Decryption Mode";

    /**
     * <pre>
     * KOREAN : 해당 Exception이 발생했을 때, RuntimeException에 반환될 문자열을 보내 Exception 내용이 출력되도록 처리하는 생성자
     * English : When the Exception occurs, a constructor who sends a string to be returned to the RuntimeException so that the Exception contents are output
     * </pre>
     * @author 주니하랑(JunyHarang) - junyharang8592@gmail.com
     * @since 1.0.0
     *
     */

    public cipherModeIncorrectValueException() {
        super(MESSAGE);
    }
}

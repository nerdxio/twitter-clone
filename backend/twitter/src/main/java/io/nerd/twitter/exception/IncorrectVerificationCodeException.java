/**
 * @author Hassan Refaat <hassan.refaat.dev@gmail.com>
 * @Created 5/4/2023 9:19 AM
 */
package io.nerd.twitter.exception;

public class IncorrectVerificationCodeException extends RuntimeException {
    public IncorrectVerificationCodeException() {
        super("Incorrect verification code");
    }
}

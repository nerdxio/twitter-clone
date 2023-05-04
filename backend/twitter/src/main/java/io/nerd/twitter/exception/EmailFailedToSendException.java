/**
 * @author Hassan Refaat <hassan.refaat.dev@gmail.com>
 * @Created 5/4/2023 8:38 AM
 */
package io.nerd.twitter.exception;

public class EmailFailedToSendException extends RuntimeException{

    public EmailFailedToSendException() {
        super("The Email failed to send");
    }
}

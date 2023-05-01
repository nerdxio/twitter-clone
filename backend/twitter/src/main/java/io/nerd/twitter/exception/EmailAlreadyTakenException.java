/**
 * @author Hassan Refaat <hassan.refaat.dev@gmail.com>
 * @Created 5/1/2023 1:08 PM
 */
package io.nerd.twitter.exception;


public class EmailAlreadyTakenException extends RuntimeException{
    public EmailAlreadyTakenException() {
        super("The Email provided already taken");
    }
}

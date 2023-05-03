/**
 * @author Hassan Refaat <hassan.refaat.dev@gmail.com>
 * @Created 5/3/2023 8:51 AM
 */
package io.nerd.twitter.exception;

public class UserDoesNotExistException extends RuntimeException {
    public UserDoesNotExistException() {
        super("The User you are looking for does not exist");
    }
}

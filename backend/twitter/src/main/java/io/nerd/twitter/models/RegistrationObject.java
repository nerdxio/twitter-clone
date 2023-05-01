/**
 * @author Hassan Refaat <hassan.refaat.dev@gmail.com>
 * @Created 5/1/2023 12:37 PM
 */
package io.nerd.twitter.models;

import java.sql.Date;

public record RegistrationObject(String firstName, String lastName, String email, Date dob) {
}



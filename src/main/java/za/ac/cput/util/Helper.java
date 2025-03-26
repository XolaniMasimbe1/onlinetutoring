package za.ac.cput.util;

/* Student.java
   Author: Anda Matomela (222578912)
   Date: 22 March 2025
*/

import org.apache.commons.validator.routines.EmailValidator;

public class Helper {
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public static boolean isValidEmail(String email) {
        EmailValidator emailValidator = EmailValidator.getInstance();
        return emailValidator.isValid(email);
    }
}
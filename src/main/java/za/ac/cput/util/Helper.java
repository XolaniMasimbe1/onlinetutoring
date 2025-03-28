package za.ac.cput.util;

public class Helper {
    public static boolean isNullOrEmpty(String s) {
        if (s == null || s.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isValidEmail(String email) {

        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return email.contains("@") && email.contains(".");
    }
}
/* OnlineTutoring.java
Helper class
Author: Xolani Masimbe (222410817)
Date: 23 March 2025

*/
package za.ac.cput.factory;

import za.ac.cput.domain.Tutor;
import za.ac.cput.util.Helper;

public class TutorFactory {
    public static Tutor createTutorFactory(String identityNumber, String firstName, String lastName) {
        if (Helper.isNullOrEmpty(identityNumber) ||
                Helper.isNullOrEmpty(firstName) ||
                Helper.isNullOrEmpty(lastName)) {
            return null;
        }

        return new Tutor.Builder()
                .setIdentityNumber(identityNumber)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(null)
                .setSubject(null)
                .build();
    }

    // Full version with all attributes
    public static Tutor createTutorFactory(String identityNumber, String firstName, String lastName,
                                           String email, String subject) {
        if (Helper.isNullOrEmpty(identityNumber) ||
                Helper.isNullOrEmpty(firstName) ||
                Helper.isNullOrEmpty(lastName) ||
                Helper.isNullOrEmpty(email) ||
                Helper.isNullOrEmpty(subject)) {
            return null;
        }
        if (!Helper.isValidEmail(email)) {
            return null;
        }
        return new Tutor.Builder()
                .setIdentityNumber(identityNumber)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setSubject(subject)
                .build();
    }
}
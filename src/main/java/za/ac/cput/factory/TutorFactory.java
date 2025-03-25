package za.ac.cput.factory;
/* TutorFactory.java
Tutor Factory class
Author: Xolani Masimbe (222410817)
Date: 23 March 2025
*/
import za.ac.cput.domain.Tutor;
import za.ac.cput.util.Helper;

public class TutorFactory {

    public static Tutor createTutorFactory(String identityNumber, String firstName, String lastName,
                                           String email,String Subject) {
        if(Helper.isNullOrEmpty(identityNumber) || Helper.isNullOrEmpty(firstName)
        || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(Subject)){
            return null;
        }
        if(!Helper.isValidEmail(email)){
            return null;
        }
       return new Tutor.Builder()
               .setIdentityNumber(identityNumber)
               .setFirstName(firstName)
               .setLastName(lastName)
               .setEmail(email)
               .setSubject(Subject)
               .build();
    }

}

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
        if(Helper.isNullorEmpty(identityNumber) || Helper.isNullorEmpty(firstName)
        || Helper.isNullorEmpty(lastName) || Helper.isNullorEmpty(email) || Helper.isNullorEmpty(Subject)){
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

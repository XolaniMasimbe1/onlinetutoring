package za.ac.cput.factory;

import za.ac.cput.domain.Student;
import za.ac.cput.util.Helper;

/* StudentFactory.java
   Author: Anda Matomela (222578912)
   Date: 22 March 2025
*/
public class StudentFactory {
    public static Student createStudent(String studentId, String firstName, String lastName, String email) {
        if (Helper.isNullOrEmpty(studentId) || Helper.isNullOrEmpty(firstName)
                || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(email)) {
            return null;
        }

        if (!Helper.isValidEmail(email)) {
            return null;
        }

        return new Student.Builder()
                .setStudentId(studentId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .build();
    }
}
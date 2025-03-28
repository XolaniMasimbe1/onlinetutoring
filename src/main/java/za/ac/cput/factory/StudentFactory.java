package za.ac.cput.factory;

/* Student.java
   Author: Anda Matomela (222578912)
   Date: 22 March 2025
*/

import za.ac.cput.domain.Student;
import za.ac.cput.util.Helper;

public class StudentFactory {
    public static Student createStudent(String studentId, String firstName,
                                        String lastName, String email) {
        // Validate student ID
        if (Helper.isNullOrEmpty(studentId)) {
            throw new IllegalArgumentException(
                    studentId == null ? "Student ID cannot be null" : "Student ID cannot be empty"
            );
        }

        // Validate first name
        if (Helper.isNullOrEmpty(firstName)) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }

        // Validate last name
        if (Helper.isNullOrEmpty(lastName)) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }

        // Validate email
        if (Helper.isNullOrEmpty(email)) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (!Helper.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }

        return new Student.Builder()
                .setStudentId(studentId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .build();
    }
}
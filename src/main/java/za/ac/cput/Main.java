
package za.ac.cput;

import za.ac.cput.domain.*;

public class Main {
    public static void main(String[] args) {
        // 1. Create Subject
        Subject math = new Subject.Builder()
                .setSubjectId("MATH101")
                .setName("Mathematics")
                .setDescription("Intro to Algebra")
                .setGradeLevel("10")
                .build();

        // 2. Create Tutor
        Tutor tutor = new Tutor.Builder()
                .setIdentityNumber("T1001")
                .setFirstName("John")
                .setLastName("Smith")
                .setEmail("john.smith@tutoring.com")
                .setSubject("Mathematics")
                .build();

        // 3. Create Student
        Student student = new Student.Builder()
                .setStudentId("S2001")
                .setFirstName("Sarah")
                .setLastName("Johnson")
                .setEmail("sarah.j@student.com")
                .setPassword("secure123")
                .build();

        // 4. Create Session
        Session session = new Session.Builder()
                .setSessionId("SES001")
                .setTutor(tutor)
                .setStudent(student)
                .setSubject(math)
                .setDate("2025-04-15")
                .setTime("14:00")
                .setDuration("60 minutes")
                .build();

        // 5. Create Review
        Review review = new Review.Builder()
                .setReviewId("REV001")
                .setTutorId(tutor.getIdentityNumber())
                .setStudentId(student.getStudentId())
                .setRating(5)
                .setComment("Excellent explanation of quadratic equations")
                .setResponse("Thank you for your feedback!")
                .build();



        // 7. Display all created objects
        System.out.println("=== TUTORING SYSTEM DEMO ===");
        System.out.println("\nSUBJECT:\n" + math);
        System.out.println("\nTUTOR:\n" + tutor);
        System.out.println("\nSTUDENT:\n" + student);
        System.out.println("\nSESSION:\n" + session);
        System.out.println("\nREVIEW:\n" + review);
    }
}
/* OnlineTutoring.java
Main  class
Author: Xolani Masimbe (222410817)
Author: Basetsana Masisi (222309385)
Date: 23 March 2025

*/

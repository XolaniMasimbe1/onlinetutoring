package za.ac.cput.TestFactory;

import za.ac.cput.domain.*;
import za.ac.cput.factory.SessionFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class SessionFactoryTest {

    @Test
    void testCreateSession() {
        Tutor tutor = new Tutor.Builder()
                .setIdentityNumber("T001")
                .setFirstName("Basetsana")
                .setLastName("Masisi")
                .setEmail("Basetsanamasisi@gmail.com")
                .setSubject("Mathematics")
                .build();

        Student student = new Student.Builder()
                .setStudentId("Std001")
                .build();

        Subject subject = new Subject.Builder()
                .setSubjectId("MATH101")
                .setName("Mathematics")
                .setDescription("Advanced Algebra")
                .setGradeLevel("12")
                .build();

        Session session = SessionFactory.createSession(
                "S001", tutor, student, subject, "2025-04-01", "10:00", "1 hour"
        );

        assertNotNull(session);
        assertEquals("Basetsana", session.getTutor().getFirstName());
    }

    @Test
    void testCreateInvalidSession() {
        Session session = SessionFactory.createSession(
                "", null, null, null, "", "", ""
        );

        assertNull(session, "Session should be null for invalid input");
    }
}

/* SessionFactoryTest.java
   Test for SessionFactory
   Author: [Basetsana Masisi (222309385)]
   Date: [26 March 2025]
*/

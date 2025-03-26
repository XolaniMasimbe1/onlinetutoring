package za.ac.cput.TestFactory;



import za.ac.cput.domain.Session;
import za.ac.cput.factory.SessionFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SessionFactoryTest {
    @Test
    void testCreateSession() {
        Session session = SessionFactory.createSession("S001", "T001", "STU001",
                "MATH101", "2025-04-01",
                "10:00", "1 hour");
        assertNotNull(session);
        assertEquals("MATH101", session.getSubjectCode());
    }
    @Test
    void testCreateInvalidSession() {
        Session session = SessionFactory.createSession("", "", "STU001",
                "MATH101", "2025-04-01",
                "10:00", "1 hour");

        assertNull(session, "Session should be null for invalid input");
    }}






/* OnlineTutoring.java
Tutor model class
Author: Basetsana Masisi (222309385)
Date: 23 March 2025
*/
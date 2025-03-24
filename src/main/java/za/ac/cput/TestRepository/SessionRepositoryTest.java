package za.ac.cput.TestRepository;



import za.ac.cput.domain.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Repository.SessionRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;


class SessionRepositoryTest {
    private SessionRepositoryImpl repository;
    private Session session;

    @BeforeEach
    void setUp() {
        repository = SessionRepositoryImpl.getRepository();
        session = new Session.Builder()
                .setSessionId("S001")
                .setTutorId("T001")
                .setStudentId("STU001")
                .setSubjectCode("MATH101") // Updated attribute
                .setDate("2025-04-01")
                .setTime("10:00")
                .setDuration("1 hour") // Now a String
                .build();
        repository.create(session);
    }

    @Test
    void testRead() {
        assertNotNull(repository.read("S001"));
    }

    @Test
    void testDelete() {
        assertTrue(repository.delete("S001"));
    }
}




/* OnlineTutoring.java
Tutor model class
Author: Basetsana Masisi (222309385)
Date: 24 March 2025
*/
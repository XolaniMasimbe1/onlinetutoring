package za.ac.cput.TestRepository;

import za.ac.cput.domain.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.repository.SessionRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class) // Ensures test order
class SessionRepositoryTest {
    private static SessionRepositoryImpl repository;
    private Session session;

    @BeforeEach
    void setUp() {
        repository = SessionRepositoryImpl.getRepository();
        repository.getAll().clear(); // Clear repository before each test

        session = new Session.Builder()
                .setSessionId("S001")
                .setTutorId("T001")
                .setStudentId("STU001")
                .setSubjectCode("MATH101")
                .setDate("2025-04-01")
                .setTime("10:00")
                .setDuration("1 hour")
                .build();
    }

    @Test
    void a_testCreate() {
        Session created = repository.create(session);
        assertNotNull(created);
        assertEquals(session.getSessionId(), created.getSessionId());
        assertTrue(repository.getAll().contains(created));
    }

    @Test
    void b_testRead() {
        repository.create(session); // Ensure session exists first
        Session read = repository.read("S001");
        assertNotNull(read);
        assertEquals(session.getSessionId(), read.getSessionId());
        assertEquals(session.getTutorId(), read.getTutorId());
    }

    @Test
    void c_testUpdate() {
        repository.create(session);
        Session updated = new Session.Builder()
                .copy(session)
                .setTime("11:00") // Change time
                .build();

        Session result = repository.update(updated);
        assertNotNull(result);
        assertEquals("11:00", repository.read("S001").getTime());
    }

    @Test
    void d_testDelete() {
        repository.create(session);
        boolean deleted = repository.delete("S001");
        assertTrue(deleted);
        assertNull(repository.read("S001"));
    }

    @Test
    void e_testGetAll() {
        repository.create(session);
        assertEquals(1, repository.getAll().size());
    }
}





//* OnlineTutoring.java
////
////Tutor model class
//Author: Basetsana Masisi (222309385)
//Date: 24 March 2025
//* /
//*/

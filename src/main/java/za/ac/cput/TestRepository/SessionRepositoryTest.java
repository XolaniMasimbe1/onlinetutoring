package za.ac.cput.TestRepository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Session;
import za.ac.cput.domain.Tutor;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.Subject;
import za.ac.cput.repository.SessionRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class SessionRepositoryTest {
    private SessionRepositoryImpl repository;
    private Session session;
    private Tutor tutor;
    private Student student;
    private Subject subject;

    @BeforeEach
    void setUp() {
        repository = SessionRepositoryImpl.getRepository();

        tutor = new Tutor.Builder().setIdentityNumber("Tt01").build();
        student = new Student.Builder().setStudentId("Std01").build();
        subject = new Subject.Builder().setSubjectId("Sbj01").build();

        session = new Session.Builder()
                .setSessionId("Ss01")
                .setTutor(tutor)
                .setStudent(student)
                .setSubject(subject)
                .setDate("2025-04-01")
                .setTime("10:00")
                .setDuration("1 hour")
                .build();
    }

    @AfterEach
    void tearDown() {
        repository.getAll().clear();
    }

    @Test
    void a_testCreate() {
        Session created = repository.create(session);
        assertNotNull(created);
        assertEquals("S001", created.getSessionId());
        assertEquals(1, repository.getAll().size());
    }

    @Test
    void b_testRead() {
        repository.create(session);
        Session found = repository.read("S001");
        assertNotNull(found);
        assertEquals("S001", found.getSessionId());
    }

    @Test
    void c_testUpdate() {
        repository.create(session);
        Session updated = new Session.Builder()
                .copy(session)
                .setTime("11:00")
                .build();

        repository.update(updated);
        Session result = repository.read("S001");
        assertEquals("11:00", result.getTime());
    }

    @Test
    void d_testDelete() {
        repository.create(session);
        boolean deleted = repository.delete("S001");
        assertTrue(deleted);
        assertNull(repository.read("S001"));
        assertEquals(0, repository.getAll().size());
    }

    @Test
    void e_testGetAll() {
        repository.create(session);
        assertEquals(1, repository.getAll().size());
    }
}
/* SessionRepositoryTest.java
   Test for SessionRepository
   Author: [Basetsana Masisi (222309385)]
   Date: [26 March 2025]
*/

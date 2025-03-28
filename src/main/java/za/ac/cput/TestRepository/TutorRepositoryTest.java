package za.ac.cput.TestRepository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Tutor;
import za.ac.cput.factory.TutorFactory;
import za.ac.cput.repository.TutorRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class TutorRepositoryTest {

    private static TutorRepository repository = TutorRepository.getRepository();
    private static Tutor tutor = TutorFactory.createTutorFactory(
            "0103315193088", "Xolani", "Masimbe",
            "222410817@mycput.ac.za", "Mathematics");

    @Test
    void a_create() {
        Tutor created = repository.create(tutor);
        assertNotNull(created);
        System.out.println("Created: " + created.toString());
    }

    @Test
    void b_read() {
        Tutor read = repository.read(tutor.getIdentityNumber());
        assertNotNull(read);
        System.out.println("Read: " + read.toString());
    }

    @Test
    void c_update() {
        Tutor newTutor = new Tutor.Builder()
                .copy(tutor)
                .setLastName("Masimbe-Updated")
                .setEmail("xolani.updated@email.com")
                .build();
        Tutor updated = repository.update(newTutor);
        assertNotNull(updated);
        System.out.println("Updated: " + updated.toString());
    }

    @Test
    @Disabled
    void d_delete() {
        assertTrue(repository.delete(tutor.getIdentityNumber()));
        System.out.println("Deleted: successfully " );
    }

    @Test
    void e_getAll() {
        System.out.println(repository.getAll());
    }
}
/* OnlineTutoring.java
Tutor TestRepository class
Author: Xolani Masimbe (222410817)
Date: 23 March 2025

*/
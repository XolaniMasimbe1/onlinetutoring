package za.ac.cput.TestRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Tutor;
import za.ac.cput.factory.TutorFactory;
import za.ac.cput.repository.TutorRepository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class TutorRepositoryTest {
    private TutorRepository repository;
    private Tutor tutor1, tutor2;

    @BeforeEach
    void setUp() {
        TutorRepository.resetRepository();
        repository = TutorRepository.getRepository();
        repository.getAll().clear();

        tutor1 = TutorFactory.createTutorFactory(
                "0103315193088", "Xolani", "Masimbe",
                "222410817@mycput.ac.za", "Mathematics");

        tutor2 = TutorFactory.createTutorFactory(
                "0312070536881", "Hope", "Kgomokaboya",
                "22215474@mycput.ac.za", "Physical Science");

        repository.create(tutor1);
        System.out.println("Initial tutor created: " + tutor1.getIdentityNumber());
    }

    @Test
    void create_Success() {
        Tutor created = repository.create(tutor2);
        assertNotNull(created);
        assertEquals(tutor2.getIdentityNumber(), created.getIdentityNumber());
        assertEquals(2, repository.getAll().size());
        System.out.println("Successfully created tutor: " + created.getIdentityNumber());
        System.out.println("Current repository size: " + repository.getAll().size());
    }

    @Test
    void create_Fail_NullTutor() {
        assertThrows(NullPointerException.class, () -> repository.create(null));
        System.out.println("Test passed: NullPointerException thrown for null tutor");
    }

    @Test
    void read_Success() {
        Tutor found = repository.read(tutor1.getIdentityNumber());
        assertNotNull(found);
        assertEquals(tutor1.getIdentityNumber(), found.getIdentityNumber());
        assertEquals(tutor1.getFirstName(), found.getFirstName());
        System.out.println("Successfully retrieved tutor: " + found.getIdentityNumber());
    }

    @Test
    void read_Fail_NotFound() {
        Tutor found = repository.read("9999999999999");
        assertNull(found);
        System.out.println("Test passed: Returned null for non-existent tutor");
    }

    @Test
    void read_Fail_NullId() {
        assertThrows(NullPointerException.class, () -> repository.read(null));
        System.out.println("Test passed: NullPointerException thrown for null ID");
    }

    @Test
    void update_Success() {
        Tutor updatedTutor = new Tutor.Builder()
                .copy(tutor1)
                .setLastName("Masimbe-Updated")
                .setEmail("xolani.updated@email.com")
                .build();

        Tutor result = repository.update(updatedTutor);
        assertNotNull(result);
        assertEquals("Masimbe-Updated", result.getLastName());

        Tutor retrieved = repository.read(tutor1.getIdentityNumber());
        assertEquals("xolani.updated@email.com", retrieved.getEmail());
        System.out.println("Successfully updated tutor: " + retrieved.getIdentityNumber());
        System.out.println("New last name: " + retrieved.getLastName());
        System.out.println("New email: " + retrieved.getEmail());
    }

    @Test
    void update_Fail_NotFound() {
        Tutor nonExistingTutor = TutorFactory.createTutorFactory(
                "9999999999999", "None", "Existing",
                "none@email.com", "Physics");
        Tutor result = repository.update(nonExistingTutor);
        assertNull(result);
        System.out.println("Test passed: Returned null for non-existent tutor update");
    }

    @Test
    void update_Fail_NullTutor() {
        assertThrows(NullPointerException.class, () -> repository.update(null));
        System.out.println("Test passed: NullPointerException thrown for null tutor update");
    }

    @Test
    void delete_Success() {
        boolean deleted = repository.delete(tutor1.getIdentityNumber());
        assertTrue(deleted);
        assertNull(repository.read(tutor1.getIdentityNumber()));
        assertEquals(0, repository.getAll().size());
        System.out.println("Successfully deleted tutor: " + tutor1.getIdentityNumber());
        System.out.println("Current repository size: " + repository.getAll().size());
    }

    @Test
    void delete_Fail_NotFound() {
        boolean deleted = repository.delete("9999999999999");
        assertFalse(deleted);
        assertEquals(1, repository.getAll().size());
        System.out.println("Test passed: Returned false for non-existent tutor deletion");
    }

    @Test
    void delete_Fail_NullId() {
        assertThrows(NullPointerException.class, () -> repository.delete(null));
        System.out.println("Test passed: NullPointerException thrown for null ID deletion");
    }

    @Test
    void getAll_Success() {
        repository.create(tutor2);
        List<Tutor> allTutors = repository.getAll();
        assertEquals(2, allTutors.size());
        assertTrue(allTutors.contains(tutor1));
        assertTrue(allTutors.contains(tutor2));
        System.out.println("Successfully retrieved all tutors:");
        allTutors.forEach(tutor -> System.out.println(" - " + tutor.getIdentityNumber()));
    }

    @Test
    void getAll_Empty() {
        repository.delete(tutor1.getIdentityNumber());
        List<Tutor> allTutors = repository.getAll();
        assertTrue(allTutors.isEmpty());
        System.out.println("Test passed: Repository is empty after deletion");
    }

    @Test
    void testTutorEqualityInRepository() {
        Tutor duplicateTutor = TutorFactory.createTutorFactory(
                tutor1.getIdentityNumber(), "Duplicate", "Tutor",
                "duplicate@email.com", "Math");

        Tutor result = repository.create(duplicateTutor);

        if (result != null) {
            System.out.println("Repository allows overwriting existing tutors");
            assertEquals(1, repository.getAll().size());
            Tutor retrieved = repository.read(tutor1.getIdentityNumber());
            assertEquals(duplicateTutor.getFirstName(), retrieved.getFirstName());
            System.out.println("Tutor overwritten with new first name: " + retrieved.getFirstName());
        } else {
            System.out.println("Repository prevents duplicate tutors");
            assertEquals(1, repository.getAll().size());
            Tutor retrieved = repository.read(tutor1.getIdentityNumber());
            assertEquals(tutor1.getFirstName(), retrieved.getFirstName());
            System.out.println("Original tutor maintained: " + retrieved.getFirstName());
        }
    }
}
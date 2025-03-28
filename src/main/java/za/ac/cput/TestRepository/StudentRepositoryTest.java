package za.ac.cput.TestRepository;

/* Student.java
   Author: Anda Matomela (222578912)
   Date: 22 March 2025
   Modified: 28 March 2025
*/

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.repository.StudentRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class StudentRepositoryTest {

    private static StudentRepository repository = StudentRepository.getRepository();
    private static Student student = StudentFactory.createStudent(
            "S001", "John", "Doe", "john.doe@example.com");

    @Test
    void a_create() {
        Student created = repository.create(student);
        assertNotNull(created);
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Student read = repository.read(student.getStudentId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Student updatedStudent = new Student.Builder()
                .copy(student)
                .setLastName("Smith")
                .setEmail("john.smith@example.com")
                .build();
        Student updated = repository.update(updatedStudent);
        assertNotNull(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    @Disabled
    void d_delete() {
        boolean success = repository.delete(student.getStudentId());
        assertTrue(success);
        System.out.println("Deleted: successfully");
    }

    @Test
    void e_getAll() {
        System.out.println("All students: " + repository.getAll());
    }
}
package za.ac.cput.TestRepository;

import za.ac.cput.domain.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.repository.StudentRepository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class StudentRepositoryTest {
    private StudentRepository studentRepository;

    @BeforeEach
    public void setUp() {
        // Reset the repository before each test
        StudentRepository.resetRepository();
        studentRepository = StudentRepository.getRepository();
    }

    @Test
    public void testCreateStudent() {
        Student student = new Student.Builder()
                .setStudentId("S001")
                .setFirstName("John")
                .setLastName("Doe")
                .setEmail("john.doe@example.com")
                .build();

        Student created = studentRepository.create(student);
        assertNotNull(created);
        assertEquals("S001", created.getStudentId());
        assertEquals(1, studentRepository.getAll().size());
    }

    @Test
    public void testReadStudent() {
        Student student = new Student.Builder()
                .setStudentId("S002")
                .setFirstName("Jane")
                .setLastName("Smith")
                .setEmail("jane.smith@example.com")
                .build();

        studentRepository.create(student);
        Student readStudent = studentRepository.read("S002");

        assertNotNull(readStudent);
        assertEquals("Jane", readStudent.getFirstName());
    }

    @Test
    public void testUpdateStudent() {
        Student student = new Student.Builder()
                .setStudentId("S003")
                .setFirstName("Alice")
                .setLastName("Johnson")
                .setEmail("alice.johnson@example.com")
                .build();

        studentRepository.create(student);

        Student updatedStudent = new Student.Builder()
                .copy(student)
                .setLastName("Brown")
                .setEmail("alice.brown@example.com")
                .build();

        Student result = studentRepository.update(updatedStudent);
        assertNotNull(result);
        assertEquals("Brown", result.getLastName());
        assertEquals(1, studentRepository.getAll().size());
    }

    @Test
    public void testDeleteStudent() {
        Student student = new Student.Builder()
                .setStudentId("S004")
                .setFirstName("Bob")
                .setLastName("White")
                .setEmail("bob.white@example.com")
                .build();

        studentRepository.create(student);
        assertTrue(studentRepository.delete("S004"));
        assertNull(studentRepository.read("S004"));
        assertEquals(0, studentRepository.getAll().size());
    }

    @Test
    public void testGetAllStudents() {
        Student student1 = new Student.Builder()
                .setStudentId("S005")
                .setFirstName("Tom")
                .setLastName("Brown")
                .setEmail("tom.brown@example.com")
                .build();

        Student student2 = new Student.Builder()
                .setStudentId("S006")
                .setFirstName("Sara")
                .setLastName("Davis")
                .setEmail("sara.davis@example.com")
                .build();

        studentRepository.create(student1);
        studentRepository.create(student2);

        List<Student> students = studentRepository.getAll();
        assertEquals(2, students.size());
    }

    @Test
    public void testCreateDuplicateStudent() {
        Student student1 = new Student.Builder()
                .setStudentId("S007")
                .setFirstName("John")
                .setLastName("Doe")
                .setEmail("john.doe@example.com")
                .build();

        Student student2 = new Student.Builder()
                .setStudentId("S007")  // Same ID
                .setFirstName("Jane")
                .setLastName("Doe")
                .setEmail("jane.doe@example.com")
                .build();

        studentRepository.create(student1);
        Student duplicate = studentRepository.create(student2);

        // Depending on your requirements - either should be null or overwrite
        if (duplicate == null) {
            assertNull(duplicate);
            assertEquals(1, studentRepository.getAll().size());
        } else {
            assertEquals("Jane", studentRepository.read("S007").getFirstName());
            assertEquals(1, studentRepository.getAll().size());
        }
    }
}
/* Student.java
   Author: Anda Matomela (222578912)
   Date: 22 March 2025
*/

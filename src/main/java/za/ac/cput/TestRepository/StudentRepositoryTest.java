package za.ac.cput.TestRepository;

/* StudentRepositoryTest.java
   Author: Anda Matomela (222578912)
   Date: 22 March 2025
*/

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

        assertNotNull(studentRepository.create(student));
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
                .setStudentId("S003")
                .setFirstName("Alice")
                .setLastName("Brown")
                .setEmail("alice.brown@example.com")
                .build();

        assertNotNull(studentRepository.update(updatedStudent));
        assertEquals("Brown", studentRepository.read("S003").getLastName());
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
}
package za.ac.cput.TestFactory;

/* Student.java
   Author: Anda Matomela (222578912)
   Date: 22 March 2025
   Modified: 28 March 2025
*/

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.StudentFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentFactoryTest {

    private static Student s1;
    private static Student s2;
    private static Student s3;

    @BeforeAll
    public static void setUp() {
        s1 = StudentFactory.createStudent("S123", "John", "Doe", "john.doe@example.com");
        s2 = StudentFactory.createStudent("S124", "Jane", "Smith", "jane.smith@example.com");
        try {
            s3 = StudentFactory.createStudent("", "Anda", "Matomela", "222578912@mycput.ac.za");
        } catch (IllegalArgumentException e) {

            s3 = null;
        }
    }

    @Test
    @Order(1)
    public void testCreateStudent() {
        assertNotNull(s1);
        System.out.println(s1);
    }

    @Test
    @Order(2)
    public void testCreateStudentWithValidData() {
        assertNotNull(s2);
        System.out.println(s2.toString());
    }

    @Test
    @Order(3)
    public void testCreateStudentThatFails() {
        assertNull(s3);
        System.out.println(s3);
    }

    @Test
    @Disabled
    @Order(4)
    public void testNotImplementedYet() {
        System.out.println("This test is not implemented yet");
    }
}
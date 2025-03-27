package za.ac.cput.TestFactory;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Tutor;
import za.ac.cput.factory.TutorFactory;

import static org.junit.jupiter.api.Assertions.*;

public class TutorFactoryTest {
    @Test
    @Order(1)
    public void testCreateTutor() {
        Tutor t1 = TutorFactory.createTutorFactory("0103315193088", "Xolani",
                "Masimbe", "222410817@mycput.ac.za", "Mathematics");
        assertNotNull(t1);
        System.out.println("Created Tutor: " + t1);
    }

    @Test
    @Order(2)
    public void testCreateAnotherTutor() {
        Tutor t2 = TutorFactory.createTutorFactory("0312070536881", "Hope", "Kgomokaboya",
                "22215474@mycput.ac.za", "Physical Science");
        assertNotNull(t2);
        System.out.println("Created another Tutor: " + t2);
    }

    @Test
    @Order(3)
    public void testCreateInvalidTutor() {
        Tutor t3 = TutorFactory.createTutorFactory("", "Thoblie",
                "Masimbe", "thobile@gmail.com", "Life Orientation");
        assertNull(t3, "Should return null for empty identity number");
        System.out.println("Invalid tutor creation test passed (returned null as expected)");
    }

    @Test
    @Order(4)
    public void testCreateTutorWithNullName() {
        Tutor t4 = TutorFactory.createTutorFactory("0211071405088", null,
                "Mandlaze", "isabelmandlaze@gmail.com", "History");
        assertNull(t4, "Should return null when creating tutor with null name");
        System.out.println("Null first name test passed (returned null as expected)");
    }

    @Test
    @Order(5)
    public void testTutorEquality() {
        Tutor t1 = TutorFactory.createTutorFactory("0103315193088", "Xolani", "Masimbe",
                "222410817@mycput.ac.za", "Mathematics");
        Tutor t5 = TutorFactory.createTutorFactory("0103315193088", "Xolani", "Masimbe",
                "222410817@mycput.ac.za", "Mathematics");
        assertEquals(t1.getIdentityNumber(), t5.getIdentityNumber(), "Tutors with same ID should be equal");
        System.out.println("Equality test passed for tutor IDs: " + t1.getIdentityNumber());
    }
}
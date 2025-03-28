package za.ac.cput.TestFactory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Tutor;
import za.ac.cput.factory.TutorFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TutorFactoryTest {
    private static Tutor t1 = TutorFactory.createTutorFactory("0103315193088", "Xolani", "Masimbe");

    private static Tutor t2 = TutorFactory.createTutorFactory("0312070536881", "Hope", "Kgomokaboya",
            "22215474@mycput.ac.za", "Physical Science");

    private static Tutor t3 = TutorFactory.createTutorFactory("0211071405088", "Isabel", "Mandlaze",
            "isabelcput.ac.za", "History");

    @Test
    @Order(1)
    public void testCreateTutor() {
        assertNotNull(t1);
        System.out.println( t1);
    }

    @Test
    @Order(2)
    public void testCreateTutorWithAllAttributes() {
        assertNotNull(t2);
        System.out.println( t2.toString());
    }

    @Test
    @Order(3)
    public void testCreateTutorThatFails() {
        assertNull(t3);
        System.out.println(t3);
    }

    @Test
    @Disabled
    @Order(4)
    public void testNotImplementedYet() {
        System.out.println("This test is not implemented yet");
    }
}
/* OnlineTutoring.java
Tutor TestFactory class
Author: Xolani Masimbe (222410817)
Date: 28 March 2025

*/

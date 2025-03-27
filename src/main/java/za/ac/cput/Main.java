package za.ac.cput;

import za.ac.cput.domain.Tutor;
import za.ac.cput.factory.TutorFactory;
import za.ac.cput.repository.TutorRepository;

public class Main {
    public static void main(String[] args) {
        // Get the repository instance
        TutorRepository repository = TutorRepository.getRepository();

        System.out.println("=== TUTOR MANAGEMENT SYSTEM ===");
        System.out.println();

        // Create some tutors using the factory
        System.out.println("Creating tutors...");
        Tutor tutor1 = TutorFactory.createTutorFactory(
                "0103315193088", "Xolani", "Masimbe",
                "xolani@tutor.com", "Mathematics");

        Tutor tutor2 = TutorFactory.createTutorFactory(
                "0312070536881", "Hope", "Kgomokaboya",
                "hope@tutor.com", "Physical Science");

        Tutor tutor3 = TutorFactory.createTutorFactory(
                "0211071405088", "Isabel", "Mandlaze",
                "isabel@tutor.com", "History");

        // Add tutors to repository
        repository.create(tutor1);
        repository.create(tutor2);
        repository.create(tutor3);

        // Display all tutors
        System.out.println("\nAll Tutors in Repository:");
        repository.getAll().forEach(System.out::println);

        // Read a specific tutor
        System.out.println("\nReading tutor with ID 0103315193088:");
        Tutor foundTutor = repository.read("0103315193088");
        System.out.println(foundTutor);

        // Update a tutor
        System.out.println("\nUpdating tutor with ID 0103315193088...");
        Tutor updatedTutor = new Tutor.Builder()
                .copy(tutor1)
                .setEmail("xolani.updated@tutor.com")
                .setSubject("Advanced Mathematics")
                .build();
        repository.update(updatedTutor);
        System.out.println("Updated tutor: " + repository.read("0103315193088"));

        // Delete a tutor
        System.out.println("\nDeleting tutor with ID 0211071405088...");
        boolean deleted = repository.delete("0211071405088");
        System.out.println("Delete successful: " + deleted);

        // Display remaining tutors
        System.out.println("\nRemaining Tutors in Repository:");
        repository.getAll().forEach(System.out::println);

        // Try to create an invalid tutor
        System.out.println("\nAttempting to create invalid tutor...");
        Tutor invalidTutor = TutorFactory.createTutorFactory(
                null, "Invalid", "Tutor", "bad-email", null);
        System.out.println("Invalid tutor created: " + (invalidTutor != null));
    }
}
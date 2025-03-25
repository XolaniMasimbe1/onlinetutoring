package za.ac.cput;

import za.ac.cput.repository.SessionRepositoryImpl;
import za.ac.cput.domain.Session;
import za.ac.cput.factory.SessionFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Get the repository instance
        SessionRepositoryImpl sessionRepository = SessionRepositoryImpl.getRepository();

        // Create sessions using factory
        Session session1 = SessionFactory.createSession("S001", "T001", "STU001",
                "MATH101", "2025-04-01", "10:00", "1 hour");

        Session session2 = SessionFactory.createSession("S002", "T002", "STU002",
                "ENG102", "2025-04-02", "12:00", "2 hours");

        // Add sessions to repository
        sessionRepository.create(session1);
        sessionRepository.create(session2);

        // Display all sessions
        System.out.println("\n=== All Sessions ===");
        displaySessions(sessionRepository.getAll());

        // Read a session
        System.out.println("\n=== Reading Session S001 ===");
        Session foundSession = sessionRepository.read("S001");
        System.out.println(foundSession != null ? foundSession : "Session not found!");

        // Update a session
        System.out.println("\n=== Updating Session S001 ===");
        Session updatedSession = new Session.Builder()
                .copy(session1)  // Using copy constructor
                .setSubjectCode("PHY103") // Updated subject code
                .setDate("2025-04-05") // Updated date
                .setTime("14:00")
                .setDuration("1 hour 30 minutes")
                .build();
        sessionRepository.update(updatedSession);

        // Show updated session
        System.out.println("Updated Session S001:");
        System.out.println(sessionRepository.read("S001"));

        // Delete a session with emoji visual indicator
        System.out.println("\n🗑 === Deleting Session S002 ===");
        boolean deleted = sessionRepository.delete("S002");
        System.out.println(deleted ? "Successfully deleted Session S002" : "Failed to delete Session S002");

        // Display remaining sessions
        System.out.println("\n=== Remaining Sessions After Deletion ===");
        displaySessions(sessionRepository.getAll());
    }

    private static void displaySessions(List<Session> sessions) {
        if (sessions == null || sessions.isEmpty()) {
            System.out.println("No sessions found.");
        } else {
            sessions.forEach(System.out::println);
        }
    }
}
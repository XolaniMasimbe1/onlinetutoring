//package za.ac.cput;
//
//
//
//
//import za.ac.cput.Repository.SessionRepositoryImpl;
//import za.ac.cput.domain.Session;
//import za.ac.cput.factory.SessionFactory;
//
//import java.util.Set;
//
//public class Main {
//    public static void main(String[] args) {
//
//        SessionRepositoryImpl sessionRepository = SessionRepositoryImpl.getRepository();
//
//
//        Session session1 = SessionFactory.createSession("S001", "T001", "STU001",
//                "MATH101", "2025-04-01", "10:00", "1 hour");
//
//        Session session2 = SessionFactory.createSession("S002", "T002", "STU002",
//                "ENG102", "2025-04-02", "12:00", "2 hours");
//
//
//        sessionRepository.create(session1);
//        sessionRepository.create(session2);
//
//
//        System.out.println("\n All Sessions:");
//        displaySessions(sessionRepository.getAll());
//
//
//        System.out.println("\n Reading Session S001:");
//        Session foundSession = sessionRepository.read("S001");
//        System.out.println(foundSession != null ? foundSession : "Session not found!");
//
//
//        System.out.println("\n Updating Session S001:");
//        Session updatedSession = new Session.Builder()
//                .setSessionId("S001")
//                .setTutorId("T001")
//                .setStudentId("STU001")
//                .setSubjectCode("PHY103") // Updated subject code
//                .setDate("2025-04-05") // Updated date
//                .setTime("14:00")
//                .setDuration("1 hour 30 minutes")
//                .build();
//        sessionRepository.update(updatedSession);
//
//
//        System.out.println(" Updated Session S001:");
//        System.out.println(sessionRepository.read("S001"));
//
//
//        System.out.println("\n🗑 Deleting Session S002...");
//        sessionRepository.delete("S002");
//
//
//        System.out.println("\n Remaining Sessions After Deletion:");
//        displaySessions(sessionRepository.getAll());
//    }
//
//
//    private static void displaySessions(Set<Session> sessions) {
//        if (sessions.isEmpty()) {
//            System.out.println("No sessions found.");
//        } else {
//            for (Session session : sessions) {
//                System.out.println(session);
//            }
//        }
//    }
//}
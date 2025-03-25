package za.ac.cput.factory;

import za.ac.cput.domain.Session;

public class SessionFactory
{
    public static Session createSession(String sessionId, String tutorId, String studentId,
                                        String subjectCode, String date, String time,
                                        String duration) {

        if (sessionId == null || sessionId.isEmpty() ||
                tutorId == null || tutorId.isEmpty() ||
                studentId == null || studentId.isEmpty() ||
                subjectCode == null || subjectCode.isEmpty() ||
                date == null || date.isEmpty() ||
                time == null || time.isEmpty() ||
                duration == null || duration.isEmpty()) {
            return null;
        }

        return new Session.Builder()
                .setSessionId(sessionId)
                .setTutorId(tutorId)
                .setStudentId(studentId)
                .setSubjectCode(subjectCode) // Updated attribute
                .setDate(date)
                .setTime(time)
                .setDuration(duration) // Now a String
                .build();
    }

}


/* OnlineTutoring.java
Tutor model class
Author: Basetsana Masisi (222309385)
Date: 22 March 2025
modified 25 March 2025
*/

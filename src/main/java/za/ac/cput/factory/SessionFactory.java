package za.ac.cput.factory;

import za.ac.cput.domain.*;

public class SessionFactory {
    public static Session createSession(String sessionId, Tutor tutor, Student student,
                                        Subject subject, String date, String time,
                                        String duration) {

        if (sessionId == null || sessionId.isEmpty() ||
                tutor == null || student == null || subject == null ||
                date == null || date.isEmpty() ||
                time == null || time.isEmpty() ||
                duration == null || duration.isEmpty()) {
            return null;
        }

        return new Session.Builder()
                .setSessionId(sessionId)
                .setTutor(tutor)
                .setStudent(student)
                .setSubject(subject)
                .setDate(date)
                .setTime(time)
                .setDuration(duration)
                .build();
    }
}
/* Onlinetutoring
Session factory.java
   Author Basetsana Masisi(222309385)
   Date: 22 March 2025
   modified 25 March 2025
*/

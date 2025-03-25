package za.ac.cput.domain;

import java.util.Objects;

public class Session {
    private final String sessionId;
    private final String tutorId;
    private final String studentId;
    private final String subjectCode;
    private final String date;
    private final String time;
    private final String duration;

    private Session(Builder builder) {
        this.sessionId = builder.sessionId;
        this.tutorId = builder.tutorId;
        this.studentId = builder.studentId;
        this.subjectCode = builder.subjectCode;
        this.date = builder.date;
        this.time = builder.time;
        this.duration = builder.duration;
    }


    public String getSessionId() { return sessionId; }
    public String getTutorId (){ return tutorId; }
    public String getStudentId() { return studentId; }
    public String getSubjectCode() { return subjectCode; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getDuration() { return duration; }


    public static class Builder {
        private String sessionId;
        private String tutorId;
        private String studentId;
        private String subjectCode;
        private String date;
        private String time;
        private String duration;

        public Builder setSessionId(String sessionId) {
            this.sessionId = sessionId;
            return this;
        }

        public Builder setTutorId(String tutorId) {
            this.tutorId = tutorId;
            return this;
        }

        public Builder setStudentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder setSubjectCode(String subjectCode) {
            this.subjectCode = subjectCode;
            return this;
        }

        public Builder setDate(String date) {
            this.date = date;
            return this;
        }

        public Builder setTime(String time) {
            this.time = time;
            return this;
        }

        public Builder setDuration(String duration) {
            this.duration = duration;
            return this;
        }

        public Session build() {
            return new Session(this);
        }


        public Builder copy(Session session) {
            this.sessionId = session.sessionId;
            this.tutorId = session.tutorId;
            this.studentId = session.studentId;
            this.subjectCode = session.subjectCode;
            this.date = session.date;
            this.time = session.time;
            this.duration = session.duration;
            return this;
        }
    }

    @Override
    public String toString() {
        return "Session{" +
                "sessionId='" + sessionId + '\'' +
                ", tutorId='" + tutorId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", subjectCode='" + subjectCode + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return Objects.equals(sessionId, session.sessionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionId);
    }
}


/* OnlineTutoring.java
Tutor model class
Author: Basetsana Masisi (222309385)
Date: 21 March 2025
modify 24 march
*/

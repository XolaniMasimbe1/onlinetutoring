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
    public String getTutorId() { return tutorId; }
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
    }
}
/* OnlineTutoring.java
Tutor model class
Author: Basetsana Masisi (222309385)
Date: 22 March 2025
*/

package za.ac.cput.domain;

import java.util.Objects;

public class Session {
    private final String sessionId;
    private final Tutor tutor;
    private final Student student;
    private final Subject subject;
    private final String date;
    private final String time;
    private final String duration;
    private Review review;

    private Session(Builder builder) {
        this.sessionId = builder.sessionId;
        this.tutor = builder.tutor;
        this.student = builder.student;
        this.subject = builder.subject;
        this.date = builder.date;
        this.time = builder.time;
        this.duration = builder.duration;
        this.review = builder.review;
    }


    public String getSessionId() { return sessionId; }
    public Tutor getTutor() { return tutor; }
    public Student getStudent() { return student; }
    public Subject getSubject() { return subject; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getDuration() { return duration; }
    public Review getReview() { return review; }



    public static class Builder {
        private String sessionId;
        private Tutor tutor;
        private Student student;
        private Subject subject;
        private String date;
        private String time;
        private String duration;
        private Review review;

        public Builder setSessionId(String sessionId) {
            this.sessionId = sessionId;
            return this;
        }

        public Builder setTutor(Tutor tutor) {
            this.tutor = tutor;
            return this;
        }

        public Builder setStudent(Student student) {
            this.student = student;
            return this;
        }

        public Builder setSubject(Subject subject) {
            this.subject = subject;
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



        public Builder copy(Session session) {
            this.sessionId = session.sessionId;
            this.tutor = session.tutor;
            this.student = session.student;
            this.subject = session.subject;
            this.date = session.date;
            this.time = session.time;
            this.duration = session.duration;
            this.review = session.review;
            return this;
        }

        public Session build() {
            return new Session(this);
        }
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

    @Override
    public String toString() {
        return "Session{" +
                "sessionId='" + sessionId + '\'' +
                ", tutor=" + tutor +
                ", student=" + student +
                ", subject=" + subject +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", duration='" + duration + '\'' +
                ", review=" + review +
                '}';
    }
}

/*  onlineturing
Session.java
   Author: Basetsana Masisi (222309385)
   Date: 21 March 2025
   modified 25 March 2025
*/


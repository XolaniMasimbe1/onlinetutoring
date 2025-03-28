package za.ac.cput.domain;

import java.util.ArrayList;
import java.util.List;

public class Tutor {
    private String identityNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String subject;
    private List<Session> sessions;
    private List<Review> reviews;

    public Tutor() {
        this.sessions = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    private Tutor(Builder builder) {
        this.identityNumber = builder.identityNumber;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.subject = builder.subject;
        this.sessions = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }


    public String getIdentityNumber() {
        return identityNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSubject() {
        return subject;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addSession(Session session) {
        this.sessions.add(session);
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "identityNumber='" + identityNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                ", sessions=" + sessions +
                ", reviews=" + reviews +
                '}';
    }

    public static class Builder {
        private String identityNumber;
        private String firstName;
        private String lastName;
        private String email;
        private String subject;

        public Builder setIdentityNumber(String identityNumber) {
            this.identityNumber = identityNumber;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setSubject(String subject) {
            this.subject = subject;
            return this;
        }
        public Builder copy(Tutor tutor) {
            this.identityNumber = tutor.identityNumber;
            this.firstName = tutor.firstName;
            this.lastName = tutor.lastName;
            this.email = tutor.email;
            this.subject = tutor.subject;
            return this;
        }

        public Tutor build() {
            return new Tutor(this);
        }
    }
}
/* OnlineTutoring.java
Subject model class
Author: Xolani Masimbe (222410817)
Date: 23 March 2025

*/
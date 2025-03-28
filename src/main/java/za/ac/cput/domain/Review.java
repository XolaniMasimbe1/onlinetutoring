package za.ac.cput.domain;

import java.util.Objects;

/**
 * Review domain class representing a student's review of a tutoring session.
 */
public class Review {
    private final String reviewId;
    private final String tutorId;
    private final String studentId;
    private final int rating;
    private final String comment;
    private final String response;

    private Review(Builder builder) {
        this.reviewId = builder.reviewId;
        this.tutorId = builder.tutorId;
        this.studentId = builder.studentId;
        this.rating = builder.rating;
        this.comment = builder.comment;
        this.response = builder.response;
    }

    // Getters
    public String getReviewId() { return reviewId; }
    public String getTutorId() { return tutorId; }
    public String getStudentId() { return studentId; }
    public int getRating() { return rating; }
    public String getComment() { return comment; }
    public String getResponse() { return response; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(reviewId, review.reviewId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId);
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId='" + reviewId + '\'' +
                ", tutorId='" + tutorId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", response='" + response + '\'' +
                '}';
    }

    public static class Builder {
        private String reviewId;
        private String tutorId;
        private String studentId;
        private int rating;
        private String comment;
        private String response;

        public Builder setReviewId(String reviewId) {
            this.reviewId = reviewId;
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

        public Builder setRating(int rating) {
            this.rating = rating;
            return this;
        }

        public Builder setComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder setResponse(String response) {
            this.response = response;
            return this;
        }

        public Builder copy(Review review) {
            this.reviewId = review.reviewId;
            this.tutorId = review.tutorId;
            this.studentId = review.studentId;
            this.rating = review.rating;
            this.comment = review.comment;
            this.response = review.response;
            return this;
        }

        public Review build() {
            return new Review(this);
        }
    }
}
/* OnlineTutoring.java
Subject model class
Author: Njabulo Nicco Mathebela (212061208)
Date: 23 March 2025

*/
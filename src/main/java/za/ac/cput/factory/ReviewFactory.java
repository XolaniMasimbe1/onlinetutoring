/* OnlineTutoring.java
Tutor model class
Author: Njabulo N Mathabela (212061208)
Date: 23 March 2025
*/
package za.ac.cput.factory;

import za.ac.cput.domain.Review;

public class ReviewFactory {

    public static Review createReview(String reviewId, String tutorId, String studentId, int rating, String comment, String response) {
        if (reviewId == null || reviewId.isEmpty() ||
                tutorId == null || tutorId.isEmpty() ||
                studentId == null || studentId.isEmpty()) {
            throw new IllegalArgumentException("Review ID, Tutor ID, and Student ID cannot be null or empty.");
        }

        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5.");
        }

        return new Review.Builder()
                .setReviewId(reviewId)
                .setTutorId(tutorId)
                .setStudentId(studentId)
                .setRating(rating)
                .setComment(comment != null ? comment : "") // Ensure non-null comment
                .setResponse(response != null ? response : "") // Ensure non-null response
                .build();
    }
}


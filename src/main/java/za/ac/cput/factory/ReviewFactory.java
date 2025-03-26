package za.ac.cput.factory;

import za.ac.cput.domain.Review;
import za.ac.cput.util.Helper;

public class ReviewFactory {
    public static Review createReview(String reviewId, String tutorId, String studentId,
                                      int rating, String comment, String response) {
        // Validate required fields
        if (Helper.isNullOrEmpty(reviewId) || Helper.isNullOrEmpty(tutorId) || Helper.isNullOrEmpty(studentId)) {
            throw new IllegalArgumentException("Review ID, Tutor ID, and Student ID cannot be null or empty.");
        }

        // Validate rating
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5.");
        }

        return new Review.Builder()
                .setReviewId(reviewId)
                .setTutorId(tutorId)
                .setStudentId(studentId)
                .setRating(rating)
                .setComment(comment)
                .setResponse(response)
                .build();
    }
}
/* OnlineTutoring.java
Tutor model class
Author: Njabulo N Mathabela (212061208)
Date: 24 March 2025
*/
package za.ac.cput.repository;

import za.ac.cput.domain.Review;

import java.util.HashSet;
import java.util.Set;

public class ReviewRepository implements IRepository<Review, String> {
    private static ReviewRepository repository = null;
    private Set<Review> reviewDB;

    private ReviewRepository() {
        this.reviewDB = new HashSet<>();
    }

    public static ReviewRepository getRepository() {
        if (repository == null) {
            repository = new ReviewRepository();
        }
        return repository;
    }

    @Override
    public Review create(Review review) {
        if (reviewDB.add(review)) {
            return review;
        }
        return null;
    }

    @Override
    public Review read(String reviewId) {
        return reviewDB.stream()
                .filter(review -> review.getReviewId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Review update(Review updatedReview) {
        Review existingReview = read(updatedReview.getReviewId());
        if (existingReview != null) {
            reviewDB.remove(existingReview);
            reviewDB.add(updatedReview);
            return updatedReview;
        }
        return null;
    }

    @Override
    public boolean delete(String reviewId) {
        Review reviewToDelete = read(reviewId);
        if (reviewToDelete != null) {
            return reviewDB.remove(reviewToDelete);
        }
        return false;
    }

    @Override
    public Set<Review> getAll() {
        return reviewDB;
    }
}

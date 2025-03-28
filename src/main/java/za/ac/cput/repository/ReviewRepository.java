package za.ac.cput.repository;

import za.ac.cput.domain.Review;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ReviewRepository implements IRepository<Review, String> {
    private final ConcurrentHashMap<String, Review> reviewMap;
    private static ReviewRepository repository;

    private ReviewRepository() {
        reviewMap = new ConcurrentHashMap<>();
    }

    public static synchronized ReviewRepository getRepository() {
        if (repository == null) {
            repository = new ReviewRepository();
        }
        return repository;
    }

    public static synchronized void resetRepository() {
        repository = null;
    }

    @Override
    public Review create(Review review) {
        Objects.requireNonNull(review, "Review cannot be null");
        Objects.requireNonNull(review.getReviewId(), "Review ID cannot be null");

        // Prevent duplicates
        if (reviewMap.containsKey(review.getReviewId())) {
            return reviewMap.get(review.getReviewId());
        }

        reviewMap.put(review.getReviewId(), review);
        return review;
    }

    @Override
    public Review read(String reviewId) {
        Objects.requireNonNull(reviewId, "Review ID cannot be null");
        return reviewMap.get(reviewId);
    }

    @Override
    public Review update(Review review) {
        Objects.requireNonNull(review, "Review cannot be null");
        Objects.requireNonNull(review.getReviewId(), "Review ID cannot be null");

        if (!reviewMap.containsKey(review.getReviewId())) {
            return null;
        }

        reviewMap.put(review.getReviewId(), review);
        return review;
    }

    @Override
    public boolean delete(String reviewId) {
        Objects.requireNonNull(reviewId, "Review ID cannot be null");
        return reviewMap.remove(reviewId) != null;
    }

    @Override
    public List<Review> getAll() {
        return new ArrayList<>(reviewMap.values());
    }

    public void clear() {
        reviewMap.clear();
    }
}
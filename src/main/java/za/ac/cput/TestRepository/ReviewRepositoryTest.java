/* OnlineTutoring.java
Tutor model class
Author: Njabulo N Mathabela (212061208)
Date: 25 March 2025
*/
package za.ac.cput.TestRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Review;
import za.ac.cput.factory.ReviewFactory;
import za.ac.cput.repository.ReviewRepository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

class ReviewRepositoryTest {
    private ReviewRepository repository;
    private Review review;

    @BeforeEach
    void setUp() {
        repository = ReviewRepository.getRepository();
        review = ReviewFactory.createReview("R001", "T123", "S456", 5, "Excellent tutor!", "Thank you!");
        repository.create(review);
    }

    @Test
    void create_Success() {
        Review newReview = ReviewFactory.createReview("R002", "T789", "S999", 4, "Good session", "Appreciated!");
        Review created = repository.create(newReview);
        assertNotNull(created);
        assertEquals("R002", created.getReviewId());
    }

    @Test
    void read_Success() {
        Review found = repository.read("R001");
        assertNotNull(found);
        assertEquals("R001", found.getReviewId());
    }

    @Test
    void read_Fail_NotFound() {
        Review found = repository.read("R999");
        assertNull(found);
    }

    @Test
    void update_Success() {
        Review updatedReview = new Review.Builder()
                .setReviewId("R001")
                .setTutorId("T123")
                .setStudentId("S456")
                .setRating(4) // Changed rating from 5 to 4
                .setComment("Very good tutor")
                .setResponse("Thanks for your feedback!")
                .build();

        Review result = repository.update(updatedReview);
        assertNotNull(result);
        assertEquals(4, result.getRating());
        assertEquals("Very good tutor", result.getComment());
    }

    @Test
    void update_Fail_NotFound() {
        Review nonExistingReview = new Review.Builder()
                .setReviewId("R999")
                .setTutorId("T000")
                .setStudentId("S000")
                .setRating(3)
                .setComment("Average")
                .setResponse("Noted")
                .build();

        Review result = repository.update(nonExistingReview);
        assertNull(result);
    }

    @Test
    void delete_Success() {
        boolean deleted = repository.delete("R001");
        assertTrue(deleted);
        assertNull(repository.read("R001"));
    }

    @Test
    void delete_Fail_NotFound() {
        boolean deleted = repository.delete("R999");
        assertFalse(deleted);
    }

    @Test
    void getAll_Success() {
        Set<Review> allReviews = repository.getAll();
        assertEquals(1, allReviews.size()); // We created 1 review in setUp()
    }
}


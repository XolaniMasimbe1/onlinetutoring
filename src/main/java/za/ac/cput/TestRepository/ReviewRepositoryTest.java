package za.ac.cput.TestRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Review;
import za.ac.cput.factory.ReviewFactory;
import za.ac.cput.repository.ReviewRepository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class ReviewRepositoryTest {
    private ReviewRepository repository;
    private Review review;

    @BeforeEach
    void setUp() {
        ReviewRepository.resetRepository();
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
        assertEquals(2, repository.getAll().size());
    }

    @Test
    void create_Fail_NullReview() {
        assertThrows(NullPointerException.class, () -> repository.create(null));
    }

    @Test
    void read_Success() {
        Review found = repository.read("R001");
        assertNotNull(found);
        assertEquals("R001", found.getReviewId());
        assertEquals("Excellent tutor!", found.getComment());
    }

    @Test
    void read_Fail_NotFound() {
        Review found = repository.read("R999");
        assertNull(found);
    }

    @Test
    void read_Fail_NullId() {
        assertThrows(NullPointerException.class, () -> repository.read(null));
    }

    @Test
    void update_Success() {
        Review updatedReview = new Review.Builder()
                .copy(review)
                .setRating(4) // Changed rating from 5 to 4
                .setComment("Very good tutor")
                .setResponse("Thanks for your feedback!")
                .build();

        Review result = repository.update(updatedReview);
        assertNotNull(result);
        assertEquals(4, result.getRating());
        assertEquals("Very good tutor", result.getComment());

        Review retrieved = repository.read("R001");
        assertEquals(4, retrieved.getRating());
    }

    @Test
    void update_Fail_NotFound() {
        Review nonExistingReview = ReviewFactory.createReview("R999", "T000", "S000", 3, "Average", "Noted");
        Review result = repository.update(nonExistingReview);
        assertNull(result);
    }

    @Test
    void update_Fail_NullReview() {
        assertThrows(NullPointerException.class, () -> repository.update(null));
    }

    @Test
    void delete_Success() {
        boolean deleted = repository.delete("R001");
        assertTrue(deleted);
        assertNull(repository.read("R001"));
        assertEquals(0, repository.getAll().size());
    }

    @Test
    void delete_Fail_NotFound() {
        boolean deleted = repository.delete("R999");
        assertFalse(deleted);
        assertEquals(1, repository.getAll().size());
    }

    @Test
    void delete_Fail_NullId() {
        assertThrows(NullPointerException.class, () -> repository.delete(null));
    }

    @Test
    void getAll_Success() {
        Review newReview = ReviewFactory.createReview("R002", "T789", "S999", 4, "Good session", "Appreciated!");
        repository.create(newReview);

        List<Review> allReviews = repository.getAll();
        assertEquals(2, allReviews.size());
        assertTrue(allReviews.contains(review));
        assertTrue(allReviews.contains(newReview));
    }

    @Test
    void getAll_Empty() {
        repository.delete("R001");
        List<Review> allReviews = repository.getAll();
        assertTrue(allReviews.isEmpty());
    }
}
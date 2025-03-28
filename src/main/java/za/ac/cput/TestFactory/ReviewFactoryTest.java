/* OnlineTutoring.java
Tutor model class
Author: Njabulo N Mathabela (212061208)
Date: 25 March 2025
*/
package za.ac.cput.TestFactory;


import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Review;
import za.ac.cput.factory.ReviewFactory;

import static org.junit.jupiter.api.Assertions.*;

class ReviewFactoryTest {

    @Test
    void createReview_Success() {
        Review review = ReviewFactory.createReview("R001", "T123", "S456", 5, "Great tutor!", "Thank you!");

        assertNotNull(review);
        assertEquals("R001", review.getReviewId());
        assertEquals("T123", review.getTutorId());
        assertEquals("S456", review.getStudentId());
        assertEquals(5, review.getRating());
        assertEquals("Great tutor!", review.getComment());
        assertEquals("Thank you!", review.getResponse());
    }

    @Test
    void createReview_Fail_NullValues() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                ReviewFactory.createReview(null, "T123", "S456", 5, "Great tutor!", "Thank you!")
        );
        assertEquals("Review ID, Tutor ID, and Student ID cannot be null or empty.", exception.getMessage());
    }

    @Test
    void createReview_Fail_InvalidRating() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                ReviewFactory.createReview("R002", "T789", "S999", 6, "Good", "Thanks!")
        );
        assertEquals("Rating must be between 1 and 5.", exception.getMessage());
    }
}

/* OnlineTutoring.java
Review TestFactory class
Author: Njabulo Nicco Mathebela (212061208)
Date: 23 March 2025

*/
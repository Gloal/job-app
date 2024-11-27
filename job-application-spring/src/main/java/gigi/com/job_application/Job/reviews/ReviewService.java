package gigi.com.job_application.Job.reviews;

import java.util.List;

public interface ReviewService{

    Review getReviewById(Long companyId, Long reviewId);

    List<Review> getAllReviewsForCompany(Long companyId);

    void saveNewReview(Long companyId, Review review);

    boolean deleteReview(Long reviewId);

    boolean updateReview(Long companyId, Long reviewId, Review updatedReview);
}

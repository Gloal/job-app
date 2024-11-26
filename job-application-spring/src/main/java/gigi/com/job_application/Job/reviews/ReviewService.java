package gigi.com.job_application.Job.reviews;

import java.util.List;

public interface ReviewService{

    Review getReviewById(Long companyId, Long reviewId);

    List<Review> getAllCompanyReviews(Long companyId);

    void createReview(Review review);

    boolean deleteReview(Long reviewId);

    boolean updateReview(Long reviewId, Review review);

}

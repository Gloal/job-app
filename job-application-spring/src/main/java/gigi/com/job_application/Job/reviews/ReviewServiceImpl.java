package gigi.com.job_application.Job.reviews;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }
    @Override
    public Review getReviewById(Long companyId, Long reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public List<Review> getAllCompanyReviews(Long companyId) {
        return null;
    }

    @Override
    public void createReview(Review review) {

    }

    @Override
    public boolean deleteReview(Long reviewId) {
        return false;
    }

    @Override
    public boolean updateReview(Long reviewId, Review review) {
        return false;
    }
}

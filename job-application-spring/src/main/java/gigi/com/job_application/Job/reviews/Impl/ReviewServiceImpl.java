package gigi.com.job_application.Job.reviews.Impl;

import gigi.com.job_application.Job.reviews.Review;
import gigi.com.job_application.Job.reviews.ReviewRepository;
import gigi.com.job_application.Job.reviews.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

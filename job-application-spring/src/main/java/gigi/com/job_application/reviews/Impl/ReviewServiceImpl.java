package gigi.com.job_application.reviews.Impl;

import gigi.com.job_application.company.Company;
import gigi.com.job_application.company.CompanyService;
import gigi.com.job_application.reviews.Review;
import gigi.com.job_application.reviews.ReviewRepository;
import gigi.com.job_application.reviews.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public Review getReviewById(Long companyId, Long reviewId) {
        //return reviewRepository.findById(reviewId).orElse(null);
        //a better method that ensures the companyId also matches
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Review> getAllReviewsForCompany(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public void saveNewReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        review.setCompany(company);
        reviewRepository.save(review);

    }

    @Override
    public boolean deleteReview(Long reviewId) {
        return false;
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        if (companyService.getCompanyById(companyId) != null) {
            updatedReview.setCompany(companyService.getCompanyById(companyId));
            updatedReview.setId(reviewId);
            return true;
        } else {
            return false;
        }
    }
}

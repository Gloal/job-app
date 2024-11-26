package gigi.com.job_application.Job.company;

import gigi.com.job_application.Job.reviews.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    //List<Review> findAllReviews(Long id);
}

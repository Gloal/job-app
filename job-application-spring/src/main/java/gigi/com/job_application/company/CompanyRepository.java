package gigi.com.job_application.company;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    //List<Review> findAllReviews(Long id);
}

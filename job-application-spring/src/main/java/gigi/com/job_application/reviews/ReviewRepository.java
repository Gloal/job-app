package gigi.com.job_application.reviews;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findByCompanyId(Long companyId);
}

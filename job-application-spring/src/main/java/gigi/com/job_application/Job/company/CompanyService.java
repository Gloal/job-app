package gigi.com.job_application.Job.company;

import gigi.com.job_application.Job.reviews.Review;

import java.util.List;

public interface CompanyService {

    void createNewCompany(Company company);

    boolean deleteCompanyById(Long id);

    Company getCompanyById(Long id);

    List<Company> getAllCompanies();

    List<Review> getAllReviewsByCompanyId(Long id);

    boolean updateCompany(Long id, Company company);
}

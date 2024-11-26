package gigi.com.job_application.Job.company.impl;

import gigi.com.job_application.Job.company.Company;
import gigi.com.job_application.Job.company.CompanyRepository;
import gigi.com.job_application.Job.company.CompanyService;
import gigi.com.job_application.Job.reviews.Review;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public void createNewCompany(Company company) {
        this.companyRepository.save(company);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        Optional<Company> companyToDelete = companyRepository.findById(id);
        if (companyToDelete.isPresent()) {
            companyRepository.delete(companyToDelete.get());
            return true;
        }
        return false;
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public List<Review> getAllReviewsByCompanyId(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        return company.map(Company::getReviews).orElse(null);
    }

    @Override
    public boolean updateCompany(Long id, Company company) {
        Optional<Company> existingCompany = companyRepository.findById(id);
        if (existingCompany.isPresent()) {
            Company companyToUpdate = existingCompany.get();
            companyToUpdate.setName(company.getName());
            companyToUpdate.setAddress(company.getAddress());
            companyRepository.save(companyToUpdate);
            return true;
        }
        return false;
    }
}

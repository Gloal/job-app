package gigi.com.job_application.Job.company;

import gigi.com.job_application.Job.company.impl.CompanyServiceImpl;
import gigi.com.job_application.Job.reviews.Review;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/companies")
public class CompanyController {

    private final CompanyServiceImpl companyService;

    public CompanyController(CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company) {
        companyService.createNewCompany(company);
        return new ResponseEntity<>("Company created successfully.", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        Company company = companyService.getCompanyById(id);
        if (company != null) {
            return new ResponseEntity<>(company, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        boolean isUpdated = companyService.updateCompany(id, company);
        if (isUpdated) {
            return new ResponseEntity<>("Company updated successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Company not found.", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
        boolean isDeleted = companyService.deleteCompanyById(id);
        if (isDeleted) {
            return new ResponseEntity<>("Company deleted successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Company not found.", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<Review>> getReviewsByCompanyId(@PathVariable Long id) {
        List<Review> reviews = companyService.getAllReviewsByCompanyId(id);
        if (reviews != null) {
            return new ResponseEntity<>(reviews, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

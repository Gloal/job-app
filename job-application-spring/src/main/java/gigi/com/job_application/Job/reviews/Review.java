package gigi.com.job_application.Job.reviews;

import gigi.com.job_application.Job.company.Company;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(cascade = CascadeType.MERGE)
    Company company;
    String firstName;
    String lastName;
    String reviewText;
    LocalDateTime reviewDate;
    int score;


    protected Review(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate() {
        this.reviewDate = LocalDateTime.now();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Review(String firstName, String lastName, String reviewText, int score, Company company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.reviewText = reviewText;
        this.reviewDate = LocalDateTime.now();
        this.score = score;
        this.company = company;
    }

}

package gigi.com.job_application.Job.reviews;

import gigi.com.job_application.Job.company.Company;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    //@ManyToOne
    //Company company;
    String firstName;
    String lastName;
    String reviewText;
    Date reviewDate;
    int score;


    protected Review(){}

    public Review(String firstName, String lastName, String reviewText, Date reviewDate, int score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.reviewText = reviewText;
        this.reviewDate = reviewDate;
        this.score = score;
        //this.company = company;
    }

}

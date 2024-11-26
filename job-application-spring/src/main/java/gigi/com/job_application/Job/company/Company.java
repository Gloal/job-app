package gigi.com.job_application.Job.company;

import gigi.com.job_application.Job.reviews.Review;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.ArrayList;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY);
    Long id;
    String companyName;
    String companyAdress;
    @OneToMany
    ArrayList<Review> reviews;

    protected Company(){}


}

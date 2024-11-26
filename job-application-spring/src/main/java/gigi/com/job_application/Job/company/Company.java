package gigi.com.job_application.Job.company;

import gigi.com.job_application.Job.Job.Job;
import gigi.com.job_application.Job.reviews.Review;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    @OneToMany
    private List<Review> reviews;
    @OneToMany
    private List<Job> jobs;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public List<Review> getReviews(){
        return reviews;
    }

    public Company(String name, String address, List<Review> reviews, List<Job> jobs) {
        this.name = name;
        this.address = address;
        this.reviews = reviews;
        this.jobs = jobs;
    }

    protected Company(){}


}

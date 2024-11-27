package gigi.com.job_application.Job.company;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @OneToMany(mappedBy = "company")
    private List<Review> reviews;
    @OneToMany(mappedBy = "company", fetch=FetchType.EAGER)
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

    public Company(String name, String address) {
        this.name = name;
        this.address = address;
        //this.reviews = new ArrayList<>();
        //this.jobs = new ArrayList<>();
    }

    public Company(){}
}

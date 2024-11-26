package gigi.com.job_application.Job.Job.impl;

import gigi.com.job_application.Job.Job.Job;
import gigi.com.job_application.Job.Job.JobRepository;
import gigi.com.job_application.Job.Job.JobService;
import gigi.com.job_application.Job.company.Company;
import gigi.com.job_application.Job.company.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;
    private CompanyRepository companyRepository;

    public JobServiceImpl(JobRepository jobRepository, CompanyRepository companyRepository){
        this.jobRepository = jobRepository;
        this.companyRepository = companyRepository;
    }

    private List<Job> jobs = new ArrayList<>();
    private int idNumber = 0;


    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createNewJob(Job job) {
//        Company company = companyRepository.findById(companyId)
//                        .orElseThrow(() -> new RuntimeException("Company not found"));
//        Job newJob = new Job();
//        newJob.setTitle("Developer");
//        newJob.setDescription("Write code");
//        newJob.setMaxSalary("900000");
//        newJob.setMinSalary("90000");
//        newJob.setLocation("Toronto");
//        newJob.setCompany(company); // Set the company
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);   }

    @Override
    public boolean updateJob(Long id, Job job) {
        Optional<Job> jobToUpdateOptional = jobRepository.findById(id);
        if(jobToUpdateOptional.isPresent()){
            Job jobToUpdate = jobToUpdateOptional.get();
            jobToUpdate.setDescription(job.getDescription());
            jobToUpdate.setTitle(job.getTitle());
            jobToUpdate.setLocation(job.getLocation());
            jobToUpdate.setMaxSalary(job.getMaxSalary());
            jobToUpdate.setMinSalary(job.getMinSalary());
            return true;

        }
        return false;
        }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    /*
    private List<Job> jobs = new ArrayList<>();
    private int idNumber = 0;


    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createNewJob(Job job) {
        job.setId(new Long(idNumber));
        idNumber++;
        jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {
        Iterator<Job> iterator = jobs.iterator();

        while(iterator.hasNext()){
            Job job = iterator.next();
            if(job.getId().equals(id)){
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deleteJobById(Long id) {
        Iterator<Job> iterator = jobs.iterator();

        while (iterator.hasNext()){
            Job job = iterator.next();
            if(job.getId().equals(id)){
                iterator.remove();
                return true;
            }
        }
        return false;

    }

    */
}

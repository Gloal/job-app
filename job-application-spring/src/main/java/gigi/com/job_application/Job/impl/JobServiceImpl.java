package gigi.com.job_application.Job.impl;

import gigi.com.job_application.Job.Job;
import gigi.com.job_application.Job.JobRepository;
import gigi.com.job_application.Job.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }

    private List<Job> jobs = new ArrayList<>();
    private int idNumber = 0;


    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createNewJob(Job job) {
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

package gigi.com.job_application.Job.impl;

import gigi.com.job_application.Job.Job;
import gigi.com.job_application.Job.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();
    private int idNumber = 0;

    @Override
    public List<Job> findAll() {
        return jobs;
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
}

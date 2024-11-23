package gigi.com.job_application.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createNewJob(Job job);

    Job getJobById(Long id);

    boolean deleteJobById(Long id);
}

package gigi.com.job_application.Job.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createNewJob(Job job);

    Job getJobById(Long id);

    boolean updateJob(Long id, Job job);

    boolean deleteJobById(Long id);
}

package gigi.com.job_application.Job;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="v1/jobs")
public class JobController {
    private List<Job> jobs = new ArrayList<>();

    @GetMapping("")
    public List<Job> findAll(){
        return jobs;
    }

    @GetMapping("/{id}")
    public Job getJobById(@RequestParam Long id){
        return jobs.get(Math.toIntExact(id));
    }

    @PostMapping("")
    public String postNewJob(@RequestBody Job job){
        jobs.add(job);
        return "Job added successfully"+job.toString();
    }

}


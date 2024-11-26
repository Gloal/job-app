package gigi.com.job_application.Job;

import gigi.com.job_application.Job.impl.JobServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(path="v1/jobs")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("")
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if(job != null)
         return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob (@PathVariable Long id, @RequestBody Job job){
        boolean isUpdated = jobService.updateJob(id, job);
        if(isUpdated){
            return ResponseEntity.ok().body("Job sucessfully updated");
        }
        return new ResponseEntity<>("Could not find that job", HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public ResponseEntity<String> postNewJob(@RequestBody Job job){
        jobService.createNewJob(job);
        return new ResponseEntity<>("Job added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        boolean isDeleted = jobService.deleteJobById(id);
        if (isDeleted){
            return ResponseEntity.ok().body("Successfully deleted");
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}


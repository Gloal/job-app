package gigi.com.job_application.Job;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public class JobRepository extends JpaRepository<Job, UUID> {
}

package com.ritvik.jobtracker.controller;

import com.ritvik.jobtracker.entity.JobApplication;
import com.ritvik.jobtracker.repository.JobApplicationRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/*
    Before entering the controller, the HTTP request goes from Tomcat to the DispatcherServlet which then redirects it
    to the controller.
    A controller answers the question "An HTTP request came, now what?"
    The RequestMapping is like "url/jobApplication" will hit this part and the type of HTTP request will be handled
    accordingly.
*/
@RestController
@RequestMapping("/jobApplications")
public class JobApplicationController {
    // We create an object named "repository" of type JobApplicationRepository. What does final mean?
    private final JobApplicationRepository repository;
    // This is a constructor to initialize the repository.
    public JobApplicationController(JobApplicationRepository repository) {
        this.repository = repository;
    }
    // This is for HTTP GET requests.
    @GetMapping
    public List<JobApplication> getAllJobApplications() {
        return repository.findAll();
    }
    // This is for HTTP POST requests.
    @PostMapping
    public JobApplication createJobApplication(@RequestBody JobApplication job) {
        return repository.save(job);
    }
    // This is for HTTP DELETE requests.
    @DeleteMapping("/{id}")
    public void deleteJobApplication(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

package com.ritvik.jobtracker.repository;
import com.ritvik.jobtracker.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
/*
    A Repository is an interface that allows DB operations on the entity and not know about what the HTTP request is.
    A repository is an inherent concept and not just for Spring. Spring boot only automates a lot of the process.
    An interface is like a contract. It does not tell "How to do", but "What can be done".
    Here it extends the class JobApplicationRepository to have functions (inherited) from JpaRepository.
    The parameters are an object of type JobApplication and ID of type Long.
*/
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

}

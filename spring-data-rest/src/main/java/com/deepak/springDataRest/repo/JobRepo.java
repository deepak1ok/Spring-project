package com.deepak.springDataRest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deepak.springDataRest.model.JobPost;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

}

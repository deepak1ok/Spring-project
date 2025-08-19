package com.deepak.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deepak.model.JobPost;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

	List<JobPost> findByPostProfileContainingIgnoreCaseOrPostDescContainingIgnoreCase(String keyword, String keyword2);

}

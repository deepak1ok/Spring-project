package com.deepak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.deepak.model.Student;
import com.deepak.repo.StudentRepo;

@SpringBootApplication
public class SpringbootDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootDataJpaApplication.class, args);

		StudentRepo repo = context.getBean(StudentRepo.class);
		Student s1 = context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);
		Student s3 = context.getBean(Student.class);

//		s1.setRollNo(1);
//		s1.setName("Kiran");
//		s1.setMarks(75);
//
//		s2.setRollNo(2);
//		s2.setName("Deva");
//		s2.setMarks(96);
//
//		s3.setRollNo(3);
//		s3.setName("Jay");
//		s3.setMarks(81);
//		repo.save(s2);
//		repo.save(s3);

//		List<Student> s = repo.findAll();
//		System.out.println(s);
//		System.out.println(repo.findAll());

//		Optional<Student> s = repo.findById(7);
//		System.out.println(s.orElse(new Student()));
//		System.out.println(repo.findById(7));

//		System.out.println(repo.findByName("Kiran")); // Add method in repo interface

//		System.out.println(repo.findByMarks(81));

		System.out.println(repo.findByMarksGreaterThan(80));

	}

}

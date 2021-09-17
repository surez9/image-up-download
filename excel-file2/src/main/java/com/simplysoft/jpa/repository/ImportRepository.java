package com.simplysoft.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplysoft.jpa.model.Student;

public interface ImportRepository  extends JpaRepository<Student, Integer>{

	
}

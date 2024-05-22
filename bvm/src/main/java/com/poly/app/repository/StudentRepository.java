package com.poly.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.app.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	List<Student> findByFullnameLike(String hoten);
}

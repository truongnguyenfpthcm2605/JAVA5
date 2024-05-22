package com.poly.app.service;

import java.util.List;
import java.util.Optional;

import com.poly.app.entity.Student;

public interface StudentService {
		Student save(Student student);
		Student update(Student student);
		Optional<Student> findByid(Integer id);
		void deleteById(Integer id);
		List<Student> findAll();
		List<Student> findByHotenLike(String hoten);
}	

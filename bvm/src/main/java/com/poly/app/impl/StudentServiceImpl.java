package com.poly.app.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.app.entity.Student;
import com.poly.app.repository.StudentRepository;
import com.poly.app.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

		
	@Autowired
	StudentRepository dao;
	@Override
	public Student save(Student student) {
		return dao.save(student);
	}

	@Override
	public Student update(Student student) {
		return dao.save(student);
	}

	@Override
	public Optional<Student> findByid(Integer id) {
		return dao.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<Student> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Student> findByHotenLike(String hoten) {
		return dao.findByFullnameLike(hoten);
	}

}

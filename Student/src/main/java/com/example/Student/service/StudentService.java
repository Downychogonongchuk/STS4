package com.example.Student.service;

import org.springframework.stereotype.Service;

import com.example.Student.DTO.StudentDTO;

@Service
public class StudentService {

	public void save(StudentDTO studentDTO) {
		System.out.println("StudentService.save()");
		System.out.println("StudentDTO = " +studentDTO);
		
	}
	
}

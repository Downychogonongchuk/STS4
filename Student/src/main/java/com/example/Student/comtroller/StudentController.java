package com.example.Student.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Student.DTO.StudentDTO;
import com.example.Student.service.StudentService;

@Controller
public class StudentController {
	@Autowired  // 필드 주입방식  
	private StudentService studentService;
	
@GetMapping("/save")
// 학생등록 화면 출력
public String save() {
	return "save";
}

@PostMapping("/save")
public String savedto(@ModelAttribute StudentDTO studentDTO, Model model) {
	model.addAttribute("stuDTO", studentDTO);
	System.out.println(studentDTO);
	studentService.save(studentDTO);
	return "index";
}
}

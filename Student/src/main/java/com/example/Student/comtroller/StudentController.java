package com.example.Student.comtroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
// , Model mode = front > back = controller 에서 생성된 데이터를 jsp에 띄움
// request = back>front  = 
//@ModelAttribute StudentDTO studentDTO = DTO 객체로 바로 받
@PostMapping("/save")
public String savedto(@ModelAttribute StudentDTO studentDTO) {
	System.out.println(studentDTO);
	studentService.save(studentDTO);
	return "index";
}
// DB가려면 service-repository 거쳐서
@GetMapping("/list")
public String findAll(Model model) { 
	// DB에서 목록 데이터를 가져옴
	List<StudentDTO> studentDTOs = studentService.findAll();
	// 리스트 데이터를 model에 담음
	model.addAttribute("studentList", studentDTOs);
	// "studentList"= $ {} 
	//list.html로 이동
	return "list";
}

@GetMapping("/student/{id}") 
//파라미터 requ or 경로상 {} @PathVa  {id}에 있는 값을 Long 타입의 id로 가져온다  
public String findById(@PathVariable("id")Long id, Model model) {
	System.out.println("id = " + id);
	StudentDTO studentDTO = studentService.findById(id);
	// 학생 한명 List X DTO 
	model.addAttribute("student",studentDTO);
	return "detail";
	}
//request = 1개씩 , model 여러개 id 하나만 가져오는 경우 request or {} PathVa , // DTO 를 가져오기위해 model
}






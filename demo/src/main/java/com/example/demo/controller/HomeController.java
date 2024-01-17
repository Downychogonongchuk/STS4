package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.Banner.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.DemoDTO;
import com.example.demo.dto.nameDTO;

import ch.qos.logback.core.pattern.FormatInfo;

// @Controller : 해당 클래스를 컨트롤러 클래스로 스프링빈에 등록
// 스프링빈: 스프링이 관리해주는 자바 객체 
// 주소창에 파라미터가 보이면 get , 주소가 노출없이 숨겨짐 post(id, pass)
@Controller
public class HomeController {
		// / 주소에 대해 get 요청이 front 로 부터 오면 아래 메서드가 실행
	@GetMapping("/")
	// method 이름 :index
	// return 타입: String
	public String index() {
		// templates 폴더에 있는 index.html을 화면에 띄워라
		return "index";
	}
	// /hi 로 get 주소 요청을 했을 때 hi.html 출력
	@GetMapping("/hi")
	public String index2() {
		return "hi";
	}
	// /param1 주소를 처리하기 위한 메서드 
	@GetMapping("/param1")
	// p1 이라는 이름으로 전달된 파라미터를 받아서 String p1에 담는다.
	public String parma1(@RequestParam("p1")String p1) {
		System.out.println("p1" + p1);
		return "index";
	}
	@GetMapping("/param2")
	public String param2(@RequestParam("p1")String p1,
										@RequestParam("p2")String p2) {
			System.out.println("p1="+p1);
			System.out.println("p2="+p2);
			return "index";
	}
	// form1 주소요청에 form1.html 출력
	@GetMapping("/form1")
	public String form1() {
		return "form1";
	}
	
	@PostMapping("/form1-param")
	public String form1Param(@RequestParam("p1")String p1,
			@RequestParam("p2")String p2) {
		System.out.println("p1=" + p1);
		System.out.println("p2=" + p2);
		return "index";
	}
	@GetMapping("/model1")
	public String model1(Model model) {
		String str1 = "오늘은 금요일";
		// 화면에 가져갈 데이터를 담음
		model.addAttribute("s1",str1);
		return "model1";
	}
	@GetMapping("/form2")
		public String model3() {
		return "form2";
	}
	@PostMapping("/form-param2")
	public String model2(@RequestParam("f1")String f1, Model model2) { // 담아갈 값이 있을 때 Model
		String f2 =f1;
		model2.addAttribute("f1",f2);
		return "model2";
	}
//	@GetMapping("/form3")
//	public String form3() {
//		return "form3";
//	}
//	@PostMapping("/form-param3")
//	public String formParam3(@RequestParam("p1")String p1,
//			@RequestParam("p2")String p2,Model model) {
//		model.addAttribute("p1",p1);
//		model.addAttribute("p2",p2);
//			return "model3";
//	}
	@GetMapping("/form3")
	public String form3() {
		return "form3";
	}
	@PostMapping("/form-param3")
	public String formParam3(@ModelAttribute nameDTO namedto,  Model model){
		// @ModelAttribute nameDTO namedto,  Model model){
		// DTO 타입 dto변수명
		model.addAttribute("dto",namedto);
			return "model3";
	}

	@GetMapping("/form4")
		public String form4() {
		return "form4";
	}
//	@PostMapping("/form-param4")
//		public String formParam4(@RequestParam("name")String name,
//				@RequestParam("age")int age,Model model) {
//		System.out.println(name+age);
//		model.addAttribute("name",name);
//		model.addAttribute("age",age);
//		return "index";
//	}
	
	@PostMapping("/form-param4")
	public String formParam4(@ModelAttribute DemoDTO demoDTO,Model model) {
	System.out.println(demoDTO);
	model.addAttribute("demo",demoDTO);
	return "model4";
	} 
	@GetMapping("/model5")
	public String model5(Model model) {
		List<DemoDTO>list = new ArrayList<>();
		for(int i=1; i<=10; i++) {
			DemoDTO demoDTO = new DemoDTO();
			demoDTO.setName("name"+i);
			demoDTO.setAge(i);
			list.add(demoDTO);
		} 
		model.addAttribute("list", list);
		return "model5";
	}
}






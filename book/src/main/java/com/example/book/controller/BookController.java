package com.example.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.book.dto.BookDTO;
import com.example.book.service.BookService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/save")
	public String save() {
		return "save";
	}
	// public String saveDto( BookDTO bookDTO) {  생략가능:@ModelAttribute
	@PostMapping("/save")
		public String saveDto(@ModelAttribute BookDTO bookDTO) {
		System.out.println(bookDTO);
		  bookService.save(bookDTO);
		  // 단순하게 list.html만 요청
//		return "list";
		  // list 출력을 위해 list 주소 요청
		  return "redirect:/list";  // 여기서의 list는 @GetMapping("/list") #재요청
		  // redirect: 컨트롤러의 메서드에서 다른 메서드의 주소를 요청하고자 할 때
	}
	@GetMapping("/list")
	public String lilst(Model model) {
		List<BookDTO>bookDTOs = bookService.list();
		model.addAttribute("bookList",bookDTOs);
		return "list"; 
	}
	@GetMapping("/book/{id}")
	public String findById(@PathVariable("id")Long id, Model model) {
		System.out.println(id);
		BookDTO bookDTO = bookService.findById(id);
		model.addAttribute("book",bookDTO);
		return "detail";
	}
	@GetMapping("/book/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		bookService.delete(id);
		return "redirect:/list";
	}
	@GetMapping("/book/update/{id}")
	public String update(@PathVariable("id")Long id, Model model) {
		BookDTO bookDTO =  bookService.findById(id);
		model.addAttribute("book", bookDTO);
		return "update";
	}
	@PostMapping("/update")
	public String update(BookDTO bookDTO) {
		System.out.println(bookDTO);
		bookService.update(bookDTO);
		return "redirect:/list";
	}
	
}

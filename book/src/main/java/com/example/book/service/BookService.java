package com.example.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.dto.BookDTO;
import com.example.book.repository.BookRepository;
@Service
public class BookService {
@Autowired 
private BookRepository bookRepository;

	public void save(BookDTO bookDTO) {
		System.out.println(bookDTO);
		bookRepository.save(bookDTO);
	}

	public List<BookDTO> list() {
		
		return bookRepository.list();
	}

	public BookDTO findById(Long id) {
		
		return bookRepository.findById(id);
	}

	public void delete(Long id) {
		bookRepository.delete(id);
		
	}

	public void update(BookDTO bookDTO) {
		bookRepository.update(bookDTO);
		
	}

}

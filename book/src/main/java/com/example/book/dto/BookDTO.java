package com.example.book.dto;

import lombok.Data;

@Data
public class BookDTO {
	Long id;
	private String  bookName;
	private String  bookAuthor;
	private String  bookPublisher;
	private int bookPrice;
}


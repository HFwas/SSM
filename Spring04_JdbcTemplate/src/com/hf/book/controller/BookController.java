package com.hf.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hf.book.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	
	public void  test() {
		service.buyBook("1", "1001");
	}
}

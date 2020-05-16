package com.hf.book_xml.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hf.book_xml.service.BookService;
import com.hf.book_xml.service.Cashier;

@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	
	@Autowired
	private Cashier cashier;
	
	public void  test() {
		service.buyBook("1", "1001");
	}
	
	public void checkOut() {
		List<String> bids = new ArrayList<String>();
		bids.add("1");
		bids.add("2");
		cashier.checkOut("1001", bids);
	}
}

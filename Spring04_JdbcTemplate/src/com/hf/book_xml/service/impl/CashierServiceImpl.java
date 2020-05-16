package com.hf.book_xml.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hf.book_xml.service.BookService;
import com.hf.book_xml.service.Cashier;

@Service
@Transactional
public class CashierServiceImpl implements Cashier{

	@Autowired
	private BookService service;
	
	@Override
	public void checkOut(String uid, List<String> bids) {
		for (String bid : bids) {
			service.buyBook(bid, uid);
		}
	}

	
	
}

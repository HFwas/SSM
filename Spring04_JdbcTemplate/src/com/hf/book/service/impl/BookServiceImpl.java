package com.hf.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hf.book.dao.BookDao;
import com.hf.book.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookDao dao;

	@Override
	public void buyBook(String bid, String uid) {
		Integer price = dao.selectPrice(bid);
		dao.updateSt(bid);
		dao.uodateBalance(uid, price);
	}
	
	
}

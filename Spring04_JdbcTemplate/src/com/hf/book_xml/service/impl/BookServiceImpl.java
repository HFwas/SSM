package com.hf.book_xml.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hf.book_xml.dao.BookDao;
import com.hf.book_xml.exception.MyException;
import com.hf.book_xml.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookDao dao;
	
	public void buyBook(String bid, String uid) {
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		Integer price = dao.selectPrice(bid);
		dao.updateSt(bid);
		dao.uodateBalance(uid, price);
	}
	
	
}

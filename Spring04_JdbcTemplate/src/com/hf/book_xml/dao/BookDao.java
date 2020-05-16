package com.hf.book_xml.dao;

public interface BookDao {
	
	Integer selectPrice(String bid);
	
	void updateSt(String bid);
	
	void uodateBalance(String uid , Integer price);
}

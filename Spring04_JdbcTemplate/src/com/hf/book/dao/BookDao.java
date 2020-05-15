package com.hf.book.dao;

public interface BookDao {
	
	Integer selectPrice(String bid);
	
	void updateSt(String bid);
	
	void uodateBalance(String uid , Integer price);
}

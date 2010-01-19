package com.netigi.dao;

import java.util.List;

import com.netigi.domain.MyBook;

public interface BookDAO {

	public void persist(MyBook book);

	public List<MyBook> findAll();

}
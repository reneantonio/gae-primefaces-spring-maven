package com.netigi.dao;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import org.springframework.stereotype.Service;


import com.netigi.domain.MyBook;

@Service("BookDAO")
public class BookDAOWithJDO implements BookDAO {

	PersistenceManagerFactory pmfInstance = PMF.get();
	
	public void persist(MyBook book){
		PersistenceManager pm = pmfInstance.getPersistenceManager();
		try {
			pm.makePersistent(book);
		} finally {
			pm.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<MyBook> findAll(){
		PersistenceManager pm = pmfInstance.getPersistenceManager();
	    String query = "select from " + MyBook.class.getName();
	    List<MyBook> bookList = (List<MyBook>) pm.newQuery(query).execute();
//	    pm.close();
	    return bookList;
	}
	
}



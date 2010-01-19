package com.netigi.test;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

import com.netigi.dao.BookDAO;
import com.netigi.dao.BookDAOWithJDO;
import com.netigi.dao.PMF;
import com.netigi.domain.MyBook;

@SuppressWarnings("serial")
public class IndexServlet extends HttpServlet {

	private BookDAO bookDAO = new BookDAOWithJDO();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");

		addBooks();
		writeBookList(resp);
	}
	
	private MyBook createBook(String title, String author) {
		MyBook book = new MyBook();
		book.setTitle(title);
		book.setAuthor(author);
		return book;
	}
	
	private void addBooks(){
		bookDAO.persist(createBook("Book 1", "Brendan"));
		bookDAO.persist(createBook("Book 2", "Joe"));
		bookDAO.persist(createBook("Book 3", "Frank"));	
	}
	
	private void writeBookList(HttpServletResponse resp) throws IOException{
		resp.getWriter().println("List of Books");
	    List<MyBook> bookList = bookDAO.findAll(); 

	    if (bookList.isEmpty()) {
	    	resp.getWriter().println("No books");
	    } else {
	        for (MyBook book : bookList) {
	        	resp.getWriter().println(book.getId()+":"+book.getTitle());
	        }
	    }	
	}
	
//	public List<MyBook> findAll(){
//		PersistenceManager pm = PMF.get().getPersistenceManager();
//	    String query = "select from " + MyBook.class.getName();
//	    List<MyBook> bookList = (List<MyBook>) pm.newQuery(query).execute();
////	    pm.close();
//	    return bookList;
//	}

}

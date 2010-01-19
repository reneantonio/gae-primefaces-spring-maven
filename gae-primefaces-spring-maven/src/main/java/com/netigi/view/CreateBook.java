package com.netigi.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.netigi.dao.BookDAO;
import com.netigi.domain.MyBook;

@Component("createBook")
@Scope("request")
public class CreateBook implements Serializable{
 
	private BookDAO bookDAO;
	private static final long serialVersionUID = 2160811386000774853L;
	private MyBook book = new MyBook();
	
	public CreateBook() {}
	
	@Autowired
	public CreateBook(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	public MyBook getBook() {
		return book;
	}
	
	public void setBook(MyBook book) {
		this.book = book;
	}
	
	public void save(ActionEvent actionEvent) {
		bookDAO.persist(book);
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Book is saved");
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		book = new MyBook();
	}
}
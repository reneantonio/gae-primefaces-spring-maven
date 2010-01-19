/*  * Copyright 2009 Prime Technology.  *  * Licensed under the Apache License, Version 2.0 (the "License");  * you may not use this file except in compliance with the License.  * You may obtain a copy of the License at  *  * http://www.apache.org/licenses/LICENSE-2.0  *  * Unless required by applicable law or agreed to in writing, software  * distributed under the License is distributed on an "AS IS" BASIS,  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  * See the License for the specific language governing permissions and  * limitations under the License.  */
package com.netigi.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.netigi.dao.BookDAO;
import com.netigi.dao.BookDAOWithJDO;
import com.netigi.domain.MyBook;

@Component("searchBooksController")
@Scope("request")

public class SearchBooksController implements Serializable {
	private static final long serialVersionUID = -2417394435764260084L;
	private List<MyBook> books;
	private MyBook book;
	private BookDAO bookDAO;
	
	@Autowired
	public SearchBooksController(BookDAO bookDAO) {
		this.bookDAO =  bookDAO;
//		book = new MyBook();
//		book.setAuthor("BJ");
//		book.setTitle("Testing");
//		this.bookDAO.persist(book);
	}

	public MyBook getBook() {
		return book;
	}

	public void setBook(MyBook book) {
		this.book = book;
	}

	private MyBook createBook(String title, String author) {
		MyBook book = new MyBook();
		book.setTitle(title);
		book.setAuthor(author);
		return book;
	}

	public List<MyBook> getBooks() {
		books = this.bookDAO.findAll();
//		books = new ArrayList<MyBook>();
//		books.add(createBook("Book 1", "Brendan"));
//		books.add(createBook("Book 2", "Joe"));
//		books.add(createBook("Book 3", "Frank"));

		return books;
	}

	public void setBooks(List<MyBook> books) {
		this.books = books;
	}
}
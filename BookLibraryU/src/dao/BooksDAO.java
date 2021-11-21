package dao;

import classes.Book;

public interface BooksDAO {
	
	public void addBook(Book book);
	public void deleteBook(Book book);
	public void updateBook(Book book);
}

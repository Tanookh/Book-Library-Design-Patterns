package dao;

import classes.Book;
import dbConnections.DBFileManager;

public class BooksFilesDAO implements BooksDAO {

	@Override
	public void addBook(Book book) {
		System.out.println("DAO: Adding "+book);		
		DBFileManager.getInstance().writeToFile(book.toString());		
	}

	@Override
	public void deleteBook(Book book) {
		System.out.println("DAO: Deleting "+book);		
		DBFileManager.getInstance().deleteFromFile(book.toString());
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		
	}

}

package actions;

import dao.BooksDAO;
import dao.BooksFilesDAO;

public abstract class BaseAction {
	protected BooksDAO dao = new BooksFilesDAO();
	
	public abstract void doAction(); 
}

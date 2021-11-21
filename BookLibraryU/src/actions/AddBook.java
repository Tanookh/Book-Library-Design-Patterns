package actions;

import classes.Book;
import java.util.Scanner;

public class AddBook extends BaseAction{

	@Override
	public void doAction() {
		System.out.println("Insert book name:");
		Scanner input = new Scanner(System.in);
		
		String name = input.nextLine();
		
		System.out.println("Insert book authour:");
		String author = input.nextLine();
		
		System.out.println("Insert book year:");
		int year = input.nextInt();
		
		
		Book book = new Book(name, year, author);
		
		this.dao.addBook(book);
		
	}

}

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		
		try {
			File myFile = new File("C:\\Users\\Tanookh\\Downloads\\Philips Course\\Library\\Books.txt");
			if(myFile.createNewFile()) {
				System.out.println("File created: " + myFile.getName());
			}
			else {
				System.out.println("File already exists.\n");
			}
		} catch (IOException e) {
			System.out.println("An error occurred\n");
			e.printStackTrace();
		}
		BookDAO dao = new BookDBFunctions();
		Scanner menuInput = new Scanner(System.in);
		do {
			System.out.println("Please choose your activity: ");
			System.out.println("Press 1 to add a book to the library");
			System.out.println("Press 2 to delete a book from the library");
			System.out.println("Press 3 to borrow a book");
			System.out.println("Press 4 to return a book");
			System.out.println("Press 5 to exit");
			int menuInputInt = menuInput.nextInt();
			Book book = getBook();
			switch(menuInputInt) {
				case 1:
				{
					dao.addBook(book);
					break;
				}
				case 2:
				{
					dao.deleteBook(book);
					break;
				}
				case 3:
				{
					dao.borrowBook(book);
					break;
				}
				case 4:
				{
					dao.returnBook(book);
					break;
				}
				case 5:
				{
					System.out.println("Exiting.");
					return;
				}
				default:
				{
						System.out.println("Wrong input try again: ");
						break;
				}
			}
		}while(true);
	}
	
	@SuppressWarnings("resource")
	private static Book getBook() {
		System.out.println("Please enter the book details");
		System.out.print("Name: ");
		Scanner bookName = new Scanner(System.in);
		String bookNameString = bookName.nextLine();
		System.out.print("Author: ");
		Scanner bookAuthor = new Scanner(System.in);
		String bookAuthorString = bookAuthor.nextLine();
		System.out.print("Year written: ");
		Scanner bookYear = new Scanner(System.in);
		String bookYearString = bookYear.nextLine();
		return new Book(bookNameString, bookAuthorString, bookYearString);
	}
}

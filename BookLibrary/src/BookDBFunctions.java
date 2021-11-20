import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BookDBFunctions implements BookDAO{
	
	private String filePath = "C:\\Users\\Tanookh\\Downloads\\Course\\Library\\Books.txt";

	@Override
	public void addBook(Book book) throws FileNotFoundException {
	        Scanner scan = new Scanner(new File(filePath));
	        while(scan.hasNext()){
	            String line = scan.nextLine().toString();
	            if(line.contains(book.getName().concat(book.getAuthor().concat(book.getYearWritten())))){
	                System.out.println("Book already exists.\n");
	                return;
	            }
	        }
	        try
	        {
	            FileWriter fw = new FileWriter(filePath, true);
	            fw.write(book.printInfo());
	            fw.close();
	            System.out.println("Book added successfully.\n");
	        }
	        catch(IOException ioe)
	        {
	            System.err.println("IOException: " + ioe.getMessage());
	        }
	}

	@Override
	public void deleteBook(Book book) throws Exception {
	    String result = fileToString(filePath);
	    if(!(result.contains(book.getName().concat(book.getAuthor().concat(book.getYearWritten()))))) {
	    	System.out.println("No such book found.\n");
	    	return;
	    }
	    if(result.contains((book.getName().concat(book.getAuthor().concat(book.getYearWritten().concat("true")))))) {
	    	System.out.println("Can't delete a borrowed book.\n");
	    	return;
	    }
	    result = result.replaceAll(book.getName().concat(book.getAuthor().concat(book.getYearWritten().concat("false"))), "");
	    PrintWriter writer = new PrintWriter(new File(filePath));
	    writer.append(result);
	    writer.flush();
	    System.out.println("Book deleted successfully.\n");
	}

	@Override
	public void borrowBook(Book book) throws Exception {
		String result = fileToString(filePath);
		if(!(result.contains(book.getName().concat(book.getAuthor().concat(book.getYearWritten()))))) {
	    	System.out.println("No such book found.\n");
	    	return;
	    }
	    if(result.contains((book.getName().concat(book.getAuthor().concat(book.getYearWritten().concat("true")))))) {
	    	System.out.println("Book already borrowed.\n");
	    	return;
	    }
	    result = result.replaceAll((book.getName().concat(book.getAuthor().concat(book.getYearWritten().concat("false")))), (book.getName().concat(book.getAuthor().concat(book.getYearWritten().concat("true")))));
	    System.out.println("Book borrowed successfully.\n");
	    PrintWriter writer = new PrintWriter(new File(filePath));
	    writer.append(result);
	    writer.flush();
	}
	
	@Override
	public void returnBook(Book book) throws Exception {
		String result = fileToString(filePath);
		if(!(result.contains(book.getName().concat(book.getAuthor().concat(book.getYearWritten()))))) {
	    	System.out.println("No such book found.\n");
	    	return;
	    }
	    if(result.contains((book.getName().concat(book.getAuthor().concat(book.getYearWritten().concat("false")))))) {
	    	System.out.println("Book already here.\n");
	    	return;
	    }
	    result = result.replaceAll((book.getName().concat(book.getAuthor().concat(book.getYearWritten().concat("true")))), (book.getName().concat(book.getAuthor().concat(book.getYearWritten().concat("false")))));
	    System.out.println("Book returned successfully.");
	    PrintWriter writer = new PrintWriter(new File(filePath));
	    writer.append(result);
	    writer.flush();
	}
	
	public static String fileToString(String filePath) throws Exception{
	      String input = null;
	      Scanner sc = new Scanner(new File(filePath));
	      StringBuffer sb = new StringBuffer();
	      while (sc.hasNextLine()) {
	         input = sc.nextLine();
	         sb.append(input);
	      }
	      return sb.toString();
	}
}

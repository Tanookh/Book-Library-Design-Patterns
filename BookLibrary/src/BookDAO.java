import java.io.FileNotFoundException;

public interface BookDAO {
	public void addBook(Book book) throws FileNotFoundException;
	public void deleteBook(Book book) throws FileNotFoundException, Exception;
	public void borrowBook(Book book) throws Exception;
	public void returnBook(Book book) throws FileNotFoundException, Exception;
}

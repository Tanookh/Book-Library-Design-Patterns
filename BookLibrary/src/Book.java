
public class Book {

	private String name;
	private String author;
	private String yearWritten;
	private String borrowed = "false";
	
	public Book(String name, String author, String yearWritten) {
		this.name = name;
		this.author = author;
		this.yearWritten = yearWritten;
	}
	
	protected String getName() {
		return name;
	}
	
	protected void setName(String name) {
		this.name = name;
	}
	
	protected String getAuthor() {
		return author;
	}
	
	protected void setAuthor(String author) {
		this.author = author;
	}
	
	protected String getYearWritten() {
		return yearWritten;
	}
	
	protected void setYearWritten(String yearWritten) {
		this.yearWritten = yearWritten;
	}
	
	protected String isBorrowed() {
		return borrowed;
	}
	
	protected void setBorrowed(String borrowed) {
		this.borrowed = borrowed;
	}
	
	protected String printInfo() {
		return this.name + this.author + this.yearWritten + this.borrowed + "\n";
	}
}

package dbConnections;

public class DBFileManager {
	
	private static DBFileManager instance = new DBFileManager();

	private DBFileManager()
	{
		System.out.println("Opening data file for reading ");
	}
	
	public static DBFileManager getInstance()
	{
		return instance;
	}
	
	
	public void writeToFile(String text)
	{
		System.out.println("writing data to file "+text);
	}
	
	public void deleteFromFile(String text)
	{
		System.out.println("deleting data from file "+text);
	}
	
	public String readFile()
	{
		return "file data";
	}
}

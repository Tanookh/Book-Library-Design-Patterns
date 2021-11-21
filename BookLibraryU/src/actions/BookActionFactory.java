package actions;

public class BookActionFactory {
	public static BaseAction create(int menuInput)
	{
		switch(menuInput)
		{
			case 1:
				return new AddBook();
			case 2: 
				return new UpdateBook();
			case 3: 
				return new DeleteBook();
			default:
				return null;
		}
	}
}

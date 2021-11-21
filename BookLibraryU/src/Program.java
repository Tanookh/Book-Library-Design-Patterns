import java.util.Scanner;

import actions.BaseAction;
import actions.BookActionFactory;

public class Program {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 
		do
		{
			drawMenu();
			int choice = input.nextInt();
			BaseAction action = BookActionFactory.create(choice);
			if(action==null)
			{
				break;
			}
			action.doAction();
			
		}while(true);
	}
	
	public static void drawMenu()
	{
		System.out.println("Please choose one of the options:");
		System.out.println("1. Add Book");
		System.out.println("2. Update Book");
		System.out.println("3. Delete Book");
		System.out.println("X. Exit");
	}

}

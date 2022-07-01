package game;

import java.util.Scanner;

public class Menu {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public Menu() { }
	
	public static Integer chooseOption() {
		System.out.println("1) Start a new game.");
		System.out.println("2) Load a save state.");
		System.out.println("3) Run tests.");
		System.out.println("4) Exit the program.");
		Integer playerInput=null;
    	String rawInput = "";
    	while(playerInput == null) {
    		try{
    			System.out.print("Choose a number between 1 and 4: ");
		    	rawInput = Menu.scanner.nextLine();
		    	//Parses the string argument as an integer.
		    	playerInput = Integer.parseInt(rawInput);
		    	if (!Menu.isValidInput(playerInput)) {
		    		System.out.print("Invalid number. ");
		    		playerInput = null;
		    	}
	        }
	        catch (NumberFormatException ex){
        			System.out.println("Invalid input. Please choose another number.");
	        }
    	}
    	return playerInput;	
	}
	
	private static boolean isValidInput(Integer playerInput) {
		return playerInput >= 1 && playerInput <= 4;
	}
}

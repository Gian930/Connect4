package main;

import java.util.Scanner;

/**
 * This Menu class it's used for give the player the possibility to choose an option.
 * @author Gianmarco Caldaroni
 *
 */
public class Menu {
	
	/**
	 * Create a new Scanner.
	 */
	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * The empty constructor.
	 */
	public Menu() { }
	
	/**
	 * chooseOption create the main menu where the player can choose one of the four option.
	 * @return playerInput the chosen option.
	 */
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
		    	playerInput = Integer.parseInt(rawInput);
		    	//If playerInput < 1 or playerInput > 4.
		    	if (!Menu.isValidInput(playerInput)) {
		    		System.out.print("Invalid number. ");
		    		playerInput = null;
		    	}
	        }
    		//If playerInput isn't a number.
	        catch (NumberFormatException ex){
    			System.out.println("Invalid input. Please choose another number.");
	        }
    	}
    	return playerInput;	
	}
	
	/**
	 * Check if playerInput is valid.
	 * @param playerInput
	 * @return true if it's valid and false otherwise.
	 */
	private static boolean isValidInput(Integer playerInput) {
		return playerInput >= 1 && playerInput <= 4;
	}
}

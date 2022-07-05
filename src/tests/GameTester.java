package tests;

import java.io.CharConversionException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import game.elements.Board;

/**
 * Tester for player's input.
 * @author Gianmarco Caldaroni.
 *
 */
public class GameTester {
	
	/**
	 * Boolean used in all method to decide if the input is valid or not.
	 */
	private static boolean isNotValid;

	/**
	 * The main test.
	 */
	public static void test() {
		
		System.out.println("\nRunning all game possible wrong input tests: \n");
		GameTester.testInput();
	}
	
	/**
	 * Check if the input is valid.
	 * @param playerInput input from the player.
	 */
    private static void isPassed(String rawInput) {
    	try {
    		
    		//Trying to parse playerInput in integer.
    		Integer playerInput = Integer.parseInt(rawInput);
    		
    		//If it's a valid number, the boolean isValid is true and false otherwise. 
    		if(playerInput >= 1 && playerInput <= Board.getWidth()) {
    			isNotValid = false;
    		} else {
    			isNotValid = true;
    		} 
    		
    		//If the input it's not a number, isValid is false.
    	} catch (NumberFormatException ex) {
    		isNotValid = true;	
    	}
    	
    	//If isValid is false we passed the tests.
    	System.out.println(isNotValid ? "PASSED" : "FAILED");
    }
    
	/**
	 * Test full column case.
	 * @param playerInput
	 */
	private static void testFullColumnInput(Integer playerInput) {
		
		String[] strings = {
				"X      ",
				"O      ",
				"X      ",
				"O      ",
				"X      ",
				"O      "
		};
		
		List<String> lines =  Arrays.asList(strings);
		Board board;
		
		try {
			board = new Board(new ArrayList<String>(lines));
			
			if(board.isColumnFull(playerInput)) {
				isNotValid = true;
			} else {
				isNotValid = false;
			}
			
			System.out.println(isNotValid ? "PASSED" : "FAILED");
			
		} catch (CharConversionException e) {
			//Unreachable code
		}

		
	}
	
	/**
	 * Test "save filename" input
	 * @param rawInput the string to check.
	 */
	private static void isSaveInput(String rawInput) {
		
		if(rawInput.startsWith("save")) {
			String[] args = rawInput.split(" ");
			

			if(args.length < 2 || args.length > 2) {
				isNotValid = true;
			} else {
				isNotValid = false;
			}
		}
		
		System.out.println(isNotValid == false ? "PASSED" : "FAILED");
	}
	
	/**
	 * Check if the input in the menu is valid.
	 * @param rawInput
	 */
	private static void menuInput(String rawInput) {
		
		try{
	    	Integer playerInput = Integer.parseInt(rawInput);
	    	if (playerInput >= 1 && playerInput <= 4) {
	    		isNotValid = false; 
	    	} else {
	    		isNotValid = true;
	    	}
        } catch (NumberFormatException ex){
			isNotValid = true;
        }
		
		System.out.println(isNotValid ? "PASSED" : "FAILED");
	}
	
    /**
     * Simulate possible input from the player.
     */
	private static void testInput() {

		System.out.print("Number greater than 7: ");
		GameTester.isPassed("10");
		System.out.print("Number smaller than 1: ");
		GameTester.isPassed("-3");
		System.out.print("Lowercase letter: ");
		GameTester.isPassed("a");
		System.out.print("Capital letter: ");
		GameTester.isPassed("C");
		System.out.print("Space: ");
		GameTester.isPassed(" ");
		System.out.print("An empty string: ");
		GameTester.isPassed("");
		System.out.print("A symbol: ");
		GameTester.isPassed("%");
		
		System.out.print("Full column input case: ");
		GameTester.testFullColumnInput(1);
		
		System.out.print("Save input case: ");
		GameTester.isSaveInput("save filename");
		
		System.out.print("Menu input; number greater than 4: ");
		GameTester.menuInput("5");
		System.out.print("Menu input; number smaller than 1: ");
		GameTester.menuInput("0");
		System.out.print("Menu input; lowercase letter: ");
		GameTester.menuInput("y");
		System.out.print("Menu input; capital letter: ");
		GameTester.menuInput("X");
		System.out.print("Menu input; space: ");
		GameTester.isPassed("    ");
		System.out.print("Menu input; an empty string: ");
		GameTester.isPassed("");
		System.out.print("Menu input; a symbol: ");
		GameTester.isPassed("=");

	}
	
}

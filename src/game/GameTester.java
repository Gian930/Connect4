package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameTester {
	
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
		Board board = new Board(new ArrayList<String>(lines));
		
		if(board.isColumnFull(playerInput)) {
			isNotValid = true;
		} else {
			isNotValid = false;
		}
		
		System.out.println(isNotValid ? "PASSED" : "FAILED");
		
	}
	
	/**
	 * Test "save filename" input
	 * @param rawInput the string to check.
	 */
	private static void isSaveInput(String rawInput) {
		
		if(rawInput.startsWith("save")) {
			String[] args = rawInput.split(" ");
			
			/**
			 * The input could be like:
			 * - "save": this is incorrect because is missing file's name.
			 * - "save filename other": this is incorrect because there are too many arguments. 
			 */
			if(args.length < 2 || args.length > 2) {
				isNotValid = true;
			} else {
				//In this case the input is valid because is like : "save filename".
				isNotValid = false;
			}
		}
		
		System.out.println(isNotValid == false ? "PASSED" : "FAILED");
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

	}
	
}

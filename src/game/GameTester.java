package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameTester {
	
	private static boolean isValid;

	/**
	 * The main test.
	 */
	public static void test() {
		
		System.out.println("\nRunning all game possible wrong input tests: \n");
		GameTester.testWrongInput();
	}
	
	/**
	 * Check if the input is valid.
	 * @param playerInput input from the player.
	 */
    private static void isPassed(String playerInput) {
    	
    	Game game = new Game();
    	
    	try {
    		//Trying to parse playerInput in integer.
    		Integer input = Integer.parseInt(playerInput);
    		//If it's a valid number, the boolean isValid is true and false otherwise. 
    		if(game.isValidInput(input)) {
    			isValid = true;
    		} else {
    			isValid = false;
    		} 
    		//If the input it's not a number, isValid is false.
    	} catch (NumberFormatException ex) {
    		isValid = false;
    	}
    	
    	//If isValid is false we passed the tests.
    	System.out.println(isValid == false ? "PASSED" : "FAILED");
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
			isValid = true;
		} else {
			isValid = false;
		}
		
		System.out.println(isValid ? "PASSED" : "FAILED");
		
	}
	
    /**
     * Simulate possible wrong input from the player.
     */
	private static void testWrongInput() {

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

	}
	

	
}

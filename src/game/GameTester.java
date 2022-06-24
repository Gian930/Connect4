package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameTester {
	
	private static boolean valid;

	/**
	 * The main test.
	 */
	public static void test() {
		
		System.out.println("Running all game tests: ");
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
    		//If it's a valid number, the boolean valid is true and false otherwise. 
    		if(game.isValidInput(input)) {
    			valid = true;
    		} else {
    			valid = false;
    		} 
    		//If the input it's not a number, valid is false.
    	} catch (NumberFormatException ex) {
    		valid = false;
    	}
    	
    	//If valid is false we passed the tests.
    	System.out.println(valid == false ? "PASSED" : "FAILED");
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
			valid = true;
		} else {
			valid = false;
		}
		
		System.out.println(valid ? "PASSED" : "FAILED");
		
	}
	
    /**
     * Simulate possible wrong input from the player.
     */
	private static void testWrongInput() {
		
		GameTester.isPassed(null);
		GameTester.isPassed("10");
		GameTester.isPassed("-3");
		GameTester.isPassed("a");
		GameTester.isPassed("C");
		GameTester.isPassed(" ");
		GameTester.isPassed("");
		GameTester.isPassed("%");
		GameTester.testFullColumnInput(1);

	}
	

	
}

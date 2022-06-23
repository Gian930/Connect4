package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class BoardTester it's used for testing the program.
 * @author Gianmarco Caldaroni.
 *
 */
public class BoardTester {
	
	public static void test() {
		System.out.print("Running test diagonal: ");
		BoardTester.testDiagonal();
	}
	
	private static void testDiagonal() {
		String[] strings = {
				"       ",
				"       ",
				"O      ",
				"XO     ",
				"XOO    ",
				"XOXOX X"
		};
		List<String> lines =  Arrays.asList(strings);
		Board board = new Board(new ArrayList<String>(lines));
		Player player1 = new Player();
		Player player2 = new Player();
		System.out.println(board.checkWinner(player1, player2) == player1 ? "PASSED" : "FAILED");
	}
	
	
	

}

package game;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class BoardTester it's used for testing the program.
 * @author Gianmarco Caldaroni.
 *
 */
public class BoardTester {
	
	public static void test() {
		String[] strings = {
				"       ",
				"       ",
				"O      ",
				"XO     ",
				"XOO    ",
				"XOXO  X"
		};
		ArrayList<String> lines = (ArrayList<String>) Arrays.asList(strings);
		Board board = new Board(lines);
//		System.out.println(board.); FARE METODO PROTECTED
	}
	

}

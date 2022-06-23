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
	
	/**
	 * Test all five possible status on the board.
	 */
	public static void test() {
		
		System.out.println("Running all horizontal tests: ");
		BoardTester.testHorizontal();
		
		System.out.println("Running all vertical tests: ");
		BoardTester.testVertical();
		
		System.out.println("Running all diagonal tests: ");
		BoardTester.testDiagonal();
		
		System.out.println("Running all anti-diagonal tests: ");
		BoardTester.testAntiDiagonal();
		
		System.out.println("Running draw test: ");
		BoardTester.testDraw();
	}
	
	/**
	 * Check if there is a winner from all the status of the board taken from input.  
	 * @param strings: the status of the board.
	 */
	private static void isPassed(String[] strings) {
		
		Player player1 = new Player();
		Player player2 = new Player();
		
		//Take the array strings and returns it as a list.
		List<String> lines =  Arrays.asList(strings);
		//Put the list in the board.
		Board board = new Board(new ArrayList<String>(lines));
		
		//For convenience player1 is always the winner and null it's for draw test case.
		System.out.println(
		   board.checkWinner(player1, player2) == player1 || board.checkWinner(player1, player2) ==  null ? "PASSED" : "FAILED");
	}
	
	
	/**
	 * Horizontal test cases.
	 */
	private static void testHorizontal() {
		
		String[] strings = {
				"       ",
				"       ",
				"       ",
				"       ",
				"XXX    ",
				"OOOO   "
		};
		
		String[] strings2 = {
				"       ",
				"       ",
				"       ",
				"       ",
				"    XXX",
				"   OOOO"
		};
		
		String[] strings3 = {
				"OOOO   ",
				"XXXO   ",
				"OOOX   ",
				"XXXO   ",
				"OOOXX  ",
				"XXXOX  "
		};
		
		String[] strings4 = {
				"   OOOO",
				"   XXXO",
				"   OOOX",
				"   XXXO",
				"  OOOXX",
				"  XXXOX"
		};
		
		BoardTester.isPassed(strings);
		BoardTester.isPassed(strings2);
		BoardTester.isPassed(strings3);
		BoardTester.isPassed(strings4);
		
	}
	
	/**
	 * Vertical test cases.
	 */
	private static void testVertical() {
		
		String[] strings = {
				"       ",
				"       ",
				"O      ",
				"O      ",
				"OX     ",
				"OXX    "
		};
		
		String[] strings2 = {
				"       ",
				"       ",
				"      O",
				"      O",
				"     XO",
				"    XXO"
		};
		
		String[] strings3 = {
				"OOO    ",
				"OXX    ",
				"OOO    ",
				"OXXX   ",
				"XOOXX  ",
				"OXXXO  "
		};
		
		String[] strings4 = {
				"    XOO",
				"    OOO",
				"    XXO",
				"   XOXO",
				"  OOXXX",
				"  OXXXO"
		};
		
		BoardTester.isPassed(strings);
		BoardTester.isPassed(strings2);
		BoardTester.isPassed(strings3);
		BoardTester.isPassed(strings4);
		
	}
	
	/**
	 * Diagonal test cases.
	 */
	private static void testDiagonal() {
		
		String[] strings = {
				"       ",
				"       ",
				"O      ",
				"XO     ",
				"XOO    ",
				"XOXOX X"
		};
		
		String[] strings2 = {
				"O      ",
				"XO     ",
				"XOO    ",
				"XOXO   ",
				"OXOX   ",
				"XOXOXOX"
		};
		
		String[] strings3 = {
				"   O   ",
				" OXXO  ",
				"XOXOXO ",
				"XOXOXXO",
				"OXOXOOX",
				"XOXOXOX"
		};
		
		String[] strings4 = {
				"       ",
				"XOXOO  ",
				"XOXOXO ",
				"XOXXOXO",
				"OXOXOOX",
				"XOXOXXO"
		};
		
		BoardTester.isPassed(strings);
		BoardTester.isPassed(strings2);
		BoardTester.isPassed(strings3);
		BoardTester.isPassed(strings4);
		
	}
	
	/**
	 * Anti-diagonal test cases.
	 */
	private static void testAntiDiagonal() {
		
		String[] strings = {
				"       ",
				"       ",
				"   O   ",
				"OXOO   ",
				"XOXX   ",
				"OXOXOXX"
		};
		
		String[] strings2 = {
				"   O   ",
				"XXOO   ",
				"OOXO    ",
				"OXXX   ",
				"OXOO   ",
				"XOXOXXX"
		};
		
		String[] strings3 = {
				"       ",
				"   X   ",
				"XOXOX O",
				"XOXOXOO",
				"OXOXOOX",
				"XOXOXOX"
		};
		
		String[] strings4 = {
				"      O",
				"    XOX",
				"   XOXO",
				"   OXOX",
				"   OOXX",
				"   XXOO"
		};
		
		BoardTester.isPassed(strings);
		BoardTester.isPassed(strings2);
		BoardTester.isPassed(strings3);
		BoardTester.isPassed(strings4);
		
	}
	
	/**
	 * Draw test case.
	 */
	private static void testDraw() {
		
		String[] strings = {
				"XXXOXXX",
				"OOOXOOO",
				"XXOOOXO",
				"OOXXOOX",
				"XXOOXXO",
				"XXOOXOX"
		};	
		
		BoardTester.isPassed(strings);
		
	}
		
	
}

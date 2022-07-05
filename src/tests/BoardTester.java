package tests;

import java.io.CharConversionException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import game.elements.Board;
import game.player.Player;
import sequence.WinningSequence;

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
		
		System.out.println("Running board horizontal tests: \n");
		BoardTester.testHorizontal();
		
		System.out.println("\nRunning board vertical tests: \n");
		BoardTester.testVertical();
		
		System.out.println("\nRunning board diagonal tests: \n");
		BoardTester.testDiagonal();
		
		System.out.println("\nRunning board anti-diagonal tests: \n");
		BoardTester.testAntiDiagonal();
		
		System.out.print("\nRunning board draw test: ");
		BoardTester.testDraw();
	}
	
	/**
	 * Check if there is a winner from all the status of the board taken from input.  
	 * @param strings: the status of the board.
	 */
	private static void isPassed(String[] strings) {
		
		Player player1 = new Player();
		Player player2 = new Player();
		WinningSequence winningSequence = new WinningSequence();
		
		//Take the array strings and returns it as a list.
		List<String> lines =  Arrays.asList(strings);
		//Put the list in the board.
		Board board;
		try {
			board = new Board(new ArrayList<String>(lines));
			
			//For convenience player1 is always the winner and null it's for draw test case.
			System.out.println(
					board.checkWinner(player1, player2,winningSequence) == player1 || 
					board.checkWinner(player1, player2,winningSequence) ==  null ? "PASSED" : "FAILED");
			
		} catch (CharConversionException e) {
			//Unreachable code.
		}
		
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
		
		System.out.print("Horizontal bottom left case: ");
		BoardTester.isPassed(strings);
		System.out.print("Horizontal bottom right case: ");
		BoardTester.isPassed(strings2);
		System.out.print("Horizontal top left case: ");
		BoardTester.isPassed(strings3);
		System.out.print("Horizontal top right case: ");
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
		
		System.out.print("Vertical bottom left case: ");
		BoardTester.isPassed(strings);
		System.out.print("Vertical bottom right case: ");
		BoardTester.isPassed(strings2);
		System.out.print("Vertical top left case: ");
		BoardTester.isPassed(strings3);
		System.out.print("Vertical top right case: ");
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
		
		System.out.print("Diagonal bottom left case: ");
		BoardTester.isPassed(strings);
		System.out.print("Diagonal top left case: ");
		BoardTester.isPassed(strings2);
		System.out.print("Diagonal top right case: ");
		BoardTester.isPassed(strings3);
		System.out.print("Diagonal bottom right case: ");
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
		
		System.out.print("Anti-diagonal bottom left case: ");
		BoardTester.isPassed(strings);
		System.out.print("Anti-diagonal top left case: ");
		BoardTester.isPassed(strings2);
		System.out.print("Anti-diagonal bottom right case: ");
		BoardTester.isPassed(strings3);
		System.out.print("Anti-diagonal top left case: ");
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

package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Test if the winning sequence generated is correct.
 * @author Gianmarco Caldaroni
 *
 */
public class WinningSequenceTester {
	
	/**
	 * All winning sequence cases.
	 */
	public static void test() {
		
		System.out.println("\nRunning winning sequence tests: \n");
		
		System.out.print("Horizontal test: ");
		WinningSequenceTester.isPassedHorizontal();
		
		System.out.print("Vertical test: ");
		WinningSequenceTester.isPassedVertical();
		
		System.out.print("Diagonal test: ");
		WinningSequenceTester.isPassedDiagonal();
		
		System.out.print("Anti-diagonal test: ");
		WinningSequenceTester.isPassedAntiDiagonal();
	}
	
	/**
	 * Generate the winning sequence with board's checkWinner method.
	 * @param strings the status of the board.
	 * @return winningSequence
	 */
	private static WinningSequence winningSequenceBuilder(String[] strings) {
		
		Player player1 = new Player();
		Player player2 = new Player();
		
		WinningSequence winningSequence= new WinningSequence();
		
		List<String> lines =  Arrays.asList(strings);
		Board board = new Board(new ArrayList<String>(lines));
		
		board.checkWinner(player1, player2, winningSequence);
		
		return winningSequence;
		
	}
	
	/**
	 * Horizontal case.
	 */
	private static void isPassedHorizontal() {
		
		String[] strings = {
				"       ",
				"       ",
				"       ",
				"       ",
				"XXX    ",
				"OOOO   "
		};
		
		Piece piece = Piece.fromCharacter('O');
		Coordinates first = new Coordinates(0,5);
		Coordinates second = new Coordinates(1,5);
		Coordinates third = new Coordinates(2,5);
		Coordinates fourth = new Coordinates(3,5);
		
		//Expected winning sequence.
		WinningSequence winningSequenceHorizontal = new WinningSequence(piece, first, second, third, fourth);
		//Generate winning sequence with winningSequenceBuilder.
		WinningSequence winningSequence = WinningSequenceTester.winningSequenceBuilder(strings);
		
		System.out.println(winningSequence.equals(winningSequenceHorizontal) ? "PASSED" : "FAILED");
				
	}

	/**
	 * Vertical case.
	 */
	private static void isPassedVertical() {
		
		String[] strings = {
				"       ",
				"       ",
				"O      ",
				"O      ",
				"OX     ",
				"OXX    "
		};
		
		Piece piece = Piece.fromCharacter('O');
		Coordinates first = new Coordinates(0,2);
		Coordinates second = new Coordinates(0,3);
		Coordinates third = new Coordinates(0,4);
		Coordinates fourth = new Coordinates(0,5);
		
		WinningSequence winningSequenceVertical = new WinningSequence(piece, first, second, third, fourth);
		WinningSequence winningSequence = WinningSequenceTester.winningSequenceBuilder(strings);
		System.out.println(winningSequence.equals(winningSequenceVertical) ? "PASSED" : "FAILED");
		
	}
	
	/**
	 * Diagonal case.
	 */
	private static void isPassedDiagonal() {
		
		String[] strings = {
				"       ",
				"       ",
				"O      ",
				"XO     ",
				"XOO    ",
				"XOXOX X"
		};
		
		Piece piece = Piece.fromCharacter('O');
		Coordinates first = new Coordinates(0,2);
		Coordinates second = new Coordinates(1,3);
		Coordinates third = new Coordinates(2,4);
		Coordinates fourth = new Coordinates(3,5);
		
		WinningSequence winningSequenceDiagonal = new WinningSequence(piece, first, second, third, fourth);
		WinningSequence winningSequence = WinningSequenceTester.winningSequenceBuilder(strings);
		System.out.println(winningSequence.equals(winningSequenceDiagonal) ? "PASSED" : "FAILED");
		
	}
	
	/**
	 * Anti-diagonal case.
	 */
	private static void isPassedAntiDiagonal() {
		
		String[] strings = {
				"       ",
				"       ",
				"   O   ",
				"OXOO   ",
				"XOXX   ",
				"OXOXOXX"
		};
		
		Piece piece = Piece.fromCharacter('O');
		Coordinates first = new Coordinates(3,2);
		Coordinates second = new Coordinates(2,3);
		Coordinates third = new Coordinates(1,4);
		Coordinates fourth = new Coordinates(0,5);
		
		WinningSequence winningSequenceAntiDiagonal = new WinningSequence(piece, first, second, third, fourth);
		WinningSequence winningSequence = WinningSequenceTester.winningSequenceBuilder(strings);
		System.out.println(winningSequence.equals(winningSequenceAntiDiagonal) ? "PASSED" : "FAILED");
		
	}

}

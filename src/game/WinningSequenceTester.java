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
		Coordinates first = new Coordinates(5,0);
		Coordinates second = new Coordinates(5,1);
		Coordinates third = new Coordinates(5,2);
		Coordinates fourth = new Coordinates(5,3);
		
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
		Coordinates first = new Coordinates(2,0);
		Coordinates second = new Coordinates(3,0);
		Coordinates third = new Coordinates(4,0);
		Coordinates fourth = new Coordinates(5,0);
		
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
		Coordinates first = new Coordinates(2,0);
		Coordinates second = new Coordinates(3,1);
		Coordinates third = new Coordinates(4,2);
		Coordinates fourth = new Coordinates(5,3);
		
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
		Coordinates first = new Coordinates(2,3);
		Coordinates second = new Coordinates(3,2);
		Coordinates third = new Coordinates(4,1);
		Coordinates fourth = new Coordinates(5,0);
		
		WinningSequence winningSequenceAntiDiagonal = new WinningSequence(piece, first, second, third, fourth);
		WinningSequence winningSequence = WinningSequenceTester.winningSequenceBuilder(strings);
		System.out.println(winningSequence.equals(winningSequenceAntiDiagonal) ? "PASSED" : "FAILED");
		
	}

}

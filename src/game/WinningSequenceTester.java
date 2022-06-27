package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningSequenceTester {
	

	public static void test() {
		
		System.out.println("\nRunning winning sequence tests: \n");
		WinningSequenceTester.testWinningSequenceHorizontal();
	}

	private static void testWinningSequenceHorizontal() {
		
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
		
		WinningSequence winningSequenceHorizontal = new WinningSequence(piece, first, second, third, fourth);
		WinningSequence winningSequence2 = WinningSequenceTester.isPassed(strings);
		System.out.println(winningSequence2);
		System.out.println(winningSequenceHorizontal);
		System.out.println(winningSequence2.equals(winningSequenceHorizontal)); //??
		
		
	
		
	}

	private static WinningSequence isPassed(String[] strings) {
		
		Player player1 = new Player();
		Player player2 = new Player();
		
		WinningSequence winningSequence= new WinningSequence();
		
		//Take the array strings and returns it as a list.
		List<String> lines =  Arrays.asList(strings);
		//Put the list in the board.
		Board board = new Board(new ArrayList<String>(lines));
		
		board.checkWinner(player1, player2, winningSequence);
		
		return winningSequence;
		
	}

}

package game;

/**
 * The Main class of the project.
 * @author Gianmarco Caldaroni.
 * @version 1.0
 * 
 */
public class Main {

	/**
	 * The main method of the project.
	 * @param args
	 */
	public static void main(String[] args) {
		BoardTester.test();
		GameTester.test();
		WinningSequenceTester.test();
		Game game = new Game();
        game.setUp();
        Player winner = game.run();
        if(winner==null) {
            System.out.println("It's a draw.");
        } else {
            System.out.println("Congratulations "+winner+", you win the game.");
        }
	}
}

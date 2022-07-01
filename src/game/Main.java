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
		Integer option = Menu.chooseOption();
		switch(option) {
			case 1:
				Game game = new Game();
		        game.setUp();
		        Player winner = game.run();
		        if(winner==null) {
		            System.out.println("It's a draw.");
		        } else {
		            System.out.println("Congratulations "+winner+", you win the game!");
		        }
		        break;
			case 2:
				break;
			case 3:
				System.out.println("Running all tests...");
				BoardTester.test();
				GameTester.test();
				WinningSequenceTester.test();
				break;
			case 4:
				System.out.println("Goodbye!");
				System.exit(0);
			default:
				//Unreachable code.
				break;
		}
	}
	
}

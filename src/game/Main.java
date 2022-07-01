package game;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The Main class of the project.
 * @author Gianmarco Caldaroni.
 * @version 1.0
 * 
 */
public class Main {
	
	private static Scanner scanner = new Scanner(System.in);

	private static void game() {
		Game game = new Game();
        game.setUp();
        Main.gameLoop(game);
        
	}
	
	private static void load() {
		Game game = null;
		while(game == null) {
			System.out.print("Choose a file to load a game: ");
			try {
				game = Game.fromSaveState(Main.scanner.nextLine());
			} catch (FileNotFoundException e) {
				System.out.println("The choosen file doesn't exist.");
			}
		}
		Main.gameLoop(game);
	}
	
	private static void gameLoop(Game game) {
		Player winner = game.run();
        if(winner==null) {
            System.out.println("It's a draw.");
        } else {
            System.out.println("Congratulations "+winner+", you win the game!");
        }
	}
	
	private static void tests() {
		System.out.println("Running all tests...");
		BoardTester.test();
		GameTester.test();
		WinningSequenceTester.test();
	}
	
	private static void exit() {
		System.out.println("Goodbye!");
		System.exit(0);
	}
	/**
	 * The main method of the project.
	 * @param args
	 */
	public static void main(String[] args) {
		
		Integer option = Menu.chooseOption();
		switch(option) {
			case 1:
				Main.game();
		        break;
			case 2:
				Main.load();
				break;
			case 3:
				Main.tests();
				break;
			case 4:
				Main.exit();
			default:
				//Unreachable code.
				break;
		}
	}
	
}

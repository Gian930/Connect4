package main;

import java.io.CharConversionException;
import java.io.FileNotFoundException;
import java.util.Scanner;

import game.Game;
import game.player.Player;
import tests.BoardTester;
import tests.GameTester;
import tests.WinningSequenceTester;

/**
 * The Main class of the project.
 * @author Gianmarco Caldaroni.
 * @version 1.0
 * 
 */
public class Main {
	
	/**
	 * Create a new Scanner.
	 */
	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Displaying if there's a winner using game.run() or if it's a draw if winner is null.
	 * @param game 
	 */
	private static void gameLoop(Game game) {
		Player winner = game.run();
        if(winner==null) {
            System.out.println("It's a draw.");
        } else {
            System.out.println("Congratulations "+winner+", you win the game!");
        }
	}

	/**
	 * Starting a new game.
	 */
	private static void game() {
		Game game = new Game();
        game.setUp();
        Main.gameLoop(game);
        
	}
	
	/**
	 * Load a previous saved game.
	 */
	private static void load() {
		Game game = null;
		while(game == null) {
			System.out.print("Choose a file to load a game: ");
			try {
				game = Game.fromSaveState(Main.scanner.nextLine());
			} catch (FileNotFoundException e) {
				System.out.println("The chosen file doesn't exist.");
			} catch (CharConversionException e) {
				System.out.println("The board of the chosen file is not valid.");
			} catch(IllegalArgumentException e) {
				System.out.println("The save file is not valid.");
			} 
		}
		Main.gameLoop(game);
	}
	
	/**
	 * Running all tests.
	 */
	private static void tests() {
		System.out.println("Running all tests...");
		BoardTester.test();
		GameTester.test();
		WinningSequenceTester.test();
	}
	
	/**
	 * Exit from the game.
	 */
	private static void exit() {
		System.out.println("Goodbye!");
		System.exit(0);
	}
	
	/**
	 * The main method of the project.
	 * @param args an array of command-line arguments for the application.
	 */
	public static void main(String[] args) {
		Integer option = Menu.chooseOption();
		//Run one of this case based on what the player has chosen.
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

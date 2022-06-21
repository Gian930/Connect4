package game;

import java.util.Random;
import java.util.Scanner;

/**
 * This class Game it's used to initialize a new Connect 4 game.
 * @author Gianmarco Caldaroni.
 *
 */
public final class Game {
	
	/**
	 * Create a Scanner object.
	 */
	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * The red player.
	 */
	private Player redPlayer;
	
	/**
	 * The yellow player.
	 */
	private Player yellowPlayer;
	
	/**
	 * The board. 
	 */
    private Board board;
    
    /**
     * The constructor.
     */
    public Game() {
    	this.redPlayer = new Player();
    	this.yellowPlayer = new Player();
        this.board= new Board();
    }
    
    /**
     * Set names of both players.
     */
    public void setUp() {
    	System.out.print("Choose red player name: ");
    	this.redPlayer.setNameFromInput();
    	System.out.print("Choose yellow player name: ");
    	this.yellowPlayer.setNameFromInput();
    }
    
    /**
     * Run a new game.
     * @return winner the winner of the game or, if it's a draw, null.
     * 
     */
    public Player run() {
    	Player winner = null;
    	boolean isRedTurn = this.chooseFirstPlayer();
    	//Initialize turn: an instance of type Piece.
    	Piece turn;
    	//If the board is filled the game is finished and there isn't a winner, so it's a draw.
    	while(winner == null && !this.board.isFilled()) {
    		Game.clearScreen();
    		System.out.println(this.board);
    		if(isRedTurn) {
    			System.out.print(this.redPlayer.getName()+"'s turn. ");
    			//turn becomes a red piece.
    			turn = Piece.RED;
    		} else {
    			System.out.print(this.yellowPlayer.getName()+"'s turn. ");
    			//else turn becomes a yellow piece.
    			turn = Piece.YELLOW;
    		}
    		int playerInput = this.chooseMove();
    		this.board.makeMove(playerInput, turn);
    		winner = this.board.checkWinner(this.redPlayer, this.yellowPlayer);
    		isRedTurn = !isRedTurn;
    	}
    	//Showing the final board.
    	Game.clearScreen();
    	System.out.println(this.board);
    	
        return winner;
    }
    
    /**
     * Choose the first player.
     * @return true (so it's the first player) or false (it's not).
     */
    private boolean chooseFirstPlayer() {
    	Random randomBooleanGenerator = new Random(); 
        return randomBooleanGenerator.nextBoolean(); 
    }
    
    /**
     * Cleaning the screen from previous moves.
     */
    private static void clearScreen() {
    	for (int i = 0; i < 50; i++) System.out.println();
    }
    
    /**
     * The player chooses a number to put it on the board.
     * @exception NumberFormatException: the string doesn't have the appropriate format.
     * @return playerInput a number taken from input by the player.
     */
    private int chooseMove() {
    	//Integer because we can convert playerInput from null to integer.
    	Integer playerInput=null;
    	while(playerInput == null) {
    		try{
    			System.out.print("Choose a number between 1 and 7: ");
		    	String number = Game.scanner.nextLine();
		    	//Parses the string argument as an integer.
		    	playerInput = Integer.parseInt(number);
		    	if (!this.isValidInput(playerInput)) {
		    		System.out.print("Invalid number. ");
		    		playerInput = null;
		    	}
	        }
	        catch (NumberFormatException ex){
	        	System.out.println("Invalid input. Please choose another number.");
	        }
    	}
    	return playerInput;	
    }
    
    /**
     * Check if playerInput is valid.
     * @param playerInput a number taken from input.
     * @return true if playerInput is valid and false otherwise.
     */
    private boolean isValidInput(Integer playerInput) {
    	return playerInput >= 1 && playerInput <= Board.getWidth() && !this.board.isColumnFull(playerInput);
    }
      
}


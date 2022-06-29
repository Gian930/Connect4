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
     * @return winner of the game or, if it's a draw, null.
     * 
     */
    public Player run() {
    	Player winner = null;
    	boolean isRedTurn = this.chooseFirstPlayer();
    	//Initialize turn: an instance of type Piece.
    	Piece turn;
    	WinningSequence winningSequence = new WinningSequence();
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
    		winner = this.board.checkWinner(this.redPlayer, this.yellowPlayer, winningSequence);
    		isRedTurn = !isRedTurn;
    	}
    	this.winningAnimation(winningSequence);
    	
        return winner;
    }
    
    private void winningAnimation(WinningSequence winningSequence) {
    	//Showing the final board.   	
    	try {
    		for(int i = 0; i < 6; i++) {
        		Thread.sleep(500);
        		Game.clearScreen();
        		this.board.blink(winningSequence);
        		System.out.println(this.board);
    		}
			
		} catch (InterruptedException e) {
			System.out.println("Something went wrong while displaying the winning animation.");
		}
    	
    	
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
     * The player chooses a number to put on the board.
     * @exception NumberFormatException: the string doesn't have the appropriate format.
     * @return playerInput a number taken from input by the player.
     */
    private int chooseMove() {
    	//Integer because we can convert playerInput from null to integer.
    	Integer playerInput=null;
    	String rawInput = "";
    	while(playerInput == null) {
    		try{
    			System.out.print("Choose a number between 1 and 7: ");
		    	rawInput = Game.scanner.nextLine();
		    	//Parses the string argument as an integer.
		    	playerInput = Integer.parseInt(rawInput);
		    	if (!this.isValidInput(playerInput)) {
		    		System.out.print("Invalid number.");
		    		playerInput = null;
		    	}
	        }
	        catch (NumberFormatException ex){
	        	if(!this.parseCommand(rawInput))
        			System.out.println("Invalid input. Please choose another number.");
	        }
    	}
    	return playerInput;	
    }
    
    private boolean parseCommand(String rawInput) {
    	if(rawInput.startsWith("save")) {
    		String[] args = rawInput.split(" ");
    		if(args.length < 2) {
    			System.out.println("Missing file name.");
    		} else if (args.length > 2) {
    			System.out.println("Too many arguments.");
    		} else {
    			if(args[1].equals("-h") || args[1].equals("--help")) {
    				System.out.println("Save command usage: \n      save [filename] | [-h | --help]");
    			} else {
    				// controllare caratteri particolari del nome del file.
    				this.saveSession(args[1]);
    				System.out.println("File saved successfully in '"+args[1]+"'.");
    			}
    		}
    		return true;
    	}
    	return false;
    }
    
    private void saveSession(String name) {
    	
    }
    
    
    /**
     * Check if playerInput is a valid number.
     * @param playerInput a number taken from input.
     * @return true if playerInput is valid and false otherwise.
     */
    public boolean isValidInput(Integer playerInput) {
    	return playerInput >= 1 && playerInput <= Board.getWidth() && !this.board.isColumnFull(playerInput);
    }
      
}


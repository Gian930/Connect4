package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * This class Game it's used to initialize a new Connect 4 game.
 * @author Gianmarco Caldaroni.
 *
 */
public final class Game {
	
	private boolean isRedTurn;
	private boolean firstTurn;
	
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
        this.isRedTurn = this.chooseFirstPlayer();
    }
    
    public Game(boolean isRedTurn, boolean firstTurn, Player redPlayer, Player yellowPlayer, Board board) {
		this.isRedTurn = isRedTurn;
		this.firstTurn = firstTurn;
		this.redPlayer = redPlayer;
		this.yellowPlayer = yellowPlayer;
		this.board = board;
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
    
    private Piece updateTurn() {
    	Piece turn;
    	if(this.isRedTurn) {
			System.out.println(this.redPlayer.getName()+"'s turn. ");
			//turn becomes a red piece.
			turn = Piece.RED;
		} else {
			System.out.println(this.yellowPlayer.getName()+"'s turn. ");
			//else turn becomes a yellow piece.
			turn = Piece.YELLOW;
		}
    	return turn;
    }
    
    /**
     * Run a new game.
     * @return winner of the game or, if it's a draw, null.
     * 
     */
    public Player run() {
    	Player winner = null;    	
    	//Initialize turn: an instance of type Piece.    	
    	WinningSequence winningSequence = new WinningSequence();
    	//If the board is filled the game is finished and there isn't a winner, so it's a draw.
    	while(winner == null && !this.board.isFilled()) {
    		Game.clearScreen();
    		Piece turn = this.updateTurn();
    		System.out.println(this.board);    		
    		int playerInput = this.chooseMove();
    		
    		this.board.makeMove(playerInput, turn);
    		winner = this.board.checkWinner(this.redPlayer, this.yellowPlayer, winningSequence);
    		this.isRedTurn = !this.isRedTurn;
    	}
    	this.winningAnimation(winningSequence);
    	
        return winner;
    }
    
    /**
     * Winning sequence animation.
     * @param winningSequence
     */
    private void winningAnimation(WinningSequence winningSequence) {   	
    	try {
    		for(int i = 0; i < 6; i++) {
    			//Showing the final board with the animation using Thread.sleep().
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
		    		System.out.print("Invalid number. ");
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
    				try {
						this.saveSession(args[1]);
					} catch (FileNotFoundException e) {
						System.out.println("Something went wrong while saving the file.");
					}
    				System.out.println("File saved successfully in '"+args[1]+"'.");
    			}
    		}
    		return true;
    	}
    	return false;
    }
    
    private void saveSession(String fileName) throws FileNotFoundException {
    	StringBuilder saveStateText = new StringBuilder();
    	saveStateText.append(this.redPlayer.toSaveState()+"\n");
    	saveStateText.append(this.yellowPlayer.toSaveState()+"\n");
    	saveStateText.append(this.firstTurn+"\n");
    	saveStateText.append(this.board.toSaveState());
    	PrintWriter writer = new PrintWriter(new File(fileName));
    	writer.write(saveStateText.toString());
    	writer.close();
    	
    }
    
    /**
     * Check if playerInput is a valid number.
     * @param playerInput a number taken from input.
     * @return true if playerInput is valid and false otherwise.
     */
    private boolean isValidInput(Integer playerInput) {
    	return playerInput >= 1 && playerInput <= Board.getWidth() && !this.board.isColumnFull(playerInput);
    }
    
    private static ArrayList<String> readLines(String fileName) throws FileNotFoundException {
    	ArrayList<String> lines = new ArrayList<String>();
    	Scanner scanner;
    	String line;
    	scanner = new Scanner(new File(fileName));
    	while(scanner.hasNextLine()) {
	    	line = scanner.nextLine();
	    	lines.add(line);
    	}
    	scanner.close();
    	return lines;
    }
    
    public static Game fromSaveState(String fileName) throws FileNotFoundException {
    	
    	ArrayList<String> lines = readLines(fileName);
    	Player redPlayer = Player.fromSaveState(lines.get(0));
    	Player yellowPlayer = Player.fromSaveState(lines.get(1));
    	boolean firstTurn = Boolean.parseBoolean(lines.get(2));
    	lines.remove(0);
    	lines.remove(0);
    	lines.remove(0);
    	Board board = Board.fromSaveState(lines);
    	boolean isRedTurn = board.evaluateTurn(firstTurn);
    	return new Game(isRedTurn, firstTurn, redPlayer, yellowPlayer, board);
    	
    	
    }
      
}


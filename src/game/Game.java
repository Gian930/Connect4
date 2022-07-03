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
	
	/**
	 * A boolean used to determinate if it's red player's turn or not. 
	 */
	private boolean isRedTurn;
	
	/**
	 * A boolean used to determinate if it's first player's turn or not.
	 */
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
    
    /**
     * Overload the constructor for fromSaveState method.
     * @param isRedTurn
     * @param firstTurn
     * @param redPlayer
     * @param yellowPlayer
     * @param board
     */
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
    
    /**
     * Switching piece color every turn.
     * @return turn piece red or yellow based on what color it was previously.
     */
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
    
    /**
     * Save the current session:
     * -The players.
     * -The boolean firstTurn it's used to determinate if it's red or yellow player's turn:
     * 	if it's true it's the turn that played first and false otherwise.
     * @param fileName the name of the file: "fileName.txt"
     * @throws FileNotFoundException if the file name doesnt's exist.
     */
    private void saveSession(String fileName) throws FileNotFoundException {
    	StringBuilder saveStateText = new StringBuilder();
    	saveStateText.append(this.redPlayer.toSaveState()+"\n");
    	saveStateText.append(this.yellowPlayer.toSaveState()+"\n");
    	saveStateText.append(this.firstTurn+"\n");
    	saveStateText.append(this.board.toSaveState());
    	//Using PrintWriter class to write in a file.
    	PrintWriter writer = new PrintWriter(new File(fileName));
    	writer.write(saveStateText.toString());
    	//Closes the stream.
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
    
    /**
     * This method it's used for reading all lines from a file.
     * @param fileName the name of the file.
     * @return lines an ArrayList of string  
     * @throws FileNotFoundException if the file name doesnt's exist.
     */
    private static ArrayList<String> readLines(String fileName) throws FileNotFoundException {
    	
    	ArrayList<String> lines = new ArrayList<String>();
    	Scanner scanner;
    	String line;
    	
    	//Using scanner and creates a new File instance for reading a file.
    	scanner = new Scanner(new File(fileName));
    	
    	while(scanner.hasNextLine()) {
	    	line = scanner.nextLine();
	    	lines.add(line);
    	}
    	scanner.close();
    	
    	return lines;
    }
    
    /**
     * This method it's used for loading an existing save state of the game previously saved.
     * @param fileName the name of the file.
     * @return new Game(isRedTurn, firstTurn, redPlayer, yellowPlayer, board);
     * @throws FileNotFoundException if the file name doesnt's exist.
     */
    public static Game fromSaveState(String fileName) throws FileNotFoundException {
    	
    	//Read the file.
    	ArrayList<String> lines = readLines(fileName);
    	
    	//Using fromSaveState(lines.get(x)) for getting redPlayer, yellowPlayer, and firstTurn.
    	Player redPlayer = Player.fromSaveState(lines.get(0));
    	Player yellowPlayer = Player.fromSaveState(lines.get(1));
    	boolean firstTurn = Boolean.parseBoolean(lines.get(2));
    	
    	/**
    	 * Remove redPlayer, yellowPlayer, and firstTurn from lines, create the board
    	 * and determinate if it' red or yellow player's turn. 
    	 */
    	lines.remove(0);
    	lines.remove(0);
    	lines.remove(0);
    	Board board = Board.fromSaveState(lines);
    	boolean isRedTurn = board.evaluateTurn(firstTurn);
    	
    	return new Game(isRedTurn, firstTurn, redPlayer, yellowPlayer, board);
    }
      
}


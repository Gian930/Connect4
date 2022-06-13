package game;
import java.util.Random;
import java.util.Scanner;

public final class Game {
	
	private static Scanner scanner = new Scanner(System.in);
	private Player redPlayer;
	private Player yellowPlayer;
    private Board board;
    
    public Game() {
    	this.redPlayer = new Player();
    	this.yellowPlayer = new Player();
        this.board= new Board();
    }
    

    public void setUp() {
    	System.out.print("Choose red player name: ");
    	this.redPlayer.setNameFromInput();
    	System.out.print("Choose yellow player name: ");
    	this.yellowPlayer.setNameFromInput();
    }

    public Player run() {
    	Player winner = null;
    	boolean isRedTurn = this.chooseFirstPlayer();
    	Piece turn;
    	while(winner == null && !this.board.isFilled()) {
    		System.out.println(this.board);
    		if(isRedTurn) {
    			System.out.print(this.redPlayer.getName()+"'s turn. ");
    			turn = Piece.RED;
    		} else {
    			System.out.print(this.yellowPlayer.getName()+"'s turn. ");
    			turn = Piece.YELLOW;
    		}
    		int playerInput = this.chooseMove();
    		this.board.makeMove(playerInput, turn);
    		Game.clearScreen();
    		this.board.isFinished();
    		//prendere input player
    		//aggiornare board con input
    		//controllare se c'è il vincitore
    		isRedTurn = !isRedTurn;
    	}
        return winner;
    }
    
    private boolean chooseFirstPlayer() {
    	Random randomBooleanGenerator = new Random(); 
        return randomBooleanGenerator.nextBoolean(); 
    }
    
    private static void clearScreen() {
    	for (int i = 0; i < 50; ++i) System.out.println();
    }
    
    private int chooseMove() {
    	Integer playerInput=null;
    	while(playerInput == null) {
    		try{
    			System.out.print("Choose a number between 1 and 7: ");
		    	String number = Game.scanner.nextLine();
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
    
    private boolean isValidInput(Integer playerInput) {
    	return playerInput >= 1 && playerInput <= Board.getWidth() && !this.board.isColumnFull(playerInput);
    }
    
    
}


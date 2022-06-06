package game;
import java.util.Random;
import java.util.Scanner;

public final class Game {
	
	private static Scanner scanner = new Scanner(System.in);
	
	private Player redPlayer;
	private Player yellowPlayer;
    private Board board;
    
    public Game(){
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
    	while(winner == null && !this.board.isFilled()) {
    		System.out.println(this.board);
    		int playerInput = this.chooseMove();
    		if(isRedTurn) {
    			// playerInput = 
    		}
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
    
    private void clearScreen() {
    	
    }
    
    private int chooseMove() {
    	Integer playerInput=null;
    	while(playerInput == null) {
    		try{
    			System.out.print("Choose a number: ");
		    	String number = scanner.nextLine();
		    	playerInput = Integer.parseInt(number);
	        }
	        catch (NumberFormatException ex){
	        	System.out.println("Invalid input. Please choose another number.");
	        }
    	}
    	return playerInput;
    	
    }
    
    
}


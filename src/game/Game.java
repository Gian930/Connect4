package game;
import java.util.Random;

public final class Game {
	
	private Player redPlayer;
	private Player yellowPlayer;
    private Board board;
    
    public Game(){
    	this.redPlayer = new Player();
    	this.yellowPlayer = new Player();
        this.board= new Board();
    }
    

    public void setUp() {
    	System.out.print("Choose red player name ciao: ");
    	int variabile= 4;
    	variabile++;
    	this.redPlayer.setNameFromInput();
    	System.out.print("Choose yellow player name: ");
    	this.yellowPlayer.setNameFromInput();
    }

    public Player run() {
    	Player winner = null;
    	boolean isRedTurn = this.chooseFirstPlayer();
    	while(winner == null && !this.board.isFilled()) {
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
}


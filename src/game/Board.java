package game;

import java.util.ArrayList;

/**
 * This class Board it's used to set a new board.
 * @author Gianmarco Caldaroni.
 *
 */
public class Board {
	
	/**
	 * The number of columns.
	 */
    private final static int WIDTH = 7;
    
    /**
     * The number of rows.
     */
    private final static int HEIGHT = 6;
    
    /**
     * The board.
     */
    private Piece[][] pieces = new Piece[HEIGHT][WIDTH];
    
    /**
     * Get the number of columns.
     * @return width
     */
    public static int getWidth() {
		return WIDTH;
	}
    
    /**
     * Get the number of rows.
     * @return height
     */
	public static int getHeight() {
		return HEIGHT;
	}
	
	/**
	 * The constructor.
	 */
	public Board() {
        for(int y=0; y<HEIGHT; y++){
            for(int x=0; x<WIDTH; x++) {
                this.pieces[y][x] = Piece.EMPTY;
            }
        }
    }
	
	/**
	 * Overload the constructor for BoardTester.
	 * @param lines represents a particular status of the board.
	 */
	public Board(ArrayList<String> lines) {
		for(int y=0; y<HEIGHT; y++) {
			String line = lines.get(y);
			for(int x=0; x<WIDTH; x++) {
				//Using Piece method for setting the board.
				this.pieces[y][x]=Piece.fromCharacter(line.charAt(x));
			}
		}
	}
    
	/**
	 * Check if the board is filled.
	 * @return false if it's not filled and true otherwise.
	 */
    public boolean isFilled() {
    	for(int x=0; x<WIDTH; x++) {
    		if(this.pieces[0][x] == Piece.EMPTY) {
    			return false;
    		}
    	}
    	return true;
    }
    
    /**
     * Check if the single column it's filled.
     * @param playerInput the chosen column.
     * @return true if it's full and false otherwise.
     */
    public boolean isColumnFull(Integer playerInput) {
    	return this.pieces[0][playerInput-1] != Piece.EMPTY;
    }
    
    /**
     * Drop the piece in the board.
     * @param playerInput the chosen column.
     * @param turn a red piece if it's red's player turn, else a yellow piece.
     */
    public void makeMove(Integer playerInput, Piece turn) {
    	for(int row = HEIGHT-1; row >= 0; row--) {
    		//Check if the board it's empty in that position.
    		if(this.pieces[row][playerInput-1] == Piece.EMPTY) {
    			this.pieces[row][playerInput-1] = turn;
    			//Stop the for loop.
    			break;
    		}
    	}
    }
    
    /**
     * Check if there is a winner.
     * @param redPlayer
     * @param yellowPlayer
     * @return winner: the red or yellow player if there are four pieces connected of that color, null otherwise.
     */
    public Player checkWinner(Player redPlayer, Player yellowPlayer) {
    	Player winner;
    	Piece color;
    	
    	color = this.checkHorizontal();
    	winner = checkColor(redPlayer, yellowPlayer, color);
    	if(winner != null) {
    		return winner;
    	}
    	
    	color = this.checkVertical();
    	winner = checkColor(redPlayer, yellowPlayer, color);
    	if(winner != null) {
    		return winner;
    	}
    	
    	color = this.checkDiagonal();
    	winner = checkColor(redPlayer, yellowPlayer, color);
    	if(winner != null) {
    		return winner;
    	}
    	
    	color = this.checkAntiDiagonal();
    	winner = checkColor(redPlayer, yellowPlayer, color);
    	if(winner != null) {
    		return winner;
    	}
    	return null;
    }
    
	/**
	 * Check the horizontal pieces.
	 * @return color if there is four horizontal pieces of the same color, null otherwise.
	 */
    private Piece checkHorizontal() {
    	for(int c1 = 0; c1 < 4; c1++) {
    		int c2 = c1+1; 
    		int c3 = c1+2;
    		int c4 = c1+3;
    		for(int r = 0; r < HEIGHT; r++) {
    			if(this.pieces[r][c1] != Piece.EMPTY && checkEquals(
					this.pieces[r][c1],
					this.pieces[r][c2],
					this.pieces[r][c3],
					this.pieces[r][c4]
					
				)) {
    				Piece color = this.pieces[r][c1];
    				return color;   				
    			}
    		}
    	}
    	return null;
    }
    
	/**
	 * Check the vertical pieces.
	 * @return color if there is four vertical pieces of the same color, null otherwise.
	 */
    private Piece checkVertical() {
    	for(int r1 = 0; r1 < 3; r1++) {
    		int r2 = r1+1;
    		int r3 = r1+2;
    		int r4 = r1+3;
    		for(int c = 0; c < WIDTH; c++) {
    			if(this.pieces[r1][c] != Piece.EMPTY && checkEquals(
					this.pieces[r1][c],
					this.pieces[r2][c],
					this.pieces[r3][c],
					this.pieces[r4][c]
					
				)) {
    				Piece color = this.pieces[r1][c];
    				return color;   				
    			}
    		}
    	}
    	return null;
    }
    
	/**
	 * Check the diagonal "\" pieces.
	 * @return color if there is four diagonal pieces of the same color, null otherwise.
	 */
    private Piece checkDiagonal() {
    	for(int i1 = 0; i1 < 3 ; i1++) {
    		int i2 = i1+1;
    		int i3 = i1+2;
    		int i4 = i1+3;
    		for(int j1 = 0; j1 < 4; j1++) {
        		int j2 = j1+1;
        		int j3 = j1+2;
        		int j4 = j1+3;
				if(this.pieces[i1][j1] != Piece.EMPTY && checkEquals(
					this.pieces[i1][j1],
					this.pieces[i2][j2],
					this.pieces[i3][j3],
					this.pieces[i4][j4]
					
				)) {
    				Piece color = this.pieces[i1][j1];
    				return color;   				
    			}
    		}
    	}
    	return null;
    }
    
   	/**
	 * Check the anti-diagonal "/" pieces.
	 * @return color if there is four anti-diagonal pieces of the same color, null otherwise.
	 */
    private Piece checkAntiDiagonal() {
    	for(int i1 = 0; i1 < 3; i1++) {
    		int i2 = i1+1;
    		int i3 = i1+2;
    		int i4 = i1+3;
    		for(int j1 = 6; j1 > 2 ; j1--) {
        		int j2 = j1-1;
        		int j3 = j1-2;
        		int j4 = j1-3;
				if(this.pieces[i1][j1] != Piece.EMPTY && checkEquals(
					this.pieces[i1][j1],
					this.pieces[i2][j2],
					this.pieces[i3][j3],
					this.pieces[i4][j4]
					
				)) {
    				Piece color = this.pieces[i1][j1];
    				return color;   				
    			}
    		}
    	}
    	return null;
    }
    
    /**
     * Check if the four pieces are equals.
     * @param piece1
     * @param piece2
     * @param piece3
     * @param piece4
     * @return true if they're equals and false otherwise.
     */
    private boolean checkEquals(Piece piece1, Piece piece2, Piece piece3, Piece piece4) {
    	//If this chain of compare it's true, for transitivity, there's no point to write piece1==piece4, because it's always true.
    	return piece1==piece2 && piece2==piece3 && piece3==piece4;
    }
    
    /**
     * Check what color is.
     * @param redPlayer
     * @param yellowPlayer
     * @param color
     * @return redPlayer or yellowPlayer depending of what color we have to check and null otherwise.
     */
    private Player checkColor(Player redPlayer, Player yellowPlayer, Piece color) {
    	if(color != null) {
    		if(color == Piece.RED) {
    			return redPlayer;
    		} else {
    			return yellowPlayer;
    		}
    	} else {
    		return null;
    	}
    }
    
    /**
     * Override the toString method of the Object superclass.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder outputString = new StringBuilder();
        for(int y=0; y<HEIGHT; y++){
        	outputString.append("║ ");
            for(int x=0; x<WIDTH; x++) {
                outputString.append(this.pieces[y][x]);
                outputString.append(" ║ ");
            }
            outputString.append("\n");
        }
        outputString.append(
        		"╠═══╬═══╬═══╬═══╬═══╬═══╬═══╣\n"
        		+ "║ 1 ║ 2 ║ 3 ║ 4 ║ 5 ║ 6 ║ 7 ║\n"
        		+ "╚═══╩═══╩═══╩═══╩═══╩═══╩═══╝"
		);
        return outputString.toString();
    }
    
}

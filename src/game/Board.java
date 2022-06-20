package game;

public class Board {
	
    private final static int WIDTH = 7;
    private final static int HEIGHT = 6;
    private Piece[][] pieces = new Piece[HEIGHT][WIDTH];
    
    
    public static int getWidth() {
		return WIDTH;
	}

	public static int getHeight() {
		return HEIGHT;
	}

	public Board() {
        for(int y=0; y<HEIGHT; y++){
            for(int x=0; x<WIDTH; x++) {
                this.pieces[y][x] = Piece.EMPTY;
            }
        }
    }
    
    public boolean isFilled() {
    	for(int x=0; x<WIDTH; x++) {
    		if(this.pieces[0][x] == Piece.EMPTY) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public boolean isColumnFull(Integer playerInput) {
    	return this.pieces[0][playerInput-1] != Piece.EMPTY;
    }
    
    public void makeMove(Integer playerInput, Piece turn) {
    	for(int row = HEIGHT-1; row >= 0; row--) {
    		if(this.pieces[row][playerInput-1] == Piece.EMPTY) {
    			this.pieces[row][playerInput-1] = turn;
    			break;
    		}
    	}
    }
    
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
    	
    	color = this.checkFirstDiagonal();
    	winner = checkColor(redPlayer, yellowPlayer, color);
    	if(winner != null) {
    		return winner;
    	}
    	
    	color = this.checkSecondDiagonal();
    	winner = checkColor(redPlayer, yellowPlayer, color);
    	if(winner != null) {
    		return winner;
    	}
    	return null;
    }
    
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
    
    private Piece checkFirstDiagonal() {
    	for(int i1 = 0; i1 < 3 ; i1++) {
    		int i2 = i1+1;
    		int i3 = i1+2;
    		int i4 = i1+3;
    		for(int j1 = 0; j1 < 3; j1++) {
        		int j2 = j1+1;
        		int j3 = j1+2;
        		int j4 = j3+3;
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
    
    private Piece checkSecondDiagonal() {
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
    
    
    private boolean checkEquals(Piece piece1, Piece piece2, Piece piece3, Piece piece4) {
    	return piece1==piece2 && piece2==piece3 && piece3==piece4;
    }
    
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

    @Override
    public String toString() {
        StringBuilder outputString = new StringBuilder();
        for(int y=0; y<HEIGHT; y++){
            for(int x=0; x<WIDTH; x++) {
                switch(this.pieces[y][x]) {
                    case YELLOW:
                        outputString.append("Y");
                        break;
                    case RED:
                        outputString.append("R");
                        break;
                    case EMPTY:
                        outputString.append("E");
                        break;
                    default:
                        break;
                }
            }
            outputString.append("\n");
        }
        return outputString.toString();
    }
    
}

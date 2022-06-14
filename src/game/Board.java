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
    	for(int row = 5; row >= 0; row--) {
    		if(this.pieces[row][playerInput-1] == Piece.EMPTY) {
    			this.pieces[row][playerInput-1] = turn;
    			break;
    		}
    	}
    }
    
    public void isFinished() {
    	
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

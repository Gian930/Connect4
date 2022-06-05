
public class Board {
    private final int WIDTH = 7;
    private final int HEIGHT = 6;
    private Piece[][] pieces = new Piece[HEIGHT][WIDTH];
    
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

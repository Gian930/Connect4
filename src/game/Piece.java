package game;


/**
 * Pieces that can be in the board.
 * @author Gianmarco Caldaroni.
 *
 */
public enum Piece {
	
	/**
	 * The yellow piece.
	 */
    YELLOW,
    
    /**
     * The red piece.
     */
    RED,
    
    /**
     * An empty piece.
     */
    EMPTY;
    
	/**
	 * @param character
	 * @return yellow, red or empty based on what character is in the board.
	 */
	public static Piece fromCharacter(char character) {
		switch(character) {
			case 'X':
				return YELLOW;
			case 'O':
				return RED;
			case ' ':
				return EMPTY;
			default:
				return null;
		}
	}
	
	
	/**
	 * Override the toString method of the Object superclass.
	 * @return "X", "O" or " " depending in what case we are.
	 */
	@Override
	public String toString() {
		switch(this) {
	        case YELLOW:
	            return "X";
	        case RED:
	            return "O";
	        case EMPTY:
	            return " ";
	        default:
	        	//Never happens.
	            return null; 
		}
	}

}

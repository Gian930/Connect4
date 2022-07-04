package game;

import java.io.CharConversionException;

/**
 * Pieces that can be in the board.
 * @author Gianmarco Caldaroni.
 * 
 */
public enum Piece implements Savable {
	
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
	public static Piece fromCharacter(char character) throws CharConversionException {
		switch(character) {
			case 'X':
				return YELLOW;
			case 'O':
				return RED;
			case ' ':
				return EMPTY;
			default:
				throw new CharConversionException();
		}
	}
	
	/**
	 * Implements toSaveState() from Interface Savable.
	 * @return this.toString()
	 */
	@Override
	public String toSaveState() {
		return this.toString();
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

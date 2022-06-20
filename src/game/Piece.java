package game;

public enum Piece {
	
    YELLOW,
    RED,
    EMPTY;
    
    // private Piece() {

    // }
	
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
	            return null; //Never happens.
		}
	}

}

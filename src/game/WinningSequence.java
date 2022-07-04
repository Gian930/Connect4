package game;

/**
 * Create the winning sequence.
 * @author Gianmarco Caldaroni.
 * 
 */
public class WinningSequence {
	
	/**
	 * The winner piece.
	 */
	private Piece piece;
	
	/**
	 * First coordinate.
	 */
	private Coordinates first;
	
	/**
	 * Second coordinate.
	 */
	private Coordinates second;
	
	/**
	 * Third coordinate.
	 */
	private Coordinates third;
	
	/**
	 * Fourth coordinate.
	 */
	private Coordinates fourth;
	
	/**
	 * The constructor.
	 * @param piece
	 * @param first
	 * @param second
	 * @param third
	 * @param fourth
	 */
	public WinningSequence(Piece piece, Coordinates first, Coordinates second, Coordinates third, Coordinates fourth) {
		this.piece=piece;
		this.first=first;
		this.second=second;
		this.third=third;
		this.fourth=fourth;
	}
	
	/**
	 * Overload the constructor in an empty constructor for WinningSequenceTester.
	 */
	public WinningSequence() {}
	
	/**
	 * Get the winner piece.
	 * @return piece
	 */
	public Piece getPiece() {
		return piece;
	}
	
	/**
	 * Set the winner piece.
	 * @param piece
	 */
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	/**
	 * Get first coordinate.
	 * @return first
	 */
	public Coordinates getFirst() {
		return first;
	}
	
	/**
	 * Set first coordinate.
	 * @param first
	 */
	public void setFirst(Coordinates first) {
		this.first = first;
	}
	
	/**
	 * Get second coordinate.
	 * @return second
	 */
	public Coordinates getSecond() {
		return second;
	}
	
	/**
	 * Set second coordinate.
	 * @param second
	 */
	public void setSecond(Coordinates second) {
		this.second = second;
	}
	
	/**
	 * Get third coordinate.
	 * @return
	 */
	public Coordinates getThird() {
		return third;
	}
	
	/**
	 * Set third coordinate.
	 * @param third
	 */
	public void setThird(Coordinates third) {
		this.third = third;
	}
	
	/**
	 * Get fourth coordinate.
	 * @return fourth
	 */
	public Coordinates getFourth() {
		return fourth;
	}
	
	/**
	 * Set the second coordinate.
	 * @param fourth
	 */
	public void setFourth(Coordinates fourth) {
		this.fourth = fourth;
	}
	
	/**
	 * Override equals method in Object for WinningSequenceTester.
	 * @param object the reference object with which to compare.
	 * @return true if this object is the same as the object argument; false otherwise.
	 */
	@Override
	public boolean equals(Object object) {
		
		//return true if the object is compare to itself.
		if(this==object) {
			return true;
		}
		
		if(!(object instanceof WinningSequence)) {
			return false;
		}
		
		WinningSequence winningSequence = (WinningSequence) object;
		
		//Using equals method from Coordinates class.
		return this.piece == winningSequence.piece && 
				this.first.equals(winningSequence.first) && 
				this.second.equals(winningSequence.second) && 
				this.third.equals(winningSequence.third) && 
				this.fourth.equals(winningSequence.fourth);
		
	}
	
	/**
	 * Override toString() method of the Object superclass.
	 * @return a string representation of the object.
	 */
	@Override
	public String toString() {
		return "{"+this.piece+"; "+this.first+", "+this.second+", "+this.third+", "+this.fourth+"}";
	}

}

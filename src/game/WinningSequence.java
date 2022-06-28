package game;

public class WinningSequence {
	
	private Piece piece;
	private Coordinates first;
	private Coordinates second;
	private Coordinates third;
	private Coordinates fourth;
	
	public WinningSequence(Piece piece, Coordinates first, Coordinates second, Coordinates third, Coordinates fourth ) {
		this.piece=piece;
		this.first=first;
		this.second=second;
		this.third=third;
		this.fourth=fourth;
	}
	
	
	public WinningSequence() {}
	
	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public Coordinates getFirst() {
		return first;
	}

	public void setFirst(Coordinates first) {
		this.first = first;
	}

	public Coordinates getSecond() {
		return second;
	}

	public void setSecond(Coordinates second) {
		this.second = second;
	}

	public Coordinates getThird() {
		return third;
	}

	public void setThird(Coordinates third) {
		this.third = third;
	}

	public Coordinates getFourth() {
		return fourth;
	}

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
		
		return this.piece == winningSequence.piece && this.first.equals(winningSequence.first)  && 
				this.second.equals(winningSequence.second) && 
				this.third.equals(winningSequence.third) && this.fourth.equals(winningSequence.fourth);
		
	}

	@Override
	public String toString() {
		return "{"+this.piece+"; "+this.first+", "+this.second+", "+this.third+", "+this.fourth+"}";
	}

}

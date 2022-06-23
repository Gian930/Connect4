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
	

}

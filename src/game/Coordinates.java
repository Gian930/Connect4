package game;

public class Coordinates {
	
	private int x;
	private int y;
	
	public Coordinates(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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
		
		if(!(object instanceof Coordinates)) {
			return false;
		}
		
		Coordinates coordinates = (Coordinates) object;
		
		return this.x == coordinates.x && this.y == coordinates.y;
	
		}
		
	
	@Override
	public String toString() {
		return "("+this.x+", "+this.y+")";
	}
	

}

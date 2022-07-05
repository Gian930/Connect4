package sequence;

/**
 * Create the coordinates for winning sequence.
 * @author Gianmarco Caldaroni.
 * 
 */
public class Coordinates {
	
	/**
	 * The x component.
	 */
	private int x;
	
	/**
	 * The y component.
	 */
	private int y;
	
	/**
	 * The constructor.
	 * @param x
	 * @param y
	 */
	public Coordinates(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	/**
	 * Get the x component.
	 * @return x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Set the x component.
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Get the y component.
	 * @return y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Set the y component.
	 * @param y
	 */
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
		
		//Casting object to a Coordinates object to allow comparison.
		Coordinates coordinates = (Coordinates) object;
		
		return this.x == coordinates.x && this.y == coordinates.y;
	
		}
		
	/**
	 * Override toString() method of the Object class.
	 * @return a string representation of the object.
	 */
	@Override
	public String toString() {
		return "("+this.x+", "+this.y+")";
	}
	

}

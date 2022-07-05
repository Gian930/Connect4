package game;

/**
 * Interface class for saving file system.
 * @author Gianmarco Caldaroni.
 */
public interface Savable {
	
	/**
	 * Method implemented in Board, Piece and Player class.
	 * @return the file content.
	 */
	public String toSaveState();
}

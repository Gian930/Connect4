package game;

import java.util.Scanner;

/**
 * This class Player define a new player.
 * @author Gianmarco Caldaroni.
 *
 */
public class Player implements Savable {
	
	/**
	 * Create a Scanner object.
	 */
	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * The name of the player.
	 */
    private String name;
    
	/**
     * The empty constructor.
     */
    public Player() { }
    
    /**
     * Overload the empty constructor for fromSaveState().
     * @param name
     */
    public Player(String name) {
		this.name = name;
	}

    /**
     * Get the name of the player.
     * @return name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Set the name of the player.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Set the name of the player chosen from input.
     */
    public void setNameFromInput() {       
        String name = scanner.nextLine();
        this.setName(name);
    }
    
    /**
     * This method it's used for getting redPlayer and yellowPlayer in Game.fromSaveState.  
     * @param input
     * @return new Player(input)
     */
    public static Player fromSaveState(String input) {
    	return new Player(input);
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
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return this.name;
    }

}

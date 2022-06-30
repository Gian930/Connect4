package game;

import java.util.Scanner;

/**
 * This class Player define a new player.
 * @author Gianmarco Caldaroni.
 *
 */
public class Player {
	
	/**
	 * Create a Scanner object.
	 */
	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * The name of the player.
	 */
    private String name;
    
    /**
     * The constructor.
     */
    public Player() { }

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
     * Override the toString method of the Object superclass.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return this.name;
    }

}

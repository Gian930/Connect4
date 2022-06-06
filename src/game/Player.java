package game;
import java.util.Scanner;

public class Player {
	
	private static Scanner scanner = new Scanner(System.in);
    private String name;
    
    public Player() {
    	
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNameFromInput() {
        
        String name = scanner.nextLine();
        this.setName(name);
    }
    
    

    @Override
    public String toString() {
        return this.name;
    }

}

import java.util.Scanner;

public class Player {
	
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
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        scanner.close();
        this.setName(name);

    }

    @Override
    public String toString() {
        return this.name;
    }

}

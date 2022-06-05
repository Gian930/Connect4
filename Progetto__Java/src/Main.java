
public class Main {

	public static void main(String[] args) {
		Game game = new Game();
        game.setUp();
        Player winner = game.run();
        if(winner==null) {
            System.out.println("It's a draw.");
        }
        else {
            System.out.println("Congratulations "+winner+", you win the game.");
        }
	}
}

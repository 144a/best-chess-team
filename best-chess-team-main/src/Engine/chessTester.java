package Engine;

public class chessTester {

	public static void main(String[] args) {
		chessGame game = new chessGame("Human", "Human");
		GUI g = new GUI();
		g.chessGame();
		game.runGame();

	}

}

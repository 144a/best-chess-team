package Engine;

import java.util.Scanner;

public class chessTester  {

	public static void main(String[] args) {
		chessGame game = new chessGame("Human", "Human");
		//GUI g = new GUI();
		//g.chessGame();
		new Panel_manager();


		game.runGame();


	}
}

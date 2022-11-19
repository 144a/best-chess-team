package Engine;

public class chessGame implements chessEngine {
	private Player white;
	private Player black;
	
	private Board board;
	private boolean gameOver;
	
	public chessGame(String p1, String p2) {
		// Initialize Players
		if(p1.equals("Human")) {
			white = new humanPlayer(Color.WHITE);
		} else {
			white = new aiPlayer(Color.WHITE);
		}
		if(p2.equals("Human")) {
			black = new humanPlayer(Color.BLACK);
		} else {
			black = new aiPlayer(Color.BLACK);
		}
		
		//System.out.println(white.getColor());
		//System.out.println(black.getColor());
		
		// Initialize Board
		board = new Board(white, black);
		
		// Set game over flag
		gameOver = false;
		
		// Display new Board
		System.out.println("+----------New Board----------+");
		board.displayBoard();
		
	}
	
	public void runGame() {
		// Loop for taking turns
		// 1 = white
		// -1 = black
		int turn = 1;
		boolean check = false;
		boolean checkmate = false;
		Player curPlayer;
		Player otherPlayer;
		while(gameOver == false) {
			// Sets current Player object to the player who's turn it is
			if(turn == 1) {
				System.out.println("White Player's Turn!");
				curPlayer = white;
				otherPlayer = black;
			} else {
				System.out.println("Black Player's Turn!");
				curPlayer = black;
				otherPlayer = white;
			}
			curPlayer.takeTurn();
			check = board.checkIfCheck(otherPlayer.getColor());
			if(check) {
				System.out.println(otherPlayer.getColor() + " is in check!");
				checkmate = board.checkIfCheckmate(otherPlayer.getColor());
			}
			board.displayBoard();
			if(checkmate) {
				curPlayer.setWon(true);
				gameOver = true;
				System.out.println(curPlayer.getColor() + "Won!");
			}
			
			turn *= -1;
			
		}
	}
	
	@Override
	public void printPlayerTypes(Player p1, Player p2) {
		
		
	}
	
}

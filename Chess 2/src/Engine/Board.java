package Engine;

public class Board {
	// Fields
	private Square[][] squares;
	private Player player1;
	private Player player2;
	
	
	// Constructor
	public Board(Player p1, Player p2) {
		this.player1 = p1;
		this.player2 = p2;
		this.squares = new Square[8][8];
		
		// Populate 2d array with Empty Square Objects		
		for(int r = 0; r < this.squares[0].length; r++) {
			for(int c = 0; c < this.squares.length; c++) {
				this.squares[r][c] = new Square(r, c, null);
			}			
		}
		
		// Set player board to current board
		p1.setBoard(this);
		p2.setBoard(this);
		
		// Populate the board with each set of pieces
		p1.placePieces();
		p2.placePieces();
	}
	
	// Methods
	public int getEval() {
		return this.player1.getValue() - this.player1.getValue();
	}
	public boolean checkIfCheck(Color c) {
		boolean ret = false;
		
		return ret;
	}
	
	public boolean checkIfCheckmate(Color c) {
		boolean ret = false;
		
		return ret;
	}
	
	public Square getSquare(int ir, int ic) {
		return this.squares[ir][ic];
	}
	
	public Square getSquare(String str) {
		int ic = "ABCDEFGH".indexOf(str.substring(0,1));
		int ir = 7 - "12345678".indexOf(str.substring(1,2));
		
		return this.squares[ir][ic];
	}
	
	public void displayBoard() {
		int counter = 0;
		System.out.print(" w |A-|B-|C-|D-|E-|F-|G-|H-| w");
		System.out.print("\n+--+--+--+--+--+--+--+--+--+--+\n");
		
		for(Square[] square_list: squares) {
			counter++;
			System.out.print("|");
			System.out.print(9 - counter);
			System.out.print("-|");			
			for(Square square: square_list) {
				if(square.getPiece() != null) {
					System.out.print(square.getPiece().toString() + "|");
				} else {
					System.out.print("  |");
				}
			}
			System.out.print(9 - counter);
			System.out.print("-|");
			System.out.print("\n+--+--+--+--+--+--+--+--+--+--+\n");
			
		}
		System.out.println(" b |A-|B-|C-|D-|E-|F-|G-|H-| b");
	}
}

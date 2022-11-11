package Engine;
import java.util.*;

public abstract class Player {
	protected ArrayList<Piece> pieces;
	protected Color color;
	private boolean won;
	protected Board board;
	
	public Player(Color icolor) {
		// Initialize new arraylist for pieces
		this.pieces = new ArrayList<Piece>(0);
		
		// Set color
		this.color = icolor;

		// Creates a set of new peices for the player in a specific order
		this.pieces.add(new Rook(icolor, null, this));
		this.pieces.add(new Knight(icolor, null, this));
		this.pieces.add(new Bishop(icolor, null, this));
		this.pieces.add(new Queen(icolor, null, this));
		this.pieces.add(new King(icolor, null, this));
		this.pieces.add(new Bishop(icolor, null, this));
		this.pieces.add(new Knight(icolor, null, this));
		this.pieces.add(new Rook(icolor, null, this));
		this.pieces.add(new Pawn(icolor, null, this));
		this.pieces.add(new Pawn(icolor, null, this));
		this.pieces.add(new Pawn(icolor, null, this));
		this.pieces.add(new Pawn(icolor, null, this));
		this.pieces.add(new Pawn(icolor, null, this));
		this.pieces.add(new Pawn(icolor, null, this));
		this.pieces.add(new Pawn(icolor, null, this));
		this.pieces.add(new Pawn(icolor, null, this));
	}
	
	// Populates locations for pieces on the board
	public void placePieces() {
		int row1 = -1;
		int row2 = -1;
		
		// Selects both the rows and the order in which they will be used
		if(this.color == Color.WHITE) {
			row1 = 7;
			row2 = 6;
		}
		if(this.color == Color.BLACK) {
			row1 = 0;
			row2 = 1;
		}
		
		// Deals with placing pieces on row 1
		for(int c = 0; c < 8; c++) {
			pieces.get(c).setLocation(board.getSquare(row1, c));
		}
		for(int c = 0; c < 8; c++) {
			pieces.get(c + 8).setLocation(board.getSquare(row2, c));
		}
	}
	
	// Done as a seperate method to simply implementation
	public boolean move(Piece piece, Square square) {
		return piece.move(square);
	}
	
	// Done to simplify abstraction path
	public void takeTurn() {
		// Takes a list object with both the piece and square object references
		List<Object> currentMove = this.getMove();
		
		// Gives move function proper inputs by casting to correct object types
		// Will re-ask for input if this.move == false
		while(!this.move((Piece) currentMove.get(0), (Square) currentMove.get(1))) {
			System.out.println("This piece cannot make that move. Please try again:");
			currentMove = this.getMove();
		}

	}
	
	public void setBoard(Board b) {
		this.board = b; 
	}
	
	public ArrayList<Piece> getPieces() {
		return this.pieces; 
	}
	
	public Color getColor() {
		return this.color;
	}
	
	// Returns a list of object to handle both Square and Piece object types
	abstract List<Object> getMove();
}

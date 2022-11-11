package Engine;

public class Queen extends Piece {
	// Super constructor
	public Queen(Color icolor, Square ilocation, Player iplayer) {
		super(icolor, ilocation, PieceType.QUEEN, iplayer);
	}

	@Override
	public boolean validate(Square loc) {	
		// Check to make sure the path there is clear of pieces
		if (this.pathClear(this.getLocation(), loc) == false) {
			System.out.println("Path check failed");
			return false;
		}
		
		return true;
	}
	
	public String toString() {
		if(this.color == Color.WHITE) {
			return "wQ";
		} else { 
			return "bQ";
		}
	}
}

package Engine;

// Validation Done!!


public class Rook extends Piece {
	// Super constructor
	public Rook(Color icolor, Square ilocation, Player iplayer) {
		super(icolor, ilocation, PieceType.ROOK, iplayer);
	}

	@Override
	public boolean validate(Square loc) {
		int[] cur = this.location.getLocation();
		int[] target = loc.getLocation();
		
		int rowdif = cur[0] - target[0];
		int coldif = cur[1] - target[1];
		
		// Check to see if it moved diagonally at all
		if(rowdif != 0 && coldif != 0) {
			return false;
		}
		
		// Check to make sure the path there is clear of pieces
		if (this.pathClear(this.getLocation(), loc) == false) {
			System.out.println("Path check failed");
			return false;
		}
		
		return true;
	}
	
	public String toString() {
		if(this.color == Color.WHITE) {
			return "wR";
		} else { 
			return "bR";
		}
	}
}
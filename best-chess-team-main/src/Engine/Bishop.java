package Engine;

//Validation Done!!

public class Bishop extends Piece {
	// Super constructor
	public Bishop(Color icolor, Square ilocation, Player iplayer) {
		super(icolor, ilocation, PieceType.BISHOP, iplayer);
	}

	@Override
	public boolean validate(Square loc) {
		int[] cur = this.location.getLocation();
		int[] target = loc.getLocation();
		
		int rowdif = cur[0] - target[0];
		int coldif = cur[1] - target[1];
		
		// Check to see if it did not move diagonally at all
		if(rowdif == 0 || coldif == 0) {
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
			return "wB";
		} else { 
			return "bB";
		}
	}
}
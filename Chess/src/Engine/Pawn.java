package Engine;

// Validation Done!!

public class Pawn extends Piece {
	// Protected Fields
	// DO NOT UNCOMMENT, THESE ARE JUST FOR REFERENCE
	// protected Color color;
	// protected Square location;
	// protected boolean captured;
	// protected PieceType type;

	// Fields
	private boolean isFirstMove;
	
	// Super constructor
	public Pawn(Color icolor, Square ilocation) {
		super(icolor, ilocation, PieceType.PAWN);
		isFirstMove = true;
	}
	

	@Override
	public boolean validate(Square loc) {
		int[] cur = this.location.getLocation();
		int[] target = loc.getLocation();
		
		int rowdif = cur[0] - target[0];
		int coldif = cur[1] - target[1];
		
		// Check to see if it moved vertically at all
		if(rowdif == 0) {
			return false;
		}
		
		// Check to see if it is moving in the right direction
		if((rowdif < 0 && this.color == Color.BLACK) || (rowdif > 0 && this.color == Color.WHITE)) {
			return false;
		}
		
		// Check to see if the row difference is incrementing/decrementing by 1
		if((rowdif != 1 && this.color == Color.BLACK) || (rowdif != -1 && this.color == Color.WHITE)) {
			// Check to see if its the first move
			if(isFirstMove) {
				if((rowdif != 2 && this.color == Color.BLACK) || (rowdif != -2 && this.color == Color.WHITE)) {
					return false;
				}
			} else {
				return false;
			}
		}
		
		// Check to see if horizontal difference is 1 and if there exists a piece there
		if(Math.abs(coldif) <= 1) {
			if(Math.abs(coldif) == 1 && loc.getPiece() == null) {
				return false;
			}
		} else {
			return false;
		}
		
		// Set first move to false
		this.isFirstMove = false;

		
		return true;
	}
	
	public String toString() {
		if(this.color == Color.WHITE) {
			return "wp";
		} else { 
			return "bp";
		}
	}
}


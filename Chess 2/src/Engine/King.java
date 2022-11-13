package Engine;

// Validation Done!!

public class King extends Piece {
	// Super constructor
	public King(Color icolor, Square ilocation, Player iplayer) {
		super(icolor, ilocation, PieceType.KING, iplayer);
		this.value = 0;
	}

	@Override
	public boolean validate(Square loc) {
		int[] cur = this.location.getLocation();
		int[] target = loc.getLocation();
		
		int rowdif = target[0] - cur[0];
		int coldif = target[1] - cur[1];
		
		if(Math.abs(coldif) > 1 && coldif != 0) {
			return false;
		}

		if(Math.abs(rowdif) > 1 && rowdif != 0) {
			return false;
		}

		
		return true;
	}
	
	public String toString() {
		if(this.color == Color.WHITE) {
			return "wK";
		} else { 
			return "bK";
		}
	}

}

package Engine;

public class Knight extends Piece {
	// Super constructor
	public Knight(Color icolor, Square ilocation, Player iplayer) {
		super(icolor, ilocation, PieceType.KNIGHT, iplayer);
	}
	
	@Override
	public boolean validate(Square loc) {
		int[] cur = this.location.getLocation();
		int[] target = loc.getLocation();
		
		int rowdif = target[0] - cur[0];
		int coldif = target[1] - cur[1];
		
		// Check to see if first movement would be horizontal
		if(Math.abs(rowdif) == 2) {
			if(Math.abs(coldif) == 1) {
				return true;
			}
		}

		// Check to see if first movement would be vertical
		if(Math.abs(rowdif) == 1) {
			if(Math.abs(coldif) == 2) {
				return true;
			}
		}

		return false;
	}
	
	public String toString() {
		if(this.color == Color.WHITE) {
			return "wN";
		} else { 
			return "bN";
		}
	}
}

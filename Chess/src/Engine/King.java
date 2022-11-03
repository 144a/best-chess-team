package Engine;

public class King extends Piece {
	// Super constructor
	public King(Color icolor, Square ilocation) {
		super(icolor, ilocation, PieceType.KING);
	}
	@Override
	public boolean move(Square loc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validate(Square loc) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String toString() {
		if(this.color == Color.WHITE) {
			return "wK";
		} else { 
			return "bK";
		}
	}

}

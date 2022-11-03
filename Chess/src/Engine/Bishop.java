package Engine;

public class Bishop extends Piece {
	// Super constructor
	public Bishop(Color icolor, Square ilocation) {
		super(icolor, ilocation, PieceType.BISHOP);
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
			return "wb";
		} else { 
			return "bb";
		}
	}
}
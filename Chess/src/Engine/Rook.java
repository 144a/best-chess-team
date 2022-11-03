package Engine;

public class Rook extends Piece {
	// Super constructor
	public Rook(Color icolor, Square ilocation) {
		super(icolor, ilocation, PieceType.ROOK);
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
			return "wr";
		} else { 
			return "br";
		}
	}
}
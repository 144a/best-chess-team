package Engine;

public class Knight extends Piece {
	// Super constructor
	public Knight(Color icolor, Square ilocation) {
		super(icolor, ilocation, PieceType.KNIGHT);
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
			return "wk";
		} else { 
			return "bk";
		}
	}
}

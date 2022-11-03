package Engine;

public class Queen extends Piece {
	// Super constructor
	public Queen(Color icolor, Square ilocation) {
		super(icolor, ilocation, PieceType.QUEEN);
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
			return "wQ";
		} else { 
			return "bQ";
		}
	}
}

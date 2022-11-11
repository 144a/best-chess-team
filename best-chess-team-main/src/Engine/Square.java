package Engine;
//square: char Letter, int Number, enum Color, Piece occupies
public class Square {
	// Fields
	private int r;
	private int c;
	private Piece piece;
	
	// Constructor
	public Square(int ir, int ic, Piece ipiece) {
		this.r = ir;
		this.c = ic;
		this.piece = ipiece;
	}
	
	// Methods
	public int[] getLocation() {
		int[] ret = {r, c};
		return ret;
	}
	
	public String getPrettyLocation() {
		String ret = "";
		
		// Calculate correct row and column labels
		ret += "ABCDEFGH".substring(c, c + 1);
		ret += "87654321".substring(r, r + 1);			
		return ret;
	}
	
	public Piece getPiece() {
		return piece;
	}
	
	public void setPiece(Piece p) {
		this.piece = p;
	}
}

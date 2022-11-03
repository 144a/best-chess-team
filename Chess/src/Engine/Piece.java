package Engine;
// piece attributes:, enum Type; methods: move(), capture(Piece captured)
public abstract class Piece {
	// Fields
	protected Color color;
	protected Square location;
	protected boolean captured;
	protected PieceType type;

	// Parent constructor
	public Piece(Color icolor, Square ilocation, PieceType itype) {
		this.color = icolor;
		this.location = ilocation;
		this.captured = false;
		this.type = itype;
	}
	
	// Abstract Methods
	public abstract boolean validate(Square loc);
	@Override
	public abstract String toString();
	
	// Methods
	public PieceType getPeiceType() {
		return this.type;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public Square getLocation() {
		return this.location;
	}
	
	public void setCaptured() {
		this.captured = true;
	}
	
	public boolean move(Square loc) {
		// Validate Move before changing anything
		if(this.validate(loc) == false) {
			return false;
		}
				
		// Check to see if there is a piece
		// If so, set piece to captured
		if(loc.getPiece() != null) {
			loc.getPiece().setCaptured();
		}
		
		// Set Current location to null
		this.location.setPiece(null);
		
		// Move to new Location
		this.location = loc;
		loc.setPiece(this);
		return true;
	}
	
	public boolean setLocation(Square loc) {
		boolean ret = false;
		// Check to see if position is open
		if(loc.getPiece() == null) {
			this.location = loc;
			loc.setPiece(this);
			return true;
		}
		return ret;
	}
}

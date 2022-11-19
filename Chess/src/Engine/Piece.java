package Engine;
// piece attributes:, enum Type; methods: move(), capture(Piece captured)
public abstract class Piece {
	// Fields
	protected Color color;
	protected Square location;
	protected boolean captured;
	protected PieceType type;
	protected Player player;

	// Parent constructor
	public Piece(Color icolor, Square ilocation, PieceType itype, Player iplayer) {
		this.color = icolor;
		this.location = ilocation;
		this.captured = false;
		this.type = itype;
		this.player = iplayer;
	}
	
	// Abstract Methods
	public abstract boolean validate(Square loc);
	@Override
	public abstract String toString();
	
	// Methods
	public PieceType getPieceType() {
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
	
	public boolean pathClear(Square loc1, Square loc2) {
		int[] cur = loc1.getLocation();
		int[] target = loc2.getLocation();
		
		int rowdif = target[0] - cur[0];
		int coldif = target[1] - cur[1];
		
		// Counter Increments
		int rinc = 0;
		int cinc = 0;
		
		// Check to see if pieces are on intersecting paths
		if(!(rowdif == 0 || coldif == 0 || Math.abs(rowdif) == Math.abs(coldif))) {
			return false;
		}
		
		// Check for increments and add one with proper direction if needed
		if(rowdif != 0) {
			rinc = (int) (1 * Math.signum(rowdif));
		}
		if(coldif != 0) {
			cinc = (int) (1 * Math.signum(coldif));
		}
	
		// Start with initial increment
		cur[0] += rinc;
		cur[1] += cinc;
		
		// Loop through piece path while waiting for matching location
		// Check every location to ensure there is no piece
		// Change in future to more efficiently 
		try {
			while(!(cur[0] == target[0] && cur[1] == target[1])) {
				// System.out.println(rinc);
				
				if(this.player.board.getSquare(cur[0], cur[1]).getPiece() != null) {
					return false;
				}
				cur[0] += rinc;
				cur[1] += cinc;
		
			}
		} catch(Exception e) {
			return false;
		}
		return true;
	}
	@Override
	public boolean equals(Object o) {
		if(o == this) {
			return true;
		}
		if (!(o instanceof Piece)) {
            return false;
        }
		Piece other = (Piece) o;
		if(!other.getColor().equals(this.color)) {
			return false;
		}
		if(!other.getPieceType().equals(this.type)) {
			return false;
		}
		Square otherLoc = other.getLocation();
		if(otherLoc.getLocation()[0] != this.getLocation().getLocation()[0] && otherLoc.getLocation()[1] != this.getLocation().getLocation()[1] ) {
			return false;
		}
		if(other.isCaptured() != this.captured) {
			return false;
		}
		return true;
		
	}

	public boolean isCaptured() {
		return captured;
	}

	public PieceType getType() {
		return type;
	}

	public Player getPlayer() {
		return player;
	}
}

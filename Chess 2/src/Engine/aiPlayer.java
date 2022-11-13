package Engine;

import java.util.List;

public class aiPlayer extends Player {
	private int depth;
	
	public aiPlayer(Color icolor) {
		super(icolor);
	}
	public int getDepth(){
		return this.depth;
	}
	@Override
	Move getMove() {
		
		return null;
	}

}

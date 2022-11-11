package Engine;

import java.util.*;
import java.util.List;
import java.util.Scanner;

public class humanPlayer extends Player {

	public humanPlayer(Color icolor) {
		super(icolor);
	}

	@Override
	List<Object> getMove() {
		// Create a scanner object for reading user input
		Scanner playerinp = new Scanner(System.in);
		
		Square pieceloc = null;
		Square targetloc = null;
		boolean isPiece = false;
		boolean isTarget = false;
		while(!isPiece) {
			System.out.println("Choose Piece to move: ");
			String userin = playerinp.nextLine();
			
			// Check for an input of greater than length 2
			if(userin.length() > 2) {
				System.out.println("Input was greater than 2 characters.");
			}
			
			// Check for an input with no number
			// Check for an input with no letter
			
			try {
				pieceloc = this.board.getSquare(userin);
				isPiece = true;
				
			} catch(Exception e) {
				System.out.println("Input requires 1B letter and 1 number.");
			}
			
			// Check to see if color is matching
			if(pieceloc.getPiece() == null) {
				isPiece = false;
				System.out.println("Input requires a square with a piece on it.");
			} else {
				if(pieceloc.getPiece().getColor() != this.color) {
					isPiece = false;
					System.out.println("Input is of a opponent's piece.");
				} else {
					isPiece = true;
				}
			}
		}
		
		while(!isTarget) {
			System.out.println("Choose location to place piece: ");
			String userin = playerinp.nextLine();
			
			// Check for an input of greater than length 2
			if(userin.length() > 2) {
				System.out.println(userin);
				System.out.println("Input was greater than 2 characters.");
			}
			
			// Check for an input with no number
			// Check for an input with no letter
			try {
				targetloc = this.board.getSquare(userin);
				// Check to make sure that there is no piece of the same color
				if(targetloc.getPiece() != null && this.color == targetloc.getPiece().getColor())  {
					System.out.println("Input already has a piece there.");
				} else {
					isTarget = true;
				}
			} catch(Exception e) {
				System.out.println("Input was greater than 2 characters.");
			}
		}
		
		// Build list of objects
		List<Object> ret = new ArrayList<Object>();
		ret.add(pieceloc.getPiece());
		ret.add(targetloc);
		
		
	    // Read user input
		return ret;
	}

}

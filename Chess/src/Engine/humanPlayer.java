

package Engine;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;
import java.util.Scanner;


public class humanPlayer extends Player  {

	String[] xy ;Square Temppieceloc = null; Square Temptargetloc = null;

	public humanPlayer(Color icolor)
    {
		super(icolor);
	}
	String x;
	Scanner playerinp = new Scanner(System.in);
	//Panel_manager pm = new Panel_manager();
	public  Piece  smo(String C)
	{

		Temppieceloc = this.board.getSquare(C);

		return Temppieceloc.getPiece();
	}

	public  Square smo2(String C)
	{
		return Temptargetloc = this.board.getSquare(C);
	}
	//String enter = playerinp.nextLine();
	@Override
	List<Object> getMove() {
		// Create a scanner object for reading user input

		Square pieceloc = null;

		Square targetloc = null;
		boolean isPiece = false;
		boolean isTarget = false;





		while(!isPiece)
		{
			System.out.println("new " + Arrays.toString(xy));

			System.out.println("Choose Piece to move: ");
			GU2 g2 = new GU2();



			String userin = playerinp.nextLine();;
			//String userin = enter;

			// Check for an input of greater than length 2
			if (userin == null)
			{
				System.out.println("Input was greater than 2 characters.");
			}
			if(userin.length() > 2)
			{
				System.out.println("Input was greater than 2 characters.");
			}
			
			// Check for an input with no number
			// Check for an input with no letter
			
			try {
				if (userin != null) {
					pieceloc = this.board.getSquare(userin);

				}
				isPiece = true;
				
			} catch(Exception e) {
				System.out.println("Input requires 1B letter and 1 number.");
			}
			
			// Check to see if color is matching
			if(pieceloc.getPiece() == null)
			{
				isPiece = false;
				System.out.println("Input requires a square with a piece on it.");
			}
			else {
				if(pieceloc.getPiece().getColor() != this.color) {
					isPiece = false;
					System.out.println("Input is of a opponent's piece.");
				}
				else
				{
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
		//Panel_manager pm = new Panel_manager();
		//pm.xy;
	//	System.out.println("frpm hm "+ Arrays.toString(pm.xy));
		List<Object> ret = new ArrayList<Object>();
		//if (pm.xy[0] == null && pm.xy[1]==null)
		{
		//	System.out.println("PLEASE SELECT NEW BOX");
		}
		//else
		{
			//ret.add((pm.xy[0]));
		}


		ret.add(pieceloc.getPiece());
		ret.add(targetloc);
		
		
	    // Read user input
		return ret;
	}

}

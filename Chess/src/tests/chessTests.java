package tests;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.math.BigDecimal;

import org.junit.Test;

import Engine.Board;
import Engine.Color;
import Engine.Pawn;
import Engine.Piece;
import Engine.Rook;
import Engine.Square;
import Engine.aiPlayer;
import Engine.humanPlayer;



public class chessTests {

	//Player Tests
	
	@Test
	public void testPlayerColor()
	{
		humanPlayer hp = new humanPlayer(Color.WHITE);
		assertEquals(hp.getColor(), Color.WHITE);
		assertNotEquals(hp.getColor(), Color.BLACK);
		aiPlayer ap = new aiPlayer(Color.BLACK);
		assertEquals(ap.getColor(), Color.BLACK);
		assertNotEquals(ap.getColor(), Color.WHITE);
	}
	
	@Test
	public void testPlayerMovesColor()
	{
		humanPlayer hp = new humanPlayer(Color.WHITE);
		humanPlayer hp2 = new humanPlayer(Color.BLACK);
		Board board = new Board(hp, hp2);
		
	}
	//Piece Tests
	
	//Pawn
	@Test
	public void testPawnValidation()
	{
		humanPlayer hp = new humanPlayer(Color.WHITE);
		humanPlayer hp2 = new humanPlayer(Color.BLACK);
		Board board = new Board(hp, hp2);
		Pawn pawn = (Pawn) hp.getPieces().get(15);
		Square current = pawn.getLocation();
		assertEquals(pawn.isFirstMove(), true);
		Square temp = board.getSquare(current.getLocation()[0],current.getLocation()[1] - 2 );
		assertEquals(pawn.validate(temp), false);
		temp = board.getSquare(current.getLocation()[0]  - 2,current.getLocation()[1]);
		assertEquals(pawn.validate(temp), true);
		temp = board.getSquare(current.getLocation()[0] - 2,current.getLocation()[1] );
		assertEquals(pawn.validate(temp), false);
		assertEquals(pawn.isFirstMove(), false);
		temp = board.getSquare(current.getLocation()[0] - 1,current.getLocation()[1] );
		assertEquals(pawn.validate(temp), true);
		temp = board.getSquare(current.getLocation()[0],current.getLocation()[1] - 1 );
		assertEquals(pawn.validate(temp), false);
		temp = board.getSquare(current.getLocation()[0] + 1,current.getLocation()[1] );
		assertEquals(pawn.validate(temp), false);
		temp = board.getSquare(current.getLocation()[0] - 1,current.getLocation()[1] -1 );
		assertEquals(pawn.validate(temp), false);
		
		
	}
	
	@Test
	public void testPawnCapturing() {
		
		humanPlayer hp = new humanPlayer(Color.WHITE);
		humanPlayer hp2 = new humanPlayer(Color.BLACK);
		Board board = new Board(hp, hp2);
		Pawn pawn = (Pawn) hp.getPieces().get(13);
		Pawn opPawn = (Pawn) hp2.getPieces().get(13);
		Square current = pawn.getLocation();
		Square temp = board.getSquare(current.getLocation()[0] -1, current.getLocation()[1]);
		temp.setPiece(opPawn);
		//assertEquals(false, pawn.pathClear(current, temp));
		temp = board.getSquare(current.getLocation()[0] -1, current.getLocation()[1] -1);
		temp.setPiece(opPawn);
		assertEquals(true, pawn.pathClear(current, temp));
	}
	
	//Rook
	
	@Test
	public void testRookValidation()
	{
		humanPlayer hp = new humanPlayer(Color.WHITE);
		humanPlayer hp2 = new humanPlayer(Color.BLACK);
		Board board = new Board(hp, hp2);
		Rook rook = (Rook) hp.getPieces().get(0);
		Square current = rook.getLocation();
		Square temp = board.getSquare(current.getLocation()[0] - 1,current.getLocation()[1] + 1 );
		assertEquals(false, rook.validate(temp));
		temp = board.getSquare(current.getLocation()[0] - 1,current.getLocation()[1] );
		temp.setPiece(null);
		assertEquals(true, rook.validate(temp));
		temp = board.getSquare(current.getLocation()[0] - 5,current.getLocation()[1] );
		assertEquals(true, rook.validate(temp));
		temp = board.getSquare(current.getLocation()[0],current.getLocation()[1] +1 );
		temp.setPiece(null);
		assertEquals(true, rook.validate(temp));
	}
	
	@Test
	public void testRookCapturing() {
		humanPlayer hp = new humanPlayer(Color.WHITE);
		humanPlayer hp2 = new humanPlayer(Color.BLACK);
		Board board = new Board(hp, hp2);
		Rook rook = (Rook) hp.getPieces().get(0);
		Pawn opPawn = (Pawn) hp2.getPieces().get(13);
		Square current = rook.getLocation();
		Square temp = board.getSquare(current.getLocation()[0] - 1,current.getLocation()[1] );
		temp.setPiece(opPawn);
		assertEquals(true, rook.validate(temp));

	}

}

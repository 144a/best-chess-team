package tests;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.math.BigDecimal;

import org.junit.Test;

import Engine.Bishop;
import Engine.Board;
import Engine.Color;
import Engine.King;
import Engine.Knight;
import Engine.Pawn;
import Engine.Piece;
import Engine.PieceType;
import Engine.Queen;
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
		rook.setLocation(temp);
		assertEquals(temp, rook.getLocation());
		assertEquals(true, rook.validate(temp));
		temp = board.getSquare(current.getLocation()[0] - 5,current.getLocation()[1] );
		assertEquals(true, rook.validate(temp));
		temp = board.getSquare(current.getLocation()[0],current.getLocation()[1] +1 );
		temp.setPiece(null);
		rook.setLocation(temp);
		assertEquals(true, rook.validate(temp));
		assertEquals(temp, rook.getLocation());
		
		
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
	
	//Queen
	@Test
	public void testQueenValidation()
	{
		humanPlayer hp = new humanPlayer(Color.WHITE);
		humanPlayer hp2 = new humanPlayer(Color.BLACK);
		Board board = new Board(hp, hp2);
		Queen queen = (Queen) hp.getPieces().get(3);
		Square current = queen.getLocation();
		Square temp = board.getSquare(current.getLocation()[0] - 1,current.getLocation()[1] + 1 );
		temp.setPiece(null);
		assertEquals(true, queen.validate(temp));
		queen.setLocation(temp);
		assertEquals(temp, queen.getLocation());
		temp = board.getSquare(current.getLocation()[0] - 1,current.getLocation()[1] );
		temp.setPiece(null);
		assertEquals(true, queen.validate(temp));
		queen.setLocation(temp);
		assertEquals(temp, queen.getLocation());
		temp = board.getSquare(current.getLocation()[0] - 3,current.getLocation()[1] );
		assertEquals(true, queen.validate(temp));
		temp = board.getSquare(current.getLocation()[0],current.getLocation()[1] +1 );
		temp.setPiece(null);
		assertEquals(true, queen.validate(temp));
	}
	
	@Test
	public void testQueenCapturing() {
		humanPlayer hp = new humanPlayer(Color.WHITE);
		humanPlayer hp2 = new humanPlayer(Color.BLACK);
		Board board = new Board(hp, hp2);
		Queen queen = (Queen) hp.getPieces().get(3);
		Pawn opPawn = (Pawn) hp2.getPieces().get(13);
		Square current = queen.getLocation();
		Square temp = board.getSquare(current.getLocation()[0] - 1,current.getLocation()[1]);
		temp.setPiece(opPawn);
		opPawn.setLocation(temp);
		assertEquals(true, queen.validate(temp));
		temp.setPiece(null);
		temp = board.getSquare(current.getLocation()[0],current.getLocation()[1] - 1);
		temp.setPiece(opPawn);
		opPawn.setLocation(temp);
		assertEquals(true, queen.validate(temp));
		temp.setPiece(null);
		temp = board.getSquare(current.getLocation()[0] - 1,current.getLocation()[1] - 1);
		temp.setPiece(opPawn);
		opPawn.setLocation(temp);
		assertEquals(true, queen.validate(temp));
	}
	
	//Knight
	@Test
	public void testKnightValidation()
	{
		humanPlayer hp = new humanPlayer(Color.WHITE);
		humanPlayer hp2 = new humanPlayer(Color.BLACK);
		Board board = new Board(hp, hp2);
		Knight knight = (Knight) hp.getPieces().get(1);
		Square current = knight.getLocation();
		Square temp = board.getSquare(current.getLocation()[0] - 2,current.getLocation()[1] -1 );
		temp.setPiece(null);
		assertEquals(true, knight.validate(temp));
		knight.setLocation(temp);
		assertEquals(temp, knight.getLocation());
	
	}
	
	@Test
	public void testKnightCapturing() {
		humanPlayer hp = new humanPlayer(Color.WHITE);
		humanPlayer hp2 = new humanPlayer(Color.BLACK);
		Board board = new Board(hp, hp2);
		Knight knight = (Knight) hp.getPieces().get(1);
		Pawn opPawn = (Pawn) hp2.getPieces().get(13);
		Square current = knight.getLocation();
		Square temp = board.getSquare(current.getLocation()[0] - 2,current.getLocation()[1] -1 );
		temp.setPiece(opPawn);
		opPawn.setLocation(temp);
		assertEquals(true, knight.validate(temp));
	}
	
	//Bishop
	@Test
	public void testBishopValidation()
	{
		humanPlayer hp = new humanPlayer(Color.WHITE);
		humanPlayer hp2 = new humanPlayer(Color.BLACK);
		Board board = new Board(hp, hp2);
		Bishop bishop = (Bishop) hp.getPieces().get(2);
		Square current = bishop.getLocation();
		Square temp = board.getSquare(current.getLocation()[0] - 1,current.getLocation()[1] + 1 );
		temp.setPiece(null);
		assertEquals(true, bishop.validate(temp));
		bishop.setLocation(temp);
		assertEquals(temp, bishop.getLocation());
		temp.setPiece(bishop);
		current = bishop.getLocation();
		temp = board.getSquare(current.getLocation()[0] + 1,current.getLocation()[1] - 1 );
		temp.setPiece(null);
		assertEquals(true, bishop.validate(temp));
		current = bishop.getLocation();
		temp = board.getSquare(current.getLocation()[0],current.getLocation()[1] - 1 );
		temp.setPiece(null);
		assertEquals(false, bishop.validate(temp));
		temp = board.getSquare(current.getLocation()[0] - 1,current.getLocation()[1] );
		temp.setPiece(null);
		assertEquals(false, bishop.validate(temp));
	
	}
	
	@Test
	public void testBishopCapturing() {
		humanPlayer hp = new humanPlayer(Color.WHITE);
		humanPlayer hp2 = new humanPlayer(Color.BLACK);
		Board board = new Board(hp, hp2);
		Bishop bishop = (Bishop) hp.getPieces().get(2);
		Pawn opPawn = (Pawn) hp2.getPieces().get(13);
		Square current = bishop.getLocation();
		Square temp = board.getSquare(current.getLocation()[0] - 1,current.getLocation()[1] -1);
		temp.setPiece(opPawn);
		opPawn.setLocation(temp);
		assertEquals(true, bishop.validate(temp));
	}
	
	//King
	@Test
	public void testKingValidation()
	{
		humanPlayer hp = new humanPlayer(Color.WHITE);
		humanPlayer hp2 = new humanPlayer(Color.BLACK);
		Board board = new Board(hp, hp2);
		King king = (King) hp.getPieces().get(4);
		Square current = king.getLocation();
		Square temp = board.getSquare(current.getLocation()[0] - 1,current.getLocation()[1] + 1 );
		temp.setPiece(null);
		assertEquals(true, king.validate(temp));
		king.setLocation(temp);
		assertEquals(temp, king.getLocation());
		temp.setPiece(king);
		current = king.getLocation();
		temp = board.getSquare(current.getLocation()[0] - 1,current.getLocation()[1]);
		temp.setPiece(null);
		assertEquals(true, king.validate(temp));
		king.setLocation(temp);
		assertEquals(temp, king.getLocation());
		temp.setPiece(king);
		current = king.getLocation();
		temp = board.getSquare(current.getLocation()[0],current.getLocation()[1] - 1);
		temp.setPiece(null);
		assertEquals(true, king.validate(temp));
		king.setLocation(temp);
		assertEquals(temp, king.getLocation());
		temp.setPiece(king);
		current = king.getLocation();
		temp = board.getSquare(current.getLocation()[0],current.getLocation()[1] - 2);
		temp.setPiece(null);
		assertEquals(false, king.validate(temp));
		assertEquals(current, king.getLocation());
	}
	
	@Test
	public void testKingCapturing() {
		humanPlayer hp = new humanPlayer(Color.WHITE);
		humanPlayer hp2 = new humanPlayer(Color.BLACK);
		Board board = new Board(hp, hp2);
		King king = (King) hp.getPieces().get(4);
		Pawn opPawn = (Pawn) hp2.getPieces().get(13);
		Square current = king.getLocation();
		Square temp = board.getSquare(current.getLocation()[0],current.getLocation()[1] -1);
		temp.setPiece(opPawn);
		opPawn.setLocation(temp);
		assertEquals(true, king.validate(temp));
	}
	
	//Square Tests
	@Test
	public void squareSetUp() {
		humanPlayer hp = new humanPlayer(Color.WHITE);
		humanPlayer hp2 = new humanPlayer(Color.BLACK);
		Board board = new Board(hp, hp2);
		Square s = board.getSquare(6, 1);
		assertEquals(PieceType.PAWN, s.getPiece().getPieceType());
		for(int i = 0; i < 8; i++) {
			assertEquals(Color.WHITE, board.getSquare(7, i).getPiece().getColor());
			assertEquals(Color.WHITE, board.getSquare(6, i).getPiece().getColor());
		}
	}
	
	@Test
	public void squareNull() {
		humanPlayer hp = new humanPlayer(Color.WHITE);
		humanPlayer hp2 = new humanPlayer(Color.BLACK);
		Board board = new Board(hp, hp2);
		Pawn opPawn = (Pawn) hp2.getPieces().get(13);
		Square s = opPawn.getLocation();
		assertEquals(PieceType.PAWN, s.getPiece().getPieceType());
		Square move = board.getSquare(s.getLocation()[0] - 1, s.getLocation()[1]);
		opPawn.setLocation(move);
		move.setPiece(opPawn);
		s.setPiece(null);
		assertEquals(null, s.getPiece());
	}
	
}

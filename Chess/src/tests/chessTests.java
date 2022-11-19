package tests;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.math.BigDecimal;

import org.junit.Test;

import Engine.Color;
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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}

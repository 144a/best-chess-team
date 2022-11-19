package Engine;

import java.util.ArrayList;

public class Board {
	// Fields
	private Square[][] squares;
	private Player player1;
	private Player player2;
	
	
	// Constructor
	public Board(Player p1, Player p2) {
		this.player1 = p1;
		this.player2 = p2;
		this.squares = new Square[8][8];
		
		// Populate 2d array with Empty Square Objects		
		for(int r = 0; r < this.squares[0].length; r++) {
			for(int c = 0; c < this.squares.length; c++) {
				this.squares[r][c] = new Square(r, c, null);
			}			
		}
		
		// Set player board to current board
		p1.setBoard(this);
		p2.setBoard(this);
		
		// Populate the board with each set of pieces
		p1.placePieces();
		p2.placePieces();
	}
	
	// Methods
	public boolean checkIfCheck(Color c) {
		ArrayList<Piece> p2Pieces = player2.getPieces();
		ArrayList<Piece> p1Pieces = player1.getPieces();
		if(c.equals(Color.WHITE)) {
			Piece king = p1Pieces.get(4);
			for(Piece p : p2Pieces) {
				if(p.validate(king.getLocation())) {
					return true;
				}
			}
		}
		if(c.equals(Color.BLACK)) {
			Piece king = p2Pieces.get(4);
			for(Piece p : p1Pieces) {
				if(p.validate(king.getLocation())) {
					return true;
				}
			}
		}
		return false;
	}
	
	 public boolean checkIfCheckmateKing(Color c) {
		ArrayList<Piece> otherPieces = new ArrayList<>();
		ArrayList<Piece> thisPieces = new ArrayList<>();
		if(c.equals(Color.WHITE)) {
			otherPieces = player2.getPieces();
			 thisPieces = player1.getPieces();
		}
		else {
			 thisPieces = player2.getPieces();
			 otherPieces = player1.getPieces();
		}
			Piece king = thisPieces.get(4);
			Square loc = king.getLocation();
			ArrayList<Square> potentialMoves = new ArrayList<>();
			//1. row, col-1
			if(loc.getLocation()[1] - 1 >= 0) {
				Square temp = this.getSquare(loc.getLocation()[0], loc.getLocation()[1] - 1);
				if(king.validate(temp)) {
					if(temp.getPiece() == null) {
					potentialMoves.add(temp);
					}
					else if (!temp.getPiece().getColor().equals(c)) {
						potentialMoves.add(temp);
					}
				}
			}
			//2. row, col + 1
			if(loc.getLocation()[1] + 1 < 8) {
				Square temp = this.getSquare(loc.getLocation()[0], loc.getLocation()[1] + 1);
				if(king.validate(temp)) {
					if(temp.getPiece() == null) {
					potentialMoves.add(temp);
					}
					else if (!temp.getPiece().getColor().equals(c)) {
						potentialMoves.add(temp);
					}
				}
			
			}
			//3. row - 1, col
			if(loc.getLocation()[0] - 1 >= 0) {
				Square temp = this.getSquare(loc.getLocation()[0] - 1, loc.getLocation()[1]);
				if(king.validate(temp)) {
					if(temp.getPiece() == null) {
					potentialMoves.add(temp);
					}
					else if (!temp.getPiece().getColor().equals(c)) {
						potentialMoves.add(temp);
					}
				}
			
			}
			//4. row + 1, col
			if(loc.getLocation()[0] + 1 < 8) {
				Square temp = this.getSquare(loc.getLocation()[0] + 1, loc.getLocation()[1]);
				if(king.validate(temp)) {
					if(temp.getPiece() == null) {
					potentialMoves.add(temp);
					}
					else if (!temp.getPiece().getColor().equals(c)) {
						potentialMoves.add(temp);
					}
				}
			
			}
			//5. row -1, col -1
			if(loc.getLocation()[0] - 1 >= 0 && loc.getLocation()[1] - 1 >= 0) {
				Square temp = this.getSquare(loc.getLocation()[0] - 1, loc.getLocation()[1] - 1);
				if(king.validate(temp)) {
					if(temp.getPiece() == null) {
					potentialMoves.add(temp);
					}
					else if (!temp.getPiece().getColor().equals(c)) {
						potentialMoves.add(temp);
					}
				}
			
			}
			//6. row -1, col + 1
			if(loc.getLocation()[0] - 1 >= 0 && loc.getLocation()[1] + 1 < 8) {
				Square temp = this.getSquare(loc.getLocation()[0] - 1, loc.getLocation()[1] + 1);
				if(king.validate(temp)) {
					if(temp.getPiece() == null) {
					potentialMoves.add(temp);
					}
					else if (!temp.getPiece().getColor().equals(c)) {
						potentialMoves.add(temp);
					}
				}
			
			}
			//7. row + 1, col - 1
			if(loc.getLocation()[0] + 1 < 8 && loc.getLocation()[1] -1 >= 0) {
				Square temp = this.getSquare(loc.getLocation()[0] + 1, loc.getLocation()[1] - 1);
				if(king.validate(temp)) {
					if(temp.getPiece() == null) {
					potentialMoves.add(temp);
					}
					else if (!temp.getPiece().getColor().equals(c)) {
						potentialMoves.add(temp);
					}
				}
			
			}
			//8. row + 1, col + 1
			if(loc.getLocation()[0] + 1 < 8 && loc.getLocation()[1] + 1 < 8) {
				Square temp = this.getSquare(loc.getLocation()[0] + 1, loc.getLocation()[1] + 1);
				if(king.validate(temp)) {
					if(temp.getPiece() == null) {
					potentialMoves.add(temp);
					}
					else if (!temp.getPiece().getColor().equals(c)) {
						potentialMoves.add(temp);
					}
				}
			
			}
			//check if potential moves are in check
			int count = 0;
			for(Square s : potentialMoves) {
				for(Piece p : otherPieces ) {
					if(p.validate(s)) {
						count++;
						break;
					}
				}
			}
			if (count >= potentialMoves.size()) {
				return true;
			}
			
			
			
		
		return false;
	}
	
	public boolean checkIfCheckmate(Color c) {
		
		ArrayList<Piece> otherPieces = new ArrayList<>();
		ArrayList<Piece> thisPieces = new ArrayList<>();
		boolean check = true;
		if(c.equals(Color.WHITE)) {
			otherPieces = player2.getPieces();
			 thisPieces = player1.getPieces();
		}
		else {
			 thisPieces = player2.getPieces();
			 otherPieces = player1.getPieces();
		}
		for(Piece p : thisPieces) {
			for(int i = 0; i < 8; i++) {
				if(p.getType() != PieceType.KING) {
					for(Square s : this.squares[i]) {
						if(p.validate(s)) {
							if(s.getPiece() == null) {
								Square curr = p.getLocation();
								curr.setPiece(null);
								s.setPiece(p);
								p.setLocation(s);
								check = checkIfCheck(c);
								curr.setPiece(p);
								s.setPiece(null);
								p.setLocation(curr);
								if(check == false) {
									return check;
								}
							}
							else if(s.getPiece().getColor() != c) {
								Square curr = p.getLocation();
								curr.setPiece(null);
								Piece capture = s.getPiece();
								s.setPiece(p);
								p.setLocation(s);
								capture.setLocation(null);
								check = checkIfCheck(c);
								curr.setPiece(p);
								s.setPiece(capture);
								capture.setLocation(s);
								p.setLocation(curr);
								if(check == false) {
									return check;
									}
							}
						}
					}
				}
				else {
					check = checkIfCheckmateKing(c);
					if(check == false) {
						return check;
					}
				}
			}
		}
		return true;
		
	}
	public Square getSquare(int ir, int ic) {
		return this.squares[ir][ic];
	}
	
	public Square getSquare(String str) {
		int ic = "ABCDEFGH".indexOf(str.substring(0,1));
		int ir = 7 - "12345678".indexOf(str.substring(1,2));
		
		return this.squares[ir][ic];
	}
	
	public void displayBoard() {
		int counter = 0;
		System.out.print(" w |A-|B-|C-|D-|E-|F-|G-|H-| w");
		System.out.print("\n+--+--+--+--+--+--+--+--+--+--+\n");
		
		for(Square[] square_list: squares) {
			counter++;
			System.out.print("|");
			System.out.print(9 - counter);
			System.out.print("-|");			
			for(Square square: square_list) {
				if(square.getPiece() != null) {
					System.out.print(square.getPiece().toString() + "|");
				} else {
					System.out.print("  |");
				}
			}
			System.out.print(9 - counter);
			System.out.print("-|");
			System.out.print("\n+--+--+--+--+--+--+--+--+--+--+\n");
			
		}
		System.out.println(" b |A-|B-|C-|D-|E-|F-|G-|H-| b");
	}
}

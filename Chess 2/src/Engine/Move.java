package Engine;

public class Move {
    private Piece piece;
    private Square start;
    private Square end;
    public Move(Piece piece, Square start, Square end){
        this.piece = piece; this.start = start; this.end = end;
    }
    public Move(Piece piece, Square end){
        this.piece = piece; this.end = end;
    }
    public Piece getPiece(){
        return piece;
    }
    public Square getStart(){
        return start;
    }
    public Square getEnd(){
        return end;
    }
    
}

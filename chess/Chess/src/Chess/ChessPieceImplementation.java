package Chess;

public class ChessPieceImplementation implements ChessPiece{

    protected Color color;
    protected Type type;
    protected boolean moved;

    ChessPieceImplementation(Color color, Type type) {
        this.color = color;
        this.type = type;
    }
    
    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void notifyMoved() {
        moved = true;
    }

    @Override
    public boolean wasMoved() {
        return moved;
    }

    @Override
    public PiecePosition[] getAvailablePositions(ChessBoard aBoard) {        
        if(getType() == type.BISHOP)
            return ChessMovementManager.getAvailablePositionsOfBishop(this, aBoard);
        else if(getType() == type.KING)
            return ChessMovementManager.getAvailablePositionsOfKing(this, aBoard);
        else if(getType() == type.KNIGHT)
            return ChessMovementManager.getAvailablePositionsOfKnight(this, aBoard);
        else if(getType() == type.PAWN)
            return ChessMovementManager.getAvailablePositionsOfPawn(this, aBoard);
        else if(getType() == type.QUEEN)
            return ChessMovementManager.getAvailablePositionsOfQueen(this, aBoard);
        else
            return ChessMovementManager.getAvailablePositionsOfRook(this, aBoard);
        
    }
}

package Chess;

import java.io.File;

public class ChessBoardImplementation implements ChessBoard {

	ChessPiece	pieces[] = new ChessPiece[8 * 8];
	
	public ChessBoardImplementation() {
		for (int i = 0; i < 8; i++) {
			pieces[getPieceIndex(i, 1)] = new ChessPieceImplementation(ChessPiece.Color.WHITE, ChessPiece.Type.PAWN);
			pieces[getPieceIndex(i, 6)] = new ChessPieceImplementation(ChessPiece.Color.BLACK, ChessPiece.Type.PAWN);
		}
		pieces[getPieceIndex(0, 0)] = new ChessPieceImplementation(ChessPiece.Color.WHITE, ChessPiece.Type.ROOK);
		pieces[getPieceIndex(7, 0)] = new ChessPieceImplementation(ChessPiece.Color.WHITE, ChessPiece.Type.ROOK);
		pieces[getPieceIndex(0, 7)] = new ChessPieceImplementation(ChessPiece.Color.BLACK, ChessPiece.Type.ROOK);
		pieces[getPieceIndex(7, 7)] = new ChessPieceImplementation(ChessPiece.Color.BLACK, ChessPiece.Type.ROOK);

		pieces[getPieceIndex(1, 0)] = new ChessPieceImplementation(ChessPiece.Color.WHITE, ChessPiece.Type.KNIGHT);
		pieces[getPieceIndex(6, 0)] = new ChessPieceImplementation(ChessPiece.Color.WHITE, ChessPiece.Type.KNIGHT);
		pieces[getPieceIndex(1, 7)] = new ChessPieceImplementation(ChessPiece.Color.BLACK, ChessPiece.Type.KNIGHT);
		pieces[getPieceIndex(6, 7)] = new ChessPieceImplementation(ChessPiece.Color.BLACK, ChessPiece.Type.KNIGHT);

		pieces[getPieceIndex(2, 0)] = new ChessPieceImplementation(ChessPiece.Color.WHITE, ChessPiece.Type.BISHOP);
		pieces[getPieceIndex(5, 0)] = new ChessPieceImplementation(ChessPiece.Color.WHITE, ChessPiece.Type.BISHOP);
		pieces[getPieceIndex(2, 7)] = new ChessPieceImplementation(ChessPiece.Color.BLACK, ChessPiece.Type.BISHOP);
		pieces[getPieceIndex(5, 7)] = new ChessPieceImplementation(ChessPiece.Color.BLACK, ChessPiece.Type.BISHOP);

		pieces[getPieceIndex(4, 0)] = new ChessPieceImplementation(ChessPiece.Color.WHITE, ChessPiece.Type.KING);
		pieces[getPieceIndex(3, 0)] = new ChessPieceImplementation(ChessPiece.Color.WHITE, ChessPiece.Type.QUEEN);
		pieces[getPieceIndex(3, 7)] = new ChessPieceImplementation(ChessPiece.Color.BLACK, ChessPiece.Type.QUEEN);
		pieces[getPieceIndex(4, 7)] = new ChessPieceImplementation(ChessPiece.Color.BLACK, ChessPiece.Type.KING);
	}
	
	@Override
	public ChessPiece[] getPieces(ChessPiece.Color PieceColor) {
		int count = 0;
		for (ChessPiece piece : pieces)
			if (piece != null && piece.getColor() == PieceColor)
				count++;

		if (count == 0)
			return null;
		
		ChessPiece[] result = new ChessPiece[count];
		count = 0;
		for (ChessPiece piece : pieces)
			if (piece != null && piece.getColor() == PieceColor)
				result[count++] = piece;

		return result;
	}
	
	private	int getPieceIndex(int column, int row) {
		return row * 8 + column;
	}

	private	int getPieceIndex(PiecePosition position) {
		return position.getRow() * 8 + position.getColumn();
	}

	private	ChessPiece getPiece(int column, int row) {
		int index = getPieceIndex(column, row);
		return pieces[index];
	}

	@Override
	public ChessPiece getPieceAt(PiecePosition position) {
		if (!PiecePosition.isAvailable(position))
			return null;
		return getPiece(position.getColumn(), position.getRow());
	}

	@Override
	public PiecePosition getPiecePosition(ChessPiece APiece) {
		for (int row = 0; row < 8; row++)
			for (int column = 0; column < 8; column++)
				if (getPiece(column, row) == APiece)
					return new PiecePosition(column, row);
		return null;
	}

	@Override
	public void removePieceAt(PiecePosition Position) {
		pieces[getPieceIndex(Position.getColumn(), Position.getRow())] = null;
	}

	@Override
	public boolean movePieceTo(ChessPiece Piece, PiecePosition Position) {
		PiecePosition oldPosition = getPiecePosition(Piece);
		if (oldPosition != null) {
			int oldIndex = getPieceIndex(oldPosition);
			int newIndex = getPieceIndex(Position);
			pieces[oldIndex] = null;
			pieces[newIndex] = Piece;
			Piece.notifyMoved();
			return true;
		}
		return false;
	}

	@Override
	public boolean containsKing(ChessPiece.Color PieceColor) {
		for (ChessPiece piece : pieces) 
			if (piece != null && piece.getType() == ChessPiece.Type.KING && piece.getColor() == PieceColor)
				return true;
		return false;
	}

	@Override
	public boolean saveToFile(File location) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean loadFromFile(File location) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}

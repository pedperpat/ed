package Chess;

public interface ChessPiece {
    
    enum Color {
        BLACK, WHITE
    }
	
	enum Type {
		KING, QUEEN, ROOK, BISHOP, KNIGHT, PAWN
	}

	/**
	 * Esta función devuelve el color de la pieza.
	 * @return The color of the piece.
	 */
    Color getColor();
	
	/**
	 * Esta función devuelve el color de la pieza
	 * @return 
	 */
    Type getType();

	/**
	 * Cuando el tablero mueve una ficha, llama a esta función para notificarle
	 * que la ha movido.
	 */
	void notifyMoved();

	/**
	 * Esta función devuelve si la ficha se ha movido en algún momento de la partida 
	 * o no.
	 * @return true if notifyMoved was called once at least, false otherwise.
	 */
	boolean	wasMoved();
	
	/**
	 * Esta función devuelve un array con todas las posibles posiciones a las que 
	 * se puede mover una ficha.
	 * @param aBoard Board containing the piece.
	 * @return the array with the available positions where the piece can be moved.
	 */
    PiecePosition[] getAvailablePositions(ChessBoard aBoard);
	
	/**
	 * Default method. This function tells if a piece can be moved or not.
	 * @param aPosition New position of the piece.
	 * @param aBoard Board containing the piece.
	 * @return true if the piece can be moved, false otherwise.
	 */
	default boolean canMoveToPosition(PiecePosition aPosition, ChessBoard aBoard) {
		PiecePosition[] positions = getAvailablePositions(aBoard);
		if (positions != null)
			for (PiecePosition position : positions)
				if (position.equals(aPosition))
					return true;
		return false;
	}
}

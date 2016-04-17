package Chess;

import java.io.File;

public interface ChessBoard {
	
	/**
	 * Esta función devuelve un array con todas las piezas que hay en el tablero.
	 * No contiene nulls.
	 * @return The pieces contained in the board.
	 */
	default ChessPiece[] getPieces() {
		return ChessUtils.cat(getPieces(ChessPiece.Color.BLACK), getPieces(ChessPiece.Color.WHITE));
	}

	/**
	 * Igual que la función getPieces, pero solo con las fichas de un color determinado.
	 * @param pieceColor Color of the required pieces.
	 * @return The pieces contained in the board with the pieceColor color.
	 */
    ChessPiece[] getPieces(ChessPiece.Color pieceColor);
	
	/**
	 * Esta función devuelve la pieza que hay en una determinada posición en el
	 * yablero.
	 * @param position The piece position
	 * @return A piece
	 */
    ChessPiece getPieceAt(PiecePosition position);
	
	/**
	 * Dada una pieza, esta función devuelve la posicion que ocupa esa pieza en el 
	 * tablero.
	 * @param aPiece The piece want to ask for.
	 * @return The position of the piece.
	 */
	PiecePosition getPiecePosition(ChessPiece aPiece);
	
	/**
	 * Esta función borra la pieza que hay en una determinada posición.
	 * @param position Position of the piece.
	 */
    void removePieceAt(PiecePosition position);
	
	/**
	 * Esta función intenta mover una pieza a la posición indicada
	 * @param piece The piece that is moving.
	 * @param position The new position of the piece.
	 * @return true if the piece could be moved, false otherwise.
	 */
    boolean movePieceTo(ChessPiece piece, PiecePosition position);
	
	/**
	 * Esta función dice si en el talbero hay un rey de un determinado color.
	 * @param pieceColor Color of the king.
	 * @return true if the king exists, false otherwise.
	 */
    boolean containsKing(ChessPiece.Color pieceColor);
	
	/**
	 * Esta función guarda la partida en un archivo
	 * @param location Path of the file to be saved.
	 * @return true if successfull, false otherwise.
	 */
	boolean saveToFile(File location);

	/**
	 * Esta función abre la partida que hay en un archivo
	 * @param location Path of the file to be loaded.
	 * @return true if successfull, false otherwise.
	 */
	boolean loadFromFile(File location);
}

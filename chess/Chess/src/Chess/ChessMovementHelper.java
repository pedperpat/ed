package Chess;

public class ChessMovementHelper {
	
	private final PiecePosition[] positions = new PiecePosition[8 * 8];
	private int count = 0;

	@SuppressWarnings("ManualArrayToCollectionCopy")
	public PiecePosition[]	getResult() {
		PiecePosition[] result = new PiecePosition[count];
		for (int i = 0; i < count; i++)
			result[i] = positions[i];
		return result;
	}

	/**
	 * Esta función intenta insertar en el array de soluciones una posición
	 * siempre que no haya ya una ficha en ella
	 * @param aPosition
	 * @param aBoard
	 * @param columnCount
	 * @param rowCount
	 * @return La pieza que ha impedido la inserción
	 */
	public boolean addPositionWithDisplacementIfAvaiable(PiecePosition aPosition, 
			ChessBoard aBoard, int columnCount, int rowCount) {
		if (PiecePosition.isAvailable(aPosition, columnCount, rowCount) && count < positions.length) {
			PiecePosition newPosition = aPosition.getDisplacedPiece(columnCount, rowCount);
			ChessPiece piece = aBoard.getPieceAt(newPosition);
			if (piece == null) {
				positions[count++] = aPosition.getDisplacedPiece(columnCount, rowCount);
				return true;
			}
		}
		return false;
	}
	public boolean addPosition(PiecePosition aPosition, int columnCount, int rowCount) {
		if (PiecePosition.isAvailable(aPosition, columnCount, rowCount) && count < positions.length) {
			positions[count++] = aPosition.getDisplacedPiece(columnCount, rowCount);
			return true;
		}
		return false;
	}
}

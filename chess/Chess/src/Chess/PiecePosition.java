package Chess;

public class PiecePosition {

	/**
	 * Returns true if there is an available position, otherwise returns false.
         * @param column Refers to the column of the piece at the board.
         * @param row Refers to the row of the piece at the board.
	 */
	public static boolean isAvailable(int column, int row) {
		return column >= 0 && column < 8 && row >= 0 && row < 8;
	}

	/**
	 * Returns false if there's a not valid position. 
         * If is a valid position, newColumn is equal to the desired column to move
         * and newRow is equal to the desired row to move the piece.
         * 
         * Then the method returns true and invoke the isAvailable method to 
         * determine if is available the next position.
         * @param position Determines the position of the piece.
         * @param columnIncrement Columns do you want to increment at the movement.
         * @param rowIncrement Rows do you want to increment at the movement.
	 */
	static boolean isAvailable(PiecePosition position, int columnIncrement, int rowIncrement) {
		if (position == null)
			return false;
		
		int newColumn = position.getColumn() + columnIncrement;
		int newRow = position.getRow() + rowIncrement;
		return isAvailable(newColumn, newRow);
	}

	/**
	 * Tells if a position is valid or invalid. Returns true and calls the
         * first method isAvailable(int column, int row) or returns false if is
         * not a valid position at the board.
         * @param position Determines the position of the piece at the board.
	 */
	static boolean isAvailable(PiecePosition position) {
		if (position == null)
			return false;
		return isAvailable(position.getColumn(), position.getRow());
	}

	private int column, row;

	/**
	 * Consructor of PiecePosition java class that assigns position in
         * column and row of the current piece.
	 */
	public PiecePosition(int column, int row) {
		this.column = column;
		this.row = row;
	}
	
	/**
	 * Returns the current column of the piece when this method is called.
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * Returns the current row of the piece when this method is called.
	 */
	public int getRow() {
		return row;
	}
	
        /**
         * Sets values at the board to the desired piece.
         * @param column Set a new column position of the piece.
         * @param row Set a new row position of the piece.
         * @return Returns true if column and row are available to set to the 
         * current piece. False if column and row are not available.
         */
	public boolean setValues(int column, int row) {
		if (isAvailable(column, row)) {
			this.column = column;
			this.row = row;			
			return true;
		}
		return false;
	}
	
	/**
	 * This method returns null if columnCount and rowCount aren't an 
         * available position.
         * If columnCount and rowCount are a valid position, then creates a new
         * PiecePosition with a newColumn and a newRow.
	 */
	public PiecePosition getDisplacedPiece(int columnCount, int rowCount) {		
		if (!isAvailable(this, columnCount, rowCount))
			return null;
		int newColumn = getColumn() + columnCount;
		int newRow = getRow() + rowCount;
		return new PiecePosition(newColumn, newRow);
	}
	
	/**
	 * Creates a new position of the current piece, cloning it.
	 */
	public PiecePosition clone() {
		return new PiecePosition(column, row);
	}
	
	/**
	 * This method returns true if the position of a piece is the correct position
         * at the board.
	 */
	public boolean equals(PiecePosition aPosition) {
		return aPosition.getColumn() == getColumn() && aPosition.getRow() == getRow();
	}
}

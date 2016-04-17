package Chess;

public class ChessMovementManager {
	
	static PiecePosition[] getAvailablePositionsOfPawn(ChessPiece aPiece, ChessBoard aBoard) {
		PiecePosition auxPosition, position = aBoard.getPiecePosition(aPiece);
		ChessMovementHelper result = new ChessMovementHelper();
		int direction = aPiece.getColor() == ChessPiece.Color.WHITE ? 1 : -1;

		result.addPositionWithDisplacementIfAvaiable(position, aBoard, 0, direction);
		if (!aPiece.wasMoved())
                    generateStepMovement(aPiece, aBoard, result, position, 0, direction, 2);
                    //result.addPositionWithDisplacementIfAvaiable(position, aBoard, 0, direction * 2);
		ChessPiece piece;
		auxPosition = position.getDisplacedPiece(1, direction);
		piece = aBoard.getPieceAt(auxPosition);
		if(piece!= null && piece.getColor() != aPiece.getColor())
			result.addPosition(auxPosition, 0, 0);

		auxPosition = position.getDisplacedPiece(-1, direction);
		piece = aBoard.getPieceAt(auxPosition);
		
		return result.getResult();
	}

	static void generateStepMovement(ChessPiece aPiece, ChessBoard aBoard, ChessMovementHelper aResult, 
			PiecePosition aPosition, int columnIncrement, int rowIncrement, 
			int maxTimes) {

		PiecePosition auxPosition;
		int times = maxTimes;
		
		auxPosition = aPosition.getDisplacedPiece(columnIncrement, rowIncrement);
		while ((times-- > 0) && auxPosition != null && PiecePosition.isAvailable(auxPosition, 0, 0)) {
			boolean added = aResult.addPositionWithDisplacementIfAvaiable(auxPosition, aBoard, 0, 0);
			if (!added) {
				ChessPiece piece = aBoard.getPieceAt(auxPosition);
				if (piece != null && piece.getColor() != aPiece.getColor())
					aResult.addPosition(auxPosition, 0, 0);
				break;
			}
			auxPosition = auxPosition.getDisplacedPiece(columnIncrement, rowIncrement);
		}
	}

	static PiecePosition[] getAvailablePositionsOfBishop(ChessPiece aPiece, ChessBoard aBoard) {
		PiecePosition position = aBoard.getPiecePosition(aPiece);
		ChessMovementHelper result = new ChessMovementHelper();

		generateStepMovement(aPiece, aBoard, result, position, 1, 1, 8);
		generateStepMovement(aPiece, aBoard, result, position, -1, 1, 8);
		generateStepMovement(aPiece, aBoard, result, position, 1, -1, 8);
		generateStepMovement(aPiece, aBoard, result, position, -1, -1, 8);
		
		return result.getResult();
	}
	static PiecePosition[] getAvailablePositionsOfKing(ChessPiece aPiece, ChessBoard aBoard) {
		PiecePosition position = aBoard.getPiecePosition(aPiece);
		ChessMovementHelper result = new ChessMovementHelper();

		generateStepMovement(aPiece, aBoard, result, position, 1, 1, 1);
		generateStepMovement(aPiece, aBoard, result, position, -1, 1, 1);
		generateStepMovement(aPiece, aBoard, result, position, 1, -1, 1);
		generateStepMovement(aPiece, aBoard, result, position, -1, -1, 1);
		generateStepMovement(aPiece, aBoard, result, position, 1, 0, 1);
		generateStepMovement(aPiece, aBoard, result, position, -1, 0, 1);
		generateStepMovement(aPiece, aBoard, result, position, 0, 1, 1);
		generateStepMovement(aPiece, aBoard, result, position, 0, -1, 1);
		
		return result.getResult();
	}

	static PiecePosition[] getAvailablePositionsOfQueen(ChessPiece aPiece, ChessBoard aBoard) {
		PiecePosition position = aBoard.getPiecePosition(aPiece);
		ChessMovementHelper result = new ChessMovementHelper();
                
                generateStepMovement(aPiece, aBoard, result, position, -1, -1, 8);
		generateStepMovement(aPiece, aBoard, result, position, 1, 1, 8);
		generateStepMovement(aPiece, aBoard, result, position, -1, 1, 8);
		generateStepMovement(aPiece, aBoard, result, position, 1, -1, 8);
		generateStepMovement(aPiece, aBoard, result, position, 1, 0, 8);
		generateStepMovement(aPiece, aBoard, result, position, -1, 0, 8);
		generateStepMovement(aPiece, aBoard, result, position, 0, 1, 8);
		generateStepMovement(aPiece, aBoard, result, position, 0, -1, 8);
		
		return result.getResult();
	}

	static PiecePosition[] getAvailablePositionsOfKnight(ChessPiece aPiece, ChessBoard aBoard) {
		PiecePosition position = aBoard.getPiecePosition(aPiece);
		ChessMovementHelper result = new ChessMovementHelper();

		generateStepMovement(aPiece, aBoard, result, position, 1, 2, 1);
		generateStepMovement(aPiece, aBoard, result, position, 1, -2, 1);
		generateStepMovement(aPiece, aBoard, result, position, -1, 2, 1);
		generateStepMovement(aPiece, aBoard, result, position, -1, -2, 1);
		generateStepMovement(aPiece, aBoard, result, position, 2, 1, 1);
		generateStepMovement(aPiece, aBoard, result, position, 2, -1, 1);
		generateStepMovement(aPiece, aBoard, result, position, -2, 1, 1);
		generateStepMovement(aPiece, aBoard, result, position, -2, -1, 1);

		return result.getResult();
	}

	static PiecePosition[] getAvailablePositionsOfRook(ChessPiece aPiece, ChessBoard aBoard) {
		PiecePosition position = aBoard.getPiecePosition(aPiece);
		ChessMovementHelper result = new ChessMovementHelper();

		generateStepMovement(aPiece, aBoard, result, position, 1, 0, 8);
		generateStepMovement(aPiece, aBoard, result, position, -1, 0, 8);
		generateStepMovement(aPiece, aBoard, result, position, 0, 1, 8);
		generateStepMovement(aPiece, aBoard, result, position, 0, -1, 8);
		
		return result.getResult();
	}
	
}

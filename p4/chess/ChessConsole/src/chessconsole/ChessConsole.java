package chessconsole;

import Chess.*;

public class ChessConsole {
    
    static  ChessAI createArtificialIntelligenceLogic() {
        return new ChessRandomAI();
    }

    static  ChessAI createPlayerLogic() {
        return new ChessRandomAI();
    }

    static ChessBoard createTable() {
        return new ChessBoardImplementation();
    }
	
	static char getCharForBoard(int column, int row) {
		if ((column & 1) == 0)
			return (row & 1) == 0 ? '*' : ' ';
		else
			return (row & 1) == 0 ? ' ' : '*';
	}
    
    static void printTable(ChessBoard Table) {
		PiecePosition position = new PiecePosition(0, 7);
		System.out.print("   ");
		for (int column = 0; column < 8; column++)
			System.out.print(" " + (column + 1) + " ");
		System.out.println();
			
		for (int row = 7; row >= 0; row--) {
			System.out.print("[" + (row + 1) + "]");
			for (int column = 0; column < 8; column++) {
				position.setValues(column, row);
				ChessPiece piece = Table.getPieceAt(position);
				if (piece == null)
					System.out.print(" " + getCharForBoard(column, row) + " ");
				else {
					switch(piece.getType()) {
						case PAWN: System.out.print("P"); break;
						case BISHOP: System.out.print("A"); break;
						case KING: System.out.print("R"); break;
						case QUEEN: System.out.print("Q"); break;
						case KNIGHT: System.out.print("C"); break;
						case ROOK: System.out.print("T"); break;
					}
					System.out.print(piece.getColor() == ChessPiece.Color.BLACK ? "N " : "B ");
				}
			}
			System.out.println("[" + (row + 1) + "]");
		}
		System.out.print("   ");
		for (int column = 0; column < 8; column++)
			System.out.print(" " + (column + 1) + " ");
		System.out.println();
		System.out.println("-----------------------------------------------------");
    }
    
    public static void main(String[] args) {
        
        ChessBoard table = createTable();
        ChessAI ai = createArtificialIntelligenceLogic();
        ChessAI player = createPlayerLogic();

        System.out.println("Bienvenido al juego del ajedrez, tú llevas las blancas");
		
        while (table.containsKing(ChessPiece.Color.BLACK) && table.containsKing(ChessPiece.Color.WHITE)) {
			
			printTable(table);
			
            if(!player.performNextMovement(table, ChessPiece.Color.WHITE))
                System.out.println("Algo ha ido mal, ...");

            if(table.containsKing(ChessPiece.Color.BLACK) && table.containsKing(ChessPiece.Color.WHITE))
                if(!ai.performNextMovement(table, ChessPiece.Color.BLACK))
                    System.out.println("Algo ha ido mal, ...");
        }

		printTable(table);
        if (table.containsKing(ChessPiece.Color.BLACK))
            System.out.println("GANARON LAS NEGRAS!!!!");
        else
            System.out.println("GANARON LAS BLANCAS!!!!");
    }
    
}

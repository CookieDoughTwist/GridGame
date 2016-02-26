package modes;

import engine.Entity;
import engine.Grid;

public class Chess {

	public static void main(String[] args) {
		Chess game = new Chess();
		game.board.print();
	}
	
	final Grid board;
	
	public Chess() {
		
		board = new Grid(8,8);
		resetBoard();
	}
	
	private void resetBoard() {
		
		for(int i = 0; i < 8; i++) {
			board.addEntity(new Entity("White Pawn"), i, 1);
			board.addEntity(new Entity("Black Pawn"), i, 6);
		}
		
		board.addEntity(new Entity("White Rook"),   0, 0);
		board.addEntity(new Entity("White Knight"), 1, 0);
		board.addEntity(new Entity("White Bishop"), 2, 0);
		board.addEntity(new Entity("White Queen"),  3, 0);
		board.addEntity(new Entity("White King"),   4, 0);
		board.addEntity(new Entity("White Bishop"), 5, 0);
		board.addEntity(new Entity("White Knight"), 6, 0);
		board.addEntity(new Entity("White Rook"),   7, 0);
		
		board.addEntity(new Entity("Black Rook"),   0, 7);
		board.addEntity(new Entity("Black Knight"), 1, 7);
		board.addEntity(new Entity("Black Bishop"), 2, 7);
		board.addEntity(new Entity("Black Queen"),  3, 7);
		board.addEntity(new Entity("Black King"),   4, 7);
		board.addEntity(new Entity("Black Bishop"), 5, 7);
		board.addEntity(new Entity("Black Knight"), 6, 7);
		board.addEntity(new Entity("Black Rook"),   7, 7);
	}
}

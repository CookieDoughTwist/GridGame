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
		
	}
}

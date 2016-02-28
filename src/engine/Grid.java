package engine;

import java.util.Arrays;
import java.util.List;

public class Grid {

	public static void main(String[] args) {
		Grid grid = new Grid(10,10);
		Entity cheese = new Entity("cheese");
		grid.addEntity(cheese, 2, 3);
		grid.print();
	}
	
	int xDim;
	int yDim;
	Square[] squares;
	
	public Grid(int x, int y) {
		
		xDim = x;
		yDim = y;
		
		squares = new Square[x*y];
		
		for(int i = 0; i < x*y; i++) {
			squares[i] = new Square(x,y); 
		}
	}
	
	public boolean addEntity(Entity entity, int x, int y) {
				
		Square square = squares[getIndex(x,y)];
		return square.addEntity(entity);
	}
	
	public void print() {
		
		for(int j = yDim-1; j >= 0; j--) {			
			for(int i = 0; i < xDim; i++) {
				System.out.print("|");
				Square square = squares[getIndex(i,j)];
				if(square.hasEntity()) {
					System.out.print("O");
				}
				else {
					System.out.print(" ");
				}						
			}
			System.out.print("|");
			System.out.println();
		}
	}
	
	private int getIndex(int x, int y) {
		
		return x + y * xDim;
	}
}

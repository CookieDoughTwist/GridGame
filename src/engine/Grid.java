package engine;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JApplet;
import javax.swing.JFrame;

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
	JApplet applet;
	
	int unitWidth = 50; // TODO: lettuce make this modular
	
	public Grid(int x, int y) {
		
		xDim = x;
		yDim = y;
		
		squares = new Square[x*y];
		
		for(int i = 0; i < x*y; i++) {
			squares[i] = new Square(x,y); 
		}
		
		applet = new GridDisplay(unitWidth,xDim,yDim);
	}
	
	public boolean addEntity(Entity entity, int x, int y) {
				
		Square square = squares[getIndex(x,y)];
		return square.addEntity(entity);
	}
	
	public void drawGrid() {
		
		JFrame f = new JFrame("Grid Test");
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.getContentPane().add("Center", applet);
		applet.init();
		f.pack();
		int topBarHeight = 23; // TODO: figure out how to calculate
		f.setSize(new Dimension((unitWidth+2)*xDim+1, (unitWidth+2)*yDim+1+topBarHeight));
		f.setVisible(true);
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

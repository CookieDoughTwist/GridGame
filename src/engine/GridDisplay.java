package engine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;

import javax.swing.JApplet;
import javax.swing.JFrame;

public class GridDisplay extends JApplet {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		
		
	}
	
	int unitWidth;
	int xDim;
	int yDim;
	
	public GridDisplay(int unitWidth, int xDim, int yDim) {
		
		this.unitWidth = unitWidth;
		this.xDim = xDim;
		this.yDim = yDim;
	}
	
	public void init() {
		
		setBackground(Color.white);
		setForeground(Color.white);
	}
	
	
   
	public void paint(Graphics g) {
	   Graphics2D g2 = (Graphics2D) g;
	   g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			   RenderingHints.VALUE_ANTIALIAS_ON);
	   g2.setPaint(Color.gray);
	   
	   for(int i = 0; i <= xDim; i++) {
		   g2.draw(new Line2D.Double(unitWidth*i, 0, unitWidth*i, unitWidth*yDim));
		   g2.draw(new Line2D.Double(0, unitWidth*i, unitWidth*xDim, unitWidth*i));
	   }
      
   }
}

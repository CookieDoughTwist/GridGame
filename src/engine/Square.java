package engine;

public class Square {

	int x;
	int y;
	Entity entity;
	
	public Square(int inX, int inY) {
		
		x = inX;
		y = inY;
	}
	
	public boolean addEntity(Entity in) {
		
		entity = in;
		return true;
	}
	
	public boolean hasEntity() {
		
		return entity != null;
	}
}

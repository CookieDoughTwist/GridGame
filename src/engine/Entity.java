package engine;

public class Entity {

	String name;
	
	public Entity(String in ) { 
		name = in;
	}
	
	
	
	public void print() {
		System.out.print("Entity: " + name);
	}
}

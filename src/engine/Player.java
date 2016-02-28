package engine;

import java.util.ArrayList;

public class Player {

	private final String name;
	private final ArrayList<Entity> entities;
	
	public Player(String name) {
		
		this.name = name;
		this.entities = new ArrayList<Entity>();
	}
	
	public void addEntity(Entity entity) {
		
		entities.add(entity);
	}
	
	public String name() {
		return name;
	}
	
	public void print() {
		
		System.out.println("Player: " + name);
		for(Entity e : entities) {
			System.out.print(" ");
			e.print();
			System.out.println();
		}
	}
}

package engine;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Engine {

	public static void main(String[] args) {
		
		Engine e = new Engine("data/modes/chess.properties");
		e.print();
	}
	
	Grid board;
	ArrayList<Player> players;
	
	public Engine(String mode) {
		
		Properties prop = new Properties();				
		
		try(InputStream propStream = new FileInputStream(mode)) {
			
			prop.load(propStream);
			
			int nPlayers = Integer.parseInt(prop.getProperty("nDefaultPlayers"));
			players = new ArrayList<Player>(nPlayers);
			board = new Grid(Integer.parseInt(prop.getProperty("xlim")),Integer.parseInt(prop.getProperty("ylim")));
			
			for(int i = 0; i < nPlayers; i++) {
				Player p = new Player(prop.getProperty("name"+i));
				players.add(p);
				List<String> entityConfigList = Arrays.asList(prop.getProperty("entityList"+i).split("\\s*;\\s*"));
				for(String s : entityConfigList) {
					List<String> params = Arrays.asList(s.split("\\s*,\\s*"));
					Entity e = new Entity(params.get(0));					
					
					board.addEntity(e,Integer.parseInt(params.get(1)),Integer.parseInt(params.get(2)));
					p.addEntity(e);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void print() {
		board.print();
		
		for(Player p : players) {
			
			p.print();
		}
	}
}

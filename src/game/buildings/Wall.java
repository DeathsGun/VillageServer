package game.buildings;

import game.Building;
import game.Location;

/**
 * 
 */
class Wall extends Building {

	private static final long serialVersionUID = 1L;

	public Wall(int number, Location location){
		super(10, 10, 10, number, location);
	}
}

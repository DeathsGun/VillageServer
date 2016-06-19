package com.github.ToK.server.command;

import game.Distributor;
import game.Location;

public class BuildMainhall implements CommandHandler {
	
	private static Distributor distributor = new Distributor();
	@Override
	public String handle() {
		Location location = new Location(3,3);
		distributor.buildMainBuilding(location);
		return "Rathhaus gebaut!";
	}

}

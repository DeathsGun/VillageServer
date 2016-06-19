package com.github.ToK.server.command;

/*
 * Copyright © 2016 | Time of Kings (ToK) - GameTeam | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

import com.github.ToK.server.main.Main;

public class Stop implements CommandHandler {
	
	@Override
	public String handle() {
		String MSG = "";
		if(Main.isRoot == true) {
			MSG = "Stoped lovely Hanna";
			System.exit(0);
			System.out.println("Shutting down the server..");
		} else {
			MSG = "Nicht genug Rechte!";
		}
		return MSG;
	}

}

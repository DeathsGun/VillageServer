package com.github.ToK.server.command;
/*
 * Copyright © 2016 | Time of Kings (ToK) - GameTeam | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

import com.github.ToK.server.main.*;

public class MyIP implements CommandHandler {

	@Override
	public String handle() {
		
		return "Your IP: "+Main.IP;
	}

}

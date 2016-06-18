/*
 * Copyright © 2016 | Time of Kings (ToK) - GameTeam | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.github.ToK.ToKserver.command;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.ToK.ToKserver.configuration.ConfigurationManager;
import com.github.ToK.ToKserver.server.Main;

public class Stop implements CommandHandler {
	
	private final Logger logger = Logger.getLogger(ConfigurationManager.class.getName());
	@Override
	public String handle() {
		String MSG = "";
		if(Main.isRoot = true) {
			MSG = "Stoped lovely Hanna";
			logger.log(Level.WARNING, "Shutting down the server..");
			System.exit(0);
		} else {
			MSG = "Nicht genug Rechte!";
		}
		return MSG;
	}

}

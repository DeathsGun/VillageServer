/*
 * Copyright © 2016 | Time of Kings (ToK) Team | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.github.ToK.ToKserver.command;

import com.github.ToK.ToKserver.server.Main;

/**
 * @author DeathsGun
 * @date Jun 12, 2016
 *
 */
public class Info implements CommandHandler {

	String cr = System.getProperty("os.name").matches("(W|w)indows.*") ? "\r\n" : "\n";
    StringBuilder builder = new StringBuilder();
	@Override
	public String handle() {
		String Info = "ToK Version: "+Main.version+cr+"Betriebssystem: "+System.getProperty("os.name")+cr+"Betriebssystemversion: "+System.getProperty("os.version")+cr+"Server Github site: https://github.com/VillageTeam/ToK-Server"+cr+"Game Github site: https://github.com/VillageTeam/Time-of-Kings";
		return Info;
	}

}

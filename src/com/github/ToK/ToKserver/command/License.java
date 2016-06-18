/*
 * Copyright © 2016 | Time of Kings (ToK) Team | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.github.ToK.ToKserver.command;

/**
 * 
 * @author DeathsGun
 * @date Jun 18, 2016
 */
public class License implements CommandHandler {

	@Override
	public String handle() {
		String cr = System.getProperty("os.name").matches("(W|w)indows.*") ? "\r\n" : "\n";
		String License = "Copyright © 2016 | Time of Kings (ToK) Team | All rights reserved."+cr+cr+cr+"This Source Code Form is subject to the terms of the Mozilla Public"+cr+"License, v. 2.0. If a copy of the MPL was not distributed with this"+cr+"file, You can obtain one at http://mozilla.org/MPL/2.0/.";
		return License;
	}

}

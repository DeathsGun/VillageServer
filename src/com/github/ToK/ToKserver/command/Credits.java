/*
 * Copyright © 2016 | Time of Kings (ToK) - GameTeam | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.github.ToK.ToKserver.command;

public class Credits implements CommandHandler {

	@Override
	public String handle() {
		String cr = System.getProperty("os.name").matches("(W|w)indows.*") ? "\r\n" : "\n";
        StringBuilder builder = new StringBuilder();
        builder.append("Time of Kings");
        builder.append(cr);
        builder.append("Special thanks to: ");
        builder.append(cr);
        builder.append("SupressWarnings");
        builder.append(cr);
        builder.append("Cromwell");
        builder.append(cr);
		return builder.toString();
	}

}

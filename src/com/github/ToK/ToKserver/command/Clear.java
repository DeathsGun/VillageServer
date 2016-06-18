/*
 * Copyright © 2016 | Time of Kings (ToK) - GameTeam | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.github.ToK.ToKserver.command;

public class Clear implements CommandHandler {

	@Override
	public String handle() {
		String cr = System.getProperty("os.name").matches("(W|w)indows.*") ? "\r\n" : "\n";
		String one = cr+cr+cr+cr+cr+cr+cr+cr+cr+cr+cr+cr+cr+cr+cr;
		String clear = one+one+one+one+one+one+"============================="+cr+"   ToK Server"+cr+"============================="+one+cr+cr+cr+cr+cr;
		return clear;
	}

}

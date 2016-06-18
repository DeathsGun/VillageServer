/*
 * Copyright © 2016 | Time of Kings (ToK) - GameTeam | All rights reserved.
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
	@Override
	public String handle() {
		String Info = cr+cr+"Tok Infos:"+cr+"================"+cr+"ToK Entwickler: "+System.getProperty("tok.vendor")+cr+"ToK Server Version: "+System.getProperty("tok.server.version")+cr+"Server Website:"+System.getProperty("tok.server.url")+cr+"Client Version: "+System.getProperty("tok.client.version")+cr+"Client Website: "+System.getProperty("tok.client.url")+cr+"================"+cr+cr+"Betriebsystem Infos: "+cr+"================"+cr+"Betriebssystem: "+System.getProperty("os.name")+cr+"Betriebssystemversion: "+System.getProperty("os.version")+cr+"Betriebssystem Architektur: "+System.getProperty("os.arch")+cr+"================"+cr+cr+"Java Infos"+cr+"================"+cr+"Java Entwickler: "+System.getProperty("java.vendor")+cr+"Entwickler Website: "+System.getProperty("java.vendor.url")+cr+"Java Version: "+System.getProperty("java.version");
		return Info;
	}

}

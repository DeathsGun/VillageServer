/*
 * Copyright © 2016 | Time of Kings (ToK) - GameTeam | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.github.ToK.ToKserver.server;

/**
 * @author DeathsGun
 * @date Jun 12, 2016
 *
 */
public class Main {
	public static boolean isRoot = false;
	public static String IP = null;
	public static String ae = "\u00e4"; // Klein
	public static String Ae = "\u00c4"; // Gross
	public static String oe = "\u00f6"; // Klein
	public static String Oe = "\u00d6"; // Gross
	public static String ue = "\u00fc"; // Klein
	public static String Ue = "\u00dc"; // Gross
	public static String ss = "\u00df";
	public static Thread server;
    public static void main(String[] args) {
    	System.setProperty("tok.server.url", "https://github.com/ToK-Gameteam/ToK-Server");
    	System.setProperty("tok.client.url", "https://github.com/ToK-Gameteam/Time-of-Kings");
    	System.setProperty("tok.client.version", "0.2");
    	System.setProperty("tok.server.version", "0.2");
    	System.setProperty("tok.vendor", "Time of Kings Gameteam");
    	server = new Thread(new TelnetServer(args.length == 0 ? null : args[0]));
    	server.start();
    }
}

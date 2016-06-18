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
public class StatusHandler implements CommandHandler {
	
	private static final long  MEGABYTE = 1024L * 1024L;
	
    public String handle() {
    	String cr = System.getProperty("os.name").matches("(W|w)indows.*") ? "\r\n" : "\n";
		String ue = "\u00fc";
		
		long freeMem = Runtime.getRuntime().freeMemory();
		long totalMem = Runtime.getRuntime().totalMemory();
		String fM = bytesToMeg(freeMem)+" Mb";
		String tM = bytesToMeg(totalMem)+" Mb";
        return cr+cr+cr+cr+"Status: L"+Main.ae+"uft!"+cr+"Freier Speicher: "+fM+cr+"Verf"+ue+"gbarer Speicher: "+tM+cr+"Verf"+ue+"bare Prozessorkerne: "+Runtime.getRuntime().availableProcessors()+" Kerne";

    }
    public static long bytesToMeg(long bytes) {
    	  return bytes / MEGABYTE ;
    }
    

}

/*
 * Copyright © 2016 | Time of Kings (ToK) Team | All rights reserved.
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
	
	public static double version = 1.0;
    public static void main(String[] args) {

        // launch the server
        new TelnetServer(args.length == 0 ? null : args[0]).run();
    }
}

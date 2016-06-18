/*
 * Copyright © 2016 | Time of Kings (ToK) Team | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.github.ToK.ToKserver;

import com.github.ToK.ToKserver.server.Main;

/**
 * @author DeathsGun
 * @date Jun 12, 2016
 *
 */
public final class Util {

    public static String buildWelcomeScreen() {
        String cr = System.getProperty("os.name").matches("(W|w)indows.*") ? "\r\n" : "\n";
        StringBuilder builder = new StringBuilder();
        builder.append(cr);
        builder.append("======================================================");
        builder.append(cr);
        builder.append(cr);
        builder.append("   Willkommen auf dem ToK Server "+Main.version);
        builder.append(cr);
        builder.append("      Running on "+System.getProperty("os.name"));
        builder.append(cr);
        builder.append(cr);
        builder.append("======================================================");
        builder.append(cr);
        builder.append(cr);
        builder.append("Viel Spass Spieler!");
        return builder.toString();
    }

}

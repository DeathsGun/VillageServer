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
public class UnknownCommandHandler implements CommandHandler {

    private final String command;

    /**
     * @param command
     */
    public UnknownCommandHandler(final String command) {

        this.command = command;
    }

    public String handle() {

        String cr = System.getProperty("os.name").matches("(W|w)indows.*") ? "\r\n" : "\n";
        StringBuilder builder = new StringBuilder();
        builder.append("Unbekannter Befehl: "+command);
        builder.append(cr);
        builder.append(" Befehle:");
        builder.append(cr);
        builder.append("sp-erstellen");
        builder.append(cr);
        builder.append("speichern");
        builder.append(cr);
        builder.append("laden");
        builder.append(cr);
        builder.append("status");
        builder.append(cr);
        builder.append("info");
        builder.append(cr);
        builder.append("license");
        builder.append(cr);
        builder.append("credits");
        if(Main.isRoot == true) {
        	builder.append(cr);
        	builder.append("stop");
        	builder.append(cr);
        	builder.append(cr);
        }
        return builder.toString();
    }

}

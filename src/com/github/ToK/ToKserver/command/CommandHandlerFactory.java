/*
 * Copyright © 2016 | Time of Kings (ToK) - GameTeam | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.github.ToK.ToKserver.command;

/**
 * @author DeathsGun
 * @date Jun 12, 2016
 *
 */
public class CommandHandlerFactory {

    private static CommandHandlerFactory factory;

    /**
     * Factory method.
     * 
     * @return
     */
    public static CommandHandlerFactory getInstance() {
        if (factory != null) {
            return factory;
        }
        return new CommandHandlerFactory();
    }

    /**
     * Get handler for given command.
     * 
     * @param command
     * @param workingDir
     * @return
     */
    public CommandHandler getHandler(final String command, final String workingDir) {
        if(command.equalsIgnoreCase("SP-Erstellen")) {
            return new SpielerErstellen();
        } else if(command.equalsIgnoreCase("laden")) {
            return new Laden();
        } else if(command.equalsIgnoreCase("speichern")) {
            return new Speichern();
        } else if(command.equalsIgnoreCase("status")) {
            return new StatusHandler();
        } else if(command.equalsIgnoreCase("ende")) {
            return new Ende();
        } else if(command.equalsIgnoreCase("Info")) {
        	return new Info();
        } else if(command.equalsIgnoreCase("License")) {
        	return new License();
        } else if(command.equalsIgnoreCase("stop")) {
        	return new Stop();
        } else if(command.equalsIgnoreCase("clear")) {
        	return new Clear();
        } else if(command.equalsIgnoreCase("credits")) {
        	return new Credits();
        }
        
        else {
            return new UnknownCommandHandler(command);
        }

    }

}

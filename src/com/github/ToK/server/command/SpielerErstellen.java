/*
 * Copyright © 2016 | Time of Kings (ToK) - GameTeam | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.github.ToK.server.command;

import game.UserInterface;

/**
 * @author DeathsGun
 * @date Jun 12, 2016
 *
 */
public class SpielerErstellen implements CommandHandler {

    public String handle() {
    	UserInterface.createPlayer();
        return "Spieler erstellt";
    }

}

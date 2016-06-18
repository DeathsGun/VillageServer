/*
 * Copyright © 2016 | Time of Kings (ToK) Team | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.github.ToK.ToKserver.command;

import com.github.ToK.game.UserInterface;

/**
 * @author DeathsGun
 * @date Jun 12, 2016
 *
 */
public class Ende implements CommandHandler {

    public String handle() {
    	UserInterface.savePlayer();
        return "Goodbye...";
    }

}

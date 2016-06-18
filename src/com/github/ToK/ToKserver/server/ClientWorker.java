/*
 * Copyright © 2016 | Time of Kings (ToK) - GameTeam | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.github.ToK.ToKserver.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.ToK.ToKserver.Util;
import com.github.ToK.ToKserver.command.CommandHandler;
import com.github.ToK.ToKserver.command.CommandHandlerFactory;
import com.github.ToK.ToKserver.command.Ende;
import com.github.ToK.ToKserver.configuration.ConfigurationManager;

/**
 * 
 * @author DeathsGun
 *
 */
public class ClientWorker implements Runnable {

    private final Socket socket;
    private String workingDir;
    private final Logger logger = Logger.getLogger(ClientWorker.class.getName());

    /**
     * @param socket
     */
    public ClientWorker(final Socket socket, String homeDir) {
        this.socket = socket;
        this.workingDir = homeDir;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    public void run() {

        try {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            final PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            InetAddress addr = socket.getLocalAddress();
            String hostAddr = addr.getHostAddress();
            InetAddress IP = InetAddress.getLocalHost();
            String ip = IP.getHostAddress();
            Main.IP = hostAddr;
            if(ip == hostAddr || ip == ConfigurationManager.getRootIP() || "localhost" == ConfigurationManager.getRootIP() || "127.0.0.1" == ConfigurationManager.getRootIP()) {
            	out.println("Hallo, Root!");
            	Main.isRoot = true;
            } else {
            	Main.isRoot = true;
            }
            // display welcome screen
            out.println(Util.buildWelcomeScreen());

            boolean cancel = false;
            CommandHandlerFactory fac = CommandHandlerFactory.getInstance();
            while (!cancel) {

                final String command = reader.readLine();
                if (command == null) {

                    continue;
                }

                //handle the command
                final CommandHandler handler = fac.getHandler(command, workingDir);
                String response = handler.handle();
                out.println(response);

                // command issuing an exit.
                if (handler instanceof Ende) {
                    cancel = true;
                }

            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                logger.log(Level.SEVERE, "Failed to close the socket", e);

            }
        }
    }

}

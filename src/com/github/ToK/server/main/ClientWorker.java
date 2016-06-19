/*
 * Copyright © 2016 | Time of Kings (ToK) - GameTeam | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.github.ToK.server.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import com.github.ToK.server.Util;
import com.github.ToK.server.command.CommandHandler;
import com.github.ToK.server.command.CommandHandlerFactory;
import com.github.ToK.server.command.Ende;

/**
 * 
 * @author DeathsGun
 *
 */
public class ClientWorker implements Runnable {

    private final Socket socket;
    private String workingDir;

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
    public static String hostAddr;
    public static String local;
    public void run() {

        try {
        	local = InetAddress.getLocalHost().getHostName().toString();
            final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            final PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            InetAddress addr = socket.getInetAddress();
            hostAddr = addr.getHostAddress();
            String socketH = addr.getHostName().toString();
            String ip = Main.RootIP;
            Main.IP = hostAddr;
            if(ip.contains(hostAddr)) {
            	System.out.println("Hallo, Root!");
            	Main.isRoot = true;
            } else {
            	Main.isRoot = false;
            }
            if(local.contains(socketH) || socketH == "localhost") {
            	System.out.println("Hallo, Root!");
            	Main.isRoot = true;
            } else {
            	Main.isRoot = false;
            }
            if(hostAddr.equals("0:0:0:0:0:0:0:1")){
            	Main.isRoot = true;
            } else {
            	Main.isRoot = false;
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
        	System.out.println(e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
            	System.out.println("Failed to close the socket");

            }
        }
    }

}

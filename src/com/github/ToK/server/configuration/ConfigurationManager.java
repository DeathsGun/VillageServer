/*
 * Copyright © 2016 | Time of Kings (ToK) - GameTeam | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.github.ToK.server.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.github.ToK.server.Constants;

/**
 * @author DeathsGun
 * @date Jun 12, 2016
 *
 */
public enum ConfigurationManager {

    INSTANCE;
    private static Properties properties;
    private static boolean FORCE_LOAD_PROPERTIES = Boolean.valueOf(System.getProperty(Constants.FORCE_LOAD))
            .booleanValue();

    /**
     * Maximum number of threads getter.
     * 
     * @return
     */
    public int getMaxThreads() {
        if (FORCE_LOAD_PROPERTIES || properties == null) {
            loadProperties();
        }
        return Integer.valueOf(properties.getProperty(Constants.MAX_THREADS, Constants.DEFAULT_MAX_THREADS));

    }

    /**
     * Port number getter.
     * 
     * @return
     */
    public int getPort() {
        if (FORCE_LOAD_PROPERTIES || properties == null) {
            loadProperties();
        }
        return Integer.valueOf(properties.getProperty(Constants.PORT_NUMBER, Constants.DEFAULT_PORT_NUM));
    }
    public static String getRootIP() {
    	if (FORCE_LOAD_PROPERTIES || properties == null) {
            loadProperties();
        }
        return String.valueOf(properties.getProperty(Constants.ROOT_IP, Constants.ROOT_IP));
    }
    /**
     * Load properties only once
     */
    private static void loadProperties() {

        properties = new Properties();
        final String configPath = System.getProperty(Constants.CONFIG_FILE_ENV_PROPERTY);
        if (configPath != null) {
            try {
            	System.out.println("Loading property file from external: " + configPath);
                properties.load(new FileInputStream(configPath));
            } catch (IOException e) {
            	System.out.println("Failed to load property file from: " + configPath + ". Looking  in classpath.");
                loadFromClassPath();

            }
        } else {
            loadFromClassPath();
        }
    }

    /**
     * Loads property from class path.
     */
    private static void loadFromClassPath() {
        try {
            InputStream in = ClassLoader.getSystemResourceAsStream("server.properties");
            if (in != null) {
            	System.out.println("Loading property file from class path");
                properties.load(in);
            }

        } catch (IOException e) {
        	System.out.println("Failed to load property file from the class path. Default configurations will be used");
        }
    }

}

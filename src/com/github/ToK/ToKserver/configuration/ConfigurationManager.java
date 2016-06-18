/*
 * Copyright © 2016 | Time of Kings (ToK) - GameTeam | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.github.ToK.ToKserver.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

import com.github.ToK.ToKserver.Constants;

/**
 * @author DeathsGun
 * @date Jun 12, 2016
 *
 */
public enum ConfigurationManager {

    INSTANCE;
    private static Properties properties;
    private final static Logger logger = Logger.getLogger(ConfigurationManager.class.getName());
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
    public static int getPort() {
        if (FORCE_LOAD_PROPERTIES || properties == null) {
            loadProperties();
        }
        return Integer.valueOf(properties.getProperty(Constants.PORT_NUMBER, Constants.DEFAULT_PORT_NUM));
    }
    public String getRoot() {
    	if (FORCE_LOAD_PROPERTIES || properties == null) {
            loadProperties();
        }
        return String.valueOf(properties.getProperty(Constants.ROOT_USER, Constants.ROOT_USER));
    }
    public String getRootPass() {
    	if (FORCE_LOAD_PROPERTIES || properties == null) {
            loadProperties();
        }
        return String.valueOf(properties.getProperty(Constants.ROOT_PASS, Constants.ROOT_PASS));
    }

    /**
     * Load properties only once
     */
    private static void loadProperties() {

        properties = new Properties();
        final String configPath = System.getProperty(Constants.CONFIG_FILE_ENV_PROPERTY);
        if (configPath != null) {
            try {
                logger.info("Loading property file from external: " + configPath);
                properties.load(new FileInputStream(configPath));
            } catch (IOException e) {
                logger.warning("Failed to load property file from: " + configPath + ". Looking  in classpath.");
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
                logger.info("Loading property file from class path");
                properties.load(in);
            }

        } catch (IOException e) {
            logger.warning("Failed to load property file from the class path. Default configurations will be used");
        }
    }

}

/*
 * Copyright © 2016 | DeathsGun | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.github.ToK.game.util;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.ProgressMonitorInputStream;

public class Download {
	
	public static void downloadFile(String Url,String output) throws Exception {
        URL url = new URL(Url);
        URLConnection uc = url.openConnection();
        InputStream is = (InputStream) uc.getInputStream();
        ProgressMonitorInputStream pmis = new ProgressMonitorInputStream( null, "Downloading File ...", is );
        pmis.getProgressMonitor().setMaximum( uc.getContentLength() );
        
        FileOutputStream out = new FileOutputStream(output);
        
        byte[] buffer = new byte[1024];
        for( int n; (n = pmis.read(buffer)) != -1; out.write(buffer, 0, n) );
        
        pmis.close();
        out.close();
        }
}

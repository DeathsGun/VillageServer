package com.github.ToK.game.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.swing.ProgressMonitorInputStream;

import com.github.ToK.game.ConsoleInterface;

public class Update {
	/**
	 * Eine Txt mit den Inhalt VERSION=0.3 und URL=http://test.com/Village.jar
	 */
	public static String UPDATE_URL = "http://pastebin.com/raw/tWNpid7m"; // Updated to latest build
	public static double GAME_VERSION = ConsoleInterface.GAME_VERSION;
	public static String Url = "";
	public static String home = "/"+System.getProperty("user.home")+"/"+"Desktop"+"/";
	public static void checkUpdate() throws IOException {
		ArrayList<String> version = WebUtil.getUrlSource(UPDATE_URL);
		for(String s : version) {
			s = s.replaceAll("\\<[^>]*>","").trim();
				if(s.contains("URL")) {
					String[] splitter = s.split("=");
					Url = splitter[1];
				}
				if(s.contains("VERSION")) {
					String[] splitter = s.split("=");
					double availableVersion = Double.parseDouble(splitter[1]);
					if(availableVersion > GAME_VERSION) {
						System.out.println("Update gefunden!");
						System.out.println("Installiere danch wird geschlossen");
						try {
							downloadUpdate();
							ZipUtil.Unzip(new File(home +"Village.jar.zip"), new File(home));
					    } catch (Exception e) {
							System.err.println("Error: "+e);
							System.exit(1);
						}
					} else {
						System.out.println("Kein Update gefunden!");
					}
				}
			}
		}
	public static void downloadUpdate() throws Exception {
        URL url = new URL(Url);
        URLConnection uc = url.openConnection();
        InputStream is = (InputStream) uc.getInputStream();
        ProgressMonitorInputStream pmis = new ProgressMonitorInputStream( null, "Downloading Update ...", is );
        pmis.getProgressMonitor().setMaximum( uc.getContentLength() );
        
        FileOutputStream out = new FileOutputStream(home +"Village.jar.zip");
        
        byte[] buffer = new byte[1024];
        for( int n; (n = pmis.read(buffer)) != -1; out.write(buffer, 0, n) );
        
        pmis.close();
        out.close();
        }
}

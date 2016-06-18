/*
 * Copyright © 2016 | DeathsGun | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.github.ToK.game.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipOutputStream;
 
public class ZipUtil {
 
    /**
     * Unzipt eine Datei
     * @param archiveFile
     * @param destinationDirectory
     */
	public static void Unzip(File archiveFile, File destinationDirectory)
    {
        try
        {
            if (!destinationDirectory.exists())
            {
                destinationDirectory.mkdir();
            }
            String destinationName = destinationDirectory.getAbsolutePath();
            // String destinationname = "d:\\servlet\\testZip\\";
            byte[] buf = new byte[1024];
            ZipInputStream zipInputStream = null;
            ZipEntry zipEntry;
            zipInputStream = new ZipInputStream(new FileInputStream(archiveFile));

            zipEntry = zipInputStream.getNextEntry();
            while (zipEntry != null)
            {
                // for each entry to be extracted
                String entryName = zipEntry.getName();
                System.out.println("entryname: " + entryName);
                File nf = new File(destinationName + "/" + entryName);
                if (entryName.endsWith("/"))
                {
                    nf.mkdir();
                }
                else
                {
                    FileOutputStream fileOutputStream = new FileOutputStream(nf);

                    int n;
                    while ((n = zipInputStream.read(buf, 0, 1024)) > -1)
                        fileOutputStream.write(buf, 0, n);

                    fileOutputStream.close();
                    zipInputStream.closeEntry();
                }
                zipEntry = zipInputStream.getNextEntry();
            }// while

            zipInputStream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
	public static void zipFile(String inFileName, String outFileName){ 
        ZipOutputStream zos = null; 
        FileInputStream fis = null; 
        try { 
            zos = new ZipOutputStream( 
                    new FileOutputStream(outFileName)); 
            fis = new FileInputStream(inFileName); 
            zos.putNextEntry(new ZipEntry(new File(inFileName).getName())); 
            int len; 
            byte[] buffer = new byte[2048]; 
            while ((len = fis.read(buffer, 0, buffer.length)) > 0) { 
                zos.write(buffer, 0, len); 
            } 
        } catch (FileNotFoundException e) { 
            e.printStackTrace(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        }finally{ 
            if(fis != null){ 
                try { 
                    fis.close(); 
                } catch (IOException e) {} 
            } 
            if(zos != null){ 
                try { 
                    zos.closeEntry(); 
                    zos.close(); 
                } catch (IOException e) {} 
            } 
        } 
    }
	
}
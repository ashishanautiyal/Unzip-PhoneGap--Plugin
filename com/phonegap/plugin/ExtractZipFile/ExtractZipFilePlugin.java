/*
    Author: Vishal Rajpal
    Filename: ExtractZipFilePlugin.java
    Created Date: 21-02-2012
    Modified Date: 21-02-2013
    Modified to comply with Cordova by: Ran Friedlender
*/

package com.phonegap.plugin.ExtractZipFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import org.json.JSONArray;
import org.json.JSONException;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;

import android.util.Log;

public class ExtractZipFilePlugin extends CordovaPlugin
{
    @Override
    public boolean execute(String action, final JSONArray args, final CallbackContext callbackContext) throws JSONException
    {
        if (action.equals("unzip"))
        {
            final String filename = args.getString(0); 
            cordova.getThreadPool().execute(new Runnable() {
                public void run() {
                    unzip(filename, callbackContext);
                }
            });

            return true;
        }

        return false;
    }

    private void unzip(String filename, CallbackContext callbackContext)
    {
        File file = new File(filename);
        String[] dirToSplit = filename.split(File.separator);
        String dirToInsert = "";

        for (int i = 0; i < dirToSplit.length - 1; i++)
        {
            dirToInsert += dirToSplit[i] + File.separator;
        }

        BufferedOutputStream dest = null;
        BufferedInputStream is = null;
        ZipEntry entry;
        ZipFile zipfile;

        try
        {
            zipfile = new ZipFile(file);
            Enumeration<? extends ZipEntry> e = zipfile.entries();

            while (e.hasMoreElements()) 
            {
                entry = (ZipEntry)e.nextElement();
                is = new BufferedInputStream(zipfile.getInputStream(entry), 8192);
                int count;
                byte data[] = new byte[102222];
                String fileName = dirToInsert + entry.getName();
                File outFile = new File(fileName);

             
                if (entry.isDirectory()) 
                {
                    outFile.mkdirs();
                } 
                else 
                {
                	 Log.i("filter",fileName+" fine name   .................");
                	String [] checkdir = split(fileName, File.separator);
                	String dir = "";
                	for(int i = 0;i<checkdir.length-1;i++){
                		if(dir.equals("")){
                		dir = checkdir[i];
                		}else{
                			dir = dir +File.separator+checkdir[i];
                		}
                	}
                	 Log.i("filter",dir+" dir   .................");
                	 File outFile1 = new File(dir);
                	 if(!outFile1.exists()){
                		 outFile1.mkdir();
                	 }
                	
                    FileOutputStream fos = new FileOutputStream(outFile);
                    dest = new BufferedOutputStream(fos, 102222);

                    while ((count = is.read(data, 0, 102222)) != -1)
                    {
                        dest.write(data, 0, count);
                    }

                    dest.flush();
                    dest.close();
                    is.close();
                  }
            }
        }
        catch (ZipException e1)
        {
            callbackContext.error(PluginResult.Status.MALFORMED_URL_EXCEPTION.toString());
            return;
        }
        catch (IOException e1)
        {
            callbackContext.error(PluginResult.Status.IO_EXCEPTION.toString()+"io exception check this out"+e1.toString());
            return;
        }

        callbackContext.success(filename);
    }
    public static String[] split(String strString, String strDelimiter)
	{
		int iOccurrences = 0;
		int iIndexOfInnerString = 0;
		int iIndexOfDelimiter = 0;
		int iCounter = 0;

		if (strString == null)
		{
			throw new NullPointerException("Input string cannot be null.");
		}
		
		if (strDelimiter.length() <= 0 || strDelimiter == null)
		{
			throw new NullPointerException("Delimeter cannot be null or empty.");
		}
		if (strString.startsWith(strDelimiter))
		{
			strString = strString.substring(strDelimiter.length());
		}

		
		if (!strString.endsWith(strDelimiter))
		{
			strString += strDelimiter;
		}
		while((iIndexOfDelimiter= strString.indexOf(strDelimiter,iIndexOfInnerString))!=-1)
		{
			iOccurrences += 1;
			iIndexOfInnerString = iIndexOfDelimiter + strDelimiter.length();
		}

		String[] strArray = new String[iOccurrences];

		iIndexOfInnerString = 0;
		iIndexOfDelimiter = 0;

		
		while((iIndexOfDelimiter= strString.indexOf(strDelimiter,iIndexOfInnerString))!=-1)
		{

			strArray[iCounter] = strString.substring(iIndexOfInnerString, iIndexOfDelimiter);
			
			iIndexOfInnerString = iIndexOfDelimiter + strDelimiter.length();

			iCounter += 1;
		}
            return strArray;
	}
}

<<<<<<< HEAD
This is a Unzip plugin of phonegap -2.7.0 .Created by Vishal Rajpal Modified by Ashisha Nautiyal

<b>How to use It:<b>

<b>Java File :</b>Copy   Com Folder inside your Src folder :

<b>JavaScript Function :</b>

function extractFile(fileurl)
{
	 alert("file url is    . "+fileurl); 
	 var ZipClient = new ExtractZipFilePlugin();
     ZipClient.extractFile(fileurl,win,fails);
     return ;
     
     
}
function win(status) 
{ 
   alert('Success in unzip'+status);
   return;
} 
  
function fails(error) 
{ 
    alert(error+"is error");
}

<b>Plugin.xml :</b>

Write This line in Plugin.xml 

<plugin name="ZipPlugin" value="com.phonegap.plugin.ExtractZipFile.ExtractZipFilePlugin" />




Visit my blog 

http://javacourseblog.blogspot.com



#                                Copyright © 2013 Ashisha Nautiyal
=======
Unzip-PhoneGap--Plugin
======================

phonegap Plugin for unzippimg
>>>>>>> 44ce342d7f82389994754d851c06398c66ba4276

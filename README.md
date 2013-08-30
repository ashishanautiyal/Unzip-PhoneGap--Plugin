Unzip-PhoneGap--Plugin
======================

phonegap Plugin for unzippimg



<<<<<<< HEAD
This is a Unzip plugin of phonegap -2.7.0 .Created by Vishal Rajpal Modified by Ashisha Nautiyal

<b>How to use It:<b>

<b>Java File :</b>Copy   Com Folder inside your Src folder :

<b>JavaScript Function :</b>
<code>
function extractFile(fileurl)
{
    console.log("file url is    . "+fileurl);<br />
    var ZipClient = new ExtractZipFilePlugin();<br />
    ZipClient.extractFile(fileurl,win,fails);<br />
     return ;<br />
     }<br />
function win(status) <br />
{ <br />
   alert('Success in unzip'+status);<br />
   return;<br />
} <br />
  <br />
function fails(error) <br />
{ 
    alert(error+"is error");<br />
}<br />
<br />
</code>
<br /><br /><br />
<b>Plugin.xml :</b>
<br /><br />
Write This line in Plugin.xml <br /><br />
<code><br /><br />
<plugin name="ZipPlugin" value="com.phonegap.plugin.ExtractZipFile.ExtractZipFilePlugin" />
</code>

<br /><br /><br /><br />

<B>Visit my blog 

http://javacourseblog.blogspot.com <b>



#                                Copyright © 2013 Ashisha Nautiyal
=======
Unzip-PhoneGap--Plugin
======================

phonegap Plugin for unzippimg


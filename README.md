# Unzip-PhoneGap--Plugin

## Installation


1) Make sure that you have [Node](http://nodejs.org/) and [Cordova CLI](https://github.com/apache/cordova-cli) or [PhoneGap's CLI](https://github.com/mwbrooks/phonegap-cli) or [Cordova Plugman](https://github.com/apache/cordova-plugman/) installed on your machine.

2) Add a plugin to your project using [Cordova CLI](https://github.com/apache/cordova-cli):

```bash
cordova plugin add <this-repo-url>
```

Or using [PhoneGap CLI](https://github.com/mwbrooks/phonegap-cli):

```bash
phonegap local plugin add https://github.com/ashishanautiyal/Unzip-PhoneGap--Plugin.git
```
3) Register plugin within `config.xml` of your app

```xml
<feature name="ExtractZipFile">
    <param name="android-package" value="com.phonegap.plugin.ExtractZipFile.ExtractZipFilePlugin"/>
</feature>
```

4) The `clobber` definition of the plugin is called `extractZipFile`. So you can reference to the plugin from anywhere in your code.

Example:

```js
function extractOK(status)
{
    console.log("extractOK");
}

function extractError(error)
{ 
    console.log("extractError "+error);
}


function extractFile(zipfile)
{
    console.log("Extracting "+ zipfile);
    extractZipFile.unzip(zipfile, extractOK, extractError);
}
```
Visit My blog . http://javacourseblog.blogspot.com for my other article

[Visit My blog for my other article](http://javacourseblog.blogspot.com)

[The Copyright license is here](https://github.com/ashishanautiyal/Unzip-PhoneGap--Plugin/blob/master/license.txt) 

https://github.com/ashishanautiyal/Unzip-PhoneGap--Plugin/blob/master/license.txt

Copyright (c) 2013 Ashish Nautiyal 



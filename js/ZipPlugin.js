/*var ExtractZipFilePlugin=function(){
};

PhoneGap.addConstructor(function() 
{
	PhoneGap.addPlugin('ExtractZipFilePlugin', new ExtractZipFilePlugin());
});

ExtractZipFilePlugin.prototype.extractFile = function(file, successCallback, errorCallback) 
{
    return PhoneGap.exec(successCallback, errorCallback, "ZipPlugin", "extract", [file]);
};*/

/* -----------------------------cordava---------------------------------------  */

/*
    Author: Vishal Rajpal
    Filename: ZipPlugin.js
    Created Date: 21-02-2012
    Modified Date: 21-02-2013
    Modified to comply with Cordova by: Ran Friedlender
*/

var ExtractZipFilePlugin = function()
{
};

ExtractZipFilePlugin.prototype.extractFile = function(file, successCallback, errorCallback) 
{
    cordova.exec(successCallback, errorCallback, "ZipPlugin", "unzip", [file]);
};
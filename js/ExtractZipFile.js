
var exec = require('cordova/exec');

/**
 * Constructor
 */
function ExtractZipFile() {
}

ExtractZipFile.prototype.unzip = function(filename, successCB, failureCB) {
    return exec(successCB, failureCB, 'ExtractZipFilePlugin',  'unzip', new Array(filename));
};

function failureCallback(err) {
    console.log("ExtractZipFile.js failed: " + err);
}


/**
 * Load ExtractZipFile
 */
var extractZipFile = new ExtractZipFile();
module.exports = extractZipFile;



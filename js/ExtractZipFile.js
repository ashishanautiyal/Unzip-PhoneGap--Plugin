
var exec = require('cordova/exec');

/**
 * Constructor
 */
function ExtractZipFile() {
}

ExtractZipFile.prototype.unzip = function(filename, successCB, failureCB) {
    return exec(successCB, failureCB, 'ExtractZipFilePlugin',  'unzip', new Array(filename));
};


/**
 * Load ExtractZipFile
 */
var extractZipFile = new ExtractZipFile();
module.exports = extractZipFile;



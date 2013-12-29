
var exec = require('cordova/exec');

/**
 * Constructor
 */
function ExtractZipFile() {
    this._callback;
}

ExtractZipFile.prototype.unzip = function(filename, cb) {
    this._callback = cb;
    return exec(cb, failureCallback, 'ExtractZipFilePlugin',  'unzip', new Array(filename));
};

function failureCallback(err) {
    console.log("ExtractZipFile.js failed: " + err);
}


/**
 * Load ExtractZipFile
 */
var extractZipFile = new ExtractZipFile();
module.exports = extractZipFile;



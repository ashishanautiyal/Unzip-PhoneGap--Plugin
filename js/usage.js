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

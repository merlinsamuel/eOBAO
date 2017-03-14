#include <InetConstants.au3>


Local $hDownload = InetGet("http://selenium-release.storage.googleapis.com/3.2/selenium-dotnet-3.2.0.zip", "C:\Users\TOMLIN\Desktop\download\file.zip", $INET_FORCERELOAD, $INET_DOWNLOADWAIT)
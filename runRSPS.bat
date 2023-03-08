@echo off
set JDK_PATH=C:\Program Files\zulu\zulu-15\bin\java.exe
set JAR_FILE=Surge-Client-Client.jar
set MAIN_CLASS=net.runelite.client.RuneLite

"%JDK_PATH%" -cp "%JAR_FILE%" "%MAIN_CLASS%" >> output.txt

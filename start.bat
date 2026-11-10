@echo off
rem Startet Schiffe versenken: erst kompilieren, dann ausfuehren.
rem Bei einem Kompilierfehler startet das Spiel nicht, das Fenster bleibt offen.
cd /d "%~dp0"
javac -encoding UTF-8 -d out src\*.java && java -cp out Main
pause

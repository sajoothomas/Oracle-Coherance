@echo off
setlocal

:config
@rem specify the Coherence installation directory
set coherence_home=D:\Oracle\coherence
set java_home=D:\Oracle\jdk1.6.0_20

@rem specify the JVM heap size
set memory=64m


:start
if not exist "%coherence_home%\lib\coherence.jar" goto instructions

if "%java_home%"=="" (set java_exec=java) else (set java_exec=%java_home%\bin\java)


:launch

set java_opts="-Xms%memory% -Xmx%memory% -Dtangosol.coherence.ttl=0 <TODO: Set -D Coherence Cache Location Here>"

"%java_exec%" -server -showversion "%java_opts%" -cp "..\bin;%coherence_home%\lib\coherence.jar" CacheTester %1 %2 %3 %4

goto exit

:instructions

echo Usage:
echo   cachetester.cmd [-s startIndex -f finishIndex]
goto exit

:exit
endlocal
@echo on
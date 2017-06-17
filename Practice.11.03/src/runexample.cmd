@echo off

setlocal
cd /d D:\Oracle\student\practices\Practice.11.03\src

set COHERENCE_CPP_HOME=D:\Oracle\coherence\coherence-cpp
set CONFIG_DIR=..\config
set PATH=%PATH%;%COHERENCE_CPP_HOME%\lib;.
set tangosol.coherence.cacheconfig=%CONFIG_DIR%\extend-cache-config.xml

echo Config File: %tangosol.coherence.cacheconfig%

trade.exe

endlocal

pause
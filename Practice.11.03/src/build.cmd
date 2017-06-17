setlocal

set MODE=%2
set COHERENCE_CPP_HOME=D:\Oracle\coherence\coherence-cpp

if "%INCLUDE%"=="" (
    echo This command must be executed from a Visual Studio command prompt.
    goto exit
  )

set OPT=/c /nologo /EHsc /GR /DWIN32
set LOPT=/NOLOGO /SUBSYSTEM:CONSOLE /INCREMENTAL:NO
set INC=/I%COHERENCE_CPP_HOME%\include /I.
set SRC=*.cpp
set OUT=trade.exe
set LIBPATH=%COHERENCE_CPP_HOME%\lib
set LIBS=%LIBPATH%\coherence.lib

if "%MODE%"=="debug" (
    set OPT=%OPT% /Zi /MDd
    set LIBS=%LIBS%
  ) else (
    set OPT=%OPT% /O2 /MD
    set LIBS=%LIBS%
  )

echo building %OUT% ...
cl %OPT% %INC% %SRC%
link %LOPT% %LIBS% *.obj /OUT:%OUT%
mt -manifest %OUT%.manifest -outputresource:%OUT%;1

del *.obj

:exit

endlocal
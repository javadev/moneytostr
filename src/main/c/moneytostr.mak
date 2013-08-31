.AUTODEPEND

#       *Translator Definitions*
CC = bcc32 +moneytostr.cfg
TASM = TASM
TLIB = tlib
TLINK = ilink32
LIBPATH = C:\Borland\BCC55\Lib
INCLUDEPATH = C:\Borland\BCC55\Include


#       *Implicit Rules*
.c.obj:
  $(CC) -c {$< }

.cpp.obj:
  $(CC) -c {$< }

#       *List Macros*


EXE_dependencies =  \
 moneytostr.obj

#       *Explicit Rules*
moneytostr.exe: moneytostr.cfg $(EXE_dependencies)
  $(TLINK) /t/x/c/P-/L$(LIBPATH) @&&|
c0x32.obj+
moneytostr.obj
moneytostr
        # no map file
cw32.lib+
import32.lib
|


#       *Individual File Dependencies*
moneytostr.obj: moneytostr.cfg moneytostr.c 

#       *Compiler Configuration File*
moneytostr.cfg: moneytostr.mak
  copy &&|
-f-
-Og
-d
-vi-
-wpro
-weas
-wpre
-DWIN32
-I$(INCLUDEPATH)
-L$(LIBPATH)
| moneytostr.cfg

.SUFFIX: .cpp .hpp

# Group Number 12

# Project name
TARGET = cs296_12_exe

# Commands
TAR = tar 
UNTAR = -xzf
CD = cd
MK = mkdir
ECHO = echo
CAT = cat
PRINTF = printf
CC = g++
DOXYGEN = doxygen


# Variables
SHARED_LIB = TRUE
PROJECT_ROOT := $(CURDIR)
EXTERNAL = $(PROJECT_ROOT)/external
SRCDIR = $(PROJECT_ROOT)/src
OBJDIR = $(PROJECT_ROOT)/myobjs
BINDIR = $(PROJECT_ROOT)/mybins
LIBDIR = $(PROJECT_ROOT)/mylibs
EXTSRC = $(EXTERNAL)/src
EXTLIB = $(EXTERNAL)/lib
INCLUDE = $(EXTERNAL)/include
BOX2D_FOLDER = $(INCLUDE)/Box2D
DOCDIR = $(PROJECT_ROOT)/doc

# Run time varibles
SRCS := $(wildcard $(SRCDIR)/*.cpp)
INCS := $(wildcard $(SRCDIR)/*.hpp)
OBJS1 := $(SRCS:$(SRCDIR)/%.cpp=$(OBJDIR)/%.o)
OBJS2 := $(SRCS:$(SRCDIR)/%.cpp=$(OBJDIR)/%.o)
OBJS3 := $(SRCS:$(SRCDIR)/%.cpp=$(OBJDIR)/%.o)
ALL_MAIN:= $(wildcard $(OBJDIR)/*[!main].o)


# Library Paths
BOX2D_ROOT=$(EXTERNAL)
GLUI_ROOT=/usr
GL_ROOT=/usr/include

# Libraries
LIBS = -lBox2D -lglui -lglut -lGLU -lGL

# Compiler and Linker flags
CPPFLAGS1 =-g -O3 -Wall -fno-strict-aliasing
CPPFLAGS2 =-g  -O3 -Wall -fno-strict-aliasing
CPPFLAGS3 =-g  -Wall -fno-strict-aliasing
CPPFLAGS1+=-I $(BOX2D_ROOT)/include -I $(GLUI_ROOT)/include
CPPFLAGS2+=-I $(BOX2D_ROOT)/include -I $(GLUI_ROOT)/include
CPPFLAGS3+=-I $(BOX2D_ROOT)/include -I $(GLUI_ROOT)/include
LDFLAGS+=-L $(BOX2D_ROOT)/lib -L $(GLUI_ROOT)/lib

.PHONY: setup clean doc report distclean distclean2 report debug_prof release_prof

# Default target
helloworld: setup2


setup1:
	@$(ECHO) "setting up compilation now....please wait.."
	@$(MK) -p $(PROJECT_ROOT)/myobjs
	@$(MK) -p $(PROJECT_ROOT)/mylibs
	@$(MK) -p $(PROJECT_ROOT)/mybins
	@if test -d $(BOX2D_FOLDER) -a -d $(EXTLIB)/Box2D -a -e $(EXTLIB)/libBox2D.a;\
	then $(ECHO) "Box 2D found installed";\
	else $(ECHO) "You haven't installed Box2D...Let me do it for you."\
	&& $(CD) $(EXTSRC) \
	&& $(TAR) $(UNTAR) Box2D.tgz \
	&& $(CD) Box2D \
	&& $(MK) -p build296 \
	&& $(CD) build296 \
	&& cmake ../ \
	&& make \
	&& make install \
	&& $(CD) ../../../../;	\
	fi;
	@$(ECHO) "Done"
	
setup2:
	@$(ECHO) "setting up compilation now....please wait.."
	@$(MK) -p $(PROJECT_ROOT)/myobjs
	@$(MK) -p $(PROJECT_ROOT)/mylibs
	@$(MK) -p $(PROJECT_ROOT)/mybins
	@if test -d $(BOX2D_FOLDER) -a -d $(EXTLIB)/Box2D -a -e $(EXTLIB)/libBox2D.a;\
	then $(ECHO) "Box 2D found installed";\
	else $(ECHO) "You haven't installed Box2D...Let me do it for you."\
	&& $(CD) $(EXTSRC) \
	&& $(TAR) $(UNTAR) Box2D.tgz \
	&& $(CD) Box2D \
	&& $(MK) -p build296 \
	&& $(CD) build296 \
	&& cmake -DCMAKE_BUILD_TYPE=Release ../ \
	&& make \
	&& make install \
	&& $(CD) ../../../../;	\
	fi;
	@$(ECHO) "Done"
	
setup3:
	@$(ECHO) "setting up compilation now....please wait.."
	@$(MK) -p $(PROJECT_ROOT)/myobjs
	@$(MK) -p $(PROJECT_ROOT)/mylibs
	@$(MK) -p $(PROJECT_ROOT)/mybins
	@if test -d $(BOX2D_FOLDER) -a -d $(EXTLIB)/Box2D -a -e $(EXTLIB)/libBox2D.a;\
	then $(ECHO) "Box 2D found installed";\
	else $(ECHO) "You haven't installed Box2D...Let me do it for you."\
	&& $(CD) $(EXTSRC) \
	&& $(TAR) $(UNTAR) Box2D.tgz \
	&& $(CD) Box2D \
	&& $(MK) -p build296 \
	&& $(CD) build296 \
	&& cmake -DCMAKE_BUILD_TYPE=Debug ../ \
	&& make \
	&& make install \
	&& $(CD) ../../../../;	\
	fi;
	@$(ECHO) "Done"

-include $(OBJS1:.o=.d)
-include $(OBJS2:.o=.d)
-include $(OBJS3:.o=.d)

#target for compiling .cpp into .o
$(OBJS1):$(OBJDIR)/%.o : $(SRCDIR)/%.cpp
	@$(PRINTF) "Compiling: %25s" "$(notdir $<)"
	@$(CC) $(CPPFLAGS1) -c $< -o $@ -MD 2> temp.log || touch temp.err
	@if test -e temp.err; \
	then $(PRINTF) "%30s\n" "[Fix This Error]" && $(CAT) temp.log; \
	elif test -s temp.log; \
	then $(PRINTF) "%30s\n" "[Just a Warning, You can ignore it]" && $(CAT) temp.log; \
	else $(PRINTF) "%30s\n" "[Complied Without Error]"; \
	fi;
	@$(RM) -f temp.log temp.err
	
$(OBJS2):$(OBJDIR)/%.o : $(SRCDIR)/%.cpp
	@$(PRINTF) "Compiling: %25s" "$(notdir $<)"
	@$(CC) $(CPPFLAGS2) -c $< -o $@ -MD 2> temp.log || touch temp.err
	@if test -e temp.err; \
	then $(PRINTF) "%30s\n" "[Fix This Error]" && $(CAT) temp.log; \
	elif test -s temp.log; \
	then $(PRINTF) "%30s\n" "[Just a Warning, You can ignore it]" && $(CAT) temp.log; \
	else $(PRINTF) "%30s\n" "[Complied Without Error]"; \
	fi;
	@$(RM) -f temp.log temp.err
	
$(OBJS3):$(OBJDIR)/%.o : $(SRCDIR)/%.cpp
	@$(PRINTF) "Compiling: %25s" "$(notdir $<)"
	@$(CC) $(CPPFLAGS3) -c $< -o $@ -MD 2> temp.log || touch temp.err
	@if test -e temp.err; \
	then $(PRINTF) "%30s\n" "[Fix This Error]" && $(CAT) temp.log; \
	elif test -s temp.log; \
	then $(PRINTF) "%30s\n" "[Just a Warning, You can ignore it]" && $(CAT) temp.log; \
	else $(PRINTF) "%30s\n" "[Complied Without Error]"; \
	fi;
	@$(RM) -f temp.log temp.err

exe:setup1 $(OBJS1)
	@$(PRINTF) "Building executable:%16s" "$(notdir $(BINDIR)/$(TARGET))"
	@$(CC) -O3 -o $(BINDIR)/$(TARGET) $(LDFLAGS) $(OBJS1) $(LIBS) 2> temp.log || touch temp.err
	@if test -e temp.err; \
	then $(PRINTF) "%30s\n" "[Fix this Error]" && $(CAT) temp.log; \
	elif test -s temp.log; \
	then $(PRINTF) "%30s\n" "[Just a Warning, You can ignore it]" && $(CAT) temp.log; \
	else $(PRINTF) "%30s\n" "[Executable file made!]"; \
	fi;
	@$(RM) -f temp.log temp.err


exe2: distclean2 setup2 $(OBJS2)
	@$(PRINTF) "Building executable:%16s" "$(notdir $(BINDIR)/$(TARGET))"
	@$(CC)  -O3 -o $(BINDIR)/$(TARGET) $(LDFLAGS) $(OBJS2) $(LIBS) 2> temp.log || touch temp.err
	@if test -e temp.err; \
	then $(PRINTF) "%30s\n" "[Fix this Error]" && $(CAT) temp.log; \
	elif test -s temp.log; \
	then $(PRINTF) "%30s\n" "[Just a Warning, You can ignore it]" && $(CAT) temp.log; \
	else $(PRINTF) "%30s\n" "[Executable file made!]"; \
	fi;
	@$(RM) -f temp.log temp.err

exe3: distclean2 setup3 $(OBJS3)
	@$(PRINTF) "Building executable:%16s" "$(notdir $(BINDIR)/$(TARGET))"
	@$(CC)  -o $(BINDIR)/$(TARGET) $(LDFLAGS) $(OBJS3) $(LIBS) 2> temp.log || touch temp.err
	@if test -e temp.err; \
	then $(PRINTF) "%30s\n" "[Fix this Error]" && $(CAT) temp.log; \
	elif test -s temp.log; \
	then $(PRINTF) "%30s\n" "[Just a Warning, You can ignore it]" && $(CAT) temp.log; \
	else $(PRINTF) "%30s\n" "[Executable file made!]"; \
	fi;
	@$(RM) -f temp.log temp.err
	
release_prof:exe2
	@perf record -g -- ./mybins/cs296_12_exe 10000 
	@mv perf.data g12_release_prof.dat
	
debug_prof:exe3
	@perf record -g -- ./mybins/cs296_12_exe 10000 
	@mv perf.data g12_debug_prof.dat
	
	
doc:
	@$(ECHO) -n "Generating Doxygen Documentation ...  "
	@$(RM) -rf doc/html
	@$(DOXYGEN) $(DOCDIR)/Doxyfile 2 > /dev/null
	@$(ECHO) "Done"


clean: 
	@$(ECHO) "Cleaning up mylibs, mybins, myobjs..."
	@rm -rf $(PROJECT_ROOT)/my* *~ $(DOCDIR)/g12_prof_report.aux $(DOCDIR)/g12_prof_report.pdf $(DOCDIR)/g12_prof_report.dvi $(DOCDIR)/g12_prof_report.bbl $(DOCDIR)/g12_prof_report.blg $(DOCDIR)/g12_prof_report.log
	@rm -rf *.old
	@$(ECHO) "Done"

distclean2:clean
	@$(ECHO) "Now Uninstalling Box2D"
	@rm -rf $(INCLUDE)/* $(EXTLIB)/* $(EXTSRC)/Box2D
	@$(ECHO) "Done"

distclean:clean
	@$(ECHO) "Now Uninstalling Box2D"
	@rm -rf $(INCLUDE)/* $(EXTLIB)/* $(EXTSRC)/Box2D
	@rm -rf *.dat
	@$(ECHO) "Done"


report:
	@cd $(DOCDIR); \
	pdflatex g12_prof_report.tex; \
	

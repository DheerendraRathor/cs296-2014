.SUFFIXES: .java .class

# Programs
SHELL 	= bash
JAVA	= java
JAR		= jar
JAVAC	= javac
ECHO	= echo
MKDIR	= mkdir
RM		= rm
######################################
PACKAGE	= cs296JTalk

BIN		= bin
DOC		= doc
SRC		= src
######################################

.PHONY: compile doc clean

compile :
	@$(ECHO) "Compiling..."
	@$(MKDIR) -p $(BIN)
	@$(JAVAC) -d $(BIN) $(SRC)/*.java $(SRC)/$(PACKAGE)/*.java
	@cd bin; $(JAR) -cfm ../cs296JTalk.jar ../manifest.txt jtalkG12.class $(PACKAGE)/
	@$(ECHO) "Done"

clean :
	@$(ECHO) "Cleaning Up..."
	@$(RM) -rf  *.jar $(BIN)
	@$(ECHO) "Done"

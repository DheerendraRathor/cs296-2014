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
PACKAGE	= cs296JTalk2

BIN		= bin
DOC		= doc
SRC		= src
######################################

.PHONY: compile doc clean

compile :
	@$(ECHO) "Compiling..."
	@$(MKDIR) -p $(BIN)
	@$(MKDIR) -p chatHistory
	@$(JAVAC) -d $(BIN) $(SRC)/*.java $(SRC)/$(PACKAGE)/*.java
	@cd bin; $(JAR) -cfm ../cs296JTalk2.jar ../manifest.mf *.class $(PACKAGE)/*.class
	@$(ECHO) "Done"

clean :
	@$(ECHO) "Cleaning Up..."
	@$(RM) -rf  *.jar $(BIN) chatHistory *.txt
	@$(ECHO) "Done"

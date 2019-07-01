JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	MySqlDatabase.java \
	CheckDatabaseDriverSetup.java \

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
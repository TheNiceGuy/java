JAVAC=javac
JFLAGS=-cp . -encoding utf8 -verbose -deprecation

EXEC=File
PACKAGE=file

all: $(EXEC)

$(EXEC):
	$(JAVAC) $(JFLAGS) *.java

run:
	java -cp .. $(PACKAGE).$(EXEC)

build: $(EXEC)
	jar -cf $(EXEC).jar myApp

clean:
	rm -rf *.class

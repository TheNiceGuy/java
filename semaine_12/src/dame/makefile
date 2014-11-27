JAVAC=javac
JFLAGS=-cp . -encoding utf8 -verbose -deprecation

EXEC=Dame
PACKAGE=dame

all: $(EXEC)

$(EXEC):
	$(JAVAC) $(JFLAGS) *.java

run:
	java -cp .. $(PACKAGE).$(EXEC)

build: $(EXEC)
	jar -cf myJar.jar myApp

clean:
	rm -rf *.class

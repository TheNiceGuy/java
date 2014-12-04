JAVAC=javac
JFLAGS=-cp . -encoding utf8 -verbose -deprecation

EXEC=Dame
PACKAGE=dame

all: $(EXEC)

$(EXEC):
	$(JAVAC) $(JFLAGS) $(PACKAGE)/*.java

run: build
	java -jar $(EXEC).jar

build: $(EXEC)
	jar -cfvm $(EXEC).jar manifest $(PACKAGE)/*.class resources/*

clean:
	rm -rf *.class

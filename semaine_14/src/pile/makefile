JAVAC=javac
JFLAGS=-cp . -encoding utf8 -verbose -deprecation

EXEC=Pile
PACKAGE=pile

all: $(EXEC)

$(EXEC):
	$(JAVAC) $(JFLAGS) $(PACKAGE)/*.java

run: build
	java -jar $(EXEC).jar

build: $(EXEC)
	jar -cfvm $(EXEC).jar manifest $(PACKAGE)/*.class

clean:
	rm -rf *.class

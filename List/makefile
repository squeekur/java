# April Dawn Kester
# akester
# CMPS 12M
# August 12, 2013
# compiles, utilities
# makefile
# No special instructions

# Variables
ADSRC	= README makefile
SOURCES    = List.java ListInterface.java ListClient.java\
             ListIndexOutOfBoundsException.java
MAINCLASS  = ListClient
CLASSES    = List.class ListInterface.class ListClient.class List\$$Node.class\
             ListIndexOutOfBoundsException.class
JARFILE    = ListClient
SUBMIT     = submit cmps012b-pt.u13 lab6

# Build Targets
all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest
	chmod +x $(JARFILE)

$(CLASSES): $(SOURCES)
	javac -Xlint:all,-serial $(SOURCES)  

clean:
	rm -f $(CLASSES) $(JARFILE) 

submit: ${SOURCES}
	${SUBMIT} ${SOURCES} $(ADSRC)

diff:
	diff out model-out
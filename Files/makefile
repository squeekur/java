# April Dawn Kester
# akester
# CMPS 12M
# July 7, 2013
# utilities
# makefile
# No special instructions


# A simple makefile with macros
JAVASRC    = FileReverse.java
SOURCES    = README makefile ${JAVASRC}
MAINCLASS  = FileReverse
CLASSES    = FileReverse.class
JARFILE    = FileReverse
JARCLASSES = ${CLASSES}
SUBMIT     = submit cmps012b-pt.u13 lab2

all: ${JARFILE}

${JARFILE}: ${CLASSES}
	echo Main-class: ${MAINCLASS} > Manifest 
	jar cvfm ${JARFILE} Manifest ${JARCLASSES} 
	rm Manifest
	chmod +x ${JARFILE}

${CLASSES}: ${JAVASRC}
	javac -Xlint ${JAVASRC}

clean:
	rm ${CLASSES} ${JARFILE}

submit: ${SOURCES}
	${SUBMIT} ${SOURCES}

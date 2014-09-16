# April Dawn Kester
# akester
# CMPS 12B
# July 1, 2013
# Creates JARFILE, compiles, submits
# makefile for pa1
# No special instructions


# A simple makefile with macros
JAVASRC    = Extrema.java
SOURCES    = README makefile ${JAVASRC}
MAINCLASS  = Extrema
CLASSES    = Extrema.class
JARFILE    = Extrema
JARCLASSES = ${CLASSES}
SUBMIT     = submit cmps012b-pt.u13 pa1

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

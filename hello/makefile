#April Dawn Kester
#akester
#CMPS 12M
#June 26, 2013
#compiles
#makefile
#No special instructions


# A simple makefile with macros
JAVASRC    = hello.java hello2.java
SOURCES    = README makefile ${JAVASRC}
MAINCLASS  = hello2
CLASSES    = hello.class hello2.class
JARFILE    = myHello
JARCLASSES = ${CLASSES}
SUBMIT     = submit cmps012b-pt.u13 lab1

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

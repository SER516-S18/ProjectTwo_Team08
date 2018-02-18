# if this doesn't work, modify the JAVAC and JAVA variables with the actual 
# path for javac and java on your machine. These can be found in the JDK
# installation location.
# Need to figure out why adding external jars to classpath is not working

JAVAC = javac
JAVA  = java
LIB = ./lib/jcommon-1.0.23.jar:./lib/jfreechart-1.0.19;

server:
	cd src/SER516_Lab2_Server; $(JAVAC) UIComponents/*.java *.java; cd ..;  $(JAVA) SER516_Lab2_Server/ServerMain;


client:
	cd src/SER516_Lab2_Client; $(JAVAC) -classpath "$(LIB)" *.java; cd ..; $(JAVA) SER516_Lab2_Client/ClientMain;

clean:
	find . -type f -name '*.class' -exec rm {} +

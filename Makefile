# if this doesn't work, modify the JAVAC and JAVA variables with the actual 
# path for javac and java on your machine. These can be found in the JDK
# installation location.

JAVAC = javac
JAVA  = java

server:
	cd src/SER516_Lab2_Server; $(JAVAC) UIComponents/*.java *.java; cd ..;  $(JAVA) SER516_Lab2_Server/ServerMain;


client:
	cd src/SER516_Lab2_Client; $(JAVAC) *.java; cd ..; $(JAVA) SER516_Lab2_Client/ClientMain;

clean:
	find . -type f -name '*.class' -exec rm {} +

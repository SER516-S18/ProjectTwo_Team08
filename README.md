# ProjectTwo_Team08

How to run

For Windows

1. clone project repository by running the following command.
	```
	git clone https://github.com/SER516/ProjectTwo_Team08.git
    ```
2. Run server.Run the following command.
	```
    cd ProjectTwo_Team08\src
   	javac SER516_Lab2_Server\*.java SER516_Lab2_Server\UIComponents\*.java 
   	java SER516_Lab2_Server.ServerMain
    ```
3. Run client. Run the following command.
	```
	cd ProjectTwo_Team08\src
	javac -cp ../lib/jfreechart-1.0.19.jar;../lib/jcommon-1.0.23.jar SER516_Lab2_Client\UIComponents\*.java SER516_Lab2_Client\*.java
    java -cp ../lib/jfreechart-1.0.19.jar;../lib/jcommon-1.0.23.jar;. SER516_Lab2_Client.ClientMain
    ```
    
For Ubuntu

1. clone project repository by running the following command.
	```
	git clone https://github.com/SER516/ProjectTwo_Team08.git
    ```
    
2. Run server.Run the following command.
	```
    cd ProjectTwo_Team08/src
    javac SER516_Lab2_Server/*.java SER516_Lab2_Server/UIComponents/*.java 
    java SER516_Lab2_Server.ServerMain
    ```
    
3. Run client. Run the following command.
	```
	cd ProjectTwo_Team08/src
    javac -cp ../lib/jfreechart-1.0.19.jar:../lib/jcommon-1.0.23.jar SER516_Lab2_Client/UIComponents/*.java SER516_Lab2_Client/*.java
    java -cp ../lib/jfreechart-1.0.19.jar:../lib/jcommon-1.0.23.jar:. SER516_Lab2_Client.ClientMain
    ```
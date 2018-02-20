package SER516_Lab2_Server;

import java.io.IOException;
import java.util.Map;

public class ServerControl {

    private ServerThread serverThread;

    public ServerThread getServerThread() {
        return serverThread;
    }

    /**
    * @param inputValues
    */
    public void start(Map inputValues)
    {
        serverThread = new ServerThread(Consts.PORT_NUMBER, inputValues);
        new Thread(serverThread).start();
    }

    public void stop()
    {
        try {
            serverThread.serverSocket.close();
        } catch (Exception e) {
            System.out.println("Server Stopped");
        }
    }
}

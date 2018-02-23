package SER516_Lab2_Server;

import java.io.IOException;
import java.util.Map;

/**
 * @author Balachandar Sampath #97
 * @version 0.1
 * @since February 17, 2018
 *
 * This class implements the stop and start functionality of server thread
 */

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

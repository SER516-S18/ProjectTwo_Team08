package SER516_Lab2_Server;

import java.io.IOException;

public class ServerControl {

    private ServerThread serverThread;

    public void start()
    {
        serverThread = new ServerThread(Consts.PORT_NUMBER);
        new Thread(serverThread).start();
    }

    public void stop()
    {
        try {
            serverThread.serverSocket.close();
        } catch (IOException e) {
            System.out.println("Server Stopped");
        }
    }
}

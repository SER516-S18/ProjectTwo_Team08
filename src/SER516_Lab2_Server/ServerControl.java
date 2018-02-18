package SER516_Lab2_Server;

import java.io.IOException;

public class ServerControl {

    private ServerThread serverThread;

    public ServerThread getServerThread() {
        return serverThread;
    }

    public void start()
    {
        serverThread = new ServerThread(Consts.PORT_NUMBER);
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

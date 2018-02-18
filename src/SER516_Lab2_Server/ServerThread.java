package SER516_Lab2_Server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread implements Runnable {
    private int localPort;
    public Boolean isStopped;
    public ServerSocket serverSocket;
    private Socket clientSocket;
    private InputStream inputStream;
    private OutputStream outputStream;

    ServerThread(int localPort)
    {
        this.localPort = localPort;
        this.isStopped = false;
    }

    @Override
    public void run() {
        try{
            serverSocket = new ServerSocket(localPort);
            System.out.println("Server Started");
            while (!isStopped && serverSocket.isBound() && !serverSocket.isClosed())
            {
               clientSocket = serverSocket.accept();
               inputStream = clientSocket.getInputStream();
               outputStream = clientSocket.getOutputStream();
               outputStream.write("Hello From Server".getBytes());
            }
            serverSocket.close();
            System.out.println("Server Stopped");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {

        }
    }
}

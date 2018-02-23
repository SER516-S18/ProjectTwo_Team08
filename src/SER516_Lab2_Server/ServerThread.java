package SER516_Lab2_Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Map;

/**
 * @author Balachandar Sampath #97
 * @version 0.2
 * @since February 17, 2018
 *
 * This class implements establishing socket connection with client and communicating with the client
 */
public class ServerThread implements Runnable {
    private int localPort;
    public ServerSocket serverSocket;
    private Socket clientSocket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    public int channels;
    public NumberGenerator numberGenerator;
    public Map inputValues;

    /**
     * Constructor
     * @param localPort
     * @param inputValues
     */
    ServerThread(int localPort, Map inputValues)
    {
        this.localPort = localPort;
        this.inputValues = inputValues;
    }

    /**
     * Creates a server and accepts client socket connection. This function reads channel from client and calls number generator
     * to generate random numbers and sends to client
     */
    @Override
    public void run() {
        try{
            serverSocket = new ServerSocket(localPort);
            System.out.println("Server Started");
            System.out.println("This server is running on Port: "+Consts.PORT_NUMBER+".");
            while (serverSocket.isBound() && !serverSocket.isClosed())
            {
                clientSocket = serverSocket.accept();
                inputStream = clientSocket.getInputStream();
                outputStream = clientSocket.getOutputStream();
                dataInputStream = new DataInputStream(inputStream);
                dataOutputStream = new DataOutputStream(outputStream);

                numberGenerator = new NumberGenerator(dataOutputStream, serverSocket);
                numberGenerator.setHigh((int)inputValues.get("high"));
                numberGenerator.setLow((int)inputValues.get("low"));
                numberGenerator.setFrequency((int)inputValues.get("frequency"));

                while(true) {
                    boolean isClientClosed = false;
                    try {
                        String val = dataInputStream.readUTF();
                        try {
                            channels = Integer.parseInt(val);
                            System.out.println("Number of Channels:" + channels);
                            numberGenerator.setChannels(channels);
                            numberGenerator.Start();
                        }
                        catch (NumberFormatException e)
                        {
                            System.out.println("Warning: Client is allowed to input number only for channels");
                        }
                    }
                    catch (SocketException | EOFException e)
                    {
                        isClientClosed = true;
                        System.out.println("Client Connection closed");
                        numberGenerator.numberTimer.stop();
                    }
                    if(isClientClosed)
                        break;
                }
            }

            serverSocket.close();
            numberGenerator.Stop();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Server Stopped");
        }
    }
}

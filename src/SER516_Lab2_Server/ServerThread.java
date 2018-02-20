package SER516_Lab2_Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Map;

/**
 * Establishes socket connection with client and runs the server
 * @author Balachandar Sampath
 * @version 1.1
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
 //   public Stats stats;
    public NumberGenerator numberGenerator;
    public Map inputValues;


// This class was written with the intention what if we want to change the frequency in the middle of conversation with server
  /*  private class Stats
    {
        public int frequency;
        public int highestValue;
        public int lowestValue;

        public Stats(int frequency,int highestValue,int lowestValue)
        {
            this.frequency = frequency;
            this.highestValue = highestValue;
            this.lowestValue = lowestValue;
        }
    }
    public void changeFrequency(int frequency)
    {
        this.stats.frequency = frequency;
    }
    public void changeHighestValue(int highestValue)
    {
        this.stats.highestValue = highestValue;
    }
    public void changeLowestValue(int lowestValue)
    {
        this.stats.lowestValue = lowestValue;
    }*/
    ServerThread(int localPort, Map inputValues)
    {
        this.localPort = localPort;
        this.inputValues = inputValues;
    }

    @Override
    public void run() {
        try{
            //Initialise hardcoded stats which can be later updated by event listener from UI
         //   stats = new Stats(5,1,10);
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

                       channels = Integer.parseInt(val);
                       System.out.println("Number of Channels:" + channels);
                       numberGenerator.setChannels(channels);
                       numberGenerator.Start();
                   }
                   catch (SocketException e)
                   {
                       isClientClosed = true;
                       System.out.println("Client Connection closed");
                       numberGenerator.numberTimer.stop();
                   }
                    if(isClientClosed)
                   break;
                  //  sendData();
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
        finally {

        }
    }
}

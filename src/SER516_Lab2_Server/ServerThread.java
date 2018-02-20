package SER516_Lab2_Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

/**
 * Author Balachandar Sampath
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
    public Stats stats;
    public NumberGenerator numberGenerator;
    public Map inputValues;
   /* private class Channels
    {
        int channel;
        public Channels(int channel)
        {
            this.channel=channel;
        }
    }*/


    private class Stats
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
    }
    ServerThread(int localPort, Map inputValues)
    {
        this.localPort = localPort;
        this.inputValues = inputValues;
    }

    @Override
    public void run() {
        try{
            //Initialise hardcoded stats which can be later updated by event listener from UI
            stats = new Stats(5,1,10);
            serverSocket = new ServerSocket(localPort);
            System.out.println("Server Started");
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

               //byte[] channels = new byte[500];
                while(true) {
                    String val = dataInputStream.readUTF();
                    channels = Integer.parseInt(val);
                    System.out.println(channels);
                    numberGenerator.setChannels(channels);
                    numberGenerator.Start();
                  //  sendData();
                }
            }
            serverSocket.close();
            numberGenerator.Stop();
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

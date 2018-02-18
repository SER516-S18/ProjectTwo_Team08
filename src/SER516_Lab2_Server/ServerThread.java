package SER516_Lab2_Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

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
    private Timer numberGeneratetimer = new Timer(1000, null);
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
    ServerThread(int localPort)
    {
        this.localPort = localPort;
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
               //byte[] channels = new byte[500];
                while(true) {
                    String val = dataInputStream.readUTF();
                    channels = Integer.parseInt(val);
                    System.out.println(channels);
                    generateNumbersForOutput();
               //     System.out.println("Here is frequency"+stats.frequency);
                  //  sendData();
                }
            }
            serverSocket.close();
            System.out.println("Server Stopped");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            numberGeneratetimer.stop();
        }
        finally {

        }
    }
    
    /**
    * Generates a set of random numbers in the range of the high and low numbers 
    * recieved through the "stats" object. It fires every 1/frequency seconds, and outputs the string to 
    * the client. The set size depends on the initial channels recieved from the client.
    * 
    * @author Jason Rice
    * @version 1.0
    *
    */
    private void generateNumbersForOutput(){
        ActionListener numbersActionListener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent eve){
                if(!serverSocket.isClosed() && serverSocket.isBound()){
                    String outPut = "";

                    for(int i = 0; i < channels; i++){
                        outPut += (int)(Math.random() * ((stats.highestValue + 1) - stats.lowestValue)
                            + stats.lowestValue);

                        if(i < (channels-1)){
                            outPut += ",";
                        }
                    }
                    try{
                        dataOutputStream.writeUTF(outPut);
                    } catch(Exception e){
                        e.printStackTrace();
                        numberGeneratetimer.stop();
                    }
                }
            } 
        }; 
        numberGeneratetimer = new Timer((int)(1000/stats.frequency), numbersActionListener);
        numberGeneratetimer.start();
    }
}

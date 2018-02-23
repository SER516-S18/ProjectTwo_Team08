package SER516_Lab2_Server;

import java.io.DataOutputStream;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.net.ServerSocket;
/**
* Class for generating the numbers based o 
* @author Jason Rice
* @version 1.0
*/
public class NumberGenerator{
    DataOutputStream dataOutputStream;
    ServerSocket serverSocket;
    int high, low, frequency, channels;
    public Timer numberTimer = new Timer(1000, null);

    /**
    * Constructor
    * @param dataOutputStream
    * @param serverSocket
    */
    public NumberGenerator(DataOutputStream dataOutputStream, ServerSocket serverSocket){
        this.dataOutputStream = dataOutputStream;
        this.serverSocket = serverSocket;
    }

    /**
    * Starts the number generator
    */
    public void Start(){
        if(dataOutputStream != null){
            generateNumbersForOutput();
        } else {
            ServerUtils.displayConsoleMessage("NumberGenerator(ln35): No DataOutputStream");
        }
    }

    /**
    * Stops the number generator
    */
    public void Stop(){
        numberTimer.stop();
    }

    /**
    * Generates a set of random numbers in the range of the high and low numbers 
    * recieved through the class. It fires every 1/frequency seconds and outputs the string to 
    * the client. The set size depends on the initial channels recieved from the client.
    */
    private void generateNumbersForOutput(){
        ActionListener numbersActionListener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent eve){
                String outPut = "";

                for(int i = 0; i < channels; i++){
                    outPut += (int)((Math.random() * (high - low)) + low);

                    if(i < (channels-1)){
                        outPut += ",";
                    }
                }

                if(serverSocket.isClosed()){
                    numberTimer.stop();
                }

                try{
                    dataOutputStream.writeUTF(outPut);
                } catch(Exception e){
                    String errorMessage = "Client connection closed.";
                    ServerUtils.displayConsoleMessage(errorMessage);
                    numberTimer.stop();
                } 
            } 
        }; 
        numberTimer = new Timer((int)(1000/frequency), numbersActionListener);
        numberTimer.start();
    }

    /**
    * Sets the number of channels, which controls how many numbers the generator will create at a time.
    * @param channels
    */
    public void setChannels(int channels){
        this.channels = channels;
    }

    /**
    * Sets the High value
    * @param high
    */
    public void setHigh(int high){
        this.high = high + 1;
    }

    /**
    * Sets the Low value
    * @param low
    */
    public void setLow(int low){
        this.low = low;
    }

    /**
    * Sets the Frequency value
    * @param frequency
    */
    public void setFrequency(int frequency){
        this.frequency = frequency;
    }
}
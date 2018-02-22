package SER516_Lab2_Client;

import java.io.*;
import java.net.Socket;

/**
* @author Ayan Shah
* Client thread to write data to the server socket
* */

public class ClientThread implements Runnable {

    final String hostName = "localhost";
    final int portNumber = Consts.PORT_NUMBER;
    private InputStream inputStream;
    private OutputStream outputStream;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private String channels;
    private String frequency;
    private SendChannelNumber sendChannelNumber;


    public ClientThread(String frequency, String channels){
        this.frequency = frequency;
        this.channels = channels;
    }


    @Override
    public void run() {
        try {
            Socket clientSocket = new Socket(hostName,portNumber);
            outputStream = clientSocket.getOutputStream();
            inputStream = clientSocket.getInputStream();
            dataInputStream = new DataInputStream(inputStream);
            dataOutputStream = new DataOutputStream(outputStream);

            sendChannelNumber = new SendChannelNumber(dataOutputStream, channels);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

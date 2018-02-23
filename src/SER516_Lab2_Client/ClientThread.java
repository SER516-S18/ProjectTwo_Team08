package SER516_Lab2_Client;

import SER516_Lab2_Client.UIComponents.ControlsPanel;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

/**
* @author Shaunak Shah
* Client thread to write data to the server socket
* */

public class ClientThread implements Runnable {

    final String hostName = "localhost";
    final int portNumber = Consts.PORT_NUMBER;
    private InputStream inputStream;
    private OutputStream outputStream;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    public Socket clientSocket;
    private int channelCount;
    private int frequency;


    public ClientThread(int channelCount, int frequency){

        this.channelCount = channelCount;
        this.frequency = frequency;
    }

    @Override
    public void run() {
        try {
            clientSocket = new Socket(hostName,portNumber);
            outputStream = clientSocket.getOutputStream();
            inputStream = clientSocket.getInputStream();
            dataInputStream = new DataInputStream(inputStream);
            dataOutputStream = new DataOutputStream(outputStream);
            sendChannelNumber(dataOutputStream);

            while(true){
                boolean isClientClosed = false;
                try{
                    String data = dataInputStream.readUTF();
                    Handlers.getInstance().updateUI(data);
                    System.out.println(data);
                }catch (SocketException e){
                    isClientClosed = true;
                    dataInputStream.close();
                    System.out.println("Client Connection closed");
                }
                if(isClientClosed)
                    break;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendChannelNumber(DataOutputStream outputStream) {
        try {
            outputStream.writeUTF(Integer.toString(channelCount));
        } catch (Exception e) {
            System.out.println("Unable to send channel value to the stream");
        }
    }

}

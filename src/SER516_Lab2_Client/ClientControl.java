package SER516_Lab2_Client;


import SER516_Lab2_Client.UIComponents.ControlsPanel;

import java.io.IOException;

/**
 * @author Ayan Shah
 * Client control class to start/stop the connection for the client socket to the server socket
 * */


public class ClientControl {

    private ClientThread clientThread;
    private Thread runClientThread;
    public Thread getClientThread(){
        return runClientThread;
    }

    public void start(int channelCount, int frequency){
        clientThread = new ClientThread(channelCount, frequency);
        new Thread(clientThread).start();
    }

    public void stop(){
        try {
            System.out.println("Close socket");
            clientThread.clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

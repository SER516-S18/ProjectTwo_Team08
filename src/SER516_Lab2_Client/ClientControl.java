package SER516_Lab2_Client;


import java.io.IOException;

/**
 * @author Ayan Shah
 * Client control class to start/stop the connection for the client socket to the server socket
 * */


public class ClientControl {

    private ClientThread clientThread;

    public ClientThread getClientThread(){
        return clientThread;
    }

    public void start(String frequency, String channels){
        clientThread = new ClientThread(frequency,channels);
        new Thread(clientThread).start();
    }

    public void stop(){
        try {
            clientThread.clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

package SER516_Lab2_Client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Chiranjeevi Ramamurthy cramamu1 1213037941 Team 8 ID 93
 * @version 0.1
 * @since February 17, 2018
 *
 * This file contains class definition for reading datastream
 * from the server at user defined frequency intervals.
 */

public class ReadDataStream {
    void clientReadData(String readFrequency, String readChannelCount)
    {
        String hostname = "localhost";
        int port = 1516;
        while(true)
        {
            try
            {
                InetAddress address = InetAddress.getByName(hostname);
                DatagramSocket socket = new DatagramSocket();

                byte[] buffer = new byte[1];
                buffer[0]=Byte.parseByte(readChannelCount);

                DatagramPacket requestBroadcast =
                        new DatagramPacket(buffer,1,address,port);
                socket.send(requestBroadcast);

                byte[] receivedData = new byte[512];
                DatagramPacket receiveResponse =
                        new DatagramPacket(receivedData,receivedData.length);
                socket.receive(receiveResponse);

                String incomingData =
                        new String(receiveResponse.getData(),
                                0, receiveResponse.getLength());

                //two calls
                //average , high, low
                //plot the graph

                Thread.sleep(1000/Integer.parseInt(readFrequency));
            }
            catch (Exception caught)
            {
                caught.printStackTrace();
            }
        }
    }
}

package SER516_Lab2_Client;

import javax.swing.*;
import java.io.DataOutputStream;

/**
 *
 * @author Shaunak Shah
 * @version 1.0
 * Reads channel from the GUI and sends it to the server
 */

public class SendChannelNumber {

    DataOutputStream dataOutputStream;
    final int defaultChannels = 1;
    private int channelValue;

    public SendChannelNumber(DataOutputStream dataOutputStream, String channels) {
        this.dataOutputStream = dataOutputStream;
        setChannelNumber(channels);
        sendChannelNumber(dataOutputStream);
    }

    private void setChannelNumber(String channels) {
        channelValue = defaultChannels;
        if (channels != "") {
            try {
                channelValue = Integer.parseInt(channels);
            } catch (Exception e) {
                System.out.println("Non-integer value entered for frequency, default used.");
            }
        }
    }

    private void sendChannelNumber(DataOutputStream outputStream) {
        try {
            System.out.println("Sending Channel number- " + channelValue);
            outputStream.writeUTF("" + channelValue);
        } catch (Exception e) {
            System.out.println("Unable to send channel value to the stream");
        }
    }

}

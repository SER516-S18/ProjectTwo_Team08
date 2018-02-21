package SER516_Lab2_Client;

import java.util.swing.*;

/**
 * Reads frequency from the GUI
 * @author nishitisawant
 * @version 1.0
 */

public class ReadFrequency{

    final int defaultFrequency = 1;

    /**
     * Takes input field for frequency from GUI and returns it if valid, or returns default value
     * @param frequency
     */

    public getInputFrequency(JTextPane frequency){

        frequencyValue = defaultFrequency;
        if(textPane.getText() != ""){
            try{
                frequencyValue = Integer.parseInt(textpane.getText());
            } catch(Exception e){
                System.out.println("Non-integer value entered for frequency, default used.");
            }
        }

        return frequencyValue;
    }

}

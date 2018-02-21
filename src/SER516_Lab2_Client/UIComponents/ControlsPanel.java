package SER516_Lab2_Client.UIComponents;

import SER516_Lab2_Client.*;

import javax.swing.*;
import java.awt.*;

public class ControlsPanel extends JPanel{

    private TextPane highestValue;
    private TextPane lowestValue;
    private TextPane averageValue;
    private TextPane frequency;
    private JComboBox<String> channels;

    public ControlsPanel(){

        initComponents();
    }

    private void initComponents(){

        setLayout(new GridLayout(0,2,10,10));

        TextPane hvLabel = new TextPane("Highest\r\nValue:", Consts.DEFAULT_FONT, Consts.LIGHTBLUE,true, false);
        TextPane lvLabel = new TextPane("Lowest\r\nValue:", Consts.DEFAULT_FONT, Consts.LIGHTBLUE,true, false);
        TextPane avgLabel = new TextPane("Average\r\nValue:", Consts.DEFAULT_FONT, Consts.LIGHTBLUE,true, false);
        TextPane chLabel = new TextPane("Channels:", Consts.DEFAULT_FONT, Consts.LIGHTBLUE,true, false);
        TextPane fqLabel = new TextPane("Frequency (HZ):", Consts.DEFAULT_FONT, Consts.LIGHTBLUE,true, false);

        highestValue = new TextPane("", Consts.DEFAULT_FONT, Consts.PINK,true, false);
        lowestValue = new TextPane("", Consts.DEFAULT_FONT, Consts.PINK,true, false);
        averageValue = new TextPane("", Consts.DEFAULT_FONT, Consts.PINK,true, false);
        channels = createChannelsComboBox();
        frequency = new TextPane("", Consts.DEFAULT_FONT, Consts.PINK,true, true);

        add(hvLabel);
        add(highestValue);
        add(lvLabel);
        add(lowestValue);
        add(avgLabel);
        add(averageValue);
        add(chLabel);
        add(channels);
        add(fqLabel);
        add(frequency);

        Handlers.setContolPanel(this);
    }


    private JComboBox<String> createChannelsComboBox(){
        JComboBox<String> noOfChannels = new JComboBox<String>();
        noOfChannels.setFont(Consts.DEFAULT_FONT);
        noOfChannels.setModel(new DefaultComboBoxModel<String>(Consts.CHANNELS));
        noOfChannels.setBackground(Consts.PINK);
        noOfChannels.setBorder(BorderFactory.createLineBorder(Color.black));
        return noOfChannels;
    }

    public String getChannels(){
        return channels.getSelectedItem().toString();
    }

    public String getFrequency(){
        return frequency.getText();
    }

    public void setHighestValue(String value){
        highestValue.setText(value);
    }

    public void setLowestValue(String value){
        lowestValue.setText(value);
    }

    public void setAverageValue(String value){
        averageValue.setText(value);
    }
}

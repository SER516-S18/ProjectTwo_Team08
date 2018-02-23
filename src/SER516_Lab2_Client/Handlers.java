package SER516_Lab2_Client;

import SER516_Lab2_Client.UIComponents.ChartPanel;
import SER516_Lab2_Client.UIComponents.ConsolePanel;
import SER516_Lab2_Client.UIComponents.ControlsPanel;

import javax.swing.*;
import java.awt.*;

public class Handlers {

    private static Handlers instance = null;

    public static Handlers getInstance(){

        if(instance == null)
            instance = new Handlers();

        return instance;
    }

    private ControlsPanel controlPanel;
    private ChartPanel chartPanel;
    private ConsolePanel consolePanel;
    private boolean flag;
    private ClientControl clientControl;

    private Handlers(){
        this.flag = false;
    }

    public void setContolPanel(JPanel panel){
        controlPanel = (ControlsPanel)panel;
    }

    public void setChartPanel(JPanel panel){
        chartPanel = (ChartPanel)panel;
    }

    public void setConsolePanel(JPanel panel){
        consolePanel = (ConsolePanel)panel;
    }

    /**
     * @author Ayan Shah
     * Client start/stop button control method
     * */

    public void clientStartStop(){

        if(!flag){
            this.flag = true;
            clientControl = new ClientControl();
            int channels;
            int frequency;
            try {
                channels = Integer.parseInt(controlPanel.getChannels());
                frequency = Integer.parseInt(controlPanel.getFrequency());
            }
            catch (NumberFormatException e){
                e.printStackTrace();
                return;
            }
            System.out.println("Channel- "+channels);
            System.out.println("Client start");
            clientControl.start(channels, frequency);
            chartPanel.initChart(channels, frequency);
        }else{
            clientControl.stop();
            this.flag = false;
        }
    }

    public void updateUI(String inputString){

        if("".equals(inputString)) return;

        String[] splitInputs = inputString.split(",");

        int[] inputVals = new int[splitInputs.length];

        for(int i= 0; i< splitInputs.length; i++){
            inputVals[i] = Integer.parseInt(splitInputs[i]);
        }


        controlPanel.setHighestValue(Integer.toString(Stats.computeMax(inputVals)));
        controlPanel.setLowestValue(Integer.toString(Stats.computeMin(inputVals)));
        controlPanel.setAverageValue(Float.toString(Stats.computeAverage(inputVals)));

        chartPanel.plotPoints(inputVals);
    }


}

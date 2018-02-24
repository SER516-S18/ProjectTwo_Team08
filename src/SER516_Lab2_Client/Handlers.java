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
    private int[] data;

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
                this.flag = false;
                return;
            }
            System.out.println("Channel- "+channels);
            System.out.println("Client start");
            clientControl.start(channels, frequency);
            chartPanel.initChart(channels, frequency);
            controlPanel.setEnabled(!flag);
        }else{
            clientControl.stop();
            this.flag = false;
            controlPanel.setEnabled(!flag);
        }
    }

    public void updateUI(String inputString) {

        if (!"".equals(inputString)){
            String[] splitInputs = inputString.split(",");

            int[] inputVals = new int[splitInputs.length];

            for (int i = 0; i < splitInputs.length; i++) {
                inputVals[i] = Integer.parseInt(splitInputs[i]);
            }
            data = inputVals;

            controlPanel.setHighestValue(Integer.toString(Stats.computeMax(data)));
            controlPanel.setLowestValue(Integer.toString(Stats.computeMin(data)));
            controlPanel.setAverageValue(Float.toString(Stats.computeAverage(data)));
        }

        if(data == null) return;

        chartPanel.plotPoints(data);
    }
}

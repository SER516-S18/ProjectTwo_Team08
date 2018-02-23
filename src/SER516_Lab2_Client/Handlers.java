package SER516_Lab2_Client;

import SER516_Lab2_Client.UIComponents.ChartPanel;
import SER516_Lab2_Client.UIComponents.ConsolePanel;
import SER516_Lab2_Client.UIComponents.ControlsPanel;

import javax.swing.*;

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
        flag = false;
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
            clientControl = new ClientControl();
            String channels = controlPanel.getChannels();
            System.out.println("Channel- "+channels);
            String frequency = controlPanel.getFrequency();
            System.out.println("Client start");
            clientControl.start(frequency, channels);
            chartPanel.initChart(Integer.parseInt(channels), Integer.parseInt(frequency));
            flag = true;

        }else{
            clientControl.stop();
            flag = false;
        }
    }

}

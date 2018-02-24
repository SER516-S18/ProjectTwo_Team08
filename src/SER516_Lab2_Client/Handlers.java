package SER516_Lab2_Client;

import SER516_Lab2_Client.UIComponents.ChartPanel;
import SER516_Lab2_Client.UIComponents.ConsolePanel;
import SER516_Lab2_Client.UIComponents.ControlsPanel;


import javax.swing.*;
import java.io.IOException;


/**
 * This class is a singleton and it servers as a controller between UI and functionality
 *
 * @author Ejaz Saifudeen
 * @author Ayan Shah
 * @author Vaishak Ramesh Vellore
 * @version 1.0
 * @since February 20, 2018
 */
public class Handlers {

    private static Handlers instance = null;

    /**
     * Returns an instance of the class
     *
     * @return Handlers
     */
    public static Handlers getInstance() {

        if (instance == null)
            instance = new Handlers();

        return instance;
    }

    private ControlsPanel controlPanel;
    private ChartPanel chartPanel;
    private ConsolePanel consolePanel;
    private boolean flag;
    private int[] data;
    private Thread runClientThread;
    private ClientThread clientThread;

    private Handlers() {
        this.flag = false;
    }

    /**
     * Sets control-panel for later use
     *
     * @param panel
     */
    public void setControlPanel(JPanel panel) {
        controlPanel = (ControlsPanel) panel;
    }

    /**
     * Sets chart-panel for later use
     *
     * @param panel
     */
    public void setChartPanel(JPanel panel) {
        chartPanel = (ChartPanel) panel;
    }

    /**
     * Sets console-panel for later use
     *
     * @param panel
     */
    public void setConsolePanel(JPanel panel) {
        consolePanel = (ConsolePanel) panel;
    }
    
    /**
     * Dispays message on the console
     */
    
    public void displayConsoleMessage(String errorMessage)
    {
        consolePanel.updateConsole(errorMessage + "\n");
    }

    /**
     * Client start/stop button control method to initiate client thread for message passing,
     * and initiate chartView.
     */

    public void clientStartStop() {

        if (!flag || !runClientThread.isAlive()) {
            this.flag = true;

            int channels;
            int frequency;
            try {
                channels = Integer.parseInt(controlPanel.getChannels());
                frequency = Integer.parseInt(controlPanel.getFrequency());
            } catch (NumberFormatException e) {
                e.printStackTrace();
                this.flag = false;
                return;
            }
            chartPanel.initChart(channels, frequency);
            clientThread = new ClientThread(channels, frequency);
            runClientThread = new Thread(clientThread);
            runClientThread.start();



        } else if (runClientThread.isAlive()) {
            this.flag = false;
            this.data = null;
            clientThread.close();
        }
    }

    /**
     * Update the client display view based on the data sent by the server,
     * which contains highest, lowest, average value and continuous
     * data for the chart.
     *
     * @param inputString comma-separated data received from server
     */
    public void updateUI(String inputString) {

        if (!"".equals(inputString)) {
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

        if (data == null) return;

        chartPanel.plotPoints(data);
    }
}

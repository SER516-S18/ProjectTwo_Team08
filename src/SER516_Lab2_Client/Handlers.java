package SER516_Lab2_Client;

import SER516_Lab2_Client.UIComponents.ChartPanel;
import SER516_Lab2_Client.UIComponents.ConsolePanel;
import SER516_Lab2_Client.UIComponents.ControlsPanel;

import javax.swing.*;
import java.io.IOException;




public class Handlers {

    private static Handlers instance = null;


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

    public void setControlPanel(JPanel panel) {
        controlPanel = (ControlsPanel) panel;
    }

    public void setChartPanel(JPanel panel) {
        chartPanel = (ChartPanel) panel;
    }

    public void setConsolePanel(JPanel panel) {
        consolePanel = (ConsolePanel) panel;
    }

    /**
     * @author Ayan Shah
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

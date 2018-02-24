package SER516_Lab2_Client.UIComponents;

import SER516_Lab2_Client.Consts;
import SER516_Lab2_Client.Handlers;
import SER516_Lab2_Client.TimeChart;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * To initialize the chart in the center panel
 *
 * @author Ejaz Saifudeen #96
 * @version 0.1
 * @since February 17, 2018
 */

public class ChartPanel extends JPanel {

    private TimeChart chart;

    public ChartPanel(){
        setLayout(new BorderLayout());
        setBackground(Consts.PINK);
        setBorder(new LineBorder(Color.black));
        setPreferredSize(new Dimension(400,400));
        Handlers.getInstance().setChartPanel(this);
    }

 /**
 * Function to plot the points on the chart
 * @param channelCount, frequency
 */ 
    public void initChart(int channelCount, int frequency){

        removeAll();
        chart = new TimeChart(channelCount,frequency);
        add(chart);
        revalidate();
        repaint();
    }

 /**
 * Function to plot the points on the chart
 * @param values
 */
    public void plotPoints(int[] values){

        chart.plotPoints(values);
    }
}

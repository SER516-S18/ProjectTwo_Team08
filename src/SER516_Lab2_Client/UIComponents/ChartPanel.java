package SER516_Lab2_Client.UIComponents;

import SER516_Lab2_Client.Consts;
import SER516_Lab2_Client.Handlers;
import SER516_Lab2_Client.TimeChart;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * To initialize the chart in the center panel
 */

public class ChartPanel extends JPanel {

    private TimeChart chart;

    public ChartPanel(){
        setLayout(new BorderLayout());
        setBackground(Consts.PINK);
        setBorder(new LineBorder(Color.black));
        setPreferredSize(new Dimension(750,300));
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

package SER516_Lab2_Client;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * This class creates a JFree chart and plots values against current time.
 *
 * @author Ejaz Saifudeen #96
 * @version 0.1
 * @since February 17, 2018
 */
public class TimeChart extends JPanel{

    int channelCount;
    int frequency;
    TimeSeries[] series;
    ChartPanel chartPanel;

    public TimeChart(int channelCount, int frequency) {
        this.channelCount = channelCount;
        this.frequency = frequency;
        series = new TimeSeries[channelCount];
        JFreeChart chart = createChart();
        chartPanel = new ChartPanel(chart);
        chartPanel.setMouseZoomable(true , false);
        chartPanel.addComponentListener(new ChartSizeListener());
        this.setLayout(new BorderLayout());
        this.add(chartPanel, BorderLayout.CENTER);

    }

    /**
     * This is the only public method in the class.
     * It is used to plot values against current time.
     *
     * @param values array of values, array length must be equal to channel count
     */
    public void plotPoints(int[] values){

        Millisecond current = new Millisecond();
        for(int i = 0; i < channelCount; i++){
            series[i].addOrUpdate(current, values[i]);
        }
    }

    /**
     * This method initializes time series for each channel and adds
     * them to a data-set. This will serve as the data-set for the chart.
     *
     * @return XYDataset
     */
    private XYDataset createDataset( ) {

        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        for(int i = 0; i < channelCount; i++){
            series[i] = new TimeSeries("Channel "+(i+1));
            timeSeriesCollection.addSeries(series[i]);
        }
        return timeSeriesCollection;
    }

    /**
     * This method set the maximum number of visible plot. This is to ensure
     * that the chart doesn't get cluttered over time.
     *
     * @param maxPlots
     */
    private void setMaximumPlots(int maxPlots){

        int maxItemAge = (1000/frequency)*maxPlots;

        for(int i = 0; i < channelCount; i++){
            series[i].setMaximumItemAge(maxItemAge);
        }
    }

    /**
     * This method create the JFree chart and return it.
     *
     * @return JFreeChart
     */
    private JFreeChart createChart() {

        XYDataset dataset = createDataset( );

        return ChartFactory.createTimeSeriesChart(
                "",
                "Time",
                "Value",
                dataset,
                true,
                false,
                false);
    }

    /**
     * Private class that listens for chart resized event.
     * Maximum number of visible plots are calculated based on the width of the chart.
     */
    private class ChartSizeListener extends ComponentAdapter  {

        public void componentResized(ComponentEvent ev) {

            int maxPlots = chartPanel.getWidth()/15;
            setMaximumPlots(maxPlots);
        }
    }

}

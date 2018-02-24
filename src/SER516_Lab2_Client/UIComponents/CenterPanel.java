package SER516_Lab2_Client.UIComponents;

import javax.swing.*;
import java.awt.*;

/**
 * Function initializes the center panel and divides them into three sections.
 */

public class CenterPanel extends JPanel {

    public CenterPanel(){
        setLayout(new BorderLayout());
        JPanel nestedPanel = new JPanel();
        ChartPanel chartPanel = new ChartPanel();
        ControlsPanel controlsPanel = new ControlsPanel();

        setBackground(SystemColor.controlHighlight);
        nestedPanel.setLayout(new BorderLayout(10,10));
        nestedPanel.add(chartPanel, BorderLayout.CENTER);
        nestedPanel.add(controlsPanel, BorderLayout.EAST);

        nestedPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        add(nestedPanel, BorderLayout.CENTER);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
}

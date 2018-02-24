package SER516_Lab2_Client.UIComponents;

import javax.swing.*;
import java.awt.*;
import SER516_Lab2_Client.*;

 /**
 * To initialize the console panel
 */

public class ConsolePanel extends JPanel{

    private TextPane consoleTextPane;
    private JScrollBar scrollBar;

    public ConsolePanel() {
        setLayout(new BorderLayout(0,0));

        TextPane consoleHeader = new TextPane("Console:", Consts.DEFAULT_FONT, SystemColor.controlHighlight, false, false);
        consoleTextPane = new TextPane("", Consts.DEFAULT_FONT, SystemColor.controlHighlight, false, false);
        JScrollPane scrollPane = new JScrollPane(consoleTextPane);
        scrollPane.setPreferredSize(new Dimension(300,150));
        scrollBar = scrollPane.getVerticalScrollBar();
        add(consoleHeader, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.SOUTH);
        setBorder(BorderFactory.createLineBorder(Color.black));

        Handlers.getInstance().setConsolePanel(this);
    }

    public void updateConsole(String message){
        consoleTextPane.setText(consoleTextPane.getText()+message+"\n");
        scrollBar.setValue(scrollBar.getMaximum());
    }
}

package SER516_Lab2_Client.UIComponents;

import javax.swing.*;
import java.awt.*;
import SER516_Lab2_Client.*;

 /**
 * To initialize the console panel
 */

public class ConsolePanel extends JPanel{

    private TextPane consoleTextPane;

    public ConsolePanel() {
        setLayout(new BorderLayout(0,0));

        TextPane consoleHeader = new TextPane("Console:", Consts.DEFAULT_FONT, SystemColor.controlHighlight, false, false);
        consoleTextPane = new TextPane("", Consts.DEFAULT_FONT, SystemColor.controlHighlight, false, false);
        consoleTextPane.setPreferredSize(150,80);

        add(consoleHeader, BorderLayout.NORTH);
        add(consoleTextPane, BorderLayout.CENTER);
        setBorder(BorderFactory.createLineBorder(Color.black));

        Handlers.getInstance().setConsolePanel(this);
    }
}

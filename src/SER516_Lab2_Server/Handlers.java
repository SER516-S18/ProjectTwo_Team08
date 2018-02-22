package SER516_Lab2_Server;

import javax.swing.JPanel;

/**
 * @author Vaishak Ramesh Vellore
 * @date 02/22/2018
 * @description Handlers on server-side application to control GUI component which indicates
 *  server status, console and control status for SER516/ProjectTwo_Team08.
*/

public class Handlers {

    private static JPanel controlPanel;
    private static JPanel serverStatusPanel;
    private static JPanel consolePanel;
    

    public static void setContolPanel(JPanel panel){
        controlPanel = panel;
    }

    public static void setserverStatusPanel(JPanel panel){
    	serverStatusPanel = panel;
    }

    public static void setConsolePanel(JPanel panel){
        consolePanel = panel;
    }
}
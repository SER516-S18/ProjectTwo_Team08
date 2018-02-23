package SER516_Lab2_Server;

import javax.swing.JPanel;

/**
 * @author Vaishak Ramesh Vellore
 * @date 02/22/2018
 * @description Handlers on server-side application to control GUI component which indicates
 *  server status for SER516/ProjectTwo_Team08.
 *  
*/

public class Handlers {
	
	private static Handlers instance = null;

    public static Handlers getInstance(){

        if(instance == null)
            instance = new Handlers();

        return instance;
    }

    private static ServerStatusPanel serverStatusPanel;

    public static void setserverStatusPanel(JPanel panel){
    	serverStatusPanel = (ServerStatusPanel)panel;
    }

}
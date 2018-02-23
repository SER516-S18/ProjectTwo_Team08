package SER516_Lab2_Client.UIComponents;

import javax.swing.*;
import java.awt.*;
import SER516_Lab2_Client.*;

/**
 * @author Vaishak Ramesh Vellore
 * @date 02/22/2018
 * @description controller on client side application to throw any runtime 
 * messages to the console designed in GUI.
 *  
*/
public class UpdateConsole {
	private TextPane consoleTextPane;
	public void ConsolePanel() {

		updateConsole();
    }
	
	public void updateConsole(String text){
        consoleTextPane.appendText(text);
    }
}

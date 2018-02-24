package SER516_Lab2_Client.UIComponents;

import SER516_Lab2_Client.Consts;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import SER516_Lab2_Client.Consts;
import javax.swing.BorderFactory;

/**
 * Function initializes the main panel and divides them into three sections.
 * @author Aayushi Shah
 * @version 1.1
 */

public class ClientUI extends JFrame {

	public ClientUI() {
		JPanel mainPanel = new JPanel();
		setTitle("Client");
		mainPanel.setLayout(new BorderLayout(20, 20));
		mainPanel.setBackground(Consts.BLUE);

		TopPanel topPanel = new TopPanel();
		CenterPanel centerPanel = new CenterPanel();
		ConsolePanel consolePanel = new ConsolePanel();
		
		topPanel.setBackground(Consts.BLUE);
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(consolePanel, BorderLayout.SOUTH);
		
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.setContentPane(mainPanel);
	}
}

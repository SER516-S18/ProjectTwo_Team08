package SER516_Lab2_Client.UIComponents;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;

public class ClientUI extends JFrame {

	public ClientUI() {
		initComponents();
	}

	private void initComponents() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(20, 20));

		TopPanel topPanel = new TopPanel();
		CenterPanel centerPanel = new CenterPanel();
		ConsolePanel consolePanel = new ConsolePanel();

		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(consolePanel, BorderLayout.SOUTH);
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.setContentPane(mainPanel);
	}
}

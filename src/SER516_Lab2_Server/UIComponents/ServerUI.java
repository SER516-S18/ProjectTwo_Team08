package SER516_Lab2_Server.UIComponents;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;

public class ServerUI {

	private JFrame serverFrame;
	private final Color BLUE = new Color(207, 220, 239);
	private final Color LIGHTBLUE = new Color(228, 232, 241);
	private final Color PINK = new Color(237, 219, 219);


	/**
	 * Create the application.
	 */
	public ServerUI() {
		initialize();
		serverFrame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		serverFrame = new JFrame();
		serverFrame.setFont(new Font("Monospaced", Font.PLAIN, 16));
		serverFrame.setTitle("Server");
		serverFrame.getContentPane().setBackground(this.BLUE);
		serverFrame.setBounds(300, 300, 789, 674);
		serverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		serverFrame.getContentPane().setLayout(null);
		
		JButton btnStartStop = new JButton("Start / Stop");
		btnStartStop.setBackground(this.PINK);
		btnStartStop.setFont(new Font("Monospaced", Font.PLAIN, 18));
		btnStartStop.setBounds(580, 16, 172, 41);
		btnStartStop.setBorder(BorderFactory.createLineBorder(Color.black));
		serverFrame.getContentPane().add(btnStartStop);
		
		JTextPane consoleTextPane = new JTextPane();
		consoleTextPane.setFont(new Font("Monospaced", Font.PLAIN, 20));
		consoleTextPane.setText("Console:");
		consoleTextPane.setEditable(false);
		consoleTextPane.setBackground(SystemColor.controlHighlight);
		consoleTextPane.setBounds(15, 512, 743, 90);
		consoleTextPane.setBorder(BorderFactory.createLineBorder(Color.black));
		serverFrame.getContentPane().add(consoleTextPane);
		
		JPanel viewPanel = new JPanel();
		viewPanel.setBackground(SystemColor.controlHighlight);
		viewPanel.setBounds(15, 65, 743, 431);
		viewPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		serverFrame.getContentPane().add(viewPanel);
		viewPanel.setLayout(null);
		
		JPanel serverInstantiatedPanel = new JPanel();
		serverInstantiatedPanel.setBounds(28, 16, 413, 399);
		serverInstantiatedPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		viewPanel.add(serverInstantiatedPanel);
		serverInstantiatedPanel.setBackground(this.PINK);
		
		/*JTextPane txtpnHighest = new JTextPane();
		txtpnHighest.setBounds(456, 16, 129, 62);
		panel_1.add(txtpnHighest);
		txtpnHighest.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtpnHighest.setEditable(false);
		txtpnHighest.setBackground(this.LIGHTBLUE);
		txtpnHighest.setBorder(BorderFactory.createLineBorder(Color.black));
		txtpnHighest.setText(" Highest\r\n Value:");*/
		
		JLabel highestValLabel = new JLabel("<html> Highest<br> Value:</html>");
		highestValLabel.setVerticalAlignment(SwingConstants.TOP);
		highestValLabel.setFont(new Font("Monospaced", Font.PLAIN, 18));
		highestValLabel.setBounds(456, 16, 129, 62);
		highestValLabel.setBackground(this.LIGHTBLUE);
		highestValLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		viewPanel.add(highestValLabel);
		
		JTextPane highestValText = new JTextPane();
		highestValText.setBounds(600, 16, 129, 62);
		viewPanel.add(highestValText);
		highestValText.setBackground(this.PINK);
		highestValText.setEditable(false);
		highestValText.setBorder(BorderFactory.createLineBorder(Color.black));
		
		/*JTextPane txtpnLowestValue = new JTextPane();
		txtpnLowestValue.setText(" Lowest\r\n Value:");
		txtpnLowestValue.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtpnLowestValue.setEditable(false);
		txtpnLowestValue.setBackground(this.LIGHTBLUE);
		txtpnLowestValue.setBounds(456, 94, 129, 62);
		txtpnLowestValue.setBorder(BorderFactory.createLineBorder(Color.black));
		panel_1.add(txtpnLowestValue);*/
		
		JLabel lowestValLabel = new JLabel("<html> Lowest<br> Value:</html>");
		lowestValLabel.setVerticalAlignment(SwingConstants.TOP);
		lowestValLabel.setFont(new Font("Monospaced", Font.PLAIN, 18));
		lowestValLabel.setBounds(456, 94, 129, 62);
		lowestValLabel.setBackground(this.LIGHTBLUE);
		lowestValLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		viewPanel.add(lowestValLabel);
		
		JTextPane lowestValText = new JTextPane();
		lowestValText.setEditable(false);
		lowestValText.setBackground(this.PINK);
		lowestValText.setBounds(600, 94, 129, 62);
		lowestValText.setBorder(BorderFactory.createLineBorder(Color.black));
		viewPanel.add(lowestValText);
		
		/*JTextPane txtpnFrequencyhz = new JTextPane();
		txtpnFrequencyhz.setText(" Frequency\r\n (Hz):");
		txtpnFrequencyhz.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtpnFrequencyhz.setEditable(false);
		txtpnFrequencyhz.setBackground(this.LIGHTBLUE);
		txtpnFrequencyhz.setBounds(456, 172, 129, 62);
		txtpnFrequencyhz.setBorder(BorderFactory.createLineBorder(Color.black));
		panel_1.add(txtpnFrequencyhz);*/
		
		JLabel frequencyLabel = new JLabel("<html> Frequency<br> (Hz):</html>");
		frequencyLabel.setVerticalAlignment(SwingConstants.TOP);
		frequencyLabel.setFont(new Font("Monospaced", Font.PLAIN, 18));
		frequencyLabel.setBounds(456, 172, 129, 62);
		frequencyLabel.setBackground(this.LIGHTBLUE);
		frequencyLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		viewPanel.add(frequencyLabel);
		
		JTextPane frequencyText = new JTextPane();
		frequencyText.setEditable(false);
		frequencyText.setBackground(this.PINK);
		frequencyText.setBounds(600, 172, 129, 62);
		frequencyText.setBorder(BorderFactory.createLineBorder(Color.black));
		viewPanel.add(frequencyText);
		
	}
}

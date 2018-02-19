package SER516_Lab2_Client.UIComponents;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

/**
 * @SER516 Lab2_Team08
 * @author Aayushi Shah
 * @Version 1.0
 */

public class ClientUI {

	private JFrame frmServer;
	private final Color BLUE = new Color(207, 220, 239);
	private final Color LIGHTBLUE = new Color(228, 232, 241);
	private final Color PINK = new Color(237, 219, 219);
	private final Color GRAY = new Color(221, 221, 221);


	/**
	 * Create the application.
	 */
	public ClientUI() {

		initialize();
		frmServer.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmServer = new JFrame();
		frmServer.setFont(new Font("Monospaced", Font.PLAIN, 16));
		frmServer.setTitle("Client\r\n");
		frmServer.getContentPane().setBackground(this.BLUE);
		frmServer.setBounds(300, 300, 789, 674);
		frmServer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmServer.getContentPane().setLayout(null);
		
		JButton btnStartStop = new JButton("Start / Stop");
		btnStartStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnStartStop.setBackground(this.PINK);
		btnStartStop.setFont(new Font("Monospaced", Font.PLAIN, 18));
		btnStartStop.setBounds(586, 8, 172, 41);
		btnStartStop.setBorder(BorderFactory.createLineBorder(Color.black));
		frmServer.getContentPane().add(btnStartStop);
		
		JTextPane txtpnConsole = new JTextPane();
		txtpnConsole.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtpnConsole.setText(" Console:");
		txtpnConsole.setEditable(false);
		txtpnConsole.setBackground(SystemColor.controlHighlight);
		txtpnConsole.setBounds(15, 509, 743, 90);
		txtpnConsole.setBorder(BorderFactory.createLineBorder(Color.black));
		frmServer.getContentPane().add(txtpnConsole);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(15, 65, 743, 433);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		frmServer.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(28, 16, 413, 399);
		panel1.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.add(panel1);
		panel1.setBackground(this.PINK);
		
		JTextPane txtHighestValue = new JTextPane();
		txtHighestValue.setBounds(456, 16, 129, 62);
		panel.add(txtHighestValue);
		txtHighestValue.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtHighestValue.setEditable(false);
		txtHighestValue.setBackground(this.LIGHTBLUE);
		txtHighestValue.setBorder(BorderFactory.createLineBorder(Color.black));
		txtHighestValue.setText(" Highest\r\n Value:");
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(600, 16, 129, 62);
		panel.add(textPane);
		textPane.setBackground(this.PINK);
		textPane.setEditable(false);
		textPane.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JTextPane txtLowestValue = new JTextPane();
		txtLowestValue.setText(" Lowest\r\n Value:");
		txtLowestValue.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtLowestValue.setEditable(false);
		txtLowestValue.setBackground(this.LIGHTBLUE);
		txtLowestValue.setBounds(456, 94, 129, 62);
		txtLowestValue.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.add(txtLowestValue);
		
		JTextPane textPane1 = new JTextPane();
		textPane1.setEditable(false);
		textPane1.setBackground(this.PINK);
		textPane1.setBounds(600, 94, 129, 62);
		textPane1.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.add(textPane1);
		
		JTextPane txtAverageValue = new JTextPane();
		txtAverageValue.setText(" Average:");
		txtAverageValue.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtAverageValue.setEditable(false);
		txtAverageValue.setBorder(BorderFactory.createLineBorder(Color.black));
		txtAverageValue.setBackground(new Color(228, 232, 241));
		txtAverageValue.setBounds(456, 170, 129, 62);
		panel.add(txtAverageValue);
		
		JTextPane textPane2 = new JTextPane();
		textPane2.setEditable(false);
		textPane2.setBorder(BorderFactory.createLineBorder(Color.black));
		textPane2.setBackground(new Color(237, 219, 219));
		textPane2.setBounds(600, 170, 129, 62);
		panel.add(textPane2);
		
		JTextPane txtpnChannels = new JTextPane();
		txtpnChannels.setText(" Channels:");
		txtpnChannels.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtpnChannels.setEditable(false);
		txtpnChannels.setBorder(BorderFactory.createLineBorder(Color.black));
		txtpnChannels.setBackground(new Color(228, 232, 241));
		txtpnChannels.setBounds(456, 243, 129, 62);
		panel.add(txtpnChannels);
		
		JTextPane txtFrequencyValue = new JTextPane();
		txtFrequencyValue.setText(" Frequency\r\n (Hz):");
		txtFrequencyValue.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtFrequencyValue.setEditable(false);
		txtFrequencyValue.setBackground(this.LIGHTBLUE);
		txtFrequencyValue.setBounds(456, 322, 129, 62);
		txtFrequencyValue.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.add(txtFrequencyValue);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setEditable(false);
		textPane_4.setBackground(this.PINK);
		textPane_4.setBounds(600, 322, 129, 62);
		textPane_4.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.add(textPane_4);
		
		JComboBox<String> noOfChannels = new JComboBox<String>();
		noOfChannels.setFont(new Font("Monospaced", Font.PLAIN, 18));
		noOfChannels.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		noOfChannels.setBounds(600, 257, 129, 20);
		noOfChannels.setBackground(this.PINK);
		noOfChannels.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.add(noOfChannels);
	}
}
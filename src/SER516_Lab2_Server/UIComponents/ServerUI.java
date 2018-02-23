package SER516_Lab2_Server.UIComponents;

import SER516_Lab2_Server.ServerControl;
import SER516_Lab2_Server.ServerThread;
import SER516_Lab2_Server.InputFieldExtractor;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import java.util.Map;

public class ServerUI extends JFrame {

	private JFrame serverFrame;
	private JPanel serverInstantiatedPanel;
	private JPanel viewPanel;
	private JTextPane highestValText;
	private JTextPane lowestValText;
	private JTextPane frequencyText;
	private boolean FLAG = false;
	private final Color BLUE = new Color(207, 220, 239);
	private final Color LIGHTBLUE = new Color(228, 232, 241);
	private final Color PINK = new Color(237, 219, 219);
	private ServerControl serverControl;
	private ServerThread serverThread;

	/** 
	 * Author: Rhythm Sharma
	 * 
	 * Initializes the contents of the frame.
	 */
	public ServerUI() {
		serverControl = new ServerControl();
		intializeServerFrame();
		initializeStartStopBtn();
		initializeConsoleTextPane();
		initializeViewPanel();
	}

	/**
	 * Author: Rhythm Sharma 
	 * Function initializes view panel objects 
	 */
	private void initializeViewPanelObjects() {
		serverInstantiatedPanel = new JPanel();
		serverInstantiatedPanel.setBounds(28, 16, 413, 399);
		serverInstantiatedPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		viewPanel.add(serverInstantiatedPanel);
		serverInstantiatedPanel.setBackground(Color.RED);

		JLabel highestValLabel = new JLabel("<html>&nbsp;Highest<br>&nbsp;Value:</html>");
		highestValLabel.setVerticalAlignment(SwingConstants.TOP);
		highestValLabel.setFont(new Font("Monospaced", Font.PLAIN, 18));
		highestValLabel.setBounds(456, 16, 129, 62);
		highestValLabel.setOpaque(true);
		highestValLabel.setBackground(this.LIGHTBLUE);
		highestValLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		viewPanel.add(highestValLabel);

		highestValText = new JTextPane();
		highestValText.setBounds(600, 16, 129, 62);
		viewPanel.add(highestValText);
		highestValText.setBackground(this.PINK);
		highestValText.setEditable(true);
		highestValText.setBorder(BorderFactory.createLineBorder(Color.black));

		JLabel lowestValLabel = new JLabel("<html>&nbsp;Lowest<br>&nbsp;Value:</html>");
		lowestValLabel.setVerticalAlignment(SwingConstants.TOP);
		lowestValLabel.setFont(new Font("Monospaced", Font.PLAIN, 18));
		lowestValLabel.setBounds(456, 94, 129, 62);
		lowestValLabel.setOpaque(true);
		lowestValLabel.setBackground(this.PINK);
		lowestValLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		viewPanel.add(lowestValLabel);

		lowestValText = new JTextPane();
		lowestValText.setEditable(true);
		lowestValText.setBackground(this.LIGHTBLUE);
		lowestValText.setBounds(600, 94, 129, 62);
		lowestValText.setBorder(BorderFactory.createLineBorder(Color.black));
		viewPanel.add(lowestValText);

		JLabel frequencyLabel = new JLabel("<html>&nbsp;Frequency<br>&nbsp;(Hz):</html>");
		frequencyLabel.setVerticalAlignment(SwingConstants.TOP);
		frequencyLabel.setFont(new Font("Monospaced", Font.PLAIN, 18));
		frequencyLabel.setBounds(456, 172, 129, 62);
		frequencyLabel.setOpaque(true);
		frequencyLabel.setBackground(this.LIGHTBLUE);
		frequencyLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		viewPanel.add(frequencyLabel);

		frequencyText = new JTextPane();
		frequencyText.setEditable(true);
		frequencyText.setBackground(this.PINK);
		frequencyText.setBounds(600, 172, 129, 62);
		frequencyText.setBorder(BorderFactory.createLineBorder(Color.black));
		viewPanel.add(frequencyText);
	}

	/**
	 * Author: Rhythm Sharma 
	 * Function initializes view panel and sets its objects and attributes 
	 */
	private void initializeViewPanel() {
		viewPanel = new JPanel();
		viewPanel.setBackground(SystemColor.controlHighlight);
		viewPanel.setBounds(15, 65, 743, 431);
		viewPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		serverFrame.getContentPane().add(viewPanel);
		viewPanel.setLayout(null);
		initializeViewPanelObjects();
	}

	/**
	 * Author: Rhythm Sharma 
	 * Function initializes console panel and sets the attributes 
	 */
	private void initializeConsoleTextPane() {
		JTextPane consoleTextPane = new JTextPane();
		consoleTextPane.setFont(new Font("Monospaced", Font.PLAIN, 20));
		consoleTextPane.setText("Console:");
		consoleTextPane.setEditable(false);
		consoleTextPane.setBackground(SystemColor.controlHighlight);
		consoleTextPane.setBounds(15, 512, 743, 90);
		consoleTextPane.setBorder(BorderFactory.createLineBorder(Color.black));
		serverFrame.getContentPane().add(consoleTextPane);
	}

	/**
	 * Author: Rhythm Sharma 
	 * Function initializes Start/ Stop button and sets its attributes 
	 */
	private void initializeStartStopBtn() {
		JButton btnStartStop = new JButton("Start / Stop");
		btnStartStop.setBackground(this.PINK);
		btnStartStop.setFont(new Font("Monospaced", Font.PLAIN, 18));
		btnStartStop.setBounds(580, 16, 172, 41);
		btnStartStop.setBorder(BorderFactory.createLineBorder(Color.black));
		serverFrame.getContentPane().add(btnStartStop);

		btnStartStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				serverStartStop(FLAG);
			}
		});
	}
	
	/**
	 * Author: Rhythm Sharma 
	 * Function initializes server frame and sets the attributes 
	 */
	private void intializeServerFrame() {
		serverFrame = new JFrame();
		serverFrame.setFont(new Font("Monospaced", Font.PLAIN, 16));
		serverFrame.setTitle("Server");
		serverFrame.getContentPane().setBackground(this.BLUE);
		serverFrame.setBounds(300, 300, 789, 674);
		serverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		serverFrame.getContentPane().setLayout(null);
		serverFrame.setVisible(true);
	}

	/**
	 * Author Akash Sharma Function to Start/Stop Server and Update Server Status
	 * 
	 * @param FLAG
	 */

	public void serverStartStop(boolean FLAG) {

		if (!FLAG) {
			InputFieldExtractor ife = new InputFieldExtractor();
			Map<String, Integer> inputValues = ife.getInputValues(highestValText, lowestValText, frequencyText);
			serverControl.start(inputValues);
			serverThread = serverControl.getServerThread();
			this.FLAG = true;
			this.serverInstantiatedPanel.setBackground(Color.GREEN);
		} else {
			serverControl.stop();
			this.FLAG = false;
			this.serverInstantiatedPanel.setBackground(Color.RED);
		}
		toggleInputFields();
	}

	/**
	 * Author: Jason Rice toggles the highest, lowest, and frequency input fields
	 * from allowing user input.
	 */
	private void toggleInputFields() {
		highestValText.setEditable(!FLAG);
		lowestValText.setEditable(!FLAG);
		frequencyText.setEditable(!FLAG);
	}
}

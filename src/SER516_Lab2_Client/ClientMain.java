package SER516_Lab2_Client;


import SER516_Lab2_Client.UIComponents.*;

import java.awt.*;

class ClientMain {



	public static void initialiseGUI()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientUI window = new ClientUI();
					window.pack();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					String errorMessage = "No Client window set.";
					Handlers.getInstance().displayConsoleMessage(errorMessage);
				}
			}
		});
	}

	public static void main(String[] args){

		initialiseGUI();
		String message = "This client is running on Port: \" + Consts.PORT_NUMBER + \".";
		Handlers.displayConsoleMessage(message);
	}


}
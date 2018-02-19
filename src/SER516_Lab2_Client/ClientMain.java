package SER516_Lab2_Client;


import SER516_Lab2_Client.UIComponents.ClientUI;

import java.awt.*;

class ClientMain {



	public static void initialiseGUI()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientUI window = new ClientUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args){

		initialiseGUI();
		System.out.println("This client is running on Port: " + Consts.PORT_NUMBER + ".");

	}


}
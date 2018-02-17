package SER516_Lab2_Server;

import SER516_Lab2_Server.UIComponents.*;

import java.awt.*;

class ServerMain {

	public static void initialiseGUI()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerUI window = new ServerUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args){

		//new Thread(new ServerThread(Consts.PORT_NUMBER)).start();
		initialiseGUI();
		System.out.println("This server is running on Port: "+Consts.PORT_NUMBER+".");

	}
}
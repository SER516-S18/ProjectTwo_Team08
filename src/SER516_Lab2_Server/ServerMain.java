package SER516_Lab2_Server;

import SER516_Lab2_Server.UIComponents.*;

class ServerMain {

	public static void initialiseGUI()
	{
		ServerFrame serverFrame = new ServerFrame();
		serverFrame.setSize(1000,500);
		serverFrame.setVisible(true);
		serverFrame.setDefaultCloseOperation(ServerFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args){

		//new Thread(new ServerThread(Consts.PORT_NUMBER)).start();
		initialiseGUI();
		System.out.println("This server is running on Port: "+Consts.PORT_NUMBER+".");

	}
}
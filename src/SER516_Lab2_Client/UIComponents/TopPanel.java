package SER516_Lab2_Client.UIComponents;

import SER516_Lab2_Client.ClientControl;
import SER516_Lab2_Client.ClientThread;
import SER516_Lab2_Client.Consts;
import SER516_Lab2_Client.ReadDataStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopPanel extends JPanel {

    private JButton btnStartStop;
    private ControlsPanel controlsPanel;
    private ClientThread clientThread;
    private ClientControl clientControl;
    private boolean FLAG;

    public TopPanel(){
        initComponents();
    }

    private void initComponents(){

        setLayout(new BorderLayout());
        btnStartStop = new JButton("Start / Stop");
        controlsPanel = new ControlsPanel();
        clientControl = new ClientControl();
        FLAG = true;
        btnStartStop.setBackground(Consts.PINK);
        btnStartStop.setFont(Consts.DEFAULT_FONT);
        btnStartStop.setBorder(BorderFactory.createLineBorder(Color.black));
        btnStartStop.setPreferredSize(new Dimension(200,40));
        add(btnStartStop, BorderLayout.EAST);

        btnStartStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientStartStop(FLAG);
            }
        });
    }

    /**
     * @author Ayan Shah
     * Client start/stop button control method
     * */

    public void clientStartStop(boolean FLAG){

        if(FLAG){
            String channels = controlsPanel.getChannels();
            String frequency = controlsPanel.getFrequency();
            System.out.println("Client start");
            clientControl.start(frequency, channels);
            this.FLAG = false;

        }else{

        }
    }
}

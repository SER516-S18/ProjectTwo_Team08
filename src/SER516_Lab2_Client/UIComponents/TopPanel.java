package SER516_Lab2_Client.UIComponents;

import SER516_Lab2_Client.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopPanel extends JPanel {

    private JButton btnStartStop;

    public TopPanel(){
        initComponents();
    }

    private void initComponents(){

        setLayout(new BorderLayout());
        btnStartStop = new JButton("Start / Stop");
        btnStartStop.setBackground(Consts.PINK);
        btnStartStop.setFont(Consts.DEFAULT_FONT);
        btnStartStop.setBorder(BorderFactory.createLineBorder(Color.black));
        btnStartStop.setPreferredSize(new Dimension(200,40));
        add(btnStartStop, BorderLayout.EAST);

        btnStartStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Handlers.getInstance().clientStartStop();
            }
        });
    }


}

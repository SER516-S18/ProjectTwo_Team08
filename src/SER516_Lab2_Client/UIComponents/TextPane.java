package SER516_Lab2_Client.UIComponents;

import javax.swing.*;
import java.awt.*;

public class TextPane  extends JPanel{

    private JTextPane textPane;
    public TextPane(){
        initComponents();
    }

    public TextPane(String text, Font font){
        initComponents();
        textPane.setText(text);
        if(font != null)
            textPane.setFont(font);
        else
            textPane.setFont(null);
    }

    public TextPane(String text, Font font, Color background, boolean hasBorder, boolean isEditable){
        initComponents();
        textPane.setText(text);
        if(font != null)
            textPane.setFont(font);
        else
            textPane.setFont(null);
        textPane.setBackground(background);
        textPane.setEditable(isEditable);
        if(hasBorder) textPane.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    private void initComponents(){
        textPane = new JTextPane();
        setLayout(new BorderLayout());
        add(textPane);
    }

    public void setPreferredSize(int height, int width){
        textPane.setPreferredSize(new Dimension(height,width));
    }

    public String getText(){
        return textPane.getText();
    }

    public void setText(String text){
        textPane.setText(text);
    }

    public void appendText(String text){
        textPane.setText(textPane.getText() + text);
    }
}

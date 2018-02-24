package SER516_Lab2_Client.UIComponents;

import javax.swing.*;
import java.awt.*;

public class TextPane  extends JTextPane{

    //private JTextPane textPane;
    public TextPane(){
    }

    public TextPane(String text, Font font){
        setText(text);
        if(font != null)
            setFont(font);
        else
            setFont(null);
    }

    public TextPane(String text, Font font, Color background, boolean hasBorder, boolean isEditable){
        setText(text);
        if(font != null)
            setFont(font);
        else
            setFont(null);
        setBackground(background);
        setEditable(isEditable);
        if(hasBorder) setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void setPreferredSize(int height, int width){
        setPreferredSize(new Dimension(height,width));
    }

    public void appendText(String text){
        setText(getText() + text);
    }
}

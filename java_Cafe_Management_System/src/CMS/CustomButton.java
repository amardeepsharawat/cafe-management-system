package CMS;

import javax.swing.*;
import java.awt.*;

public class CustomButton extends JButton {

    public CustomButton(String text)
    {
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setFocusPainted(false);
        setText(text);
    }

    CustomButton(int a, int b)
    {
        setSize(a,b);
    }
}

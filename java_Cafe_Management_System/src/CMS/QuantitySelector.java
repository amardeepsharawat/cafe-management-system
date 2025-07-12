package CMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuantitySelector extends JPanel implements ActionListener {
    CustomButton btnIncrement;
    CustomButton btnDecrement;
    JTextField textfield;
    int initial_value = 0;
    int value_buffer = 0;

    QuantitySelector()
    {
        btnIncrement = new CustomButton("+");
        btnIncrement.setBounds(0,0,45,20);
        this.add(btnIncrement);
        btnIncrement.addActionListener(this);

        textfield = new JTextField();
        textfield.setBounds(47,0,52,21);
        this.add(textfield);
        textfield.setText(Integer.toString(initial_value));

        btnDecrement = new CustomButton("-");
        btnDecrement.setBounds(100,0,45,20);
        btnDecrement.setBackground(Color.BLACK);
        this.add(btnDecrement);
        btnDecrement.addActionListener(this);



        setLayout(null);
        setSize(145,20);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent evt)
    {
        if (evt.getSource()==btnIncrement)
        {
         value_buffer += 1;
         textfield.setText(Integer.toString(value_buffer));
        }
        else if (evt.getSource()==btnDecrement)
        {
            if(value_buffer >= 1) {
                value_buffer -= 1;
            }
            textfield.setText(Integer.toString(value_buffer));
        }
    }


}

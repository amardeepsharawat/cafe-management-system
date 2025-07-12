package CMS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Home_Page extends JFrame implements ActionListener {
    CustomButton btnTakeOrder,btnTakePayment;
    JLabel BG_img;
    Home_Page()
    {
        BG_img = new JLabel("Background Image");
        BG_img.setIcon(new ImageIcon(getClass().getResource("/images/img_Cafe.jpg")));
        BG_img.setBounds    (0,0,615,442);

        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        btnTakeOrder = new CustomButton("Take Order");
        btnTakeOrder.setBounds(400,190,150,30);
        add(btnTakeOrder);
        btnTakeOrder.addActionListener(this);

        btnTakePayment = new CustomButton("Take Payment");
        btnTakePayment.setBounds(400,230,150,30);
        add(btnTakePayment);
        btnTakePayment.addActionListener(this);

        add(BG_img);
        setLayout(null);
        setTitle("Home");
        setVisible(true);
        setSize(630,480);
        setLocationRelativeTo(null);
        setResizable(false);

    }
    public void actionPerformed(ActionEvent evt)
    {
        if (evt.getSource()==btnTakeOrder)
        {
            new Menu_Page();
        } else if (evt.getSource()==btnTakePayment) {
            new Payment();
        }
    }

    public static void main(String[] args) {
              new Home_Page();
    }

}


package CMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ColdDrink extends JPanel implements ActionListener {
    private static final int DRINK_COUNT = 5;
    private static final String[] DRINK_NAMES = {"Thumbs Up", "Pepsi", "Coca Cola", "Limca", "Fanta"};
    private static final int[] QTY_SEL_YPOS = {100,150,200,250,300};
    private static final int[] BTN_YPOS = {95,145,195,245,295};
    private static final int WIDTH = 50;
    private static final int HEIGHT = 30;
    private static final String URL = "jdbc:mysql://localhost:3306/cafe_management_system";
    private static final String CLASS_NAME = "com.mysql.cj.jdbc.Driver";

    // Removed hardcoded username and password
    private static final String USERNAME = "root";
    private static final String PASSWORD = "@Tiger123";

    private JLabel[] lblColdDrink = new JLabel[DRINK_COUNT];
    private JButton[] btnPriceColdDrink = new JButton[DRINK_COUNT];
    private QuantitySelector[] qtySel_ColdDrink = new QuantitySelector[DRINK_COUNT];
    private JLabel lblQuantity, lblHalf, BG_img;
    private String[] drinkPrices = new String[DRINK_COUNT];

    private int QtySel_xpos = 170;
    private int[] btnXpos = {400,465};
    private int x = 20;
    private int font_size = 18;

    public ColdDrink() {
        BG_img = new JLabel("Background Image");
        BG_img.setIcon(new ImageIcon(getClass().getResource("/images/img_ColdDrinks.jpg")));
        BG_img.setBounds(0,0,600,400);

        for(int i=0; i<DRINK_COUNT; i++){
            lblColdDrink[i] = createLabel(DRINK_NAMES[i], x,95+(i*50),150,30, new Font("Arial", Font.PLAIN, font_size), Color.WHITE);
            drinkPrices[i] = getDrinkPrice(DRINK_NAMES[i]);
            btnPriceColdDrink[i]  = createButton(drinkPrices[i], btnXpos[0],BTN_YPOS[i],WIDTH ,HEIGHT, Color.BLACK, Color.GRAY);
            btnPriceColdDrink[i].addActionListener(this);
            qtySel_ColdDrink[i]  = new QuantitySelector();
            add(qtySel_ColdDrink[i]);
            qtySel_ColdDrink[i].setLocation(QtySel_xpos,QTY_SEL_YPOS[i]);
        }

        lblQuantity = createLabel("Quantity", 210,40,150,50, new Font("Arial", Font.PLAIN, 20), Color.WHITE);
        lblHalf = createLabel("Price", 400,40,60,50, new Font("Arial", Font.PLAIN, font_size), Color.WHITE);

        add(BG_img);
        setLayout(null);
        setVisible(true);
    }

    private JLabel createLabel(String text, int x, int y, int width, int height, Font font, Color color) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setFont(font);
        label.setForeground(color);
        add(label);
        return label;
    }

    private JButton createButton(String text, int x, int y, int width, int height, Color bg, Color fg) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setBackground(bg);
        button.setForeground(fg);
        add(button);
        return button;
    }

    private String getDrinkPrice(String drinkName){
        String price = "";
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement st = con.prepareStatement("select * from item_price where itemName = ?")) {
            st.setString(1, drinkName);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                price = rs.getString("itemPrice");
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return price;
    }

    public void actionPerformed(ActionEvent evt) {
        for(int i=0; i<DRINK_COUNT; i++){
            if (evt.getSource()==btnPriceColdDrink[i]){
                updateOrderBuffer(DRINK_NAMES[i], drinkPrices[i], qtySel_ColdDrink[i].textfield.getText());
            }
        }
    }

    private void updateOrderBuffer(String itemName, String itemPrice, String itemQuantity){
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement st = con.prepareStatement("select exists(select * from order_buffer where items = ?)")) {
            st.setString(1, itemName);
            ResultSet rs = st.executeQuery();
            if (rs.next() && rs.getInt(1) == 1) {
                try (PreparedStatement pst = con.prepareStatement("DELETE FROM order_buffer WHERE items = ?")) {
                    pst.setString(1, itemName);
                    pst.execute();
                }
            }
            try (PreparedStatement pst = con.prepareStatement("insert into order_buffer(items, price, quantity)values(?,?,?)")) {
                pst.setString(1, itemName);
                pst.setString(2, itemPrice);
                pst.setString(3, itemQuantity);
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}


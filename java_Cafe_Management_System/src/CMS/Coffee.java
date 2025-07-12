package CMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Coffee extends JPanel implements ActionListener {
    JLabel lblCoffee1,lblCoffee2,lblCoffee3,lblCoffee4,lblQuantity,lblHalf,BG_img;
    /*---------------------------COFFEE---------------------------*/
    // Black And White CMS.Coffee
    JButton btnPriceCoffee1;
    QuantitySelector qtySel_Coffee1;
    // Cappuccino
    JButton btnPriceCoffee2;
    QuantitySelector qtySel_Coffee2;
    // Orange Americano
    JButton btnPriceCoffee3;
    QuantitySelector qtySel_Coffee3;
    // CMS.Coffee White Cream
    JButton btnPriceCoffee4;
    QuantitySelector qtySel_Coffee4;
    int QtySel_xpos = 200;
    int[] QtySel_ypos = {100,150,200,250};
    int btnXpos = 400;
    int[] btnYpos = {95,145,195,245};
    int width = 50;
    int height = 30;
    String URL = "jdbc:mysql://localhost:3306/cafe_management_system";
    String USERNAME = "root";
    String PASSWORD = "@Tiger123";
    String className = "com.mysql.cj.jdbc.Driver";
    String Coffee1Price,Coffee2Price,Coffee3Price,Coffee4Price;
    int x = 20;
    int font_size = 18;
    Coffee()
    {
        BG_img = new JLabel("Background Image");
        BG_img.setIcon(new ImageIcon(getClass().getResource("/images/img_Coffee2.jpg")));
        BG_img.setBounds    (0,0,600,400);


        lblCoffee1 = new JLabel("Black and White");
        lblCoffee1.setBounds(x,95,150,30);
        add(lblCoffee1);
        lblCoffee1.setFont(new Font("Arial", Font.PLAIN, font_size));
        lblCoffee1.setForeground(Color.WHITE);

        lblCoffee2 = new JLabel("Cappuccino");
        lblCoffee2.setBounds(x,145,150,30);
        add(lblCoffee2);
        lblCoffee2.setFont(new Font("Arial", Font.PLAIN, font_size));
        lblCoffee2.setForeground(Color.WHITE);

        lblCoffee3 = new JLabel("Orange Americano");
        lblCoffee3.setBounds(x,195,180,30);
        add(lblCoffee3);
        lblCoffee3.setFont(new Font("Arial", Font.PLAIN, font_size));
        lblCoffee3.setForeground(Color.WHITE);

        lblCoffee4 = new JLabel("Coffee White Cream");
        lblCoffee4.setBounds(x,245,180,30);
        add(lblCoffee4);
        lblCoffee4.setFont(new Font("Arial", Font.PLAIN, font_size));
        lblCoffee4.setForeground(Color.WHITE);

        lblQuantity = new JLabel("Quantity");
        lblQuantity.setBounds(235,40,150,50);
        add(lblQuantity);
        lblQuantity.setFont(new Font("Arial", Font.PLAIN, 20));
        lblQuantity.setForeground(Color.WHITE);

        lblHalf = new JLabel("Price");
        lblHalf.setBounds(400,40,60,50);
        add(lblHalf);
        lblHalf.setFont(new Font("Arial", Font.PLAIN, font_size));
        lblHalf.setForeground(Color.LIGHT_GRAY);
        
        try {
            String query = "select * from item_price where itemName = 'Black and White Coffee'" ;
            Class.forName(className);
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();

            Coffee1Price = rs.getString("itemPrice");

            rs.close();
            st.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        btnPriceCoffee1  = new JButton(Coffee1Price);
        btnPriceCoffee1.setBounds( btnXpos,btnYpos[0],width ,height);
        btnPriceCoffee1.setBackground(Color.BLACK);
        btnPriceCoffee1.setForeground(Color.GRAY);
        add(btnPriceCoffee1);
        btnPriceCoffee1.addActionListener(this);
        qtySel_Coffee1  = new QuantitySelector();
        qtySel_Coffee1.setLocation(QtySel_xpos,QtySel_ypos[0]);
        add(qtySel_Coffee1);

        try {
            String query = "select * from item_price where itemName = 'Cappuccino'" ;
            Class.forName(className);
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();

            Coffee2Price = rs.getString("itemPrice");

            rs.close();
            st.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        btnPriceCoffee2  = new JButton(Coffee2Price);
        btnPriceCoffee2.setBounds( btnXpos,btnYpos[1],width ,height);
        btnPriceCoffee2.setBackground(Color.BLACK);
        btnPriceCoffee2.setForeground(Color.GRAY);
        add(btnPriceCoffee2);
        btnPriceCoffee2.addActionListener(this);
        qtySel_Coffee2  = new QuantitySelector();
        qtySel_Coffee2.setLocation(QtySel_xpos,QtySel_ypos[1]);
        add(qtySel_Coffee2);

        try {
            String query = "select * from item_price where itemName = 'Orange Americano'" ;
            Class.forName(className);
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();

            Coffee3Price = rs.getString("itemPrice");

            rs.close();
            st.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        btnPriceCoffee3  = new JButton(Coffee3Price);
        btnPriceCoffee3.setBounds( btnXpos,btnYpos[2],width ,height);
        btnPriceCoffee3.setBackground(Color.BLACK);
        btnPriceCoffee3.setForeground(Color.GRAY);
        add(btnPriceCoffee3);
        btnPriceCoffee3.addActionListener(this);
        qtySel_Coffee3  = new QuantitySelector();
        qtySel_Coffee3.setLocation(QtySel_xpos,QtySel_ypos[2]);
        add(qtySel_Coffee3);

        try {
            String query = "select * from item_price where itemName = 'Coffee White Cream'" ;
            Class.forName(className);
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();

            Coffee4Price = rs.getString("itemPrice");

            rs.close();
            st.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        btnPriceCoffee4  = new JButton(Coffee4Price);
        btnPriceCoffee4.setBounds( btnXpos,btnYpos[3],width ,height);
        btnPriceCoffee4.setBackground(Color.BLACK);
        btnPriceCoffee4.setForeground(Color.GRAY);
        add(btnPriceCoffee4);
        btnPriceCoffee4.addActionListener(this);
        qtySel_Coffee4  = new QuantitySelector();
        qtySel_Coffee4.setLocation(QtySel_xpos,QtySel_ypos[3]);
        add(qtySel_Coffee4);
        add(BG_img);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent evt)
    {
        if (evt.getSource()==btnPriceCoffee1){
            int flag = 0;
            try {
                String query = "select exists(select * from order_buffer where items = 'Black and White Coffee')" ;
                Class.forName(className);
                Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                rs.next();

                flag = rs.getInt(1);

                rs.close();
                st.close();
                con.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            if(flag == 1) {
                try {
                    String query = "DELETE FROM order_buffer WHERE items = 'Black and White Coffee' ";
                    Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    PreparedStatement st = con.prepareStatement(query);
                    st.execute(query);

                    st.close();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }

                try {
                    String query = "insert into order_buffer(items, price, quantity)values(?,?,?)";
                    Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    PreparedStatement st = con.prepareStatement(query);
                    st.setString(1, "Black and White Coffee");
                    st.setString(2, Coffee1Price);
                    st.setString(3, qtySel_Coffee1.textfield.getText());
                    st.executeUpdate();
                    st.close();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            } else {
                try {
                    String query = "insert into order_buffer(items, price, quantity)values(?,?,?)";
                    Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    PreparedStatement st = con.prepareStatement(query);
                    st.setString(1, "Black and White Coffee");
                    st.setString(2, Coffee1Price);
                    st.setString(3, qtySel_Coffee1.textfield.getText());
                    st.executeUpdate();
                    st.close();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        } else if (evt.getSource()==btnPriceCoffee2) {
            int flag = 0;
            try {
                String query = "select exists(select * from order_buffer where items = 'Cappuccino')" ;
                Class.forName(className);
                Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                rs.next();

                flag = rs.getInt(1);

                rs.close();
                st.close();
                con.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            if(flag == 1) {
                try {
                    String query = "DELETE FROM order_buffer WHERE items = 'Cappuccino' ";
                    Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    PreparedStatement st = con.prepareStatement(query);
                    st.execute(query);

                    st.close();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }

                try {
                    String query = "insert into order_buffer(items, price, quantity)values(?,?,?)";
                    Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    PreparedStatement st = con.prepareStatement(query);
                    st.setString(1, "Cappuccino");
                    st.setString(2, Coffee2Price);
                    st.setString(3, qtySel_Coffee2.textfield.getText());
                    st.executeUpdate();
                    st.close();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            } else {
                try {
                    String query = "insert into order_buffer(items, price, quantity)values(?,?,?)";
                    Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    PreparedStatement st = con.prepareStatement(query);
                    st.setString(1, "Cappuccino");
                    st.setString(2, Coffee2Price);
                    st.setString(3, qtySel_Coffee2.textfield.getText());
                    st.executeUpdate();
                    st.close();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        } else if (evt.getSource()==btnPriceCoffee3) {
            int flag = 0;
            try {
                String query = "select exists(select * from order_buffer where items = 'Orange Americano')" ;
                Class.forName(className);
                Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                rs.next();

                flag = rs.getInt(1);

                rs.close();
                st.close();
                con.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            if(flag == 1) {
                try {
                    String query = "DELETE FROM order_buffer WHERE items = 'Orange Americano' ";
                    Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    PreparedStatement st = con.prepareStatement(query);
                    st.execute(query);

                    st.close();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }

                try {
                    String query = "insert into order_buffer(items, price, quantity)values(?,?,?)";
                    Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    PreparedStatement st = con.prepareStatement(query);
                    st.setString(1, "Orange Americano");
                    st.setString(2, Coffee3Price);
                    st.setString(3, qtySel_Coffee3.textfield.getText());
                    st.executeUpdate();
                    st.close();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            } else {
                try {
                    String query = "insert into order_buffer(items, price, quantity)values(?,?,?)";
                    Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    PreparedStatement st = con.prepareStatement(query);
                    st.setString(1, "Orange Americano");
                    st.setString(2, Coffee3Price);
                    st.setString(3, qtySel_Coffee3.textfield.getText());
                    st.executeUpdate();
                    st.close();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        } else if (evt.getSource()==btnPriceCoffee4){
            int flag = 0;
            try {
                String query = "select exists(select * from order_buffer where items = 'Coffee White Cream')" ;
                Class.forName(className);
                Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                rs.next();

                flag = rs.getInt(1);

                rs.close();
                st.close();
                con.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            if(flag == 1) {
                try {
                    String query = "DELETE FROM order_buffer WHERE items = 'Coffee White Cream' ";
                    Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    PreparedStatement st = con.prepareStatement(query);
                    st.execute(query);

                    st.close();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }

                try {
                    String query = "insert into order_buffer(items, price, quantity)values(?,?,?)";
                    Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    PreparedStatement st = con.prepareStatement(query);
                    st.setString(1, "Coffee White Cream");
                    st.setString(2, Coffee4Price);
                    st.setString(3, qtySel_Coffee4.textfield.getText());
                    st.executeUpdate();
                    st.close();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            } else {
                try {
                    String query = "insert into order_buffer(items, price, quantity)values(?,?,?)";
                    Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    PreparedStatement st = con.prepareStatement(query);
                    st.setString(1, "Coffee White Cream");
                    st.setString(2, Coffee4Price);
                    st.setString(3, qtySel_Coffee4.textfield.getText());
                    st.executeUpdate();
                    st.close();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }
    }
}

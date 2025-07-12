package CMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Burger extends JPanel implements ActionListener {
    JLabel lblBurger1,lblBurger2,lblBurger3,lblBurger4,lblQuantity,lblHalf,BG_img;
    /*---------------------------Burgers---------------------------*/

    // Burger King
    CustomButton btnPriceBurger1;
    QuantitySelector qtySel_Burger1;

    // Cheese Burger
    CustomButton btnPriceBurger2;
    QuantitySelector qtySel_Burger2;

    // Crunchy Burger
    CustomButton btnPriceBurger3;
    QuantitySelector qtySel_Burger3;

    // Veggie Burger
    CustomButton btnPriceBurger4;
    QuantitySelector qtySel_Burger4;

    int QtySel_xpos = 170;
    int[] QtySel_ypos = {100,150,200,250};
    int btnXpos = 400;
    int[] btnYpos = {95,145,195,245};

    int width = 50;
    int height = 30;

    String URL = "jdbc:mysql://localhost:3306/cafe_management_system";
    String USERNAME = "root";
    String PASSWORD = "@Tiger123";
    String className = "com.mysql.cj.jdbc.Driver";

    String Burger1Price,Burger2Price,Burger3Price,Burger4Price;

    int x = 20;
    int font_size = 18;
    public Burger()
    {
        BG_img = new JLabel("Background Image");
        BG_img.setIcon(new ImageIcon(getClass().getResource("/images/img_Burgers.jpg")));
        BG_img.setBounds    (0,0,600,400);

        lblBurger1 = new JLabel("Burger King");
        lblBurger1.setBounds(x,95,150,30);
        add(lblBurger1);
        lblBurger1.setFont(new Font("Arial", Font.PLAIN, font_size));
        lblBurger1.setForeground(Color.WHITE);

        lblBurger2 = new JLabel("Cheese Burger");
        lblBurger2.setBounds(x,145,150,30);
        add(lblBurger2);
        lblBurger2.setFont(new Font("Arial", Font.PLAIN, font_size));
        lblBurger2.setForeground(Color.WHITE);

        lblBurger3 = new JLabel("Crunchy Burger");
        lblBurger3.setBounds(x,195,180,30);
        add(lblBurger3);
        lblBurger3.setFont(new Font("Arial", Font.PLAIN, font_size));
        lblBurger3.setForeground(Color.WHITE);

        lblBurger4 = new JLabel("Veggie Burger");
        lblBurger4.setBounds(x,245,150,30);
        add(lblBurger4);
        lblBurger4.setFont(new Font("Arial", Font.PLAIN, font_size));
        lblBurger4.setForeground(Color.WHITE);

        lblQuantity = new JLabel("Quantity");
        lblQuantity.setBounds(210,40,150,50);
        add(lblQuantity);
        lblQuantity.setFont(new Font("Arial", Font.PLAIN, 20));
        lblQuantity.setForeground(Color.WHITE);

        lblHalf = new JLabel("Price");
        lblHalf.setBounds(400,40,60,50);
        add(lblHalf);
        lblHalf.setFont(new Font("Arial", Font.PLAIN, font_size));
        lblHalf.setForeground(Color.WHITE);

        try {
            String query = "select * from item_price where itemName = 'Burger King'" ;
            Class.forName(className);
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();

            Burger1Price = rs.getString("itemPrice");

            rs.close();
            st.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        btnPriceBurger1  = new CustomButton(Burger1Price);
        btnPriceBurger1.setBounds( btnXpos,btnYpos[0],width ,height);
        add(btnPriceBurger1);
        btnPriceBurger1.addActionListener(this);
        qtySel_Burger1  = new QuantitySelector();
        qtySel_Burger1.setLocation(QtySel_xpos,QtySel_ypos[0]);
        add(qtySel_Burger1);

        try {
            String query = "select * from item_price where itemName = 'Cheese Burger'" ;
            Class.forName(className);
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();

            Burger2Price = rs.getString("itemPrice");

            rs.close();
            st.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        btnPriceBurger2  = new CustomButton(Burger2Price);
        btnPriceBurger2.setBounds( btnXpos,btnYpos[1],width ,height);
        add(btnPriceBurger2);
        btnPriceBurger2.addActionListener(this);
        qtySel_Burger2  = new QuantitySelector();
        qtySel_Burger2.setLocation(QtySel_xpos,QtySel_ypos[1]);
        add(qtySel_Burger2);

        try {
            String query = "select * from item_price where itemName = 'Crunchy Burger'" ;
            Class.forName(className);
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();

            Burger3Price = rs.getString("itemPrice");

            rs.close();
            st.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        btnPriceBurger3  = new CustomButton(Burger3Price);
        btnPriceBurger3.setBounds( btnXpos,btnYpos[2],width ,height);
        add(btnPriceBurger3);
        btnPriceBurger3.addActionListener(this);
        qtySel_Burger3  = new QuantitySelector();
        qtySel_Burger3.setLocation(QtySel_xpos,QtySel_ypos[2]);
        add(qtySel_Burger3);

        try {
            String query = "select * from item_price where itemName = 'Veggie Burger'" ;
            Class.forName(className);
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();

            Burger4Price = rs.getString("itemPrice");

            rs.close();
            st.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        btnPriceBurger4  = new CustomButton(Burger4Price);
        btnPriceBurger4.setBounds( btnXpos,btnYpos[3],width ,height);
        add(btnPriceBurger4);
        btnPriceBurger4.addActionListener(this);
        qtySel_Burger4  = new QuantitySelector();
        qtySel_Burger4.setLocation(QtySel_xpos,QtySel_ypos[3]);
        add(qtySel_Burger4);

        add(BG_img);

        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent evt)
    {
               if (evt.getSource()==btnPriceBurger1) {
                   int flag = 0;
                   try {
                       String query = "select exists(select * from order_buffer where items = 'Burger King')" ;
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
                           String query = "DELETE FROM order_buffer WHERE items = 'Burger King' ";
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
                           st.setString(1, "Burger King");
                           st.setString(2, Burger1Price);
                           st.setString(3, qtySel_Burger1.textfield.getText());
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
                           st.setString(1, "Burger King");
                           st.setString(2, Burger1Price);
                           st.setString(3, qtySel_Burger1.textfield.getText());
                           st.executeUpdate();
                           st.close();
                           con.close();
                       } catch (SQLException e) {
                           System.out.println(e);
                       }
                   }
        } else if (evt.getSource()==btnPriceBurger2) {
                   int flag = 0;
                   try {
                       String query = "select exists(select * from order_buffer where items = 'Cheese Burger')" ;
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
                           String query = "DELETE FROM order_buffer WHERE items = 'Cheese Burger' ";
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
                           st.setString(1, "Cheese Burger");
                           st.setString(2, Burger2Price);
                           st.setString(3, qtySel_Burger2.textfield.getText());
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
                           st.setString(1, "Cheese Burger");
                           st.setString(2, Burger2Price);
                           st.setString(3, qtySel_Burger2.textfield.getText());
                           st.executeUpdate();
                           st.close();
                           con.close();
                       } catch (SQLException e) {
                           System.out.println(e);
                       }
                   }
        } else if (evt.getSource()==btnPriceBurger3) {
                   int flag = 0;
                   try {
                       String query = "select exists(select * from order_buffer where items = 'Crunchy Burger')" ;
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
                           String query = "DELETE FROM order_buffer WHERE items = 'Crunchy Burger' ";
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
                           st.setString(1, "Crunchy Burger");
                           st.setString(2, Burger3Price);
                           st.setString(3, qtySel_Burger3.textfield.getText());
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
                           st.setString(1, "Crunchy Burger");
                           st.setString(2, Burger3Price);
                           st.setString(3, qtySel_Burger3.textfield.getText());
                           st.executeUpdate();
                           st.close();
                           con.close();
                       } catch (SQLException e) {
                           System.out.println(e);
                       }
                   }
        } else if (evt.getSource()==btnPriceBurger4) {
                   int flag = 0;
                   try {
                       String query = "select exists(select * from order_buffer where items = 'Veggie Burger')" ;
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
                           String query = "DELETE FROM order_buffer WHERE items = 'Veggie Burger' ";
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
                           st.setString(1, "Veggie Burger");
                           st.setString(2, Burger4Price);
                           st.setString(3, qtySel_Burger4.textfield.getText());
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
                           st.setString(1, "Veggie Burger");
                           st.setString(2, Burger4Price);
                           st.setString(3, qtySel_Burger4.textfield.getText());
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

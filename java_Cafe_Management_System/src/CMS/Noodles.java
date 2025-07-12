package CMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Noodles extends JPanel implements ActionListener {
    JLabel lblNoodle1,lblNoodle2,lblNoodle3,lblNoodle4,lblQuantity,lblHalf,lblFull,BG_img;
    /*---------------------------Noodles---------------------------*/

    // Hakka Noodles
    CustomButton btnPriceHalfNoodles1 ;
    CustomButton btnPriceFullNoodles1 ;
    QuantitySelector qtySel_Noodles1;

    //Pan Fried Noodles
    CustomButton btnPriceHalfNoodles2 ;
    CustomButton btnPriceFullNoodles2 ;
    QuantitySelector qtySel_Noodles2;

    // Vegetable Chowmein
    CustomButton btnPriceHalfNoodles3 ;
    CustomButton btnPriceFullNoodles3 ;
    QuantitySelector qtySel_Noodles3;

    // Paneer Noodles
    CustomButton btnPriceHalfNoodles4 ;
    CustomButton btnPriceFullNoodles4 ;
    QuantitySelector qtySel_Noodles4;

    int QtySel_xpos = 200;
    int[] QtySel_ypos = {100,150,200,250};
    int[] btnXpos = {400,465};
    int[] btnYpos = {95,145,195,245};
    int width = 50;
    int height = 30;
    String URL = "jdbc:mysql://localhost:3306/cafe_management_system";
    String USERNAME = "root";
    String PASSWORD = "@Tiger123";
    String className = "com.mysql.cj.jdbc.Driver";

    String Noodles1Price[],Noodles2Price[],Noodles3Price[],Noodles4Price[];
    int x = 20;
    int font_size = 18;
    public Noodles()
    {
        BG_img = new JLabel("Background Image");
        BG_img.setIcon(new ImageIcon(getClass().getResource("/images/img_Noodles.jpg")));
        BG_img.setBounds    (0,0,600,400);


        lblNoodle1 = new JLabel("Hakka Noodles");
        lblNoodle1.setBounds(x,95,150,30);
        add(lblNoodle1);
        lblNoodle1.setFont(new Font("Arial", Font.PLAIN, font_size));
        lblNoodle1.setForeground(Color.WHITE);

        lblNoodle2 = new JLabel("Pan Fried Noodles");
        lblNoodle2.setBounds(x,145,150,30);
        add(lblNoodle2);
        lblNoodle2.setFont(new Font("Arial", Font.PLAIN, font_size));
        lblNoodle2.setForeground(Color.WHITE);

        lblNoodle3 = new JLabel("Vegetable Chowmein");
        lblNoodle3.setBounds(x,195,180,30);
        add(lblNoodle3);
        lblNoodle3.setFont(new Font("Arial", Font.PLAIN, font_size));
        lblNoodle3.setForeground(Color.WHITE);

        lblNoodle4 = new JLabel("Paneer Noodles");
        lblNoodle4.setBounds(x,245,150,30);
        add(lblNoodle4);
        lblNoodle4.setFont(new Font("Arial", Font.PLAIN, font_size));
        lblNoodle4.setForeground(Color.WHITE);

        lblQuantity = new JLabel("Quantity");
        lblQuantity.setBounds(235,40,150,50);
        add(lblQuantity);
        lblQuantity.setFont(new Font("Arial", Font.PLAIN, 20));
        lblQuantity.setForeground(Color.WHITE);

        lblHalf = new JLabel("Half");
        lblHalf.setBounds(405,40,60,50);
        add(lblHalf);
        lblHalf.setFont(new Font("Arial", Font.PLAIN, font_size));
        lblHalf.setForeground(Color.WHITE);

        lblFull = new JLabel("Full");
        lblFull.setBounds(470,40,60,50);
        add(lblFull);
        lblFull.setFont(new Font("Arial", Font.PLAIN, font_size));
        lblFull.setForeground(Color.WHITE);


        Noodles1Price = new String[2];
        Noodles2Price = new String[2];
        Noodles3Price = new String[2];
        Noodles4Price = new String[2];

        try {
            String query = "select * from item_price where itemName = 'Hakka Noodles'" ;
            Class.forName(className);
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();

            String halfPrice = rs.getString("itemPriceHalf");
            Noodles1Price[0] = halfPrice;
            String fullPrice = rs.getString("itemPriceFull");
            Noodles1Price[1] = fullPrice;

            rs.close();
            st.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        btnPriceHalfNoodles1  = new CustomButton(Noodles1Price[0]);
        btnPriceHalfNoodles1.setBounds( btnXpos[0],btnYpos[0],width ,height);
        add(btnPriceHalfNoodles1);
        btnPriceHalfNoodles1.addActionListener(this);
        btnPriceFullNoodles1  = new CustomButton(Noodles1Price[1]);
        btnPriceFullNoodles1.setBounds(btnXpos[1],btnYpos[0],width ,height);
        add(btnPriceFullNoodles1);
        btnPriceFullNoodles1.addActionListener(this);
        qtySel_Noodles1  = new QuantitySelector();
        add(qtySel_Noodles1);
        qtySel_Noodles1.setLocation(QtySel_xpos,QtySel_ypos[0]);

        try {
            String query = "select * from item_price where itemName = 'Pan Fried Noodles'" ;
            Class.forName(className);
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();

            String halfPrice = rs.getString("itemPriceHalf");
            Noodles2Price[0] = halfPrice;
            String fullPrice = rs.getString("itemPriceFull");
            Noodles2Price[1] = fullPrice;

            rs.close();
            st.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        btnPriceHalfNoodles2  = new CustomButton(Noodles2Price[0]);
        btnPriceHalfNoodles2.setBounds(btnXpos[0],btnYpos[1],width ,height);
        add(btnPriceHalfNoodles2);
        btnPriceHalfNoodles2.addActionListener(this);
        btnPriceFullNoodles2  = new CustomButton(Noodles2Price[1]);
        btnPriceFullNoodles2.setBounds(btnXpos[1],btnYpos[1],width ,height);
        add(btnPriceFullNoodles2);
        btnPriceFullNoodles2.addActionListener(this);
        qtySel_Noodles2  = new QuantitySelector();
        add(qtySel_Noodles2);
        qtySel_Noodles2.setLocation(QtySel_xpos,QtySel_ypos[1]);

        try {
            String query = "select * from item_price where itemName = 'Vegetable Chowmein'" ;
            Class.forName(className);
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();

            String halfPrice = rs.getString("itemPriceHalf");
            Noodles3Price[0] = halfPrice;
            String fullPrice = rs.getString("itemPriceFull");
            Noodles3Price[1] = fullPrice;

            rs.close();
            st.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        btnPriceHalfNoodles3  = new CustomButton(Noodles3Price[0]);
        btnPriceHalfNoodles3.setBounds(btnXpos[0],btnYpos[2],width ,height);
        add(btnPriceHalfNoodles3);
        btnPriceHalfNoodles3.addActionListener(this);
        btnPriceFullNoodles3  = new CustomButton(Noodles3Price[1]);
        btnPriceFullNoodles3.setBounds(btnXpos[1],btnYpos[2],width ,height);
        add(btnPriceFullNoodles3);
        btnPriceFullNoodles3.addActionListener(this);
        qtySel_Noodles3  = new QuantitySelector();
        add(qtySel_Noodles3);
        qtySel_Noodles3.setLocation(QtySel_xpos,QtySel_ypos[2]);

        try {
            String query = "select * from item_price where itemName = 'Paneer Noodles'" ;
            Class.forName(className);
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();

            String halfPrice = rs.getString("itemPriceHalf");
            Noodles4Price[0] = halfPrice;
            String fullPrice = rs.getString("itemPriceFull");
            Noodles4Price[1] = fullPrice;

            rs.close();
            st.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        btnPriceHalfNoodles4  = new CustomButton(Noodles4Price[0]);
        btnPriceHalfNoodles4.setBounds(btnXpos[0],btnYpos[3],width ,height);
        add(btnPriceHalfNoodles4);
        btnPriceHalfNoodles4.addActionListener(this);
        btnPriceFullNoodles4  = new CustomButton(Noodles4Price[1]);
        btnPriceFullNoodles4.setBounds(btnXpos[1],btnYpos[3],width ,height);
        add(btnPriceFullNoodles4);
        btnPriceFullNoodles4.addActionListener(this);
        qtySel_Noodles4  = new QuantitySelector();
        add(qtySel_Noodles4);
        qtySel_Noodles4.setLocation(QtySel_xpos,QtySel_ypos[3]);

        add(BG_img);

        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent evt)
    {
               if (evt.getSource()==btnPriceHalfNoodles1) {
                   int flag = 0;
                   try {
                       String query = "select exists(select * from order_buffer where items = 'Hakka Noodles')" ;
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
                           String query = "DELETE FROM order_buffer WHERE items = 'Hakka Noodles' ";
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
                           st.setString(1, "Hakka Noodles");
                           st.setString(2, Noodles1Price[0]);
                           st.setString(3, qtySel_Noodles1.textfield.getText());
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
                           st.setString(1, "Hakka Noodles");
                           st.setString(2, Noodles1Price[0]);
                           st.setString(3, qtySel_Noodles1.textfield.getText());
                           st.executeUpdate();
                           st.close();
                           con.close();
                       } catch (SQLException e) {
                           System.out.println(e);
                       }
                   }
        } else if (evt.getSource()==btnPriceFullNoodles1) {
                   int flag = 0;
                   try {
                       String query = "select exists(select * from order_buffer where items = 'Hakka Noodles')" ;
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
                           String query = "DELETE FROM order_buffer WHERE items = 'Hakka Noodles' ";
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
                           st.setString(1, "Hakka Noodles");
                           st.setString(2, Noodles1Price[1]);
                           st.setString(3, qtySel_Noodles1.textfield.getText());
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
                           st.setString(1, "Hakka Noodles");
                           st.setString(2, Noodles1Price[1]);
                           st.setString(3, qtySel_Noodles1.textfield.getText());
                           st.executeUpdate();
                           st.close();
                           con.close();
                       } catch (SQLException e) {
                           System.out.println(e);
                       }
                   }
        } else if (evt.getSource()==btnPriceHalfNoodles2) {
                   int flag = 0;
                   try {
                       String query = "select exists(select * from order_buffer where items = 'Pan fried Noodles')" ;
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
                           String query = "DELETE FROM order_buffer WHERE items = 'Pan fried Noodles' ";
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
                           st.setString(1, "Pan fried Noodles");
                           st.setString(2, Noodles2Price[0]);
                           st.setString(3, qtySel_Noodles2.textfield.getText());
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
                           st.setString(1, "Pan fried Noodles");
                           st.setString(2, Noodles2Price[0]);
                           st.setString(3, qtySel_Noodles2.textfield.getText());
                           st.executeUpdate();
                           st.close();
                           con.close();
                       } catch (SQLException e) {
                           System.out.println(e);
                       }
                   }
        } else if (evt.getSource()==btnPriceFullNoodles2) {
                   int flag = 0;
                   try {
                       String query = "select exists(select * from order_buffer where items = 'Pan fried Noodles')" ;
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
                           String query = "DELETE FROM order_buffer WHERE items = 'Pan fried Noodles' ";
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
                           st.setString(1, "Pan fried Noodles");
                           st.setString(2, Noodles2Price[1]);
                           st.setString(3, qtySel_Noodles2.textfield.getText());
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
                           st.setString(1, "Pan fried Noodles");
                           st.setString(2, Noodles2Price[1]);
                           st.setString(3, qtySel_Noodles2.textfield.getText());
                           st.executeUpdate();
                           st.close();
                           con.close();
                       } catch (SQLException e) {
                           System.out.println(e);
                       }
                   }
        } else if (evt.getSource()==btnPriceHalfNoodles3) {
                   int flag = 0;
                   try {
                       String query = "select exists(select * from order_buffer where items = 'Vegetable Chowmein')" ;
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
                           String query = "DELETE FROM order_buffer WHERE items = 'Vegetable Chowmein' ";
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
                           st.setString(1, "Vegetable Chowmein");
                           st.setString(2, Noodles3Price[0]);
                           st.setString(3, qtySel_Noodles3.textfield.getText());
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
                           st.setString(1, "Vegetable Chowmein");
                           st.setString(2, Noodles3Price[0]);
                           st.setString(3, qtySel_Noodles3.textfield.getText());
                           st.executeUpdate();
                           st.close();
                           con.close();
                       } catch (SQLException e) {
                           System.out.println(e);
                       }
                   }
        } else if (evt.getSource()==btnPriceFullNoodles3) {
                   int flag = 0;
                   try {
                       String query = "select exists(select * from order_buffer where items = 'Vegetable Chowmein')" ;
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
                           String query = "DELETE FROM order_buffer WHERE items = 'Vegetable Chowmein' ";
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
                           st.setString(1, "Vegetable Chowmein");
                           st.setString(2, Noodles3Price[1]);
                           st.setString(3, qtySel_Noodles3.textfield.getText());
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
                           st.setString(1, "Vegetable Chowmein");
                           st.setString(2, Noodles3Price[1]);
                           st.setString(3, qtySel_Noodles3.textfield.getText());
                           st.executeUpdate();
                           st.close();
                           con.close();
                       } catch (SQLException e) {
                           System.out.println(e);
                       }
                   }
        } else if (evt.getSource()==btnPriceHalfNoodles4) {
                   int flag = 0;
                   try {
                       String query = "select exists(select * from order_buffer where items = 'Paneer Noodles')" ;
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
                           String query = "DELETE FROM order_buffer WHERE items = 'Paneer Noodles' ";
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
                           st.setString(1, "Paneer Noodles");
                           st.setString(2, Noodles4Price[0]);
                           st.setString(3, qtySel_Noodles4.textfield.getText());
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
                           st.setString(1, "Paneer Noodles");
                           st.setString(2, Noodles4Price[0]);
                           st.setString(3, qtySel_Noodles4.textfield.getText());
                           st.executeUpdate();
                           st.close();
                           con.close();
                       } catch (SQLException e) {
                           System.out.println(e);
                       }
                   }
        } else if (evt.getSource()==btnPriceFullNoodles4) {
                   int flag = 0;
                   try {
                       String query = "select exists(select * from order_buffer where items = 'Paneer Noodles')" ;
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
                           String query = "DELETE FROM order_buffer WHERE items = 'Paneer Noodles' ";
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
                           st.setString(1, "Paneer Noodles");
                           st.setString(2, Noodles4Price[1]);
                           st.setString(3, qtySel_Noodles4.textfield.getText());
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
                           st.setString(1, "Paneer Noodles");
                           st.setString(2, Noodles4Price[1]);
                           st.setString(3, qtySel_Noodles4.textfield.getText());
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

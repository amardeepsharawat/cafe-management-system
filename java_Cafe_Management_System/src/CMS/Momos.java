package CMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Momos extends JPanel implements ActionListener {

    JLabel lblMomo1,lblMomo2,lblChaap1,lblChaap2,lblQuantity,lblHalf,lblFull,BG_img;
    /*---------------------------Momos---------------------------*/

    // Fried Momos

    JLabel Momos1;
    CustomButton btnPriceHalfMomos1 ;
    CustomButton btnPriceFullMomos1 ;
    QuantitySelector qtySel_Momos1;

    // Chilli Momos
    JLabel Momos2;
    CustomButton btnPriceHalfMomos2 ;
    CustomButton btnPriceFullMomos2 ;
    QuantitySelector qtySel_Momos2;

    // Afghani Chaap
    JLabel Chaap1;
    CustomButton btnPriceHalfChaap1  ;
    CustomButton btnPriceFullChaap1 ;
    QuantitySelector qtySel_Chaap1;

    // Fried Chaap
    JLabel Chaap2;
    CustomButton btnPriceHalfChaap2  ;
    CustomButton btnPriceFullChaap2 ;
    QuantitySelector qtySel_Chaap2;

    int QtySel_xpos = 170;
     int[] QtySel_ypos = {100,150,240,290};
     int[] btnXpos = {400,465};
     int[] btnYpos = {95,145,235,285};
     int width = 50;
     int height = 30;

    String URL = "jdbc:mysql://localhost:3306/cafe_management_system";
    String USERNAME = "root";
    String PASSWORD = "@Tiger123";
    String className = "com.mysql.cj.jdbc.Driver";

    String Momo1Price[],Momo2Price[],Chaap1Price[],Chaap2Price[];
    int x = 20;
    int font_size = 18;
    public Momos()
    {
        BG_img = new JLabel("Background Image");
        BG_img.setIcon(new ImageIcon(getClass().getResource("/images/img_Momos.jpg")));
        BG_img.setBounds    (0,0,600,400);


        lblMomo1 = new JLabel("Fried Momos");
        lblMomo1.setBounds(x,95,120,30);
        add(lblMomo1);
        lblMomo1.setFont(new Font("Arial", Font.PLAIN, font_size));
        lblMomo1.setForeground(Color.WHITE);

        lblMomo2 = new JLabel("Chilli Momos");
        lblMomo2.setBounds(x,145,120,30);
        add(lblMomo2);
        lblMomo2.setFont(new Font("Arial", Font.PLAIN, font_size));
        lblMomo2.setForeground(Color.WHITE);

        lblChaap1 = new JLabel("Afghani Chaap");
        lblChaap1.setBounds(x,230,120,30);
        add(lblChaap1);
        lblChaap1.setFont(new Font("Arial", Font.PLAIN, font_size));
        lblChaap1.setForeground(Color.WHITE);

        lblChaap2 = new JLabel("Fried Chaap");
        lblChaap2.setBounds(x,280,120,30);
        add(lblChaap2);
        lblChaap2.setFont(new Font("Arial", Font.PLAIN, font_size));
        lblChaap2.setForeground(Color.WHITE);

        lblQuantity = new JLabel("Quantity");
        lblQuantity.setBounds(205,40,150,50);
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

        Momo1Price = new String[2];
        Momo2Price = new String[2];
        Chaap1Price = new String[2];
        Chaap2Price = new String[2];

        Momos1 = new JLabel("Fried Momos");
        try {
            String query = "select * from item_price where itemName = 'Fried Momos'" ;
            Class.forName(className);
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();

            String halfPrice = rs.getString("itemPriceHalf");
            Momo1Price[0] = halfPrice;
            String fullPrice = rs.getString("itemPriceFull");
            Momo1Price[1] = fullPrice;

            rs.close();
            st.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        btnPriceHalfMomos1  = new CustomButton(Momo1Price[0]);
        btnPriceHalfMomos1.setBounds( btnXpos[0],btnYpos[0],width ,height);
        add(btnPriceHalfMomos1);
        btnPriceHalfMomos1.addActionListener(this);
        btnPriceFullMomos1  = new CustomButton(Momo1Price[1]);
        btnPriceFullMomos1.setBounds(btnXpos[1],btnYpos[0],width ,height);
        add(btnPriceFullMomos1);
        btnPriceFullMomos1.addActionListener(this);
        qtySel_Momos1  = new QuantitySelector();
        add(qtySel_Momos1);
        qtySel_Momos1.setLocation(QtySel_xpos,QtySel_ypos[0]);

        Momos2 = new JLabel("Chilli Momos");
        try {
            String query = "select * from item_price where itemName = 'Chilli Momos'" ;
            Class.forName(className);
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();

            String halfPrice = rs.getString("itemPriceHalf");
            Momo2Price[0] = halfPrice;
            String fullPrice = rs.getString("itemPriceFull");
            Momo2Price[1] = fullPrice;

            rs.close();
            st.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        btnPriceHalfMomos2  = new CustomButton(Momo2Price[0]);
        btnPriceHalfMomos2.setBounds(btnXpos[0],btnYpos[1],width ,height);
        add(btnPriceHalfMomos2);
        btnPriceHalfMomos2.addActionListener(this);
        btnPriceFullMomos2  = new CustomButton(Momo2Price[1]);
        btnPriceFullMomos2.setBounds(btnXpos[1],btnYpos[1],width ,height);
        add(btnPriceFullMomos2);
        btnPriceFullMomos2.addActionListener(this);
        qtySel_Momos2  = new QuantitySelector();
        add(qtySel_Momos2);
        qtySel_Momos2.setLocation(QtySel_xpos,QtySel_ypos[1]);

        Chaap1 = new JLabel("Afghani Chaap");
        try {
            String query = "select * from item_price where itemName = 'Afghani Chaap'" ;
            Class.forName(className);
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();

            String halfPrice = rs.getString("itemPriceHalf");
            Chaap1Price[0] = halfPrice;
            String fullPrice = rs.getString("itemPriceFull");
            Chaap1Price[1] = fullPrice;

            rs.close();
            st.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        btnPriceHalfChaap1  = new CustomButton(Chaap1Price[0]);
        btnPriceHalfChaap1.setBounds(btnXpos[0],btnYpos[2],width ,height);
        add(btnPriceHalfChaap1);
        btnPriceHalfChaap1.addActionListener(this);
        btnPriceFullChaap1  = new CustomButton(Chaap1Price[1]);
        btnPriceFullChaap1.setBounds(btnXpos[1],btnYpos[2],width ,height);
        add(btnPriceFullChaap1);
        btnPriceFullChaap1.addActionListener(this);
        qtySel_Chaap1  = new QuantitySelector();
        add(qtySel_Chaap1);
        qtySel_Chaap1.setLocation(QtySel_xpos,QtySel_ypos[2]);

        Chaap2 = new JLabel("Fried Chaap");
        try {
            String query = "select * from item_price where itemName = 'Fried Chaap'" ;
            Class.forName(className);
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();

            String halfPrice = rs.getString("itemPriceHalf");
            Chaap2Price[0] = halfPrice;
            String fullPrice = rs.getString("itemPriceFull");
            Chaap2Price[1] = fullPrice;

            rs.close();
            st.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        btnPriceHalfChaap2  = new CustomButton(Chaap2Price[0]);
        btnPriceHalfChaap2.setBounds(btnXpos[0],btnYpos[3],width ,height);
        add(btnPriceHalfChaap2);
        btnPriceHalfChaap2.addActionListener(this);
        btnPriceFullChaap2  = new CustomButton(Chaap2Price[1]);
        btnPriceFullChaap2.setBounds(btnXpos[1],btnYpos[3],width ,height);
        add(btnPriceFullChaap2);
        btnPriceFullChaap2.addActionListener(this);
        qtySel_Chaap2  = new QuantitySelector();
        add(qtySel_Chaap2);
        qtySel_Chaap2.setLocation(QtySel_xpos,QtySel_ypos[3]);

        add(BG_img);

        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent evt)
    {
               if (evt.getSource()==btnPriceHalfMomos1) {
                   int flag = 0;
                   try {
                       String query = "select exists(select * from order_buffer where items = 'Fried Momos')" ;
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
                           String query = "DELETE FROM order_buffer WHERE items = 'Fried Momos' ";
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
                           st.setString(1, "Fried Momos");
                           st.setString(2, Momo1Price[0]);
                           st.setString(3, qtySel_Momos1.textfield.getText());
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
                           st.setString(1, "Fried Momos");
                           st.setString(2, Momo1Price[0]);
                           st.setString(3, qtySel_Momos1.textfield.getText());
                           st.executeUpdate();
                           st.close();
                           con.close();
                       } catch (SQLException e) {
                           System.out.println(e);
                       }
                   }
        } else if (evt.getSource()==btnPriceFullMomos1) {
                   int flag = 0;
                   try {
                       String query = "select exists(select * from order_buffer where items = 'Fried Momos')" ;
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
                           String query = "DELETE FROM order_buffer WHERE items = 'Fried Momos' ";
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
                           st.setString(1, "Fried Momos");
                           st.setString(2, Momo1Price[1]);
                           st.setString(3, qtySel_Momos1.textfield.getText());
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
                           st.setString(1, "Fried Momos");
                           st.setString(2, Momo1Price[1]);
                           st.setString(3, qtySel_Momos1.textfield.getText());
                           st.executeUpdate();
                           st.close();
                           con.close();
                       } catch (SQLException e) {
                           System.out.println(e);
                       }
                   }
        } else if (evt.getSource()==btnPriceHalfMomos2) {

                   int flag = 0;
                   try {
                       String query = "select exists(select * from order_buffer where items = 'Chilli Momos')" ;
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
                           String query = "DELETE FROM order_buffer WHERE items = 'Chilli Momos' ";
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
                           st.setString(1, "Chilli Momos");
                           st.setString(2, Momo2Price[0]);
                           st.setString(3, qtySel_Momos2.textfield.getText());
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
                           st.setString(1, "Chilli Momos");
                           st.setString(2, Momo2Price[0]);
                           st.setString(3, qtySel_Momos2.textfield.getText());
                           st.executeUpdate();
                           st.close();
                           con.close();
                       } catch (SQLException e) {
                           System.out.println(e);
                       }
                   }
        } else if (evt.getSource()==btnPriceFullMomos2) {
                   int flag = 0;
                   try {
                       String query = "select exists(select * from order_buffer where items = 'Chilli Momos')" ;
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
                           String query = "DELETE FROM order_buffer WHERE items = 'Chilli Momos' ";
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
                           st.setString(1, "Chilli Momos");
                           st.setString(2, Momo2Price[1]);
                           st.setString(3, qtySel_Momos2.textfield.getText());
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
                           st.setString(1, "Chilli Momos");
                           st.setString(2, Momo2Price[1]);
                           st.setString(3, qtySel_Momos2.textfield.getText());
                           st.executeUpdate();
                           st.close();
                           con.close();
                       } catch (SQLException e) {
                           System.out.println(e);
                       }
                   }
        } else if (evt.getSource()==btnPriceHalfChaap1) {
                   int flag = 0;
                   try {
                       String query = "select exists(select * from order_buffer where items = 'Afghani Chaap')" ;
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
                           String query = "DELETE FROM order_buffer WHERE items = 'Afghani Chaap' ";
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
                           st.setString(1, "Afghani Chaap");
                           st.setString(2, Chaap1Price[0]);
                           st.setString(3, qtySel_Chaap1.textfield.getText());
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
                           st.setString(1, "Afghani Chaap");
                           st.setString(2, Chaap1Price[0]);
                           st.setString(3, qtySel_Chaap1.textfield.getText());
                           st.executeUpdate();
                           st.close();
                           con.close();
                       } catch (SQLException e) {
                           System.out.println(e);
                       }
                   }
        } else if (evt.getSource()==btnPriceFullChaap1) {
                   int flag = 0;
                   try {
                       String query = "select exists(select * from order_buffer where items = 'Afghani Chaap')" ;
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
                           String query = "DELETE FROM order_buffer WHERE items = 'Afghani Chaap' ";
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
                           st.setString(1, "Afghani Chaap");
                           st.setString(2, Chaap1Price[1]);
                           st.setString(3, qtySel_Chaap1.textfield.getText());
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
                           st.setString(1, "Afghani Chaap");
                           st.setString(2, Chaap1Price[1]);
                           st.setString(3, qtySel_Chaap1.textfield.getText());
                           st.executeUpdate();
                           st.close();
                           con.close();
                       } catch (SQLException e) {
                           System.out.println(e);
                       }
                   }

        } else if (evt.getSource()==btnPriceHalfChaap2) {

                   int flag = 0;
                   try {
                       String query = "select exists(select * from order_buffer where items = 'Fried Chaap')" ;
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
                           String query = "DELETE FROM order_buffer WHERE items = 'Fried Chaap' ";
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
                           st.setString(1, "Fried Chaap");
                           st.setString(2, Chaap2Price[0]);
                           st.setString(3, qtySel_Chaap2.textfield.getText());
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
                           st.setString(1, "Fried Chaap");
                           st.setString(2, Chaap2Price[0]);
                           st.setString(3, qtySel_Chaap2.textfield.getText());
                           st.executeUpdate();
                           st.close();
                           con.close();
                       } catch (SQLException e) {
                           System.out.println(e);
                       }
                   }
        } else if (evt.getSource()==btnPriceFullChaap2) {
                   int flag = 0;
                   try {
                       String query = "select exists(select * from order_buffer where items = 'Fried Chaap')" ;
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
                           String query = "DELETE FROM order_buffer WHERE items = 'Fried Chaap' ";
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
                           st.setString(1, "Fried Chaap");
                           st.setString(2, Chaap2Price[1]);
                           st.setString(3, qtySel_Chaap2.textfield.getText());
                           st.executeUpdate();
                           st.close();
                           con.close();
                       } catch (SQLException e) {
                           System.out.println(e);
                       }
                   } else
                   {
                       try {
                           String query = "insert into order_buffer(items, price, quantity)values(?,?,?)";
                           Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                           PreparedStatement st = con.prepareStatement(query);
                           st.setString(1, "Fried Chaap");
                           st.setString(2, Chaap2Price[1]);
                           st.setString(3, qtySel_Chaap2.textfield.getText());
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

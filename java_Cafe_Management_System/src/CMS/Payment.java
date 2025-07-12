package CMS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.stream.Location;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;

public class Payment extends JFrame  {

    JTable table = new JTable();
    int CountPrice;
    int CountQuantity;

    String[] price;
    String[] quantity;
    int[] priceCNVT;
    int[] quantityCNVT;

    int[] total;
    int grandTotal;

    String URL = "jdbc:mysql://localhost:3306/cafe_management_system";
    String USERNAME = "root";
    String PASSWORD = "@Tiger123";
    String className = "com.mysql.cj.jdbc.Driver";
    public Payment()
    {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        try {
            String query = "SELECT COUNT(price) FROM order_buffer" ;
            Class.forName(className);
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();

            CountPrice = rs.getInt("COUNT(price)");

            rs.close();
            st.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        try {
            String query = "SELECT COUNT(quantity) FROM order_buffer" ;
            Class.forName(className);
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();

            CountQuantity = rs.getInt("COUNT(quantity)");

            rs.close();
            st.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        price = new String[CountPrice];
        quantity = new String[CountQuantity];
        priceCNVT  = new int[CountPrice];
        quantityCNVT = new int[CountQuantity];
        //System.out.println("Price: "+CountPrice);
        //System.out.println("Quantity: "+CountQuantity);

       try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe_management_system", "root", "@Tiger123");
            Statement st = con.createStatement();
            String query = "select price from order_buffer";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                price[CountPrice-1] = rs.getString(1);
                CountPrice--;
            }
            st.close();
            con.close();
            rs.close();
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe_management_system", "root", "@Tiger123");
            Statement st = con.createStatement();
            String query = "select quantity from order_buffer";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                quantity[CountQuantity-1] = rs.getString(1);
                CountQuantity--;
            }
            st.close();
            con.close();
            rs.close();
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        }

        for (int i=0;i<priceCNVT.length;i++)
        {
            priceCNVT[i] = Integer.parseInt(price[i]);
            quantityCNVT[i] = Integer.parseInt(quantity[i]);
        }

        total = new int[priceCNVT.length];
        for (int i=0;i<total.length;i++)
        {
            total[i] = priceCNVT[i]*quantityCNVT[i];
        }

        for (int i=0;i<total.length;i++)
        {
            grandTotal = grandTotal + total[i];
        }

        System.out.println(grandTotal);

        try {
            String query = "insert into order_buffer(items, price)values(?,?)";
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, "Total Payable");
            st.setString(2, String.valueOf(grandTotal));

            st.executeUpdate();
            st.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe_management_system", "root", "@Tiger123");
                Statement st = con.createStatement();
                String query = "select * from order_buffer";
                ResultSet rs = st.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();
                DefaultTableModel model = (DefaultTableModel) table.getModel();

                int cols = rsmd.getColumnCount();
                String[] colName = {"ITEMS", "PRICE", "QUANTITY"};
                model.setColumnIdentifiers(colName);
                String items, price, quantity;
                while (rs.next()) {
                    items = rs.getString(1);
                    price = rs.getString(2);
                    quantity = rs.getString(3);
                    String[] row = {items, price, quantity};
                    model.addRow(row);
                }

                st.close();
                con.close();
                rs.close();
            } catch (ClassNotFoundException | SQLException e1) {
                e1.printStackTrace();
            }

            table.setPreferredScrollableViewportSize(new Dimension(600, 410));
            table.setFillsViewportHeight(true);
            JScrollPane js = new JScrollPane(table);
            js.setVisible(true);
            add(js);


        setTitle("Payment");
        setVisible(true);
        setSize(400,500);
        setLocationRelativeTo(null);
        setResizable(false);


    }

    public static void main(String[] args) {
        new Payment();
    }
}

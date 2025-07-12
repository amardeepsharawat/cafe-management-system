package CMS;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Menu_Page extends JFrame {

    JTabbedPane menuSelector;
    Momos momos;
    Burger burger;
    Noodles noodles;
    Coffee coffee;
    ColdDrink colddrink;

    String URL = "jdbc:mysql://localhost:3306/cafe_management_system";
    String USERNAME = "root";
    String PASSWORD = "@Tiger123";

    public Menu_Page()
    {
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        try {
            String query = "DELETE FROM order_buffer";
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement st = con.prepareStatement(query);
            st.execute(query);
            st.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        momos = new Momos();

        burger = new Burger();

        noodles = new Noodles();

        coffee = new Coffee();

        colddrink = new ColdDrink();

        menuSelector = new JTabbedPane();
        add(menuSelector);
        menuSelector.setBounds(7,10,600,425);

        menuSelector.addTab("Momos", momos);

        menuSelector.addTab("Burger",burger);

        menuSelector.addTab("Noodles",noodles);

        menuSelector.addTab("Coffee",coffee);

        menuSelector.addTab("Cold Drinks",colddrink);

        setLayout(null);
        setTitle("Menu");
        setVisible(true);
        setSize(630,480);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static void main(String[] args) {
        new Menu_Page();
    }
}

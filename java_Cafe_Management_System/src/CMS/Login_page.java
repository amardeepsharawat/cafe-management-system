package CMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

class Login_page extends JFrame implements ActionListener
{
    JLabel Username_Label,Password_Label,or_Label;
    CustomButton OK_Button,EXIT_Button,Sign_Up_Refer;
    JTextField Username_txtField;
    JPasswordField Password_txtField;
    String DB_URL = "jdbc:mysql://localhost:3306/cafe_management_system";
    String USERNAME = "root";
    String PASSWORD = "@Tiger123";
    public Login_page()
    {

        Username_Label = new JLabel("Username");
        Password_Label = new JLabel("Password");
        or_Label = new JLabel("OR");
        Username_txtField = new JTextField();
        Password_txtField = new JPasswordField();
        OK_Button = new CustomButton("OK");
        EXIT_Button = new CustomButton("Exit");
        Sign_Up_Refer = new CustomButton("Sign Up");


        setLayout(null);

        Username_Label.setBounds    (40,40,100,30 );
        Username_Label.setFont(new Font("Arial", Font.PLAIN, 18));
        Username_Label.setForeground(Color.BLACK);

        Password_Label.setBounds    (40,90,100,30 );
        Password_Label.setFont(new Font("Arial", Font.PLAIN, 18));
        Password_Label.setForeground(Color.BLACK);

        Username_txtField.setBounds (150,40,130,25);
        Password_txtField.setBounds (150,90,130,25);
        OK_Button.setBounds         (40,150,80,25 );
        EXIT_Button.setBounds       (170,150,80,25);

        or_Label.setBounds          (136,170,40,40);
        or_Label.setFont(new Font("Arial", Font.PLAIN, 18));
        or_Label.setForeground(Color.BLACK);

        Sign_Up_Refer.setBounds     (98,207,100,25);

        OK_Button.addActionListener(this);
        OK_Button.setFocusPainted(false);
        EXIT_Button.addActionListener(this);
        EXIT_Button.setFocusPainted(false);
        Sign_Up_Refer.addActionListener(this);
        Sign_Up_Refer.setFocusPainted(false);

        add(Username_Label);// add label to the frame
        add(Password_Label);
        add(Username_txtField);
        add(Password_txtField);
        add(OK_Button);
        add(EXIT_Button);
        add(or_Label);
        add(Sign_Up_Refer);

        setLayout(null);
        setTitle("Login");
        setVisible(true);
        setSize(317,300);
        setLocationRelativeTo(null);
        setResizable(false);


    }//constructor
    public void actionPerformed(ActionEvent evt){

        if(evt.getSource()==OK_Button) {
            String strUSRNAME = Username_txtField.getText();
            String strPASSWD = String.valueOf(Password_txtField.getPassword());
            user = getAuthenticatedUser(strUSRNAME,strPASSWD);
            if(user != null){
                new Home_Page();
                this.setVisible(false);
            }else {
                JOptionPane.showMessageDialog(Login_page.this,
                        "Email or Password Invalid",
                        "Try again",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (evt.getSource()==EXIT_Button)
        {
                this.setVisible(false);
        }
        else if (evt.getSource()==Sign_Up_Refer)
        {
            new SignUp_page();
            this.setVisible(false);
        }
    }
    public User user;
    private  User getAuthenticatedUser(String name,String password)
    {
        User user = null;
        try
        {
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM userDetails WHERE userName=? and UPassWord=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                user = new User();
                user.name = resultSet.getString("userName");
                user.password = resultSet.getString("UPassWord");
            }
            stmt.close();
            conn.close();

        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return user;
    }


    public static void main(String[] args) {
        new Login_page();
    }
}//class



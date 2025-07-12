package CMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class SignUp_page extends JFrame implements ActionListener {

        JLabel Username_Label,Password_Label,Confirm_Password_Label;
        CustomButton OK_Button,EXIT_Button;
        JTextField Username_txtField;
        JPasswordField Password_txtField,Confirm_Password_txtField;

    String DB_URL = "jdbc:mysql://localhost:3306/cafe_management_system";
    String USERNAME = "root";
    String PASSWORD = "@Tiger123";
    int counter1=0,counter2=0,counter3=0;
        public SignUp_page()
        {
            Username_Label = new JLabel("Enter Username");
            Password_Label = new JLabel("Password");
            Confirm_Password_Label = new JLabel("Confirm Password");
            Username_txtField = new JTextField();
            Password_txtField = new JPasswordField();
            Confirm_Password_txtField = new JPasswordField();
            OK_Button= new CustomButton("OK");
            EXIT_Button= new CustomButton("Exit");


            setLayout(null);

            Username_Label.setBounds(20,40,130,30);
            Username_Label.setFont(new Font("Arial", Font.PLAIN, 18));
            Username_Label.setForeground(Color.BLACK);

            Password_Label.setBounds(20,90,130,30);
            Password_Label.setFont(new Font("Arial", Font.PLAIN, 18));
            Password_Label.setForeground(Color.BLACK);

            Confirm_Password_Label.setBounds(20,140,180,30);
            Confirm_Password_Label.setFont(new Font("Arial", Font.PLAIN, 18));
            Confirm_Password_Label.setForeground(Color.BLACK);

            Username_txtField.setBounds(230,40,130,25);
            Password_txtField.setBounds(230,90,130,25);
            Confirm_Password_txtField.setBounds(230,140,130,25);
            OK_Button.setBounds(80,200,100,30);
            EXIT_Button.setBounds(210,200,100,30);


            OK_Button.addActionListener(this);
            EXIT_Button.addActionListener(this);

            add(Username_Label);// add label to the frame
            add(Password_Label);
            add(Confirm_Password_Label);
            add(Username_txtField);
            add(Password_txtField);
            add(Confirm_Password_txtField);
            add(OK_Button);
            add(EXIT_Button);

            setLayout(null);
            setTitle("Sign Up");
            setVisible(true);
            setSize(400,300);
            setLocationRelativeTo(null);
            setResizable(false);


        }//constructor
        public void actionPerformed(ActionEvent evt){

            if(evt.getSource()==OK_Button) {
                registerUser();
                }
            else if (evt.getSource()==EXIT_Button){
                this.setVisible(false);
            }
        }

    private void registerUser() {
        String s1 = Username_txtField.getText();
        String s2 = String.valueOf(Password_txtField.getPassword());
        String s3 = String.valueOf(Confirm_Password_txtField.getPassword());
        if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty())
        {
            JOptionPane.showMessageDialog(this,
                    "Please enter all fields!",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!s2.equals(s3)){
            JOptionPane.showMessageDialog(this,
                    "Confirm password does not match!",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

       user = addUserToDatabase(s1,s2,s3);
        if (user!=null)
        {
            JOptionPane.showMessageDialog(this,
                    "Registration Successful!","Sign up",
                    JOptionPane.INFORMATION_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(this,
                    "Username already exists!","Try again",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public User user;
    private User addUserToDatabase(String s1, String s2, String s3) {
            User user = null;

            try
            {
                Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
                Statement stmt = conn.createStatement();
                String sql = "INSERT INTO userDetails(userName,UPassWord)VALUES(?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1,s1);
                preparedStatement.setString(2,s2);
                //Insert row into the table
                int addedRows = preparedStatement.executeUpdate();
                if(addedRows>0)
                {
                    user = new User();
                    user.name = s1;
                    user.password =s2;
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
        new SignUp_page();
    }
    }//class


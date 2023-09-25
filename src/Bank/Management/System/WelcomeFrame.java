package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class WelcomeFrame extends JFrame implements ActionListener{

    JLabel heading, name,accountType, accountNumber, cardNumber,pinNo,
            firstLogin,information, description, ifsc;
    JButton login,back;
    String pin_no;

    WelcomeFrame(String pin_no) {
        super("Welcome");
        this.pin_no = pin_no;


        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("Icons/3dBank.png"));
        Image ii = i.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i1 = new ImageIcon(ii);
        JLabel bankImg = new JLabel(i1);
        bankImg.setBounds(20,0,150,150);
        add(bankImg);

        heading = new JLabel("WELCOME TO ATM SERVICES");
        heading.setFont(new Font("Arial", Font.BOLD,30));
        heading.setForeground(Color.CYAN);
        heading.setBounds(220,50,500,30);
        add(heading);

        information = new JLabel("Your Account Details");
        information.setForeground(Color.WHITE);
        information.setFont(new Font("Arial", Font.ITALIC,20));
        information.setBounds(80,170,300,30);
        add(information);

        name = new JLabel();
        name.setBounds(80,235,500,30);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Arial", Font.BOLD,18));
        add(name);

        accountType = new JLabel();
        accountType.setBounds(80,270,500,30);
        accountType.setForeground(Color.WHITE);
        accountType.setFont(new Font("Arial", Font.BOLD,18));
        add(accountType);


        accountNumber = new JLabel();
        accountNumber.setBounds(80,305,500,30);
        accountNumber.setForeground(Color.WHITE);
        accountNumber.setFont(new Font("Arial", Font.BOLD,18));
        add(accountNumber);

        cardNumber = new JLabel();
        cardNumber.setBounds(80,340,500,30);
        cardNumber.setForeground(Color.WHITE);
        cardNumber.setFont(new Font("Arial", Font.BOLD,18));
        add(cardNumber);

        pinNo = new JLabel();
        pinNo.setBounds(80,375,500,30);
        pinNo.setForeground(Color.WHITE);
        pinNo.setFont(new Font("Arial", Font.BOLD,18));
        add(pinNo);

        ifsc = new JLabel();
        ifsc.setBounds(490,130,500,30);
        ifsc.setForeground(Color.cyan);
        ifsc.setFont(new Font("Arial", Font.BOLD,18));
        add(ifsc);

        description = new JLabel("Kindly Secure Your Pin Number & Do Not Share Your Pin Number To Anyone");
        description.setFont(new Font("cursive", Font.ITALIC,14));
        description.setForeground(Color.WHITE);
        description.setBounds(80,420,700,30);
        add(description);

        firstLogin = new JLabel("<html>If You Just Register Your Self \n"+
                "Kindly Login Your Self Using Your Card Number And Pin Number \n"+
                "And Make Your First Deposit, ThankYou  🙏 <html>");
        firstLogin.setFont(new Font("cursive", Font.ITALIC,14));
        firstLogin.setForeground(Color.CYAN);
        firstLogin.setBounds(80,460,700,100);
        add(firstLogin);

        try {
            Cons connection = new Cons();
            ResultSet resultSet = connection.statement.executeQuery("SELECT * FROM SignUp");
            while (resultSet.next()) {
                name.setText("Account Holder :         " + resultSet.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Cons connection = new Cons();
            ResultSet resultSet = connection.statement.executeQuery("SELECT * FROM SignUpPage3");
            while (resultSet.next()) {
                accountType.setText("Account Type  :           " + resultSet.getString("account_type"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Cons connection = new Cons();
            ResultSet resultSet = connection.statement.executeQuery("SELECT * FROM customer_details");
            while (resultSet.next()) {
                accountNumber.setText("Account Number  :      "+ resultSet.getString(3));
                cardNumber.setText("Card Number  :            " + resultSet.getString(1).substring(0,4) +"-" + resultSet.getString(1).substring(4,8)+"-" + resultSet.getString(1).substring(8,12)+"-"+ resultSet.getString(1).substring(12));
                pinNo.setText("Pin No  :                        " + resultSet.getString(2));
                ifsc.setText("IFSC CODE : " + resultSet.getString(4));
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        back = new JButton("BACK");
        back.setFont(new Font("Arial", Font.BOLD,18));
        back.setForeground(Color.BLACK);
        back.setBackground(Color.GRAY);
        back.setBounds(50,580,100,30);
        back.addActionListener(this);
        add(back);

        login = new JButton("LOGIN");
        login.setFont(new Font("Arial", Font.BOLD,18));
        login.setForeground(Color.BLACK);
        login.setBackground(Color.GRAY);
        login.setBounds(600,580,100,30);
        login.addActionListener(this);
        add(login);

        getContentPane().setBackground(new Color(0x03032C));
        setSize(800,700);
        setLocation(150,0);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            setVisible(false);
            new Login(pin_no);
        } else {
            setVisible(false);
            new MainInterface(pin_no);
        }
    }


    public static void main(String[] args) {
        new WelcomeFrame("");
    }
}

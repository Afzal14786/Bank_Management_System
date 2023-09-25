package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainInterface extends JFrame implements ActionListener{
    String pin_no;
    JButton deposit,withdraw,miniStatement,changePin,fastcash,balanceEnquiry,exit, yourInformation;
    MainInterface(String pin_no) {
        this.pin_no = pin_no;
        /**
         * ATM Image
         */
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("Icons/Atm.png"));
        Image ii = i.getImage().getScaledInstance(1366,768,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(ii);
        JLabel atmImage = new JLabel(i3);
        atmImage.setBounds(0,0,1366,768);
        add(atmImage);

        JLabel select = new JLabel("Please Select Your Transection");
        select.setBounds(400,190,400,40);
        select.setFont(new Font("System",Font.BOLD,20));
        select.setForeground(Color.WHITE);
        atmImage.add(select);
        /**
         * ATM Buttons
         */
        deposit = new JButton("DEPOSIT");
        deposit.setFont(new Font("Raleway", Font.BOLD,16));
        deposit.setForeground(Color.black);
        deposit.setBackground(new Color(0xC3F3E5));
        deposit.setBounds(360,250,130,30);
        deposit.addActionListener(this);
        atmImage.add(deposit);

        withdraw = new JButton("WITHDRAW");
        withdraw.setFont(new Font("Raleway", Font.BOLD,16));
        withdraw.setForeground(Color.black);
        withdraw.setBackground(new Color(0xC3F3E5));
        withdraw.addActionListener(this);
        withdraw.setBounds(600,250,150,30);
        atmImage.add(withdraw);

        miniStatement = new JButton("MINI STATEMENT");
        miniStatement.setFont(new Font("Raleway", Font.BOLD,16));
        miniStatement.setForeground(Color.black);
        miniStatement.setBackground(new Color(0xC3F3E5));
        miniStatement.setBounds(360,295,170,30);
        miniStatement.addActionListener(this);
        atmImage.add(miniStatement);

        changePin = new JButton("CHANGE PIN");
        changePin.setFont(new Font("Raleway", Font.BOLD,16));
        changePin.setForeground(Color.black);
        changePin.setBackground(new Color(0xC3F3E5));
        changePin.setBounds(597,295,152,30);
        changePin.addActionListener(this);
        atmImage.add(changePin);

        balanceEnquiry = new JButton("BALANCE ENQUIRY");
        balanceEnquiry.setFont(new Font("Raleway", Font.BOLD,16));
        balanceEnquiry.setForeground(Color.black);
        balanceEnquiry.setBackground(new Color(0xC3F3E5));
        balanceEnquiry.setBounds(360,337,200,30);
        balanceEnquiry.addActionListener(this);
        atmImage.add(balanceEnquiry);

        fastcash = new JButton("FAST CASH");
        fastcash.setFont(new Font("Raleway", Font.BOLD,16));
        fastcash.setForeground(Color.black);
        fastcash.setBackground(new Color(0xC3F3E5));
        fastcash.setBounds(360,380,150,30);
        fastcash.addActionListener(this);
        atmImage.add(fastcash);

        yourInformation = new JButton("YOUR DETAILS");
        yourInformation.setFont(new Font("Raleway", Font.BOLD,16));
        yourInformation.setForeground(Color.black);
        yourInformation.setBackground(new Color(0xC3F3E5));
        yourInformation.setBounds(597,340,155,30);
        yourInformation.addActionListener(this);
        atmImage.add(yourInformation);

        exit = new JButton("EXIT");
        exit.setFont(new Font("Raleway", Font.BOLD,16));
        exit.setForeground(Color.black);
        exit.setBackground(new Color(0xC3F3E5));
        exit.setBounds(647,380,100,30);
        exit.addActionListener(this);
        atmImage.add(exit);

        getContentPane().setBackground(new Color(0x2828CC));
        setLayout(null);
        setSize(1366,768);
        setLocation(0,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == deposit) {
                setVisible(false);
                new Deposit(pin_no);
            } else if (e.getSource() == exit) {
                System.exit(0);
            } else if (e.getSource() == withdraw) {
                setVisible(false);
                new Withdraw(pin_no);
            } else if (e.getSource() == balanceEnquiry) {
                setVisible(false);
                new BalanceEnquiry(pin_no);
            } else if (e.getSource() == fastcash) {
                setVisible(false);
                new FastCash(pin_no);
            } else if (e.getSource() == changePin) {
                setVisible(false);
                new ChangePin(pin_no);
            } else if (e.getSource() == miniStatement) {
                new MiniStatement(pin_no);
            } else if (e.getSource() == yourInformation) {
                setVisible(false);
                new CustomerDetails(pin_no);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "@error: " + exception);
            return;
        }
    }
    public static void main(String[] args) {
        new MainInterface("");
    }
}

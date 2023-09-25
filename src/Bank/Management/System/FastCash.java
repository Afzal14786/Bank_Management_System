package Bank.Management.System;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    String pin_no;
    JButton fastCash10000, fastCash5000, fastCash2000, fastCash500, fastCash1000, fastCash1500, fastCash100, back;
    FastCash(String pin_no) {
        this.pin_no = pin_no;

        /**
         * Atm Image
         */
        ImageIcon atm = new ImageIcon(ClassLoader.getSystemResource("Icons/Atm.png"));
        Image i = atm.getImage().getScaledInstance(1366,768,Image.SCALE_DEFAULT);
        ImageIcon ii = new ImageIcon(i);
        JLabel atmImage = new JLabel(ii);
        atmImage.setBounds(0,0,1366,768);
        add(atmImage);
        /**
         * Lable
         */
        JLabel select = new JLabel("SELECT WITHDRAWL AMOUNT");
        select.setBounds(400,190,400,40);
        select.setFont(new Font("System",Font.BOLD,20));
        select.setForeground(Color.WHITE);
        atmImage.add(select);
        /**
         * ATM Buttons
         */
        fastCash10000 = new JButton("₹ 10000");
        fastCash10000.setFont(new Font("Raleway", Font.BOLD,16));
        fastCash10000.setForeground(Color.black);
        fastCash10000.setBackground(new Color(0xC3F3E5));
        fastCash10000.setBounds(360,250,100,30);
        fastCash10000.addActionListener(this);
        atmImage.add(fastCash10000);

        fastCash5000 = new JButton("₹ 5000");
        fastCash5000.setFont(new Font("Raleway", Font.BOLD,16));
        fastCash5000.setForeground(Color.black);
        fastCash5000.setBackground(new Color(0xC3F3E5));
        fastCash5000.addActionListener(this);
        fastCash5000.setBounds(647,250,100,30);
        atmImage.add(fastCash5000);

        fastCash2000 = new JButton("₹ 2000");
        fastCash2000.setFont(new Font("Raleway", Font.BOLD,16));
        fastCash2000.setForeground(Color.black);
        fastCash2000.setBackground(new Color(0xC3F3E5));
        fastCash2000.setBounds(360,295,100,30);
        fastCash2000.addActionListener(this);
        atmImage.add(fastCash2000);

        fastCash500 = new JButton("₹ 500");
        fastCash500.setFont(new Font("Raleway", Font.BOLD,16));
        fastCash500.setForeground(Color.black);
        fastCash500.setBackground(new Color(0xC3F3E5));
        fastCash500.setBounds(647,295,100,30);
        fastCash500.addActionListener(this);
        atmImage.add(fastCash500);

        fastCash1000 = new JButton("₹ 1000");
        fastCash1000.setFont(new Font("Raleway", Font.BOLD,16));
        fastCash1000.setForeground(Color.black);
        fastCash1000.setBackground(new Color(0xC3F3E5));
        fastCash1000.setBounds(360,337,100,30);
        fastCash1000.addActionListener(this);
        atmImage.add(fastCash1000);

        fastCash1500 = new JButton("₹ 1500");
        fastCash1500.setFont(new Font("Raleway", Font.BOLD,16));
        fastCash1500.setForeground(Color.black);
        fastCash1500.setBackground(new Color(0xC3F3E5));
        fastCash1500.setBounds(360,380,100,30);
        fastCash1500.addActionListener(this);
        atmImage.add(fastCash1500);

        fastCash100 = new JButton("₹ 100");
        fastCash100.setFont(new Font("Raleway", Font.BOLD,16));
        fastCash100.setForeground(Color.black);
        fastCash100.setBackground(new Color(0xC3F3E5));
        fastCash100.setBounds(647,333,100,30);
        fastCash100.addActionListener(this);
        atmImage.add(fastCash100);

        back = new JButton("BACK");
        back.setFont(new Font("Raleway", Font.BOLD,16));
        back.setForeground(Color.black);
        back.setBackground(new Color(0xC3F3E5));
        back.setBounds(647,380,100,30);
        back.addActionListener(this);
        atmImage.add(back);

        setLayout(null);
        setSize(1366,768);
        setLocation(0,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            new MainInterface(pin_no);
        } else {
            String amount = ((JButton)e.getSource()).getText().substring(2);
            String maxAmount = "10000";
            Cons connection = new Cons();
            Date date = new Date();
            try {
                ResultSet resultSet = connection.statement.executeQuery("select * from deposit where pin_no ='"+pin_no+"'");
                int balance = 0;
                while (resultSet.next()) {
                    if (resultSet.getString("amount_type").equals("Deposit")) {
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }
                if (e.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                connection.statement.executeUpdate("insert into deposit Values('"+pin_no+"', '"+date+"', 'Withdraw', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "₹ " +amount + " Withdraw Successfully");

                setVisible(false);
                new MainInterface(pin_no);

            } catch (Exception E) {
                JOptionPane.showMessageDialog(null, "@error: " + E);
                return;
            }
        }
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}

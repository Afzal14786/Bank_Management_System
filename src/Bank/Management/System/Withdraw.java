package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
    String pinNo;
    TextField amountText;
    JButton withdraw, back;
    Withdraw(String pinNo) {
        this.pinNo = pinNo;
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
         * Lables and text filed for entering the deposit amount
         */
        JLabel text = new JLabel("MAXIMUM WITHDRAW IS ₹ 10,000");
        text.setBounds(390,175,600,30);
        text.setFont(new Font("System",Font.BOLD,20));
        text.setForeground(Color.WHITE);
        atmImage.add(text);

        JLabel enterAmount = new JLabel("PLEASE ENTER YOUR AMOUNT");
        enterAmount.setBounds(390,230, 400,30);
        enterAmount.setFont(new Font("System",Font.BOLD,20));
        enterAmount.setForeground(Color.WHITE);
        atmImage.add(enterAmount);

        amountText = new TextField();
        amountText.setBounds(380,270,300,30);
        amountText.setFont(new Font("Raleway",Font.BOLD,16));
        amountText.setBackground(new Color(153, 221, 238));
        amountText.setForeground(Color.BLACK);
        atmImage.add(amountText);
        /**
         * Buttons ::
         *      1. WITHDRAW
         *      2. Back
         */
        withdraw = new JButton("WITHDRAW");
        withdraw.setFont(new Font("Raelway",Font.BOLD,16));
        withdraw.setBounds(595,335,150,35);
        withdraw.setForeground(Color.BLACK);
        withdraw.setBackground(new Color(153, 221, 238));
        withdraw.addActionListener(this);
        atmImage.add(withdraw);

        back = new JButton("BACK");
        back.setFont(new Font("Raelway",Font.BOLD,16));
        back.setBounds(595,375,150,35);
        back.setBackground(new Color(153, 221, 238));
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        atmImage.add(back);

        setLayout(null);
        setSize(1366,768);
        setLocation(0,0);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String amount = amountText.getText();
        Date date = new Date();

        if (e.getSource() == withdraw) {
            try {
                if (amountText.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw");
                    return;
                } else {
                    Cons connection = new Cons();
                    String query = "select * from deposit where pin_no ='"+pinNo+"'";
                    ResultSet resultSet = connection.statement.executeQuery(query);
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("amount_type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));

                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    connection.statement.executeUpdate("insert into deposit Values('"+pinNo+"', '"+date+"', 'Withdraw', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "₹ " + amount + " Debited Successfully");
                    setVisible(false);
                    new MainInterface(pinNo);
                }

            } catch (Exception E) {
                JOptionPane.showMessageDialog(null, "@error: " + E);
                return;
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new MainInterface(pinNo);
        }


    }

    public static void main(String[] args) {
        new Withdraw("");
    }
}

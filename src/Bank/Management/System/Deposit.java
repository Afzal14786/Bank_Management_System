package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends  JFrame implements ActionListener {
    String pinNo;
    TextField amountText;
    JButton deposit, back;
    public Deposit(String pinNo) {
        this.pinNo  = pinNo;
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
        JLabel text = new JLabel("ENTER DEPOSIT AMOUNT");
        text.setBounds(413,175,400,30);
        text.setFont(new Font("System",Font.BOLD,20));
        text.setForeground(Color.WHITE);
        atmImage.add(text);

        amountText = new TextField();
        amountText.setBounds(380,210,320,30);
        amountText.setFont(new Font("Raleway",Font.BOLD,16));
        amountText.setBackground(new Color(153, 221, 238));
        amountText.setForeground(Color.BLACK);
        atmImage.add(amountText);
        /**
         * Buttons ::
         *      1. Deposit
         *      2. Back
         */
        deposit = new JButton("DEPOSIT");
        deposit.setFont(new Font("Raelway",Font.BOLD,16));
        deposit.setBounds(595,335,150,35);
        deposit.setForeground(Color.BLACK);
        deposit.setBackground(new Color(153, 221, 238));
        deposit.addActionListener(this);
        atmImage.add(deposit);

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
        /**
         * Connection and store the information in database
         */
        String amount = amountText.getText();
        Date date = new Date();
        try {
            if (e.getSource() == deposit) {
                if (amountText.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter The Amount");
                    return;
                } else {
                    Cons connection = new Cons();
                    String query = "insert into deposit Values('"+pinNo+"', '"+date+"', 'Deposit', '"+amount+"')";
                    connection.statement.executeUpdate(query);

                    JOptionPane.showMessageDialog(null,"₹ " + amount + " Deposited Successfully");
                    setVisible(false);
                    new MainInterface(pinNo);
                }
            } else if (e.getSource() == back) {
                setVisible(false);
                new MainInterface(pinNo);
            }
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "@error: " + E);
            return;
        }
    }
    public static void main(String[] args) {
        new Deposit("");
    }
}

package Bank.Management.System;

import com.mysql.cj.protocol.Resultset;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JLabel lable2;
    JButton back;

    String pin_no;
    BalanceEnquiry(String pin_no){
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
         * Lables and text filed for entering the deposit amount
         */
        JLabel text = new JLabel("Your Current Balance Is ");
        text.setBounds(390,175,600,30);
        text.setFont(new Font("System",Font.BOLD,20));
        text.setForeground(Color.WHITE);
        atmImage.add(text);

        lable2 = new JLabel();
        lable2.setBounds(390,230, 400,30);
        lable2.setFont(new Font("System",Font.BOLD,20));
        lable2.setForeground(Color.WHITE);
        atmImage.add(lable2);

        back = new JButton("BACK");
        back.setFont(new Font("Raelway",Font.BOLD,16));
        back.setBounds(595,375,150,35);
        back.setBackground(new Color(153, 221, 238));
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        atmImage.add(back);

        int balance = 0;
        try {
            Cons connection = new Cons();
            String query = "select * from deposit where pin_no ='"+pin_no+"'";
            ResultSet resultSet = connection.statement.executeQuery(query);
            while (resultSet.next()) {
                if (resultSet.getString("amount_type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "@error: " + e);
            return;
        }
        lable2.setText("₹ " + balance);

        setLayout(null);
        setSize(1366,768);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new MainInterface(pin_no);

    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}

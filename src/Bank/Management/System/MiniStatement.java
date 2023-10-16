package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {
    String pin_no;
    JButton exit;
        MiniStatement(String pin_no) {
            this.pin_no = pin_no;
            /**
             * lables
             */
            JLabel previous = new JLabel("YOUR PREVIOUS TRANSECTIONS");
            previous.setFont(new Font("Realway",Font.BOLD,20));
            previous.setBounds(20,0,330,30);
            add(previous);

            JLabel name = new JLabel();
            name.setBounds(20,35,400,20);
            name.setFont(new Font("Realway",Font.BOLD,18));
            add(name);

            JLabel cardNo = new JLabel("Card No :");
            cardNo.setBounds(20,60,300,30);
            cardNo.setFont(new Font("Realway", Font.BOLD, 16));
            add(cardNo);

            JLabel lable1 = new JLabel();
            lable1.setBounds(20,110,400,450);
            add(lable1);

            JLabel lable4 = new JLabel();
            lable4.setBounds(20,550,300,30);
            add(lable4);

            try {
                Cons connection = new Cons();
                ResultSet resultSet = connection.statement.executeQuery("select * from SignUp");
                while (resultSet.next()) {
                    name.setText("Name : " + resultSet.getString("name"));
                }
            }catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "@error: " + exception);
                return;
            }

            try {
                Cons connection = new Cons();
                ResultSet resultSet = connection.statement.executeQuery("select * from Login;");
                while (resultSet.next()) {
                    cardNo.setText("Card No : " + resultSet.getString(1).substring(0,4) + " - " + "XXXX - XXXX" + " - " +resultSet.getString("card_number").substring(12));
                }
             } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "@error: " + e);
                return;
            }

            try {
                int balance = 0;
                Cons connection = new Cons();
                ResultSet resultSet = connection.statement.executeQuery("select * from deposit where pin_no='"+pin_no+"'");
                while (resultSet.next()) {
                    lable1.setText(lable1.getText()+ "<html>" + resultSet.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ resultSet.getString("amount_type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("amount") + "<br><br><html>");

                    if (resultSet.getString("amount_type").equals("Deposit")) {
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }
                lable4.setText("Your Total Balance is ₹ " + balance);

            } catch (Exception E) {
                JOptionPane.showMessageDialog(null, "@error: " + E);
                return;
            }
            /**
             * Button
             */
            exit = new JButton("EXIT");
            exit.setBounds(140,600,100,30);
            exit.addActionListener(this);
            add(exit);

            getContentPane().setBackground(new Color(201, 97, 243));
            setLayout(null);
            setSize(400,700);
            setLocation(40,0);
            setVisible(true);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
            setVisible(false);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}

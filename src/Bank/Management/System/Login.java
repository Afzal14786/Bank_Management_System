
package Bank.Management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{
    // lables
    JLabel jlable, jlable1, jlabel2, lable3, description, cardDescription, provider;
    // buttons //
    JButton loginBtn, registerBtn;
    String pin_no;
     Login(String pin_no) {
        super("Welcome to Online ATM Services");
        this.pin_no = pin_no;
        /**
         * @pargram
         * Bank Logo image
         */
        ImageIcon moonBackGround = new ImageIcon(ClassLoader.getSystemResource("Icons/moonBackground.jpg"));
        Image moonBackGround1 = moonBackGround.getImage().getScaledInstance(1200,900,Image.SCALE_DEFAULT);
        ImageIcon moon = new ImageIcon(moonBackGround1);
        JLabel moonLable = new JLabel(moon);
        moonLable.setBounds(0,0,1200,900);
        add(moonLable);

        ImageIcon dep = new ImageIcon(ClassLoader.getSystemResource("Icons/moneyDeposit.png"));
        Image depImg = dep.getImage().getScaledInstance(290,290,Image.SCALE_DEFAULT);
        ImageIcon depImg2 = new ImageIcon(depImg);
        JLabel depositImage = new JLabel(depImg2);
        depositImage.setBounds(60,260,290,290);
        moonLable.add(depositImage);


        ImageIcon i =  new ImageIcon(ClassLoader.getSystemResource("Icons/3dBank.png"));
        Image i2 = i.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,50,200,200);
        moonLable.add(image);
        // cards //
        ImageIcon ii = new ImageIcon(ClassLoader.getSystemResource("Icons/3DCARD.png"));
        Image ii1 = ii.getImage().getScaledInstance(350,350,Image.SCALE_DEFAULT);
        ImageIcon ii2 = new ImageIcon(ii1);
        JLabel cards = new JLabel(ii2);
        cards.setBounds(280,10,350,350);
        moonLable.add(cards);

        ImageIcon money = new ImageIcon(ClassLoader.getSystemResource("Icons/ProviderImage.png"));
        Image money1 = money.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon money2 = new ImageIcon(money1);
        JLabel money3 = new JLabel(money2);
        money3.setBounds(690,400,250,250);
        moonLable.add(money3);

        ImageIcon login = new ImageIcon(ClassLoader.getSystemResource("Icons/loginLogo.png"));
        Image loginImag = login.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon loginImg1 = new ImageIcon(loginImag);
        JLabel loginImage = new JLabel(loginImg1);
        loginImage.setBounds(1080,80,50,50);
        moonLable.add(loginImage);

        ImageIcon register = new ImageIcon(ClassLoader.getSystemResource("Icons/RegisteredIcon.png"));
        Image registerImg = register.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon registerImg2 = new ImageIcon(registerImg);
        JLabel registerIcon = new JLabel(registerImg2);
        registerIcon.setBounds(820,80,40,50);
        moonLable.add(registerIcon);
        /**
         * @pargram
         * Lables //
         */
        jlable = new JLabel("WELCOME TO INDIA'S FIRST ONLINE ATM SERVICES");
        jlable.setForeground(new Color(9, 7, 0));
        jlable.setFont( new Font("Realway", Font.ITALIC,35));
        jlable.setBounds(130,20,900,40);
        moonLable.add(jlable);

        description = new JLabel("<html><i> Online ATM Servics has become a fundamental part of Modern Banking\n" +
                "We offering Our Customers the flexibility to manage there financial conveniently and\n " +
                "securely from their computers or mobile devices.\n" +
                "These services continue to evolve, providing innovative features and\n" +
                "enhanced securityto meet the needs of today's digital banking customers.  <i><html>");
        description.setFont(new Font("Arial",Font.BOLD,18));
        description.setForeground(Color.BLACK);
        description.setBounds(40,580,600,150);
        moonLable.add(description);

        cardDescription = new JLabel("<html><i> Register With Us and Get Your Electronic ATM Card and Account Number\n" +
                "These cards enable account holders to make electronic transactions\n" +
                " withdraw cash from automated teller machines (ATMs)\n" +
                "Online ATM cards are linked directly to the cardholder's bank account\n " +
                "They are typically protected by personal identification numbers (PINs)\n" +
                "and offer a secure and efficient way to conduct everyday financial transactions. <i><html>");
        cardDescription.setFont(new Font("Arial", Font.BOLD,18));
        cardDescription.setForeground(new Color(0xBE4F2B14, true));
        cardDescription.setBounds(360,280,700,150);
        moonLable.add(cardDescription);

        provider = new JLabel("We Are 24/7 Available For Your Service");
        provider.setFont(new Font("Arial", Font.BOLD,18));
        provider.setForeground(new Color(67));
        provider.setBounds(690,640,350,30);
        moonLable.add(provider);

        loginBtn = new JButton("Login");
        loginBtn.setFont(new Font("Arial", Font.BOLD, 14));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setBackground(Color.DARK_GRAY);
        loginBtn.setBounds(990,90,80,30);
        loginBtn.addActionListener(this);
        moonLable.add(loginBtn);

        registerBtn = new JButton("Register");
        registerBtn.setFont(new Font("Arial",Font.BOLD,14));
        registerBtn.setForeground(Color.white);
        registerBtn.setBackground(Color.DARK_GRAY);
        registerBtn.setBounds(870,90,100,30);
        registerBtn.addActionListener(this);
        moonLable.add(registerBtn);


        setLayout(null);
        setSize(1200, 900);
        setLocation(50, 0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == registerBtn) {
                setVisible(false);
                new SignUp();
            }
            if (e.getSource()==loginBtn) {
                setVisible(false);
                new LoginFrame(pin_no);
            }
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "@error : " + E);
            return;
        }
    }
    public static void main(String[] args) {
        new Login("");
    }
}

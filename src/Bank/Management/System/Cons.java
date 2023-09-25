package Bank.Management.System;
import java.sql.*;
public class Cons {
    Connection conn;
    Statement statement;
    public Cons() {

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankDataBase", "root", "Afzal#14777");
            statement =conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

}

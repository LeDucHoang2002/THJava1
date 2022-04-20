/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Swing_CSDL;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class KetNoiSQL {
    public Connection getConnection() throws ClassNotFoundException {
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName =QuanLySP";
            String user = "sa";
            String pwd = "12345";
             con = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return con;
    }
}

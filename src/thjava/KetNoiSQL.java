/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KetNoiSQL {
    private Connection con = null;
    public KetNoiSQL() {
        String url = "net.sourceforge.jtds.jdbc.Driver";
        try {
            Class.forName(url);
            String dbUrl = "jdbc:jtds:sqlserver://localhost:1433/NganHang;instance=SQLEXPRESS;user=sa;password=12345";
            con = DriverManager.getConnection(dbUrl);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KetNoiSQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(KetNoiSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void tracuuTaiKhoan() throws SQLException {
        int soTK = ThuVien.getInt("MOI NHAP SO TAI KHOAN");
        String sql = "Select noAccount from Account where noAccount=" + soTK;
        PreparedStatement pstm = con.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        if (rs.next() == true) {
            KetNoiSQL kn = new KetNoiSQL();
            System.out.println("TIM THAY TAI KHOAN");
            System.out.println("1. RUT TIEN");
            System.out.println("2. THEM TIEN");
            int chon = ThuVien.getInt("MOI CHON");
            switch (chon) {
                case 1:
                    double soTienCanRut = ThuVien.getDouble("NHAP SO TIEN CAN RUT");
                    kn.withdrawMoney(soTK, soTienCanRut);
                    break;
                case 2:
                    double soTienCanThem = ThuVien.getDouble("NHAP SO TIEN CAN THEM");
                    kn.addMoney(soTK, soTienCanThem);
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("TIM KHONG THAY TAI KHOAN");
        }
    }
    public ResultSet GetResultSet(String tableName) throws SQLException {
        ResultSet rs = null;
        Statement stmt = con.createStatement();
        String sql = "select * from " + tableName;
        rs = stmt.executeQuery(sql);
        return rs;
    }
    NumberFormat df = new DecimalFormat("#,###");
    public void infoAll() throws SQLException {
        ResultSet rs = GetResultSet("Account");
        System.out.println("*THÔNG TIN SỐ TÀI KHOẢN*");
        while (rs.next()) {
            System.out.print(rs.getString("noAccount"));
            System.out.print(" - ");
            System.out.print(rs.getString("nameAccount"));
            System.out.print(" - ");
            System.out.println(df.format(Double.parseDouble(rs.getString("moneyAccount"))) + " VNĐ");
        }
    }
    public void createAccount() throws SQLException {
        List<NguoiDung> listuser = new ArrayList<NguoiDung>();
        int n = ThuVien.getInt("NHAP SO LUONG CAN THEM VAO HE THONG");
        for (int i = 0; i < n; i++) {
            listuser.add(new NguoiDung(ThuVien.getInt("SO TAI KHOAN"), ThuVien.getString("HO TEN"), ThuVien.getDouble("SO TIEN")));
        }
        String sql = "INSERT INTO Account(noAccount,nameAccount,moneyAccount) VALUES(?,?,?);";
        PreparedStatement pstmt = con.prepareStatement(sql);
        for (NguoiDung user : listuser) {
            pstmt.setInt(1, user.getNoAccount());
            pstmt.setString(2, user.getNameAccount());
            pstmt.setDouble(3, user.getMoneyAccount());
            pstmt.execute();
        }
    }
    public double tesMoney(int noAccount) throws SQLException {
        double soTien = 0;
        String sql = "Select noAccount, moneyAccount from Account where noAccount=" + noAccount;
        PreparedStatement pstm = con.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        if (rs.next() == true) {
            soTien = Double.parseDouble(rs.getString("moneyAccount"));
        }
        return soTien;
    }
    public void withdrawMoney(int noAccount, double totalWithDrawMoney) throws SQLException {
        System.out.println("SO TIEN TRUOC KHI RUT : " + tesMoney(noAccount));
        if (totalWithDrawMoney > tesMoney(noAccount)) {
            System.out.println("SO TIEN KHONG DU");
            return;
        }
        double soTien = tesMoney(noAccount) - totalWithDrawMoney;
        String sql = "UPDATE Account SET moneyAccount='" + soTien + "'where noAccount=" + noAccount;
        Statement stmt = con.createStatement();
        stmt.execute(sql);
        System.out.println("SO TIEN SAU KHI RUT : " + tesMoney(noAccount));
    }
    public void addMoney(int noAccount, double totalAddMoney) throws SQLException {
        System.out.println("SO TIEN TRUOC KHI THEM : " + df.format(tesMoney(noAccount)));
        double soTien = tesMoney(noAccount) + totalAddMoney;
        String sql = "UPDATE Account SET moneyAccount='" + soTien + "'where noAccount=" + noAccount;
        Statement stmt = con.createStatement();
        stmt.execute(sql);
        System.out.println("SO TIEN SAU KHI THEM : " + df.format(tesMoney(noAccount)));
    }
}

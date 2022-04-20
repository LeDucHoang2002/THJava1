/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thjava1;

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

    public void Them() throws SQLException {
        List<NguoiDung> listuser = new ArrayList<NguoiDung>();
        int n = ThuVien.getInt("Nhập số lượng nhân viên cần thêm");
        for (int i = 0; i < n; i++) {
            listuser.add(new NguoiDung(ThuVien.getInt("Mã Nhân Viên"), 
                ThuVien.getString("Họ Tên"), ThuVien.getInt("Hệ Số")));
        }
        String sql = "INSERT INTO NhanVien2(MaNV,HoTen,HeSo) VALUES(?,?,?);";
        PreparedStatement pstmt = con.prepareStatement(sql);
        for (NguoiDung user : listuser) {
            pstmt.setInt(1, user.getNoAccount());
            pstmt.setString(2, user.getNameAccount());
            pstmt.setInt(3, user.getMoneyAccount());
            pstmt.execute();
        }

    }
    NumberFormat df = new DecimalFormat("#,###");

    public void tracuuTaiKhoan() throws SQLException {
        int soTK = ThuVien.getInt("Mời nhập Mã nhân viên");
        String sql = "Select MaNV,HoTen,HeSo from NhanVien2 where MaNV=" + soTK;
        PreparedStatement pstm = con.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        double lg = 0;
        if (rs.next() == true) {

            System.out.println("Tìm thấy nhân viên " + rs.getString("HoTen"));
            lg = rs.getInt("HeSo") * 1490000;
            System.out.println("Lương của nhân viên với MaNV " + soTK + " : " + df.format(lg) + " VNĐ");
        } else {
            System.out.println("Tìm không thấy nhân viên");
        }
    }

    public void delete() throws SQLException {
        Statement statement = con.createStatement();
        int soTK = ThuVien.getInt("Mời Nhập Mã Nhân Viên Cần xoá");
        String sql = "Select MaNV from NhanVien2 where MaNV=" + soTK;
        PreparedStatement pstm = con.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        if (rs.next() == true) {
            String sql1 = "delete from NhanVien2 where MaNV=" + soTK;
            statement.executeUpdate(sql1);
            System.out.println("Xoá Thành Công");
        } else {
            System.out.println("Tìm không thấy nhân viên");
        }
    }
}

package thjava1;

import static java.lang.System.exit;
import java.sql.SQLException;

public class ChuongTrinh {

    public static void main(String[] args) throws SQLException {
        KetNoiSQL kn = new KetNoiSQL();
        System.out.println("XIN CHAO");
        System.out.println("1. Tra cuu tai khoan");
        System.out.println("2. Hien thi tai khoan");
        System.out.println("3. Them tai khoan");
        System.out.println("4. Thoat");
        while (true) {
            try {
                int n = ThuVien.getInt("HAY CHON SO CAN THUC HIEN");
                if (n > 0 && n < 5) {

                    switch (n) {
                        case 1:
                            kn.tracuuTaiKhoan();
                            break;
                        case 2:
                            kn.delete();
                            break;
                        
                        case 3:
                            kn.Them();
                            break;
                        case 4:
                            exit(0);
                    }
                } else {
                    System.out.println("S CHONJ KHONG HOP LE");
                }
            } catch (Exception e) {
                System.out.println("VUI LONGF CHON SO NGUYEN");
            }
        }
    }
}

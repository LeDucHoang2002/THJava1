/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaiTap1;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class LeDucHoang extends JFrame {

    public LeDucHoang() {
        JLabel jlbHello = new JLabel("Tên: Lê Đức Hoàng");
        add(jlbHello);
        this.setSize(240, 150);
        pack();//Dong goi       Dùng:kích thước khung vừa với chữ và không dùng: Kích thước khung như size mình điền
        setVisible(true);//True: Cho phep cua so hien ra    false: không hiển thị cửa sổ
    }

    public static void main(String args[]) {
        new LeDucHoang();
    }
}

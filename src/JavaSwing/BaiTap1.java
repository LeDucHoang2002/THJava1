package JavaSwing;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class BaiTap1 extends JFrame {

    public BaiTap1() {
        JLabel jlbHello = new JLabel("Tên: Lê Đức Hoàng");
        add(jlbHello);
        this.setSize(240, 150);
        //pack();//Dong goi       Dùng:kích thước khung vừa với chữ và không dùng: Kích thước khung như size mình điền
        setVisible(true);//True: Cho phep cua so hien ra    false: không hiển thị cửa sổ
    }

    public static void main(String args[]) {
        new BaiTap1();
    }
}

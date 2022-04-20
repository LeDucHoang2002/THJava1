/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaiTap2;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class JlabelDemo extends JPanel {

    JLabel jlbLabel1, jlbLabel2, jlbLabel3;

    public JlabelDemo() { //Tao icon voi hinh anh tuy thich 
        ImageIcon icon = new ImageIcon(getClass().getResource("avatar-mini.jpg")); //Grid Layout chia thanh 3 cot va 1 hang 
        setLayout(new GridLayout(3, 5)); // Dat vi tri cua Text o giua (CENTER), trai (LEFT), phai (RIGHT), 
// tren cung (TOP) hoac duoi cung (BOTTOM) 
        jlbLabel1 = new JLabel("Label1 chua Image va Text", icon, JLabel.LEFT);
        jlbLabel1.setVerticalTextPosition(JLabel.BOTTOM);
        jlbLabel1.setHorizontalTextPosition(JLabel.LEFT);
        jlbLabel2 = new JLabel("Label 2 chi chua Text"); //Label 3 chi chua icon 
        jlbLabel3 = new JLabel(icon); // Them labels vao Panel 
        add(jlbLabel1);
        add(jlbLabel2);
        add(jlbLabel3);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("JLabel Demo");
        frame.setContentPane(new JlabelDemo());
        frame.pack();
        frame.setVisible(true);
    }
}

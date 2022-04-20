package JavaSwing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class BaiTap6 extends JFrame {

    private JPanel logoPane, loginPane;
    private JTextField tfs, tfs1;
    private JSplitPane mainPane;

    private void createLogoPane() {
        logoPane = new JPanel(new GridLayout(1, 1));
        logoPane.setBackground(Color.white);
        logoPane.add(new JLabel(new ImageIcon("avatar-mini.jpg")));
    }

    private void createLoginPane() {
        loginPane = new JPanel();
        loginPane.setLayout(new BorderLayout());
        loginPane.setBackground(Color.white);
        JPanel headPane = new JPanel();
        JLabel tt = new JLabel("Login", JLabel.CENTER);
        tt.setFont(new javax.swing.plaf.FontUIResource("Arial", Font.BOLD, 18));
        headPane.add(tt);;
        JPanel bPane = new JPanel(new GridLayout(0, 2, 5, 5));
        bPane.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));
        bPane.add(new JLabel("Username" + ":", JLabel.RIGHT));
        tfs = new JTextField(12);
        bPane.add(tfs);
        bPane.add(new JLabel("Password" + ":", JLabel.RIGHT));
        tfs1 = new JTextField(12);
        bPane.add(tfs1);
        JPanel footPane = new JPanel();
        JButton button = new JButton("Login");
        footPane.add(button);
        JButton button1 = new JButton("Cancel");
        footPane.add(button1);
        footPane.setBackground(Color.white);
        bPane.add(footPane, BorderLayout.SOUTH);
        loginPane.add(headPane, BorderLayout.NORTH);
        loginPane.add(bPane, BorderLayout.CENTER);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String text = tfs.getText();
                String text1 = tfs1.getText();
                if (text.equals("") | text1.equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Chưa Nhập User Hoặc Password");
                } else {
                    if (text.equals("1") & text1.equals("1")) {
                        BaiTap5 l = new BaiTap5();
                        l.setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "User Hoặc Password Không Chính Xác");
                    }

                }
            }
        });
    }

    public BaiTap6() {
        createLogoPane();
        createLoginPane();
        mainPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, logoPane, loginPane);
        setContentPane(mainPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Online Shopping");
        pack();
    }

    public static void main(String[] args) {
        BaiTap6 s = new BaiTap6();
        s.pack();
        s.show();
    }
}

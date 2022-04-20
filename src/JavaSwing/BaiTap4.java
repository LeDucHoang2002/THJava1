package JavaSwing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class BaiTap4 extends JFrame implements ActionListener {

    private double b;
    private JPanel panelcalculator, mainPanel, panelOUTPUT;
    private JTextArea textarea;
    private String btnName[] = {"0", "1", "2", "3",
        "4", "5", "6", "7",
        "8", "9", "+", "-",
        "*", "/", "%", "=",
        "C"};
    private JButton btn;

    public BaiTap4() {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(250, 350);
        setLocationRelativeTo(null);
        setResizable(false);
        add(createmainFrame());

    }

    /*Hàm tạo panel chính*/
    public JPanel createmainFrame() {
        setTitle("Calculator");

        mainPanel = new JPanel(new BorderLayout(5, 4));
        mainPanel.add(createButtonofCalculator(), BorderLayout.CENTER);
        mainPanel.add(createTextArea(), BorderLayout.NORTH);

        return mainPanel;
    }

    /*Khởi tạo jbutton*/
    private JButton myButton(String btnname) {
        btn = new JButton(btnname);
        btn.addActionListener(this);
        return btn;
    }

    /*Add các jbutton vào panel*/
    public JPanel createButtonofCalculator() {
        panelcalculator = new JPanel(new GridLayout(4, 5, 3, 3));
        for (int i = 0; i < btnName.length; i++) {
            panelcalculator.add(myButton(btnName[i]));
        }
        return panelcalculator;
    }

    /* Khởi tạo jtextarea */
    private JPanel createTextArea() {
        panelOUTPUT = new JPanel(new GridLayout(1, 1));
        textarea = new JTextArea(3, 3);
        panelOUTPUT.add(textarea);
        textarea.setEditable(false);
        return panelOUTPUT;
    }

    public static void main(String[] args) {
        new BaiTap4().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

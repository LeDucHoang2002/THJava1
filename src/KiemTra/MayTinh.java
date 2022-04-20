/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KiemTra;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MayTinh implements ActionListener {

    JFrame frame;
    JButton[] buttons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JTextField jTextField;
    JButton addButton, subButton, mulButton, divButton;
    JButton dotButton, relButton, delButton, clrButton;
    JButton[] arrJButton = {
        addButton = new JButton("+"),
        relButton = new JButton("="),
        clrButton = new JButton("CLEAR"),
        dotButton = new JButton(".")
    };
    JPanel jPanel;
    double num1, num2, num3, rel;
    char checkPoint;
    String text;
    Font font = new Font("Monaco", Font.PLAIN, 25);
    boolean kt = false;

    MayTinh() {
        frame = new JFrame("May tinh");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);

        jTextField = new JTextField();
        jTextField.setBounds(30, 20, 320, 50);
        jTextField.setFont(font);

        frame.add(jTextField);
        jPanel = new JPanel();
        jPanel.setBounds(30, 80, 320, 350);
        jPanel.setLayout(new GridLayout(4, 4, 10, 10));

        for (int i = 0; i < arrJButton.length; i++) {
            functionButtons[i] = arrJButton[i];
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font);
            functionButtons[i].setFocusable(false);
        }
        int k = 0;
        for (int i = 0; i < 10; i++) {
            buttons[i] = new JButton(String.valueOf(i));
            buttons[i].addActionListener(this);
            buttons[i].setFont(font);
            buttons[i].setFocusable(false);
        }
        for (int i = 1; i < 10; i++) {
            jPanel.add(buttons[i]);
        }
        jPanel.add(buttons[0]);
        jPanel.add(arrJButton[3]);

        frame.add(jPanel);
        arrJButton[0].setBounds(430, 100, 110, 50);
        arrJButton[1].setBounds(430, 190, 110, 50);
        arrJButton[2].setBounds(400, 280, 155, 50);
        frame.add(arrJButton[0]);
        frame.add(arrJButton[1]);
        frame.add(arrJButton[2]);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == buttons[i]) {
                jTextField.setText(jTextField.getText().concat(String.valueOf(i)));
            }
        }
        for (int i = 0; i < arrJButton.length - 3; i++) {
            if (e.getSource() == arrJButton[i] && i != 3) {
                num1 = Double.parseDouble(jTextField.getText());
                jTextField.setText(jTextField.getText().concat("" + arrJButton[i].getText()));
                checkPoint = arrJButton[i].getText().charAt(0);
                switch (checkPoint) {
                    case '+':
                        num3 += num1;
                }
                jTextField.setText("");
            }
        }
        boolean k = false;
        if (e.getSource() == arrJButton[3]) {
            text = jTextField.getText();
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == '.') {
                    k = true;
                }
            }
            if (!k) {
                jTextField.setText(jTextField.getText().concat("" + arrJButton[3].getText()));
            }
        }
        if (e.getSource() == arrJButton[1]) {
            num2 = Double.parseDouble(jTextField.getText());
            switch (checkPoint) {
                case '+':
                    rel = num3 + num2;
                    break;
                default:
                    rel = num2;
                    break;
            }
            jTextField.setText(String.valueOf(rel));
            num1 = rel;
        }
        if (e.getSource() == arrJButton[2]) {
            num1 = 0;
            num2 = 0;
            num3 = 0;
            rel = 0;
            jTextField.setText("");
        }
    }

    public static void main(String[] args) {
        new MayTinh();
    }
}

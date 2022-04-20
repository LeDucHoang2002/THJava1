package BaiTap;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class Menu extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu mainMenu, helpMenu;
    private JMenuItem login, logout, exit, edit, view, about;
    private AppMenuListener appMenuLis = new AppMenuListener();
    private JPanel mainPanel;

    private JMenuItem createMenuItem(String name) {
        JMenuItem menuItem = new JMenuItem(name);
        menuItem.addActionListener(appMenuLis);
        return menuItem;
    }

    private void createMenu() {
        login = createMenuItem("Login");
        logout = createMenuItem("Logout");
        exit = createMenuItem("Exit");
        edit = createMenuItem("Edit");
        view = createMenuItem("View");
        about = createMenuItem("About");
        menuBar = new JMenuBar();
        mainMenu = new JMenu("File");
        helpMenu = new JMenu("Help");
        menuBar.add(mainMenu);
        menuBar.add(helpMenu);
        mainMenu.add(login);
        mainMenu.add(logout);
        mainMenu.add(edit);
        mainMenu.add(view);
        mainMenu.add(exit);
        helpMenu.add(about);
        setJMenuBar(menuBar);
    }
//------------------------------------------------------------------------------------------------------------------
//inner class
//------------------------------------------------------------------------------------------------------------------	

    class AppMenuListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Object itemClicked = e.getSource();
            if (itemClicked == login) {

                ImageIcon icon = new ImageIcon(getClass().getResource("spkt.png"), "JavaSwing");
                JLabel jlabel = new JLabel("Trường ĐH Sư Phạm Kỹ Thuật", icon, JLabel.LEFT);
                setSize(500, 400);
                mainPanel.add(jlabel);
                setVisible(true);
            } else if (itemClicked == exit) {
                System.exit(1);
            }

        }
    }

    public void actionPerformed(ActionEvent e) {

    }
//------------------------------------------------------------------------------------------------------------------

    public Menu() {
        mainPanel = new JPanel(new GridLayout(2, 1, 1, 1));

        createMenu();
        setContentPane(mainPanel);
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Menu");
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        Menu s = new Menu();

        s.show();
    }
}

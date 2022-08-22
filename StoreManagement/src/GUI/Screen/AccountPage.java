package GUI.Screen;

import javax.swing.*;

public class AccountPage {
    private JLabel Title;
    private JPanel Main;

    JFrame frame = new JFrame();
    AccountPage(){

        frame.add(Main);
        frame.setTitle("Account Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(960,720);

    }
}

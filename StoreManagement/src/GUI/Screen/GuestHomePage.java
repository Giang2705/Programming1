package GUI.Screen;

import GUI.Components.ListProducts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GuestHomePage implements ActionListener {
    private JPanel Main;
    private JButton btnLogin;
    private JButton btnRegister;
    private JButton btnGoBack;
    private JButton btnAdminLogin;

    private JScrollPane scroll;
    private JPanel productList;
    private JLabel categorySort;
    private JComboBox category;
    private JLabel priceSort;
    private JComboBox price;

    JFrame frame = new JFrame();
    GuestHomePage() throws IOException {
        ListProducts listProducts = new ListProducts(false, null);

        productList.setLayout(new GridLayout(1,1));
        productList.add(listProducts.productList);

//        Main
        btnLogin.addActionListener(this);
        btnAdminLogin.addActionListener(this);
        btnRegister.addActionListener(this);
        btnGoBack.addActionListener(this);

        frame.add(Main);
        frame.setTitle("Guest Homepage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(960,720);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin){
            frame.dispose();
            UserLoginPage userLoginPage = new UserLoginPage();
        }
        if (e.getSource() == btnAdminLogin){
            frame.dispose();
            AdminLoginPage adminLoginPage = new AdminLoginPage();
        }
        if (e.getSource() == btnRegister){
            frame.dispose();
            UserRegisterForm userRegisterForm = new UserRegisterForm();
        }
        if (e.getSource()==btnGoBack){
            frame.dispose();
            WelcomeScreen welcomeScreen = new WelcomeScreen();
        }
    }
}
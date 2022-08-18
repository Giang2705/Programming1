import ClassAttribute.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AdminHomePage implements ActionListener {
    private JButton btnLogout;
    private JButton btnCart;
    private JPanel Main;
    private JComboBox category;
    private JComboBox price;
    private JLabel priceSort;
    private JLabel categorySort;
    private JButton btnAccount;
    private JPanel productsList;


    public JButton getBtnAccount(){
        return btnAccount;
    }

    JFrame frame = new JFrame();
    AdminHomePage(){

        btnLogout.addActionListener(this);
        btnAccount.addActionListener(this);

        productsList.setLayout(new GridLayout(3, 3));
        for(int i = 1; i<=9; i++){
            productsList.add(new JButton(""+ i));
        }

        frame.add(Main);

        frame.setTitle("Home");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(960,720);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogout){
            frame.dispose();
            GuestHomePage guestHomePage = new GuestHomePage();
        }
        if (e.getSource() == btnAccount){
            frame.dispose();
            AccountPage accountPage = new AccountPage();
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        List<Product> products = new ArrayList<Product>();

    }
}

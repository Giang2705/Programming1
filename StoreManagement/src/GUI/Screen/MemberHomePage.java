package GUI.Screen;

import GUI.Components.ListProducts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MemberHomePage extends Component implements ActionListener {
    private JButton btnLogout;
    private JButton btnCart;
    private JPanel Main;
    private JComboBox category;
    private JComboBox price;
    private JLabel priceSort;
    private JLabel categorySort;
    private JButton btnAccount;
    private JPanel productList;


    public JButton getBtnAccount(){
        return btnAccount;
    }

    JFrame frame = new JFrame();

    public MemberHomePage() throws IOException {
        ListProducts listProducts = new ListProducts(true);
        productList.setLayout(new GridLayout(1,1));
        productList.add(listProducts.productList);

        btnLogout.addActionListener(this);
        btnAccount.addActionListener(this);
        btnCart.setToolTipText("You have 0 products in your cart!");

        frame.setLayout(new GridLayout());

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
            try {
                GuestHomePage guestHomePage = new GuestHomePage();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == btnAccount){
            frame.dispose();
            AccountPage accountPage = new AccountPage();
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}

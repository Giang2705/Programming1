package GUI.Screen;

import GUI.Components.ListProducts;
import GUI.Components.Orders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MemberHomePage extends Component implements ActionListener {
    private JButton btnLogout;
    private JPanel Main;
    private JComboBox category;
    private JComboBox price;
    private JLabel priceSort;
    private JLabel categorySort;
    private JPanel productList;
    private JPanel cartArea;
    public JButton username;

    JFrame frame = new JFrame();

    public MemberHomePage(String name) throws IOException {
        username.setText(name);
        ListProducts listProducts = new ListProducts(true, name);
        productList.setLayout(new GridLayout(1,1));
        productList.add(listProducts.productList);

        btnLogout.addActionListener(this);
//        btnAccount.addActionListener(this);

        Orders orders = new Orders();
        cartArea.setLayout(new GridLayout());
        cartArea.add(orders.Main);

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
//        if (e.getSource() == btnAccount){
//            frame.dispose();
//            AccountPage accountPage = new AccountPage();
//        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}

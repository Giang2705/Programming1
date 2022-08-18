import ClassAttribute.Member;
import ClassAttribute.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MemberHomePage extends Component implements ActionListener {
    private JButton btnLogout;
    private JButton btnCart;
    private JPanel Main;
    private JComboBox category;
    private JComboBox price;
    private JLabel priceSort;
    private JLabel categorySort;
    private JButton btnAccount;


    public JButton getBtnAccount(){
        return btnAccount;
    }

    JFrame frame = new JFrame();

    MemberHomePage(){
        btnLogout.addActionListener(this);
        btnAccount.addActionListener(this);

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
        frame.setLayout(new GridLayout(products.size()/3, 3));
        for(int i = 1; i<=products.size(); i++){
            frame.add(new JTextField(products.get(i).getProductName()));
        }
    }
}

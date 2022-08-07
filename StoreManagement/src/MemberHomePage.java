import ClassAttribute.Member;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberHomePage implements ActionListener {
    private JButton btnLogout;
    private JButton btnCart;
    private JPanel Main;
    private JComboBox category;
    private JComboBox price;
    private JLabel priceSort;
    private JPanel product1;
    private JPanel product3;
    private JLabel categorySort;
    private JPanel product2;
    private JButton addToCartButton;
    private JButton btnAccount;


    public JButton getBtnAccount(){
        return btnAccount;
    }

    JFrame frame = new JFrame();
    MemberHomePage(){

        btnLogout.addActionListener(this);
        btnAccount.addActionListener(this);

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
    }
}

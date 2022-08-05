import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberHomePage implements ActionListener {
    private JButton btnLogout;
    private JButton btnCart;
    private JPanel Main;
    private JButton btnAccount;
    private JComboBox category;
    private JComboBox price;
    private JLabel priceSort;
    private JPanel product1;
    private JPanel product3;
    private JLabel categorySort;
    private JPanel product2;
    private JButton addToCartButton;

    JFrame frame = new JFrame();
    MemberHomePage(){
        btnLogout.addActionListener(this);

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
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminHomePage implements ActionListener {
    private JButton btnLogout;
    private JPanel Admin;
    private JPanel product1;
    private JButton addToCartButton;
    private JButton btnAccount;


    public JButton getBtnAccount(){
        return btnAccount;
    }

    JFrame frame = new JFrame();
    AdminHomePage(){

        btnLogout.addActionListener(this);
        btnAccount.addActionListener(this);

        frame.add(Admin);
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

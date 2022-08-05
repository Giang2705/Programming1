import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class WelcomeScreen implements ActionListener {
    private JTextArea GroupInfo;
    private JButton btnExit;
    private JButton btnContinue;
    private JLabel Title;
    private JLabel SystemLabel;
    private JPanel Main;

    JFrame frame = new JFrame();
    WelcomeScreen() {
        btnExit.addActionListener(this);
        btnContinue.addActionListener(this);

        frame.add(Main);
        frame.setTitle("Welcome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(960,720);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnExit){
            JFrame modal = new JFrame("EXIT");
            if(JOptionPane.showConfirmDialog(modal, "Do you want to exit?", "EXIT", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION){
                System.exit(0);
            }
        }

        if(e.getSource()==btnContinue){
            frame.dispose();
            GuestHomePage guestHomePage = new GuestHomePage();
        }
    }
}



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreManagement {
    private JPanel Main;
    private JButton button1;


    public static void main(String[] args) {
        JFrame frame = new JFrame("StoreManagement");
        frame.setContentPane(new StoreManagement().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

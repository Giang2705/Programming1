import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class modalAddToCart implements ChangeListener {
    private JLabel productNameTitle;
    private JLabel productPriceTitle;
    public JLabel productName;
    public JLabel productPrice;
    public JSpinner amountChange;
    public JTextField textField1;
    private JButton submitButton;
    private JButton cancelButton;
    public JPanel ModalAddToCart;

    JFrame frame = new JFrame();
    modalAddToCart(){
        amountChange.addChangeListener(this);
        frame.setLayout(new GridLayout());

        frame.add(ModalAddToCart);
        frame.setTitle("Add to cart");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(480,540);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        textField1.setText(""+(Integer)(amountChange.getValue())*Integer.parseInt(productPrice.getText()));
    }
}

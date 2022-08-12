import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNewProductForm implements ActionListener{

    JFrame frame = new JFrame();
    private JPanel Main;
    private JPanel registerForm;
    private JLabel addNewProductTitle;
    private JLabel productIdLabel;
    private JTextField productIdField1;
    private JLabel productNameLabel;
    private JTextField productNameField1;
    private JButton btnAdd;
    private JButton btnClear;
    private JButton btnCancel;

    private JButton btnHome;

    private JTextField productPriceField;
    private JLabel productCategoryLabel;
    private JLabel productPriceLabel;
    private JComboBox categoryList1;

    AddNewProductForm(){

        btnHome.addActionListener(this);
        btnClear.addActionListener(this);
        btnCancel.addActionListener(this);
        btnAdd.addActionListener(this);

        frame.setTitle("Add");
        frame.add(Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(960,720);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == btnLogin){
//            frame.dispose();
//            UserLoginPage userLoginPage = new UserLoginPage();
//        }
        if (e.getSource() == btnHome || e.getSource() == btnCancel){
            frame.dispose();
            GuestHomePage guestHomePage = new GuestHomePage();
        }
        if (e.getSource() == btnClear){
            productIdField1.setText("");
            productNameField1.setText("");

            productPriceField.setText("");
        }
        if (e.getSource() == btnAdd){
            String username = productIdField1.getText();
            String password = productNameField1.getText();
//            String fullname = fullnameField.getText();
            String phone = productPriceField.getText();

            storeDatabase database = new storeDatabase();
            database.createFolder();
            database.createFile();
            database.count();
//            database.register(username, password, fullname, phone);
        }
    }
}

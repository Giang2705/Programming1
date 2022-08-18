

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddNewProductForm implements ActionListener{

    JFrame frame = new JFrame();
    private JPanel Main;
    private JPanel addNewProductForm;
//    private JLabel loginTitle;
    private JLabel productIDLabel;
    private JTextField productIDField1;

    private JLabel productNameLabel;
    private JTextField productNameField1;

    private JLabel productCategoryLabel;
    private JOptionPane productCategoryField1;

    private JLabel productPriceLabel;
    private JTextField productPriceField1;
    private JButton btnAdd;
    private JButton btnClear;
    private JLabel dha;
    private JButton btnCancel;

    private JButton btnHome;

    AddNewProductForm(){
//        btnLogin.addActionListener(this);
        btnHome.addActionListener(this);
        btnClear.addActionListener(this);
        btnCancel.addActionListener(this);
        btnAdd.addActionListener(this);

        frame.setTitle("Add New Product");
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
            productIDField1.setText("");

            productNameField1.setText("");
//            productCategoryField1.set;
            productPriceField1.setText("");
        }
        if (e.getSource() == btnAdd){
            String id = productIDField1.getText();
            String name = productNameField1.getText();
//            Category category = productCategoryField1.get;
            double price = Double.parseDouble(productPriceField1.getText());

            storeDatabase database = new storeDatabase();
            database.createFolder();
            database.createFile();
            database.productCountLine();
            database.addNewProduct(id, name, price);
        }
    }
}

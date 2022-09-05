package GUI.Screen;

import ClassAttribute.Category;
import ClassAttribute.Product;
import Functions.readDatabase;
import Functions.storeDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.List;

public class UpdateProductForm implements ActionListener{

    JFrame frame = new JFrame();
    private JPanel Main;
    private JPanel registerForm = new JPanel();
    private JLabel editProductDetailTitle;
    private JLabel productIdLabel;
    public JTextField productIdField1;
    private JLabel productNameLabel;
    public JTextField productNameField1;
    private JButton btnAdd;
    private JButton btnCancel;

    private JButton btnHome;

    public JTextField productPriceField;
    private JLabel productCategoryLabel;
    private JLabel productPriceLabel;
    public JTextField category1;


     public UpdateProductForm(){


//        String productId = GenerateID.getID(10);
//        productIdField1.setText(productId);

        btnHome.addActionListener(this);
        btnCancel.addActionListener(this);
        btnAdd.addActionListener(this);
        frame.setTitle("Add");
        // fetching option for Category
        readDatabase readData = new readDatabase();
        try {
            readData.readCategoryFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//        String catDefault = categoryArray[0];


        registerForm.add(btnHome);
        registerForm.add(editProductDetailTitle);
        registerForm.setLayout(new GridLayout(0, 2,10,10));
        registerForm.add(productIdLabel);
        registerForm.add(productIdField1);
        registerForm.add(productNameLabel);
        registerForm.add(productNameField1);
        registerForm.add(productCategoryLabel);
        registerForm.add(productPriceLabel);
        registerForm.add(productPriceField);
        registerForm.add(btnAdd);
        registerForm.add(btnCancel);
        frame.add(registerForm);
//                categoryList1.setSelectedIndex(0);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(960,720);
        frame.pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        boolean error = false;
//        if (e.getSource() == btnHome || e.getSource() == btnCancel){
//            frame.dispose();
//            try {
//                AdminHomePage adminHomePage = new AdminHomePage();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        }
//
//        if (e.getSource() == btnAdd){
//            String productName = productNameField1.getText();
//            Category productCat = new Category(selectedItem);
////            System.out.println(productCat);
//            int productPrice = 0;
//            try {
//                productPrice = Integer.parseInt((productPriceField.getText()));
//            } catch (NumberFormatException exception) {
//                JOptionPane.showMessageDialog(frame, "Invalid Input");
//                error = true;
//            }
//
//
//            if ((productName.length() == 0) || (productCat.getCategoryName().length() == 0)) {
//                JFrame modal = new JFrame("Unvalidated");
//                modal.setVisible(true);
//                JOptionPane.showConfirmDialog(null, "Please fill in all fields of the form!", "Unvalidated", JOptionPane.DEFAULT_OPTION);
//                modal.dispose();
//                System.out.println("False");
//            } else {
//                Product product = new Product(productIdField1.getText(), productName, productCat, productPrice);
//                if (!error) {
//                    System.out.println("Add Prod");
//                    storeDatabase database = new storeDatabase();
//                    database.createProductFile();
//                    database.productCountLine();
//                    database.addNewProduct(product);
//                    readDatabase readDatabase = new readDatabase();
//                    try {
//                        readDatabase.readProductFile();
//                    } catch (IOException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                }
//                JOptionPane.showMessageDialog(frame, "Successfully add new product");
//                frame.dispose();
//                AddNewProductForm addNewProductForm = new AddNewProductForm();
//            }
//
//        }
    }

}

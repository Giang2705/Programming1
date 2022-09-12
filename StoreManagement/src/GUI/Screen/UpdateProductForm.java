package GUI.Screen;

import ClassAttribute.Category;
import ClassAttribute.Product;
import Functions.readDatabase;
import Functions.updateDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JButton btnUpdate;
    private JButton btnCancel;

    private JButton btnHome;

    public JTextField productPriceField;
    private JLabel productCategoryLabel;
    private JLabel productPriceLabel;
    public JTextField category1;
    private JLabel adminName;
    private JLabel admin;

    private String[] catList;

    public UpdateProductForm(String id, String name, String category, Double price){


//        String productId = GenerateID.getID(10);
//        productIdField1.setText(productId);

        productIdField1.setText(id);
        productNameField1.setText(name);
        category1.setText(category);
        productPriceField.setText(String.valueOf(price));


        btnHome.addActionListener(this);
        btnCancel.addActionListener(this);
        btnUpdate.addActionListener(this);
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
        registerForm.add(category1);
        registerForm.add(productPriceLabel);
        registerForm.add(productPriceField);
        registerForm.add(btnUpdate);
        registerForm.add(btnCancel);
        frame.add(registerForm);
//                categoryList1.setSelectedIndex(0);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(960,720);
        frame.pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

//        boolean error = false;
        if (e.getSource() == btnHome || e.getSource() == btnCancel){
            frame.dispose();
//            try {
//                AdminHomePage adminHomePage = new AdminHomePage();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
        }
//
        if (e.getSource() == btnUpdate){
            Category category = new Category(category1.getText());
            Product product = new Product(productIdField1.getText(), productNameField1.getText(), category, Double.parseDouble(productPriceField.getText()));
            updateDatabase updateDatabase = new updateDatabase();
            updateDatabase.editProduct("Database/products.csv", product);
            readDatabase readDatabase = new readDatabase();
            frame.dispose();
        }
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

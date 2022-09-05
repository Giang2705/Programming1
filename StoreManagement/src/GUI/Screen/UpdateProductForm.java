package GUI.Screen;

import ClassAttribute.Category;
import ClassAttribute.Product;
import Functions.readDatabase;
import Functions.storeDatabase;
import Functions.updateDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.List;

public class UpdateProductForm implements ActionListener, ItemListener {

    JFrame frame = new JFrame();
    private JPanel Main;
    private JPanel registerForm = new JPanel();
    private JLabel editProductDetailTitle;
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

    private List<String> categories;
    private String selectedItem = "";

    private String[] catList;

    public UpdateProductForm(String id, String name, String selectedCategory, Double price){


//        String productId = GenerateID.getID(10);
//        productIdField1.setText(productId);

        productIdField1.setText(id);
        productNameField1.setText(name);
        selectedItem = "";

        btnHome.addActionListener(this);
        btnClear.addActionListener(this);
        btnCancel.addActionListener(this);
        btnAdd.addActionListener(this);
        categoryList1.addActionListener(this);
        frame.setTitle("Add");
        // fetching option for Category
        readDatabase readData = new readDatabase();
        try {
            readData.readCategoryFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        categories = readData.getCategoryNames();

        String[] categoryArray = categories.toArray(new String[0]);
        catList = categoryArray;

        categoryList1 = new JComboBox(categoryArray);

//        String catDefault = categoryArray[0];

        categoryList1.addItemListener(this::itemStateChanged);

        registerForm.add(btnHome);
        registerForm.add(editProductDetailTitle);
        registerForm.setLayout(new GridLayout(0, 2,10,10));
        registerForm.add(productIdLabel);
        registerForm.add(productIdField1);
        registerForm.add(productNameLabel);
        registerForm.add(productNameField1);
        registerForm.add(productCategoryLabel);
        registerForm.add(categoryList1);
        registerForm.add(productPriceLabel);
        registerForm.add(productPriceField);
        registerForm.add(btnAdd);
        registerForm.add(btnClear);
        registerForm.add(btnCancel);
        frame.add(registerForm);
//                categoryList1.setSelectedIndex(0);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(960,720);
        frame.pack();

    }
    @Override
    public void itemStateChanged(ItemEvent e)
    {
        // if the state combobox is changed
        if (e.getSource() == categoryList1) {
            selectedItem = String.valueOf(categoryList1.getSelectedItem());
        } else {
            selectedItem = catList[0];
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean error = false;
        if (e.getSource() == btnHome || e.getSource() == btnCancel){
            frame.dispose();
            try {
                AdminHomePage adminHomePage = new AdminHomePage();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == btnClear){
            productIdField1.setText("");
            productNameField1.setText("");
            productPriceField.setText("");
        }


        if (e.getSource() == btnAdd){
            String productName = productNameField1.getText();
            Category productCat = new Category(selectedItem);
//            System.out.println(productCat);
            int productPrice = 0;
            try {
                productPrice = Integer.parseInt((productPriceField.getText()));
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(frame, "Invalid Input");
                error = true;
            }


            if ((productName.length() == 0) || (productCat.getCategoryName().length() == 0)) {
                JFrame modal = new JFrame("Unvalidated");
                modal.setVisible(true);
                JOptionPane.showConfirmDialog(null, "Please fill in all fields of the form!", "Unvalidated", JOptionPane.DEFAULT_OPTION);
                modal.dispose();
                System.out.println("False");
            } else {
                Product product = new Product(productIdField1.getText(), productName, productCat, productPrice);
                if (!error) {
                    System.out.println("Update Prod");
                    updateDatabase updateDatabase = new updateDatabase();
                    updateDatabase.editProduct("Database/products.csv", productIdField1.getText(), productIdField1.getText(), productNameField1.getText(), String.valueOf(selectedItem.getBytes()), productPriceField.getText());
                }
                JOptionPane.showMessageDialog(frame, "Successfully add new product");
                frame.dispose();
                AddNewProductForm addNewProductForm = new AddNewProductForm();
            }

        }
    }


}

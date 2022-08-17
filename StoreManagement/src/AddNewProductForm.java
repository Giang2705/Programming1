import ClassAttribute.Category;
import ClassAttribute.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class AddNewProductForm implements ActionListener, ItemListener {

    JFrame frame = new JFrame();
    private JPanel Main;
    private JPanel registerForm = new JPanel();
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

    private List<String> categories;
    private String selectedItem = "";

    AddNewProductForm(){


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


        categoryList1 = new JComboBox(categoryArray);
//        categoryList1.setSelectedItem(categoryArray[0]);
        String catDefault = categoryArray[0];

        categoryList1.addItemListener(this::itemStateChanged);

        registerForm.add(btnHome);
        registerForm.add(addNewProductTitle);
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
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean error = false;
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
            String productId = productIdField1.getText();
            String productName = productNameField1.getText();

            Category productCat = new Category(selectedItem);
//            System.out.println(productCat);
            double productPrice = 0;
            try {
                productPrice = Double.parseDouble(productPriceField.getText());
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(frame, "Invalid Input");
                error = true;
            }
            Product product = new Product(productId, productName, productCat, productPrice);
            if (!error) {
                System.out.println("Add Prod");
                storeDatabase database = new storeDatabase();
                database.createProductFile();
                database.productCountLine();
                database.addNewProduct(product);
                readDatabase readDatabase = new readDatabase();
                try {
                    readDatabase.readProductFile();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        }
    }


}

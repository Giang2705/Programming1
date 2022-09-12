package GUI.Screen;

import ClassAttribute.Admin;
import ClassAttribute.Category;
import ClassAttribute.Product;
import Functions.GenerateID;
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

    private String[] catList;
    Functions.readDatabase readDatabase = new readDatabase();
    List<Product> products = readDatabase.readProductFile();

    AddNewProductForm() throws IOException {


        String productId = GenerateID.getID(10);
        productIdField1.setText(productId);

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
                List<Admin> admins = readDatabase.readAdminFile();
                Admin admin = new Admin();
                for (int i = 0; i<admins.size(); i++){
                    if(admins.get(i).getStatus().equals("loged in")){
                        admin = admins.get(i);
                        break;
                    }
                }
                AdminHomePage adminHomePage = new AdminHomePage(admin.getAdminUsername());
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
            double productPrice = 0;
            try {
                productPrice = Double.parseDouble((productPriceField.getText()));
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
                JOptionPane.showMessageDialog(frame, "Successfully add new product");
                frame.dispose();
                try {
                    AddNewProductForm addNewProductForm = new AddNewProductForm();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        }
    }


}

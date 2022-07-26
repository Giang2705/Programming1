package GUI.Screen;

import ClassAttribute.Admin;
import ClassAttribute.Category;
import ClassAttribute.Product;
import Functions.ChangeLoginStatus;
import Functions.readDatabase;
import GUI.Components.ListOrdersAdmin;
import GUI.Components.ListProductsAdmin;
import GUI.Components.ListUsersAdmin;
//import GUI.Components.ProductsTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminHomePage implements ActionListener {
    private JButton btnLogout;
    private JPanel Main;
    private JButton btnAccount;
    private JButton addNewProductButton;
    private JButton addNewCategoryButton;
    private JPanel Management;
    private JButton productList;
    private JButton userList;
    private JButton orderList;
    private JButton refresh;
    private JTextField textField1;
    private JButton searchButton;

    public JButton getBtnAccount(){
        return btnAccount;
    }

    JFrame frame = new JFrame();

    public void listOfProducts() throws IOException {
        readDatabase readDatabase = new readDatabase();
        List<Product> products = readDatabase.readProductFile();
        ListProductsAdmin listProductsAdmin = new ListProductsAdmin(products);

        textField1.setVisible(false);
        searchButton.setVisible(false);
        Management.removeAll();
        Management.add(listProductsAdmin.getMain());
        frame.validate();
    }

    public void listOfUsers() throws IOException {
        ListUsersAdmin listUsersAdmin = new ListUsersAdmin();

        textField1.setVisible(false);
        searchButton.setVisible(false);
        Management.removeAll();
        Management.add(listUsersAdmin.getMain());
        frame.validate();
    }

    public void listOfMemberOrders() throws IOException {
        ListOrdersAdmin listOrdersAdmin = new ListOrdersAdmin();
        listOrdersAdmin.ListUserOrdersAdmin(textField1.getText());

        textField1.setVisible(true);
        searchButton.setVisible(true);
        Management.removeAll();
        Management.add(listOrdersAdmin.getMain());
        frame.validate();
    }

    public void listOfOrders() throws IOException {
        ListOrdersAdmin listOrdersAdmin = new ListOrdersAdmin();
        listOrdersAdmin.ListOrdersAdmin();

        textField1.setVisible(true);
        searchButton.setVisible(true);
        Management.removeAll();
        Management.add(listOrdersAdmin.getMain());
        frame.validate();
    }
    public AdminHomePage(String adminUsername) throws IOException {
        readDatabase readDatabase =new readDatabase();
        List<Category> categories = readDatabase.readCategoryFile();
        List<Product> products = readDatabase.readProductFile();

        textField1.setVisible(false);
        searchButton.setVisible(false);
        btnAccount.setText(adminUsername);
        productList.addActionListener(this);
        productList.setSelected(true);
        userList.addActionListener(this);
        orderList.addActionListener(this);
        refresh.addActionListener(this);
        btnLogout.addActionListener(this);
        btnAccount.addActionListener(this);
        addNewCategoryButton.addActionListener(this);
        addNewProductButton.addActionListener(this);
        searchButton.addActionListener(this);

        ListProductsAdmin listProductsAdmin = new ListProductsAdmin(products);
        ListUsersAdmin listUsersAdmin = new ListUsersAdmin();
        ListOrdersAdmin listOrdersAdmin = new ListOrdersAdmin();

        Management.setLayout(new GridLayout(1,1));
        Management.add(listProductsAdmin.getMain());


        frame.add(Main);

        frame.setTitle("Home");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(1240,720);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogout){
            frame.dispose();
            try {
                readDatabase readDatabase = new readDatabase();
                List<Admin> admins = readDatabase.readAdminFile();
                Admin admin = new Admin();
                for (int i = 0; i< admins.size(); i++){
                    admin = admins.get(i);
                }
                MemberHomePage memberHomePage = new MemberHomePage();
                ChangeLoginStatus changeLoginStatus = new ChangeLoginStatus();
                changeLoginStatus.ChangeLoginStatus(admin.getAdminId(), "loged out");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == btnAccount){
            frame.dispose();
//            AccountPage accountPage = new AccountPage();
        }
        if (e.getSource() == addNewCategoryButton) {
            frame.dispose();
            try {
                AddNewCategoryForm addNewCategoryForm = new AddNewCategoryForm();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == addNewProductButton) {
            frame.dispose();
            try {
                AddNewProductForm addNewProductForm = new AddNewProductForm();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == productList){
            try {
                productList.setSelected(true);
                userList.setSelected(false);
                orderList.setSelected(false);

                listOfProducts();

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == userList){
            try {
                productList.setSelected(false);
                userList.setSelected(true);
                orderList.setSelected(false);

                listOfUsers();

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == orderList){
            try {
                productList.setSelected(false);
                userList.setSelected(false);
                orderList.setSelected(true);

                listOfOrders();

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == searchButton){
            try {
                productList.setSelected(false);
                userList.setSelected(false);
                orderList.setSelected(true);

                listOfMemberOrders();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == refresh){
            if(productList.isSelected()){
                try {
                    listOfProducts();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            } else if (userList.isSelected()){
                try {
                    listOfUsers();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            } else if (orderList.isSelected()){
                try {
                    listOfOrders();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        List<Product> products = new ArrayList<Product>();

    }
}

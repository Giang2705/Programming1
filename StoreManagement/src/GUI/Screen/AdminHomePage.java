package GUI.Screen;

import ClassAttribute.Product;
import Functions.readDatabase;
import GUI.Components.OrdersTable;
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
    private JComboBox category;
    private JComboBox price;
    private JLabel priceSort;
    private JLabel categorySort;
    private JButton btnAccount;
    private JButton addNewProductButton;
    private JButton addNewCategoryButton;
    private JPanel Management;



    public JButton getBtnAccount(){
        return btnAccount;
    }

    JFrame frame = new JFrame();
    public AdminHomePage(List<Product> products) throws IOException {
//        ProductsTable productsTable = new ProductsTable();
//        OrdersTable ordersTable = new OrdersTable();
        ListProductsAdmin listProductsAdmin = new ListProductsAdmin(products);

        Management.setLayout(new GridLayout(1,1));
        Management.add(listProductsAdmin.Main);

        btnLogout.addActionListener(this);
        btnAccount.addActionListener(this);
        addNewCategoryButton.addActionListener(this);
        addNewProductButton.addActionListener(this);

        frame.add(Main);

        frame.setTitle("Home");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(960,720);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogout){
            frame.dispose();
            try {
                GuestHomePage guestHomePage = new GuestHomePage();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == btnAccount){
            frame.dispose();
            AccountPage accountPage = new AccountPage();
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
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        List<Product> products = new ArrayList<Product>();

    }
}

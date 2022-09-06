package GUI.AdminPage.UserList;

import ClassAttribute.Member;
import ClassAttribute.Product;
import GUI.AdminPage.NewCategory.AddNewCategoryForm;
import GUI.AdminPage.NewProduct.AddNewProductForm;
import GUI.Screen.AccountPage;
import GUI.GuestPage.GuestHomePage;
//import GUI.Components.ProductsTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminDisplayUsersList implements ActionListener {
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
    private JButton orderListButton;
    private JButton userListButton;
    private JButton productListButton;


    public JButton getBtnAccount(){
        return btnAccount;
    }

    JFrame frame = new JFrame();
    public AdminDisplayUsersList(List<Member> members) throws IOException {
//        ProductsTable productsTable = new ProductsTable();
//        OrdersTable ordersTable = new OrdersTable();
        ListUsersAdmin listUsersAdmin = new ListUsersAdmin(members);

        Management.setLayout(new GridLayout(1,1));
        Management.add(listUsersAdmin.Main);

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

package GUI.Screen;

import ClassAttribute.Member;
import ClassAttribute.Product;
import Functions.SortByPrice;
import Functions.readDatabase;
import GUI.Components.ListProducts;
import GUI.Components.modalAddToCart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.List;

public class MemberHomePage extends Component implements ActionListener, ItemListener {
    private JButton btnLogout;
    private JPanel Main;
    private JComboBox category;
    private JComboBox price;
    private JLabel priceSort;
    private JLabel categorySort;
    private JPanel productList;
    public JButton username;
    private JButton Cart;

    readDatabase readDatabase = new readDatabase();
    List<Member> members = readDatabase.readUserFile();
    Member member;
    ListProducts listProducts;
    private String selectedOption = "";

    JFrame frame = new JFrame();

    public MemberHomePage(String name) throws IOException {
        Cart.addActionListener(this);
        btnLogout.addActionListener(this);
        price.addActionListener(this);

        username.setText(name);
        for (int i = 0; i<members.size(); i++){
            if (members.get(i).getUsername().equals(name)){
                member = members.get(i);
            }
        }
        String [] optionPrice = {"default", "ascending", "descending"};
        for (int i = 0; i < optionPrice.length; i++){
            price.addItem(optionPrice[i]);
        }

        price.addItemListener(this::itemStateChanged);

        listProducts = new ListProducts(true, name, "default");
        productList.setLayout(new GridLayout(1,1));
        productList.add(listProducts.productList);

        frame.setLayout(new GridLayout());

        frame.add(Main);
        frame.setTitle("Home");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(960,720);

    }

    @Override
    public void itemStateChanged(ItemEvent e){
        if(e.getSource() == price){
            selectedOption = String.valueOf(price.getSelectedItem());
            if(selectedOption.equals("ascending")){
                try {
                    listProducts = new ListProducts(true, username.getText(), "ascending");
                    productList.removeAll();
                    productList.add(listProducts.productList);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            } else if (selectedOption.equals("descending")){
                try {
                    listProducts = new ListProducts(true, username.getText(), "descending");
                    productList.removeAll();
                    productList.add(listProducts.productList);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                try {
                    listProducts = new ListProducts(true, username.getText(), "default");
                    productList.removeAll();
                    productList.add(listProducts.productList);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } else {
            selectedOption = "default";
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Cart){
            frame.dispose();
            try {
                CartScreen cartScreen = new CartScreen(username.getText());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == btnLogout){
            frame.dispose();
            try {
                GuestHomePage guestHomePage = new GuestHomePage();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
//        if (e.getSource() == btnAccount){
//            frame.dispose();
//            AccountPage accountPage = new AccountPage();
//        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}

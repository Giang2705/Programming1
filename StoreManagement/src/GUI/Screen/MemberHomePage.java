package GUI.Screen;

import ClassAttribute.Member;
import ClassAttribute.Product;
import Functions.ChangeLoginStatus;
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
    private List<String> categories;
    private String selectedOption = "";
    String [] optionPrice = {"default", "ascending", "descending"};
    private String selectedCategory = "";

    JFrame frame = new JFrame();

    public MemberHomePage() throws IOException {
        Cart.addActionListener(this);
        btnLogout.addActionListener(this);
        price.addActionListener(this);
        category.addActionListener(this);

        for (int i = 0; i<members.size(); i++){
            if (members.get(i).getStatus().equals("loged in")){
                member = members.get(i);
                username.setText(member.getUsername());
            }
        }
        for (int i = 0; i < optionPrice.length; i++){
            price.addItem(optionPrice[i]);
        }
        price.addItemListener(this::itemStateChanged);

        readDatabase readData = new readDatabase();
        try {
            readData.readCategoryFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        categories = readData.getCategoryNames();
        for (int i = 0; i < categories.size(); i++) {
           if (i == 0) {
               category.addItem("default");
           } else {
               category.addItem(categories.get(i));
           }
        }
        category.addItemListener(this::itemStateChanged);

        listProducts = new ListProducts(true, member.getUsername(), "default", "default");
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
        if(e.getSource() == price || e.getSource() == category){
            selectedOption = String.valueOf(price.getSelectedItem());
            selectedCategory = String.valueOf(category.getSelectedItem());

            for (int i = 0; i < categories.size(); i++) {
                for (int j = 0; j < optionPrice.length; j++) {
                    if (selectedCategory.equals("default")) {
                        if (selectedOption.equals(optionPrice[j])) {
                            try {
                                listProducts = new ListProducts(true, username.getText(), optionPrice[j], "default");
                                productList.removeAll();
                                productList.add(listProducts.productList);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    } else if (selectedOption.equals(optionPrice[j]) && selectedCategory.equals(categories.get(i))) {
                        try {
                            listProducts = new ListProducts(true, username.getText(), optionPrice[j], categories.get(i));
                            productList.removeAll();
                            productList.add(listProducts.productList);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }

        } else {
            selectedOption = "default";
            selectedCategory = "default";
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Cart){
            frame.dispose();
            try {
                CartScreen cartScreen = new CartScreen(member.getUsername());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == btnLogout){
            String status = "loged out";
            frame.dispose();
            try {
                ChangeLoginStatus changeLoginStatus = new ChangeLoginStatus();
                changeLoginStatus.ChangeLoginStatus(member.getId(), status);
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

package GUI.Screen;

import ClassAttribute.*;
import Functions.*;
import GUI.Components.ConfirmedOrderModal;
import GUI.Components.ProductInCart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CartScreen implements ActionListener {
    private JPanel Main;
    private JLabel usernameLabel;
    private JLabel username;
    private JButton btnHome;
    private JButton btnConfirm;
    private JButton btnDelete;
    private JPanel ListOfAddedProducts;
    JFrame frame = new JFrame();

    public Member member() throws IOException {
        readDatabase readDatabase = new readDatabase();
        Member member = null;
        List<Member> members = readDatabase.readUserFile();
        for (int i = 0; i< members.size(); i++){
            if(members.get(i).getStatus().equals("loged in")){
                member = members.get(i);
            }
        }
        return member;
    }

    public List<Cart> getMemberCart() throws IOException {
        readDatabase readDatabase = new readDatabase();
        List<Cart> carts = readDatabase.readCartFile(); //list cart

        List<Cart> memberCart = new ArrayList<>();
        if (carts != null){
            for (int i = 0; i < carts.size(); i++) {
                if (carts.get(i).getMember().getUsername().equals(member().getUsername())) {
                    memberCart.add(carts.get(i));
                }
            }
        }

        return memberCart;
    }

    public CartScreen(String name) throws IOException {
        btnHome.addActionListener(this);
        btnConfirm.addActionListener(this);
        btnDelete.addActionListener(this);
        username.setText(name);

        getMemberCart();

        ListOfAddedProducts.setLayout(new GridLayout(getMemberCart().size(), 1));
        for (int i = 0; i < getMemberCart().size(); i++) {
            if(getMemberCart().get(i).getStatus().equals("unpaid")){
                ProductInCart productInCart = new ProductInCart();
                productInCart.getProductName().setText(getMemberCart().get(i).getProduct().getProductName());
                productInCart.getPrice().setText(String.valueOf(getMemberCart().get(i).getProduct().getProductPrice()));
                productInCart.getAmount().setText(String.valueOf(getMemberCart().get(i).getAmount()));
                productInCart.getTotal().setText(String.valueOf(getMemberCart().get(i).getTotal()));
                productInCart.getID().setText(getMemberCart().get(i).getId());
                ListOfAddedProducts.add(productInCart.Main);
            }
        }

        frame.add(Main);
        frame.setTitle("Cart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(960, 720);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnHome) {
            frame.dispose();
            try {
                MemberHomePage memberHomePage = new MemberHomePage();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == btnConfirm) {
            List<Cart> productsOrder = new ArrayList<>();
            double total = 0;
            double amountDiscount = 0;
            try {
                for(int i = 0; i<getMemberCart().size(); i++){
                    if(getMemberCart().get(i).getStatus().equals("paid")){
                        productsOrder.add(getMemberCart().get(i));
                        ChangeStatusProductInCart changeStatusProductInCart = new ChangeStatusProductInCart();
                        changeStatusProductInCart.changeStatus(getMemberCart().get(i).getId(), "confirm");
                    }
                }
                String id = "Ord.00" + GenerateID.getID(3);
                for (int i = 0; i < productsOrder.size(); i++) {
                    total += productsOrder.get(i).getTotal();
                }

//                check membership
                if(member().getMembership().equals("SILVER")){
                    Discount silverDiscount = new SilverDiscount();
                    amountDiscount = silverDiscount.calculateDiscountedAmount(total);
                    total -= amountDiscount;
                } else if(member().getMembership().equals("GOLD")){
                    Discount goldDiscount = new GoldDiscount();
                    amountDiscount = goldDiscount.calculateDiscountedAmount(total);
                    total -= amountDiscount;
                } else if(member().getMembership().equals("PLATINUM")){
                    Discount platinumDiscount = new PlatinumDiscount();
                    amountDiscount = platinumDiscount.calculateDiscountedAmount(total);
                    total -= amountDiscount;
                }

                String createdDate = GetDate.GetDate();
                String status = "Confirmed";

                Order order = new Order(id, productsOrder, total, createdDate, status);

                storeDatabase storeDatabase = new storeDatabase();
                storeDatabase.createFolder();
                storeDatabase.createOrdersFile();
                storeDatabase.ordersCountLine();
                storeDatabase.addOrder(order, productsOrder);


//                update to total spending
                Double totalSpending = null;
                GetTotalSpending getTotalSpending = new GetTotalSpending();

                totalSpending = getTotalSpending.totalSpending(member().getId(), order);
                UpdateTotalSpending updateTotalSpending = new UpdateTotalSpending();
                updateTotalSpending.update(member().getId(), totalSpending);
                ChangeMembership changeMembership = new ChangeMembership(member());


                frame.dispose();
                CartScreen cartScreen = new CartScreen(username.getText());

                ConfirmedOrderModal confirmedOrderModal = new ConfirmedOrderModal(id, order.getCart().get(0).getMember().getUsername(), amountDiscount, order.getTotal(), order.getCreatedDate(), order.getStatus());

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == btnDelete) {
            try {
                for(int i = 0; i<getMemberCart().size(); i++){
                    if(getMemberCart().get(i).getStatus().equals("delete")){
                        RemoveProductsFromCart removeProductsFromCart = new RemoveProductsFromCart();
                        removeProductsFromCart.removeProductsFromCart(getMemberCart().get(i).getId());
                    }
                }
                frame.dispose();
                CartScreen cartScreen = new CartScreen(username.getText());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
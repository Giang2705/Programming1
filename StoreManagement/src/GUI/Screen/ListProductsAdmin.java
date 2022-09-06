package GUI.Screen;

import ClassAttribute.Product;
import Functions.readDatabase;
import GUI.Components.ProductItemAdmin;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class ListProductsAdmin {
    public JPanel Main;
    private JScrollPane scrollpane;
    private JPanel ListOfProducts;

    JFrame frame = new JFrame();

    public ListProductsAdmin(List<Product> products) throws IOException {
        ListOfProducts.setLayout(new GridLayout(products.size(), 1));
        for (int i = 0; i < products.size(); i++) {
            ProductItemAdmin productItemAdmin = new ProductItemAdmin();
            productItemAdmin.getId().setText(products.get(i).getProductId());
            productItemAdmin.getName().setText(products.get(i).getProductName());
            productItemAdmin.getCategory().setText(products.get(i).getProductCategory().getCategoryName());
            productItemAdmin.getPrice().setText(String.valueOf(products.get(i).getProductPrice()));
            ListOfProducts.add(productItemAdmin.getMain());
        }

//        frame.add(Main);
//        frame.setTitle("List Of Products");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//        frame.setSize(960, 720);
    }
}

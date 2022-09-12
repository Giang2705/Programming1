package GUI.Components;

import ClassAttribute.Product;
import Functions.readDatabase;
import GUI.Components.ProductItemAdmin;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class ListProductsAdmin {
    public JPanel getMain() {
        return Main;
    }

    public JPanel Main;
    private JScrollPane scrollpane;
    private JPanel ListOfProducts;

    JFrame frame = new JFrame();

    public ListProductsAdmin(List<Product> products) throws IOException {
        readDatabase readDatabase = new readDatabase();
        ListOfProducts.setLayout(new GridLayout(products.size(), 1));
        for (int i = 0; i < products.size(); i++) {
            ProductItemAdmin productItemAdmin = new ProductItemAdmin();
            productItemAdmin.getId().setText(products.get(i).getProductId());
            productItemAdmin.getName().setText(products.get(i).getProductName());
            productItemAdmin.getCategory().setText(products.get(i).getProductCategory().getCategoryName());
            productItemAdmin.getPrice().setText(String.valueOf(products.get(i).getProductPrice()));
            ListOfProducts.add(productItemAdmin.getMain());
        }
    }
}

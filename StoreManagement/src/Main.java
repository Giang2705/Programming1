import ClassAttribute.Category;
import ClassAttribute.Member;
import ClassAttribute.Product;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        WelcomeScreen welcomeScreen = new WelcomeScreen();
//        Category new_cat = new Category("1234", "Category");
//        Product product1 = new Product("s3879069", "Phong", new_cat, 50);
//        product1.addNewProduct();
        readDatabase readData = new readDatabase();
        try {
            readData.readProductFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        System.out.println(readData.getCategoryNames());

    }
}
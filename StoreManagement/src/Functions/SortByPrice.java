package Functions;

import ClassAttribute.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortByPrice {
//    readDatabase readDatabase = new readDatabase();
    public List<Product> Ascending (List<Product> products) throws IOException {
//        List<Product> products = readDatabase.readProductFile();
        Collections.sort(products);
        return products;
    }
    public List<Product> Descending (List<Product> productsA)throws IOException {
        List<Product> products = Ascending(productsA);
        Collections.reverse(products);
        return products;
    }
}

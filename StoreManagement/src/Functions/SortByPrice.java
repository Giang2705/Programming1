package Functions;

import ClassAttribute.Product;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class SortByPrice {
    public List<Product> Ascending (List<Product> products) throws IOException {
        Collections.sort(products);
        return products;
    }
    public List<Product> Descending (List<Product> productsA)throws IOException {
        List<Product> products = Ascending(productsA);
        Collections.reverse(products);
        return products;
    }
}

package ClassAttribute;

import java.util.Arrays;

public class Category {
    private String id;
    private String name;
//    private Product[] products;

    public Category(String id,
                    String name
//                    int amt_of_product
                    ) {
        this.id = id;
        this.name = name;
//        products = new Product[amt_of_product];

    }

//    @Override
//    public String displayProductListWithinCategory() {
//        return "Category{" +
//                "products=" + Arrays.toString(products) +
//                '}';
//    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
//                ", products=" + Arrays.toString(products) +
                '}';
    }

    public String displayCategoryInfo() { return this.toString();}

    public String getCategoryId() {
        return id;
    }

    public void setCategoryId(String id) {
        this.id = id;
    }

    public String getCategoryName() {
        return name;
    }

    public void setCategoryName(String name) {
        this.name = name;
    }

//    public Product[] getProducts() {
//        return products;
//    }
//
//    public void setProducts(Product[] products) {
//        this.products = products;
//    }
}


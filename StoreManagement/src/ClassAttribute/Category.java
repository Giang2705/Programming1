package ClassAttribute;

import java.util.Arrays;

public class Category {

    private String name;
//    private Product[] products;

    public Category(String name) {

        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                '}';
    }

    public String displayCategoryInfo() { return this.toString();}


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


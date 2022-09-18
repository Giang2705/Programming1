package GUI.Components;

import ClassAttribute.Category;
import ClassAttribute.Product;
import Functions.DeleteProductInCategory;
import Functions.deleteDatabase;
import Functions.readDatabase;
import GUI.Screen.UpdateProductForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class ProductItemAdmin implements ActionListener {
    private JPanel Main;
    private JLabel IDLabel;
    private JLabel NameLabel;
    private JLabel CategoryLabel;
    private JLabel PriceLabel;
    private JLabel Action;
    private JLabel id;
    private JLabel name;
    private JLabel category;
    JFrame frame = new JFrame();

    public JPanel getMain() {
        return Main;
    }

    public void setMain(JPanel main) {
        Main = main;
    }

    public JLabel getIDLabel() {
        return IDLabel;
    }

    public void setIDLabel(JLabel IDLabel) {
        this.IDLabel = IDLabel;
    }

    public JLabel getNameLabel() {
        return NameLabel;
    }

    public void setNameLabel(JLabel nameLabel) {
        NameLabel = nameLabel;
    }

    public JLabel getCategoryLabel() {
        return CategoryLabel;
    }

    public void setCategoryLabel(JLabel categoryLabel) {
        CategoryLabel = categoryLabel;
    }

    public JLabel getPriceLabel() {
        return PriceLabel;
    }

    public void setPriceLabel(JLabel priceLabel) {
        PriceLabel = priceLabel;
    }

    public JLabel getAction() {
        return Action;
    }

    public void setAction(JLabel action) {
        Action = action;
    }

    public JLabel getId() {
        return id;
    }

    public void setId(JLabel id) {
        this.id = id;
    }

    public JLabel getName() {
        return name;
    }

    public void setName(JLabel name) {
        this.name = name;
    }

    public JLabel getCategory() {
        return category;
    }

    public void setCategory(JLabel category) {
        this.category = category;
    }

    public JLabel getPrice() {
        return price;
    }

    public void setPrice(JLabel price) {
        this.price = price;
    }

    public JButton getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(JButton btnEdit) {
        this.btnEdit = btnEdit;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(JButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    private JLabel price;
    private JButton btnEdit;
    private JButton btnDelete;
    private JLabel adminName;

    public ProductItemAdmin() {
        btnEdit.addActionListener(this);
        btnDelete.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEdit){
            Category category = new Category(null, null);
            readDatabase readDatabase = new readDatabase();
            try {
                List<Category> categories = readDatabase.readCategoryFile();
                for (int i = 0; i < categories.size(); i++){
                    if (categories.get(i).getCategoryName().equals(this.category.getText())){
                        category = categories.get(i);
                    }
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            String id = this.id.getText();
            String name = this.name.getText();
            Double price = Double.parseDouble(this.price.getText());

            try {
                UpdateProductForm updateProductForm = new UpdateProductForm(id, name, category, price);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == btnDelete){
            Category category = new Category(null, null);
            readDatabase readDatabase = new readDatabase();
            try {
                List<Category> categories = readDatabase.readCategoryFile();
                for (int i = 0; i < categories.size(); i++){
                    if (categories.get(i).getCategoryName().equals(this.category.getText())){
                        category = categories.get(i);
                    }
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            deleteDatabase deleteDatabase = new deleteDatabase();
            String id = this.id.getText();
            String name = this.name.getText();
            Double price = Double.parseDouble(this.price.getText());

            Product deletedProduct = new Product(id, name, category, price);
            deleteDatabase.removeRecord("Database/products.csv", deletedProduct);

            DeleteProductInCategory deleteProductInCategory = new DeleteProductInCategory(deletedProduct);
        }
    }
}

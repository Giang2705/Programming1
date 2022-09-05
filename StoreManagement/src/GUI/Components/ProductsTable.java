package GUI.Components;

import ClassAttribute.Product;
import Functions.readDatabase;
import GUI.Screen.UpdateProductForm;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class ProductsTable implements ActionListener {
    Functions.readDatabase readDatabase = new readDatabase();
    List<Product> products = readDatabase.readProductFile();

    public JPanel Main;
    private JTable ProductsTable;

    private JButton updateButton;

    private static class Table extends AbstractTableModel{
        private List<Product> products;
        private String[] Headers = {"id", "name", "category", "price"};

        private Table(List<Product> products){
            this.products = products;
        }

        @Override
        public int getRowCount() {
            return products.size();
        }

        @Override
        public int getColumnCount() {
            return Headers.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex){
                case 0 -> products.get(rowIndex).getProductId();
                case 1 -> products.get(rowIndex).getProductName();
                case 2 -> products.get(rowIndex).getProductCategory().getCategoryName();
                case 3 -> products.get(rowIndex).getProductPrice();
                default -> "-";
            };
        }

        @Override
        public String getColumnName(int column){
            return Headers[column];
        }
    }

    public ProductsTable() throws IOException {
        Table table = new Table(products);
        ProductsTable.setModel(table);
        ProductsTable.setAutoCreateRowSorter(true);
        updateButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updateButton) {
            UpdateProductForm updateProductForm = new UpdateProductForm();
//            updateProductForm.productIdField1.setText();
        }
    }

}

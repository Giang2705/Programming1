package GUI.Components;

import ClassAttribute.Order;
import Functions.readDatabase;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class ConfirmedOrderModal {
    private JPanel Main;
    private JLabel Title;
    private JLabel usernameLabel;
    private JLabel productsLabel;
    private JLabel totalLabel;
    private JLabel createdDateLabel;
    private JLabel statusLabel;
    private JLabel username;
    private JTable tableOfConfirmedProducts;
    private JLabel total;
    private JLabel createdDate;
    private JLabel status;
    private JButton btnPrint;
    private JLabel idLabel;
    private JLabel ID;

    readDatabase readDatabase = new readDatabase();
    List<Order> orders = readDatabase.readOrderFile(username.getText());

    Order order;
    public Order getOrder(String id) {
        for (int i = 0; i<orders.size(); i++){
            if (orders.get(i).getId().equals(id)){
                order = orders.get(i);
            }
        }
        return order;
    }

    private static class Table extends AbstractTableModel {
        private Order order;
        private String[] Headers = {"id", "name", "category", "price", "amount", "total"};

        private Table(Order order){
            this.order = order;
        }

        @Override
        public int getRowCount() {
            return order.getCart().size();
        }

        @Override
        public int getColumnCount() {
            return Headers.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex){
                case 0 -> order.getCart().get(rowIndex).getProduct().getProductId();
                case 1 -> order.getCart().get(rowIndex).getProduct().getProductName();
                case 2 -> order.getCart().get(rowIndex).getProduct().getProductCategory().getCategoryName();
                case 3 -> order.getCart().get(rowIndex).getProduct().getProductPrice();
                case 4 -> order.getCart().get(rowIndex).getAmount();
                case 5 -> order.getCart().get(rowIndex).getTotal();
                default -> "-";
            };
        }

        @Override
        public String getColumnName(int column){
            return Headers[column];
        }
    }

    JFrame frame = new JFrame();


    public ConfirmedOrderModal(String id, String name, Integer Total, String date, String stt) throws IOException {
        Table table = new ConfirmedOrderModal.Table(getOrder(id));
        tableOfConfirmedProducts.setModel(table);
        tableOfConfirmedProducts.setAutoCreateRowSorter(true);

        ID.setText(id);
        username.setText(name);
        total.setText(String.valueOf(Total));
        createdDate.setText(date);
        status.setText(stt);

        frame.setLayout(new GridLayout());

        frame.add(Main);
        frame.setTitle("Invoice");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(960,540);
    }
}

package GUI.Components;

import ClassAttribute.Order;
import Functions.readDatabase;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class OrdersTable {

    public JPanel Main;
    private JScrollPane scrollpane;
    private JTable orderTable;

    readDatabase readDatabase = new readDatabase();
    List<Order> orders = readDatabase.readOrderFile();

    private static class Table extends AbstractTableModel {
        private List<Order> orders;
        private String[] Headers = {"id", "member", "total", "status", "action"};

        private Table(List<Order> orders){
            this.orders = orders;
        }

        @Override
        public int getRowCount() {
            return orders.size();
        }

        @Override
        public int getColumnCount() {
            return Headers.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex){
                case 0 -> orders.get(rowIndex).getId();
                case 1 -> orders.get(rowIndex).getCart().get(0).getMember().getUsername();
                case 2 -> orders.get(rowIndex).getTotal();
                case 3 -> orders.get(rowIndex).getStatus();
                case 4 -> new JButton();
                default -> "-";
            };
        }

        @Override
        public String getColumnName(int column){
            return Headers[column];
        }
    }

    public OrdersTable() throws IOException {
        Table table = new Table(orders);
        orderTable.setModel(table);
        orderTable.setAutoCreateRowSorter(true);
    }
}

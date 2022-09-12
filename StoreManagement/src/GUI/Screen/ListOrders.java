package GUI.Screen;

import ClassAttribute.Order;
import Functions.GetTotalSpending;
import Functions.SearchOrder;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class ListOrders implements ActionListener {
    private JPanel Main;
    private JTable tableOrders;
    private JTextField textField1;
    private JButton searchButton;
    private JButton refreshButton;
    private JScrollPane scrollPane;

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    private String memberID;

    private static class Table extends AbstractTableModel {
        private List<Order> orders;
        private String[] Headers = {"id", "total", "created date", "status"};

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
                case 1 -> orders.get(rowIndex).getTotal();
                case 2 -> orders.get(rowIndex).getCreatedDate();
                case 3 -> orders.get(rowIndex).getStatus();
                default -> "-";
            };
        }

        @Override
        public String getColumnName(int column){
            return Headers[column];
        }
    }

    JFrame frame = new JFrame();
    public ListOrders(String id) throws IOException {
        setMemberID(id);
        searchButton.addActionListener(this);
        refreshButton.addActionListener(this);

        SearchOrder searchOrder = new SearchOrder();
        List<Order> memberOrders = searchOrder.searchOrderByMemberID(id);

        Table table = new Table(memberOrders);
        tableOrders.setModel(table);
        tableOrders.setAutoCreateRowSorter(true);

        frame.add(Main);
        frame.setTitle("Order History");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(920,350);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton){
            SearchOrder searchOrder = new SearchOrder();
            try {
                if (!textField1.getText().equals("")){
                    List<Order> order = searchOrder.searchIdOrder(getMemberID(), textField1.getText());
                    Table table = new Table(order);
                    tableOrders.setModel(table);
                    tableOrders.setAutoCreateRowSorter(true);
                    frame.validate();
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == refreshButton){
            SearchOrder searchOrder = new SearchOrder();
            try {
                textField1.setText("");
                List<Order> orders = searchOrder.searchOrderByMemberID(getMemberID());
                Table table = new Table(orders);
                tableOrders.setModel(table);
                tableOrders.setAutoCreateRowSorter(true);
                frame.validate();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}

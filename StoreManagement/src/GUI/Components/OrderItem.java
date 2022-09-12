package GUI.Components;

import ClassAttribute.Order;
import Functions.readDatabase;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class OrderItem implements ActionListener{
    private JPanel Main;
    private JLabel labelID;
    private JLabel labelMember;
    private JLabel labelTotal;
    private JLabel labelCreatedDate;
    private JLabel labelStatus;
    private JLabel labelAction;
    private JButton btnDetails;
    private JLabel id;
    private JLabel member;
    private JLabel total;
    private JLabel date;
    private JLabel status;

    public JPanel getMain() {
        return Main;
    }

    public void setMain(JPanel main) {
        Main = main;
    }

    public JLabel getLabelID() {
        return labelID;
    }

    public void setLabelID(JLabel labelID) {
        this.labelID = labelID;
    }

    public JLabel getLabelMember() {
        return labelMember;
    }

    public void setLabelMember(JLabel labelMember) {
        this.labelMember = labelMember;
    }

    public JLabel getLabelTotal() {
        return labelTotal;
    }

    public void setLabelTotal(JLabel labelTotal) {
        this.labelTotal = labelTotal;
    }

    public JLabel getLabelCreatedDate() {
        return labelCreatedDate;
    }

    public void setLabelCreatedDate(JLabel labelCreatedDate) {
        this.labelCreatedDate = labelCreatedDate;
    }

    public JLabel getLabelStatus() {
        return labelStatus;
    }

    public void setLabelStatus(JLabel labelStatus) {
        this.labelStatus = labelStatus;
    }

    public JLabel getLabelAction() {
        return labelAction;
    }

    public void setLabelAction(JLabel labelAction) {
        this.labelAction = labelAction;
    }


    public JButton getBtnDetails() {
        return btnDetails;
    }

    public void setBtnDetails(JButton btnDetails) {
        this.btnDetails = btnDetails;
    }

    public JLabel getId() {
        return id;
    }

    public void setId(JLabel id) {
        this.id = id;
    }

    public JLabel getMember() {
        return member;
    }

    public void setMember(JLabel member) {
        this.member = member;
    }

    public JLabel getTotal() {
        return total;
    }

    public void setTotal(JLabel total) {
        this.total = total;
    }

    public JLabel getDate() {
        return date;
    }

    public void setDate(JLabel date) {
        this.date = date;
    }

    public JLabel getStatus() {
        return status;
    }

    public void setStatus(JLabel status) {
        this.status = status;
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

    public OrderItem(){
        btnDetails.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDetails){
            Order order = null;
            readDatabase readDatabase = new readDatabase();
            try {
                List<Order> orders = readDatabase.readOrderFile();
                for (int i = 0; i<orders.size(); i++){
                    if(orders.get(i).getId().equals(id.getText())){
                        order = orders.get(i);
                        break;
                    }
                }
                Table table = new Table(order);
                ModalOrderDetails modalOrderDetails = new ModalOrderDetails();
                modalOrderDetails.getId().setText(id.getText());
                modalOrderDetails.getMemberName().setText(member.getText());
                modalOrderDetails.getTotal().setText(total.getText());
                modalOrderDetails.getStatus().setText(order.getStatus());
                modalOrderDetails.getTableOfConfirmedProducts().setModel(table);
                modalOrderDetails.getTableOfConfirmedProducts().setAutoCreateRowSorter(true);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}

package GUI.Components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDetails){
            ModalOrderDetails modalOrderDetails = new ModalOrderDetails();
//            modalOrderDetails.setId();
        }
    }
}

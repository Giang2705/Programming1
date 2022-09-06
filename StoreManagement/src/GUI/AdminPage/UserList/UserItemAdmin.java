package GUI.AdminPage.UserList;

import ClassAttribute.Category;
import ClassAttribute.Product;
import Functions.deleteDatabase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserItemAdmin implements ActionListener {
    private JPanel Main;
    private JLabel IDLabel;
    private JLabel NameLabel;
    private JLabel PhoneLabel;
    private JLabel MembershipLabel;
    private JLabel TotalSpendingLabel;
    private JLabel Action;
    private JLabel userID;
    private JLabel userName;
    private JLabel userTotalSpend;
    private JLabel adminName;
    private JLabel userMembership;

    private JLabel userPhone;
    JFrame frame = new JFrame();

    public JPanel getMain() {
        return Main;
    }

    public void setMain(JPanel main) {
        Main = main;
    }

    public JLabel getAction() {
        return Action;
    }

    public void setAction(JLabel action) {
        Action = action;
    }

    public JLabel getUserID() {
        return userID;
    }

    public void setUserID(JLabel id) {
        this.userID = id;
    }

    public JLabel getUserName() {
        return userName;
    }

    public void setUserName(JLabel name) {
        this.userName = name;
    }

    public JLabel getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(JLabel category) {
        this.userPhone = category;
    }

    public JLabel getUserTotalSpend() {
        return userTotalSpend;
    }

    public void setUserTotalSpend(JLabel price) {
        this.userTotalSpend = price;
    }

    public JLabel getUserMembership() {
        return userMembership;
    }

    public void setUserMembership(JLabel userMembership) {
        this.userMembership = userMembership;
    }

    public UserItemAdmin() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

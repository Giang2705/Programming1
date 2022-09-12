package GUI.Screen;

import ClassAttribute.Category;
import ClassAttribute.Member;
import ClassAttribute.Product;
import Functions.readDatabase;
import Functions.updateDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class AccountPage implements ActionListener{

    JFrame frame = new JFrame();
    private JPanel Main;
    private JPanel accountForm;
    private JLabel accountPageTitle;
    private JLabel userIdLabel;
    public JTextField userIdField1;
    private JLabel userNameLabel;
    public JTextField userNameField1;

    private JButton btnHome;

    private JLabel passwordLabel;

    public JTextField password1;
    private JLabel phoneLabel;
    private JLabel membershipLabel;
    private JLabel totalSpendingLabel;
    private JTextField phone1;
    private JTextField membership1;
    private JTextField totalSpending1;
    private JButton orderHistory;


    public AccountPage(String id, String name, String password, String phone, String membership, double total){

        userIdField1.setText(id);
        userNameField1.setText(name);
        password1.setText(password);
        phone1.setText(phone);
        membership1.setText(membership);
        totalSpending1.setText(String.valueOf(total));


        btnHome.addActionListener(this);
        orderHistory.addActionListener(this);

        frame.setTitle("Add");
        // fetching option for Category
        readDatabase readData = new readDatabase();
        try {
            readData.readCategoryFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//        String catDefault = categoryArray[0];


//        registerForm.add(btnHome);
//        registerForm.add(accountPageTitle);
//        registerForm.setLayout(new GridLayout(0, 2,10,10));
//        registerForm.add(userIdLabel);
//        registerForm.add(userIdField1);
//        registerForm.add(userNameLabel);
//        registerForm.add(userNameField1);
//        registerForm.add(passwordLabel);
//        registerForm.add(password1);
//        registerForm.add(phoneLabel);
//        registerForm.add(phone1);
//        registerForm.add(membershipLabel);
//        registerForm.add(membership1);
//        registerForm.add(totalSpendingLabel);
//        registerForm.add(totalSpending1);
        frame.add(Main);
//                categoryList1.setSelectedIndex(0);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(960,720);
        frame.pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

//        boolean error = false;
        if (e.getSource() == btnHome) {
            try {
                readDatabase readDatabase = new readDatabase();
                List<Member> members = readDatabase.readUserFile();
                for (int i = 0; i< members.size(); i++){
                    if(members.get(i).getStatus().equals("loged in")){
                        MemberHomePage memberHomePage = new MemberHomePage();
                        memberHomePage.getUsername().setText(members.get(i).getUsername());
                    }
                }
                frame.dispose();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == orderHistory) {
            try {
                ListOrders listOrders = new ListOrders(userIdField1.getText());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
//
    }

}

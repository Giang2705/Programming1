package GUI.Screen;

import ClassAttribute.Category;
import ClassAttribute.Product;
import Functions.readDatabase;
import Functions.storeDatabase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class AddNewCategoryForm implements ActionListener{

    JFrame frame = new JFrame();
    private JPanel Main;
    private JPanel addNewCategoryForm;
    private JLabel addNewCategoryTitle;
    private JLabel categoryNameLabel;
    private JTextField categoryNameField1;
    private JButton btnAdd;
    private JButton btnHome;
    private JButton btnClear;
    private JButton btnCancel;
    Functions.readDatabase readDatabase = new readDatabase();
    List<Product> products = readDatabase.readProductFile();


    AddNewCategoryForm() throws IOException {

        btnHome.addActionListener(this);
        btnAdd.addActionListener(this);
        btnClear.addActionListener(this);
        btnCancel.addActionListener(this);

        frame.setTitle("Add");
        frame.add(Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(960,720);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == btnLogin){
//            frame.dispose();
//            UserLoginPage userLoginPage = new UserLoginPage();
//        }
        if (e.getSource() == btnHome || e.getSource() == btnCancel){
            frame.dispose();
//            try {
//                AdminHomePage adminHomePage = new AdminHomePage(products);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
        }

        if (e.getSource() == btnClear){

            categoryNameField1.setText("");
        }
        if (e.getSource() == btnAdd){
            String name = categoryNameField1.getText();
            if ((name.length() == 0)) {
                JFrame modal = new JFrame("Unvalidated");
                modal.setVisible(true);
                JOptionPane.showConfirmDialog(null, "Please fill in all fields of the form!", "Unvalidated", JOptionPane.DEFAULT_OPTION);
                modal.dispose();
                System.out.println("False");
            } else {
                Category category = new Category(name);
                storeDatabase database = new storeDatabase();

//            database.createFolder();
                database.createCategoryFile();
                database.categoryCountLine();
                database.addNewCategory(category);
                readDatabase readDatabase = new readDatabase();
                try {
                    readDatabase.readCategoryFile();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}

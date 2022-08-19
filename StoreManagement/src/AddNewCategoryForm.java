import ClassAttribute.Category;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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


    AddNewCategoryForm(){

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
            AdminHomePage adminHomePage = new AdminHomePage();
        }

        if (e.getSource() == btnClear){

            categoryNameField1.setText("");
        }
        if (e.getSource() == btnAdd){
            String name = categoryNameField1.getText();
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

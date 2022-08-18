import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddNewCategoryForm implements ActionListener{

    JFrame frame = new JFrame();
    private JPanel Main;
    private JPanel addNewCategoryForm;
    //    private JLabel loginTitle;
    private JLabel categoryIDLabel;
    private JTextField categoryIDField1;

    private JLabel categoryNameLabel;
    private JTextField categoryNameField1;

//    private JLabel productCategoryLabel;
//    private JOptionPane productCategoryField1;
//
//    private JLabel productPriceLabel;
//    private JTextField productPriceField1;
    private JButton btnAdd;
    private JButton btnClear;
    private JLabel dha;
    private JButton btnCancel;

    private JButton btnHome;

    AddNewCategoryForm(){
//        btnLogin.addActionListener(this);
        btnHome.addActionListener(this);
        btnClear.addActionListener(this);
        btnCancel.addActionListener(this);
        btnAdd.addActionListener(this);

        frame.setTitle("Add New Category");
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
            GuestHomePage guestHomePage = new GuestHomePage();
        }
        if (e.getSource() == btnClear){
            categoryIDField1.setText("");

            categoryNameField1.setText("");
        }
        if (e.getSource() == btnAdd){
            String id = categoryIDField1.getText();
            String name = categoryNameField1.getText();


            storeDatabase database = new storeDatabase();
            database.createFolder();
            database.createFile();
            database.categoryCountLine();
            database.addNewCategory(id, name);
        }
    }
}

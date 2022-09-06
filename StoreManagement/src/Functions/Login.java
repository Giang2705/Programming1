package Functions;

import ClassAttribute.Admin;
import ClassAttribute.Cart;
import ClassAttribute.Member;
import ClassAttribute.Product;
import GUI.Components.LoginFailed;
import GUI.Screen.*;
import java.io.IOException;
import java.util.List;

public class Login {
//    User login
    public void UserLogin(String username, String password) throws IOException {
        boolean checked = false;
        readDatabase readDatabase = new readDatabase();

        try {
            List <Member> members = readDatabase.readUserFile();

            for (int i = 0; i<members.size(); i++){

                if (members.get(i).getUsername().equals(username) && members.get(i).getPassword().equals(password)){

                    MemberHomePage memberHomePage = new MemberHomePage(members.get(i).getUsername());
                    checked = true;
                    break;
                }
            }
            if (checked == false) {
                LoginFailed loginFailed = new LoginFailed();
                UserLoginPage userLoginPage = new UserLoginPage();
            }


        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

//    Admin login
    public void AdminLogin(String username, String password) throws IOException {
        boolean checked = false;
        readDatabase readDatabase = new readDatabase();

        try {
            List <Admin> admins = readDatabase.readAdminFile();
            List<Product> products = readDatabase.readProductFile();

            for (int i = 0; i<admins.size(); i++){

                if (admins.get(i).getAdminUsername().equals(username) && admins.get(i).getAdminPassword().equals(password)){
                    AdminHomePage adminHomePage = new AdminHomePage(products);
                    adminHomePage.getBtnAccount().setText(admins.get(i).getAdminUsername());
                    checked = true;
                    break;
                }
            }
            if (checked == false) {
                LoginFailed loginFailed = new LoginFailed();
                AdminLoginPage adminLoginPage = new AdminLoginPage();
            }

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

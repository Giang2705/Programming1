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
                    String status = "loged in";
                    ChangeLoginStatus changeLoginStatus = new ChangeLoginStatus();
                    changeLoginStatus.ChangeLoginStatus(members.get(i).getId(), status);
                    MemberHomePage memberHomePage = new MemberHomePage();
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

            for (int i = 0; i<admins.size(); i++){

                if (admins.get(i).getAdminUsername().equals(username) && admins.get(i).getAdminPassword().equals(password)){
                    String status = "loged in";
                    ChangeLoginStatus changeLoginStatus = new ChangeLoginStatus();
                    changeLoginStatus.ChangeLoginStatus(admins.get(i).getAdminId(), status);
                    AdminHomePage adminHomePage = new AdminHomePage(admins.get(i).getAdminUsername());
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

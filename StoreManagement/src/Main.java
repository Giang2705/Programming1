import ClassAttribute.Admin;
import ClassAttribute.Category;
import ClassAttribute.Member;
import ClassAttribute.Product;
import Functions.*;
import GUI.Screen.WelcomeScreen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        readDatabase readDatabase = new readDatabase();
        List<Member> members = readDatabase.readUserFile();
        List<Admin> admins = readDatabase.readAdminFile();


//           log out all of member account before running a new process
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getStatus().equals("loged in")) {
                ChangeLoginStatus changeLoginStatus = new ChangeLoginStatus();
                changeLoginStatus.ChangeLoginStatus(members.get(i).getId(), "loged out");
            }
        }
//            log out all of admin account before running a new process

        for (int j = 0; j < admins.size(); j++){
            if (admins.get(j).getStatus().equals("loged in")){
                ChangeLoginStatus changeLoginStatus = new ChangeLoginStatus();
                changeLoginStatus.ChangeLoginStatus(admins.get(j).getAdminId(), "loged out");
            }
        }

//        running welcome screen
        WelcomeScreen welcomeScreen = new WelcomeScreen();
    }
}
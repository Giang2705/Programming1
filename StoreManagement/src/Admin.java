import java.util.Scanner;

public class Admin {
    public static void main(String[] args){
        login();
    }

    public static void login() {
        String AdminAccount = "administrator";
        String AdminPassword = "12345678";

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Input Account: ");
            String account = sc.nextLine();

            System.out.print("Input Password: ");
            String password = sc.nextLine();

            if (account.trim().equals(AdminAccount.trim())
                    || password.trim().equals(AdminPassword.trim())) {
                System.out.println("Logging...");
                return;
            } else {
                System.out.println("Error");
            }
        }
    }

}

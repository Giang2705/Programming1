import java.io.*;
import java.util.Objects;
import java.util.Scanner;


public class User {
    public static void main(String[] args) throws IOException {
        userRegister();
//        userLogin();
    }


    public static void userRegister() throws IOException {

        Scanner InputData = new Scanner(new File("dataAccount.txt"));
        Scanner UserCreate = new Scanner(System.in);

        System.out.print("Name of your account: ");
        String userAccount = UserCreate.nextLine();

        System.out.print("Password: ");
        String userPassword = UserCreate.nextLine();

        while (InputData.hasNextLine()) {

            String Checking = InputData.nextLine();
            String[] ArrChecking = Checking.split(", ");

            if (!Objects.equals(userAccount, ArrChecking[0])) {
                try(FileWriter UserFile = new FileWriter("dataAccount.txt", true);
                    BufferedWriter Bw = new BufferedWriter(UserFile);
                    PrintWriter writer = new PrintWriter(Bw)){
                    writer.println(userAccount + ", " + userPassword);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else if (userAccount.trim().equals(ArrChecking[0])){
                System.out.println(ArrChecking[0]+", "+userAccount);
                System.out.println("The account already exists");
                break;
            }
        }
    }

    public static void userLogin() throws FileNotFoundException {

        Scanner InputData = new Scanner(new File("dataAccount.txt"));
        Scanner InputUser = new Scanner(System.in);

        System.out.print("Your account: ");
        String UserAccount = InputUser.nextLine();

        System.out.print("Your Password: ");
        String UserPassword = InputUser.nextLine();

        while (InputData.hasNextLine()) {

            String Checking = InputData.nextLine();
            String[] ArrChecking = Checking.split(", ");

            if (ArrChecking[0].trim().equals(UserAccount.trim())
                    && ArrChecking[1].trim().equals(UserPassword.trim()))
            {
                System.out.print("Logging");
                return;
            }

            else if (!InputData.hasNextLine()){
                System.out.println("wrong");
            }
        }
    }

}

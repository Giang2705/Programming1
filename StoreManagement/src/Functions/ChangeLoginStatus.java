package Functions;

import ClassAttribute.Admin;
import ClassAttribute.Member;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeLoginStatus {
    public void ChangeLoginStatus(String id, String status) throws IOException {
//        take array of members and admins
        ArrayList<String> tempArray = new ArrayList<>();
        readDatabase readDatabase = new readDatabase();
        List<Member> members = readDatabase.readUserFile();
        String path = "";
        try {
            try {
                for(int i = 0; i<members.size(); i++){
                    if (members.get(i).getId().equals(id)){
                        path = "Database/users.csv";
                        break;
                    }
                }
                if(path.equals("")){
                    path = "Database/admins.csv";
                }

                FileReader fr = new FileReader(path);
                Scanner reader = new Scanner(fr);
                String line;
                String[] lineArr;

                while ((line=reader.nextLine()) != null) {
                    lineArr = line.split(",");
                    if(lineArr[0].equals(id)){
                        if(path.equals("Database/users.csv")){
//                            add new database into temp array
                            tempArray.add(
                                    lineArr[0] + "," +
                                            lineArr[1] + "," +
                                            lineArr[2] + "," +
                                            lineArr[3] + "," +
                                            lineArr[4] + "," +
                                            lineArr[5] + "," +
                                            lineArr[6] + "," +
                                            status
                            );
                        } else {
//                            add new database into temp array
                            tempArray.add(
                                    lineArr[0] + "," +
                                            lineArr[1] + "," +
                                            lineArr[2] + "," +
                                            status
                            );
                        }
                    } else  {
                        tempArray.add(line);
                    }
                }
                fr.close();
            } catch (Exception e){

            }
        } catch (Exception e){

        }
        try {
            try {
//                print database of temp array into new file
                PrintWriter pr = new PrintWriter(path);

                for (int i = 0; i<tempArray.size(); i++) {
                    pr.println(tempArray.get(i));
                }
                pr.close();
            } catch (Exception e){

            }
        } catch (Exception e) {

        }
    }
}

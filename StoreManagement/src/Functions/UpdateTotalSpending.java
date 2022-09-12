package Functions;

import ClassAttribute.Member;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpdateTotalSpending {
    public void update(String id, Double totalSpending) throws IOException {
        ArrayList<String> tempArray = new ArrayList<>();
        readDatabase readDatabase = new readDatabase();
        List<Member> members = readDatabase.readUserFile();
        String path = "Database/users.csv";
        try {
            try {
                FileReader fr = new FileReader(path);
                Scanner reader = new Scanner(fr);
                String line;
                String[] lineArr;

                while ((line=reader.nextLine()) != null) {
                    lineArr = line.split(",");
                    if(lineArr[0].equals(id)){
                            tempArray.add(
                                    lineArr[0] + "," +
                                            lineArr[1] + "," +
                                            lineArr[2] + "," +
                                            lineArr[3] + "," +
                                            lineArr[4] + "," +
                                            lineArr[5] + "," +
                                            String.valueOf(totalSpending) + "," +
                                            lineArr[7]
                            );
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

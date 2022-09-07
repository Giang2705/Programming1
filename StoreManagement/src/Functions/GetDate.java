package Functions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {
    public static String GetDate(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
}

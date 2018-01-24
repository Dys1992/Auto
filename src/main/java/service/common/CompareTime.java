package common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CompareTime {
    public boolean compareTime(String time,String time1) throws ParseException {
        DateFormat df = new SimpleDateFormat("HH:mm");

            Date dt1 = df.parse(time);
            Date dt2 = df.parse(time1);

        if (dt1.getTime()>dt2.getTime()){
            return true;
        }
        else {
            return false;
        }
    }
}

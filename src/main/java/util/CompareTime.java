package searchcase.common;

import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CompareTime {
    public static final Logger log =Logger.getLogger(CompareTime.class);
    public boolean compareTime(String time,String time1) {
        DateFormat df = new SimpleDateFormat("HH:mm");

        Date dt1 = null;
        Date dt2 = null;
        try {
            dt1 = df.parse(time);
            dt2 = df.parse(time1);
        } catch (ParseException e) {
            log.error("CompareTime中时间转换失败");
            e.printStackTrace();
        }

        if (dt1.getTime()>dt2.getTime()){
            return true;
        }
        else {
            return false;
        }
    }
}

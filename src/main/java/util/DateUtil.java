package util;

import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author fy39919
 */
public class DateUtil {
    /** logger */
    private static final Logger logger               = Logger.getLogger(DateUtil.class);

    /** seconds of day */
    public final static long    ONE_DAY_SECONDS      = 86400;
    /** millseconds of day */
    public final static long    ONE_DAY_MILL_SECONDS = 86400000;

    /** yyyyMMdd日期格式 */
    public final static String  SHORT_FORMAT          = "yyyyMMdd";

    /** yyyyMMddHHmmss日期格式 */
    public final static String  LONG_FORMAT           = "yyyyMMddHHmmss";

    /** yyyy-MM-dd日期格式 */
    public final static String  WEB_FORMAT            = "yyyy-MM-dd";

    /** HHmmss日期格式 */
    public final static String  TIME_FORMAT           = "HHmmss";

    /** yyyyMM日期格式 */
    public final static String  MONTH_FORMAT          = "yyyyMM";

    /** yyyy年MM月dd日 日期格式 */
    public final static String  CHINESEDT_FORMAT      = "yyyy年MM月dd日";

    /** yyyy-MM-dd HH:mm:ss日期格式 */
    public final static String  NEW_FORMAT            = "yyyy-MM-dd HH:mm:ss";

    /** yyyy-MM-dd HH:mm日期格式 */
    public final static String  NOSECOND_FORMAT       = "yyyy-MM-dd HH:mm";

    /** HH:mm日期格式 */
    public final static String  NOSECOND_TIME_FORMAT     = "HH:mm";



    /**
     * 私有构造函数
     */
    private DateUtil(){

    }

    /**
     * @param pattern
     * @return
     */
    public static DateFormat getNewDateFormat(String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);
        df.setLenient(false);
        return df;
    }

    /**
     *当前日期
     *@return
     * 2018-01-25格式日期
     */
    public static String getToday(int addDay) {
        DateFormat dateFormat = getNewDateFormat(WEB_FORMAT);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,addDay);
        return dateFormat.format(calendar.getTime());
    }

    /**
     *当前日期
     *@return
     *HH:mm格式时间
     **/
    public static String getNoSecondTime(){
        DateFormat dateFormat = getNewDateFormat(NOSECOND_TIME_FORMAT);
        Date date = new Date();
        return  dateFormat.format(date);
    }




    public static void main(String[] args) throws ParseException {

    }


    public static boolean compareTime(String time) throws ParseException {
        Date date = new Date();
        DateFormat sdf = getNewDateFormat(NOSECOND_TIME_FORMAT);
        String nowTime = sdf.format(date);
        System.out.println(nowTime);


            Date dt1 = sdf.parse(time);
            Date dt2 = sdf.parse(nowTime);
            if (dt1.getTime()>dt2.getTime()){
                return true;
            }else {
                return false;
            }
    }
}

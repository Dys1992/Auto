package common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    /** logger */
    private static final Logger logger               = Logger.getLogger(DateUtil.class);

    /** seconds of day */
    public final static long    ONE_DAY_SECONDS      = 86400;
    /** millseconds of day */
    public final static long    ONE_DAY_MILL_SECONDS = 86400000;

    /** yyyyMMdd日期格式 */
    public final static String  shortFormat          = "yyyyMMdd";

    /** yyyyMMddHHmmss日期格式 */
    public final static String  longFormat           = "yyyyMMddHHmmss";

    /** yyyy-MM-dd日期格式 */
    public final static String  webFormat            = "yyyy-MM-dd";

    /** HHmmss日期格式 */
    public final static String  timeFormat           = "HHmmss";

    /** yyyyMM日期格式 */
    public final static String  monthFormat          = "yyyyMM";

    /** yyyy年MM月dd日 日期格式 */
    public final static String  chineseDtFormat      = "yyyy年MM月dd日";

    /** yyyy-MM-dd HH:mm:ss日期格式 */
    public final static String  newFormat            = "yyyy-MM-dd HH:mm:ss";

    /** yyyy-MM-dd HH:mm日期格式 */
    public final static String  noSecondFormat       = "yyyy-MM-dd HH:mm";

    /** HH:mm日期格式 */
    public final static String  noSecondTimeFormat     = "HH:mm";



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
    public static String getToday(int addDay) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(webFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,addDay);
        return dateFormat.format(calendar.getTime());
    }

        /**
            *HH:mm格式时间
         **/
    public static String getNoSecondTime(){
        DateFormat dateFormat = new SimpleDateFormat(noSecondTimeFormat);
        Calendar calendar = Calendar.getInstance();

        return  dateFormat.format(calendar.getTime());
    }




    public static void main(String[] args) throws ParseException {
        System.out.println(getNoSecondTime());
    }



}
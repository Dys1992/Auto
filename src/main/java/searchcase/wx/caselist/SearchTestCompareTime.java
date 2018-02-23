package searchcase.wx.caselist;

import com.alibaba.fastjson.JSON;
import model.flightrequestmodel.FlightInfo;
import model.flightresponsemodel.FlightInfoSimpleList;
import model.flightresponsemodel.WxSreachBean;
import org.apache.log4j.Logger;
import util.DateUtil;
import util.ExcelUtil;
import util.RedisUtil;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author fy39919
 */

public class SearchTestCompareTime {

        private static final Logger log = Logger.getLogger(SearchTestCompareTime.class);

        public static void compareTimeTest(String channel) throws FileNotFoundException, ParseException {

            List<FlightInfo> list = ExcelUtil.getExcelData(channel);
            log.info(channel+"渠道当前航班起飞时间是否大于当前时间开始测试:"+"\n");

            for (FlightInfo aList : list) {
                String key = channel + aList.getDepCode() + aList.getArrCode();
                boolean isAfter = compareTime(key);
                log.info(aList.getDepCode() + aList.getArrCode() + "起飞时间是否大于当前时间" + isAfter);
                assert isAfter;
            }

        }

        private static boolean compareTime(String key) throws ParseException {
            List<String> list = new ArrayList<>();
            try{
                String value = RedisUtil.getJedis().get(key);

                log.info("Key的值为："+key);
                log.info("Value的值为："+value);

                WxSreachBean jsonObject = JSON.parseObject(value, WxSreachBean.class);
                List<FlightInfoSimpleList> flightinfolist = jsonObject.getFlightInfoSimpleList();

                for (FlightInfoSimpleList aFlightinfolist : flightinfolist) {
                    list.add(aFlightinfolist.getFlyOffOnlyTime());
                }
                Collections.sort(list);

            }finally {
                RedisUtil.getJedis().close();
            }
            return  DateUtil.compareTime(list.get(0));
        }


}

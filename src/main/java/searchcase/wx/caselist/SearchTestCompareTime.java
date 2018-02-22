package searchcase.wx.caselist;

import com.alibaba.fastjson.JSON;
import constants.FilePathConstants;
import model.flightrequestmodel.FlightInfo;
import model.flightresponsemodel.FlightInfoSimpleList;
import model.flightresponsemodel.WxSreachBean;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import util.DateUtil;
import util.ExcelUtil;

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
        private static Jedis jedis = new Jedis(FilePathConstants.redisAddress);

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

        private static boolean compareTime(String key) throws  ParseException {

            List<String> list = new ArrayList<>();
            String value = jedis.get(key);

            log.info("Key的值为："+key);
            log.info("Value的值为："+value);

            WxSreachBean jsonObject = JSON.parseObject(value, WxSreachBean.class);
            List<FlightInfoSimpleList> flightinfolist = jsonObject.getFlightInfoSimpleList();

            for (FlightInfoSimpleList aFlightinfolist : flightinfolist) {
                list.add(aFlightinfolist.getFlyOffOnlyTime());
            }
            Collections.sort(list);
            return  DateUtil.compareTime(list.get(0));

        }


}

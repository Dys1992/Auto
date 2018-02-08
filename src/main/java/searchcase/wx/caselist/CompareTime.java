package searchcase.wx.caselist;

import com.alibaba.fastjson.JSON;
import common.DateUtil;
import model.flightrequestmodel.FlightInfo;
import model.flightresponsemodel.FlightInfoSimpleList;
import model.flightresponsemodel.WxSreachBean;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;
import util.ExcelUtil;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CompareTimeTest {
    public static final Logger log = Logger.getLogger(CompareTimeTest.class);

    public void compareTimeTest(String channel) throws FileNotFoundException, ParseException {
        Jedis jedis = new Jedis("127.0.0.1");
        List<FlightInfo> list = ExcelUtil.getExcelData(channel);
        log.info(channel+"渠道当前航班起飞时间是否大于当前时间开始测试:"+"\n");

        for (int i = 0;i<list.size();i++ ){
            String key = channel+list.get(i).getDepCode()+list.get(i).getArrCode();
            boolean isAfter = compareTime(key);
            log.info(list.get(i).getDepCode()+list.get(i).getArrCode()+"起飞时间是否大于当前时间"+isAfter);
            assert isAfter == true;
        }

    }

    public static boolean compareTime(String key) throws  ParseException {
        Jedis jedis = new Jedis("127.0.0.1");
        List<String> list = new ArrayList<String>();
        String value = jedis.get(key);

        log.info("Key的值为："+key);
        log.info("Value的值为："+value);

        WxSreachBean jsonObject = JSON.parseObject(value, WxSreachBean.class);
        List<FlightInfoSimpleList> flightinfolist = jsonObject.getFlightInfoSimpleList();

        for (int i=0;i< flightinfolist.size() ;i++){
            list.add(flightinfolist.get(i).getFlyOffOnlyTime());
        }
        Collections.sort(list);
        return  DateUtil.compareTime(list.get(0).toString());

    }
}

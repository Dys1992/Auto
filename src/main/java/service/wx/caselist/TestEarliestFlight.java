package service.wx;

import common.AnalyzeResponse;
import common.CompareTime;
import common.NowTime;
import common.flightinfo.cabinsInfoVO;
import common.flightinfo.flightInfoVO;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.*;

public class TestEarliestFlight {

    @Test
    public void testWxFlightOffTime() throws ParseException {


        //获取当前时间
        NowTime nowTime = new NowTime();
        String time1 = nowTime.nowTime();



        //调用JSON解析接口获取时间List
        AnalyzeResponse analyzeResponse = new AnalyzeResponse();
        List<String> list = new ArrayList<String>();
        Map<flightInfoVO, cabinsInfoVO> map = analyzeResponse.analyzeResponse();
        for(Map.Entry<flightInfoVO,cabinsInfoVO> entry : map.entrySet()){
            list.add(entry.getKey().getFlightOffTime());
        }


        //对时间List排序
        Collections.sort(list);

        String time = list.get(0).toString();
        CompareTime compareTime = new CompareTime();

        //断言，判断目前最早的航班起飞时间是否大于当前时间
        assert compareTime.compareTime(time,time1);

    }
}

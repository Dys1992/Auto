package searchcase.wx.caselist;

import com.alibaba.fastjson.JSONObject;
import util.NowTime;
import util.DataProviderSetUtil;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import model.WxSreachBean;
import util.CompareTime;
import common.GetSearchResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class WxCompareTime {

    public static final Logger log = Logger.getLogger(WxFlightSearchResponse.class);
    List list =new ArrayList();
    String WxFlightSearchResponseStr ;
    @Test(dataProvider = "testWxFlightSearch",dataProviderClass = DataProviderSetUtil.class)
    public   void  wxSearchInfo(HashMap<String, String> data)throws Exception {
        if (data != null) {
            GetSearchResponse getSearchResponse = new GetSearchResponse();
            WxFlightSearchResponseStr = getSearchResponse.getResponse(data, "wx");
            WxSreachBean wxSreachBean = JSONObject.parseObject(WxFlightSearchResponseStr, WxSreachBean.class);
            List<model.FlightInfoSimpleList> wxFlightSimpleInfo= wxSreachBean.getFlightInfoSimpleList();
//            wxFlightSimpleInfo.get()
//            list.add(wxSreachBean.get());
            log.info("微信渠道查询接口请求成功");

        } else {
            log.error("Excel获取为空");
        }
        Collections.sort(list);
        String time =  list.get(0).toString();
        NowTime nowTime = new NowTime();
        String time2 = nowTime.nowTime();
        CompareTime compareTime = new CompareTime();
        if (compareTime.compareTime(time,time2) == true){
            log.info("当前所有航班的起飞时间晚于当前时间");
        }
        else{
            log.error("查询接口有误,有起飞时间早于当前时间的航班!!");
        }
    }
}

package service.wx.caselist;

import com.alibaba.fastjson.JSONObject;
import exceldata.DataProviderSet;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pojo.WxSreachBean;
import service.common.GetSearchResponse;

import java.util.HashMap;

public class WxFlightSearchResponse {
    public static final Logger log = Logger.getLogger(WxFlightSearchResponse.class);

    String WxFlightSearchResponseStr ;
    @Test(dataProvider = "testWxFlightSearch",dataProviderClass =DataProviderSet.class)
    public   void  wxSearchInfo(HashMap<String, String> data)throws Exception
    {
       if (data != null) {
            GetSearchResponse getSearchResponse = new GetSearchResponse();
            WxFlightSearchResponseStr = getSearchResponse.getWxResponse(data, "wx");
            WxSreachBean wxSreachBean = JSONObject.parseObject(WxFlightSearchResponseStr, WxSreachBean.class);
            wxSreachBean.getArriveCity();
           log.info("微信渠道查询接口请求成功");

        }else{
            log.error("Excel获取为空");
    }
    }

}

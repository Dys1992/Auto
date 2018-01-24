package service.wx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import exceldata.DataProviderSet;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.TouchFlightSearch;
import pojo.WxSreachBean;

import java.util.HashMap;

public class WxFlightSearchResponse {
    public static final Logger log = Logger.getLogger(WxFlightSearchResponse.class);;

    String WxFlightSearchResponseStr ;
    @Test(dataProvider = "testWxFlightSearch",dataProviderClass =DataProviderSet.class)
    public   void  ValidateBaseInfo(HashMap<String, String> data)throws Exception
    {
        System.out.println(data);
        GetWxSearchResponse getWxSearchResponse = new GetWxSearchResponse();
        WxFlightSearchResponseStr = getWxSearchResponse.getWxResponse(data);
        WxSreachBean wxSreachBean = JSONObject.parseObject(WxFlightSearchResponseStr,WxSreachBean.class);
        log.info("11111111111");

        System.out.println(wxSreachBean.getArriveCity());


    }

}

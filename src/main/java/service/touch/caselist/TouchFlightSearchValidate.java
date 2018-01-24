package validate;

import pojo.TouchFlightSearch;
import com.alibaba.fastjson.JSON;
import exceldata.DataProviderSet;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.wx.GetTFlightSearchResponse;

import java.util.HashMap;

public class TouchFlightSearchValidate {
    GetTFlightSearchResponse getTFlightSearchResponse;
    String TFlightSearchResponseStr ;
    @Test(dataProvider="testTFlightSearch",dataProviderClass = DataProviderSet.class)
    public   void  ValidateBaseInfo(HashMap<String, String> data)throws Exception
    {
        System.out.println("请求参数：--->>>"+data);
        getTFlightSearchResponse = new GetTFlightSearchResponse();
        TFlightSearchResponseStr=getTFlightSearchResponse.getResponse(data);
        TouchFlightSearch touchFlightSearch = JSON.parseObject(TFlightSearchResponseStr, TouchFlightSearch.class);
        System.out.println("验证起飞机场：--->>>"+touchFlightSearch.getFlyOffCode());
        System.out.println("验证抵达机场：--->>>"+touchFlightSearch.getArriveCityCode());
        Assert.assertEquals("SHA", touchFlightSearch.getFlyOffCode());
        Assert.assertEquals("上海", touchFlightSearch.getFlyOffCity());
    }
}

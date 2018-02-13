package searchcase.wx.caselist;
import org.apache.log4j.Logger;


import java.util.HashMap;

public class WxFlightSearchResponse {
    public static final Logger log = Logger.getLogger(WxFlightSearchResponse.class);

    public   void  wxSearchInfo(HashMap<String, String> data)throws Exception
    {
       if (data != null) {
          log.info("微信渠道查询接口请求成功");

        }else{
            log.error("Excel获取为空");
    }
    }

}

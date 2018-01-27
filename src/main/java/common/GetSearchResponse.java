package common;


import util.DateUtil;
import util.HttpRequests;`

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

public class GetSearchResponse {
    public static final Logger log = Logger.getLogger(GetSearchResponse.class);

    public String getWxResponse(HashMap<String, String> data,String channel){
        String response = null;
        GetUrl getUrl = new GetUrl();
        try {
            String wxSearchUrl = getUrl.geturl(channel);
            String departureDate = null;
            try {
                departureDate = DateUtil.getToday(1);
                log.error("起飞日期获取失败");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String depCode = data.get("departure");
            String arrCode = data.get("arrival");
            String userIp = data.get("userip");
            String flat = data.get("flat");

            String productType = data.get("producttype");
            GetParam getParam = new GetParam();
            String params = getParam.getParam(depCode,arrCode,departureDate,userIp,flat,productType);

            log.info("This is param:"+params);
            log.info(channel+"渠道查询接口地址:"+wxSearchUrl);

            HttpRequests httpRequests = new HttpRequests();

            response = httpRequests.getRequests(wxSearchUrl,params);

        } catch (IOException e) {
            log.error("GetWxSearchResponse组装数据失败!");
            e.printStackTrace();
        }

        return response;


    }


}

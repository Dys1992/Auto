package common;

import constants.FilePathConstants;
import model.flightrequestmodel.FlightInfo;
import org.apache.log4j.Logger;
import util.ExcelUtil;
import util.HttpResquestUtil;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GetSearchResponse {
    public static final Logger log = Logger.getLogger(GetSearchResponse.class);

    public List<String> getResponse(String channel) throws FileNotFoundException {
        List<FlightInfo> list = ExcelUtil.getExcelData(channel);
        List<String> list1 = new ArrayList<String>();
        String response ;
        String params;
        String departureDate = null;

        try {
            String wxSearchUrl = geturl(channel);
            try {
                departureDate = common.DateUtil.getToday(1);

            } catch (ParseException e) {
                log.error("起飞日期获取失败");
                e.printStackTrace();
            }
            for(int i=0;i<list.size();i++){
                String depCode = list.get(i).getDepCode();
                String arrCode = list.get(i).getArrCode();
                if (channel.equals("wx")){
                    params = RequestParam.wxParam(depCode,arrCode,departureDate);
                    response = HttpResquestUtil.getRequests(wxSearchUrl,params);
                    list1.add(response);
                }else {
                    params = RequestParam.touchParam(depCode,arrCode,departureDate);
                    response = HttpResquestUtil.getRequests(wxSearchUrl,params);
                    list1.add(response);
                }
                log.info("This is param:"+params);
                log.info(channel+"渠道查询接口地址:"+wxSearchUrl);
                log.info(response);
            }
        } catch (IOException e) {
            log.error("GetWxSearchResponse组装数据失败!");
            e.printStackTrace();
        }
        return list1;

    }



    public String geturl(String channel) throws IOException {
        Properties prop = new Properties();
        InputStream in = null;
        File file = new File(FilePathConstants.urlFilePath);
        try {
            in = new BufferedInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        prop.load(in);
        String url = prop.getProperty(channel).trim();
        return url;
    }


}

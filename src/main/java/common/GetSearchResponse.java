package common;

import common.imp.RequestParamImpl;
import constants.FilePathConstants;
import model.flightrequestmodel.FlightInfo;
import util.ExcelUtil;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GetSearchResponse {
    public static final Logger log = Logger.getLogger(GetSearchResponse.class);

    public List<String> getWxResponse(String channel) throws FileNotFoundException {

        RequestParam param = new RequestParamImpl();

        List<FlightInfo> list = new ArrayList<FlightInfo>();
        List<String> list1 = new ArrayList<String>();
        String response = null;
        list = ExcelUtil.getExcelData();
        try {


            String wxSearchUrl = geturl(channel);
            String departureDate = null;
            try {
                departureDate = common.DateUtil.getToday(1);

            } catch (ParseException e) {
                log.error("起飞日期获取失败");
                e.printStackTrace();
            }
            for(int i=0;i<list.size();i++){
                String depCode = list.get(i).getDepCode();
                String arrCode = list.get(i).getArrCode();
                String userIp = list.get(i).getUserIp();
                String flat = list.get(i).getFlat();
                String productType  = list.get(i).getProductType();
//                if(channel.equals("wx")){
//                    param.wxParam(depCode,arrCode,departureDate,userIp,flat,productType);
//
//                }else if(channel.equals("touch")){
//                    param.touchParam(depCode,arrCode,departureDate,userIp,flat,productType)
//                }else if(channel.equals("app")){
//                    param.appParam();
//                }
                String params = getParam(depCode,arrCode,departureDate,userIp,flat,productType);
                log.info("This is param:"+params);
                log.info(channel+"渠道查询接口地址:"+wxSearchUrl);
                response = common.HttpResquestUtil.getRequests(wxSearchUrl,params);
                list1.add(response);

                log.info(response);
            }
        } catch (IOException e) {
            log.error("GetWxSearchResponse组装数据失败!");
            e.printStackTrace();
        }
        return list1;

    }



    public String getParam(String depCode,String arrCode,String depDate,String userIp,String flat,String productType){
        String param = "Departure=" + depCode + "&Arrival=" +
                arrCode + "&DepartureDate=" + depDate +
                "&userIp="+userIp+"&flat="+flat+"&ProductType="+productType+"&gettype=0&Force=2";

        return param;
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

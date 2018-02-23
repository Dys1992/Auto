package common;

import constants.FilePathConstants;
import model.flightrequestmodel.FlightInfo;
import org.apache.log4j.Logger;
import util.ExcelUtil;
import util.HttpResquestUtil;
import util.RedisUtil;

import java.io.*;
import java.util.List;
import java.util.Properties;

import static util.DateUtil.getToday;


/**
 * @author fy39919
 */
public class SaveSearchResponse {
    private static  final Logger log = Logger.getLogger(SaveSearchResponse.class);

    public void  saveResponse(String channel){

        try {
            List<FlightInfo> list = ExcelUtil.getExcelData(channel);
            for (FlightInfo aList : list) {
                String dep = aList.getDepCode();
                String arr = aList.getArrCode();
                String departureDate = getToday(FilePathConstants.flyOffTime);
                String url = getUrl(channel);
                String param = getParam(channel, dep, arr, departureDate);
                String response = HttpResquestUtil.getRequests(url, param);

                log.info(channel+"测试链接:"+url + param);
                //返回值存入redis,key(航线)value(返回参数)
                RedisUtil.getJedis().set(channel+dep + arr, response);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            RedisUtil.getJedis().close();
        }
    }


    private String getUrl(String channel){
        Properties prop = new Properties();
        InputStream in = null;
        File file = new File(FilePathConstants.urlFilePath);
        try {
            in = new BufferedInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(channel).trim();
    }



    private String getParam(String channel, String depCode, String arrCode, String depDate){
        String param = null;
        switch (channel) {
            case "wx":
                param = String.format("Departure=%s&Arrival=%s&DepartureDate=%s&userIp=012345&flat=174&ProductType=1&gettype=0&Force=2", depCode, arrCode, depDate);
                break;
            case "touch":
                param = String.format("Departure=%s&Arrival=%s&DepartureDate=%s&&userIp=123456&flat=&ProductType=0&gettype=0&Force=2", depCode, arrCode, depDate);
                break;
            case "app":
                param = null;
                break;
            case "qq":
                param = null;
                break;
        }


        return param;
    }


}

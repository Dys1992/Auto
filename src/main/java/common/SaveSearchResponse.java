package common;

import constants.FilePathConstants;
import model.flightrequestmodel.FlightInfo;
import org.testng.annotations.Test;
import util.ExcelUtil;
import util.HttpResquestUtil;

import java.io.*;
import java.text.ParseException;
import java.util.List;
import java.util.Properties;
import redis.clients.jedis.*;

/**
 * @author fy39919
 */
public class SaveSearchResponse {

    public void  saveResponse(String channel){
        Jedis jedis = new Jedis("127.0.0.1");
        try {
            List<FlightInfo> list = ExcelUtil.getExcelData(channel);

            for (int i = 0; i< list.size();i++){

                String dep = list.get(i).getDepCode();
                String arr = list.get(i).getArrCode();
                String departureDate = common.DateUtil.getToday(0);
                String url = getUrl(channel);
                String param = getParam(channel,dep,arr,departureDate);
                String response = HttpResquestUtil.getRequests(url,param);

                //返回值存入redis,key(航线)value(返回参数)
                jedis.set(dep+arr,response);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    /**
     *@Author:fy39919
     *@Date:Created in 10:53 2018/2/8
     **/

    public String getUrl(String channel){
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
        String url = prop.getProperty(channel).trim();
        return url;
    }


    /**
     *@Author:fy39919
     *@Date:Created in 10:53 2018/2/8
     **/

    public String getParam(String channel,String depCode,String arrCode,String depDate){
        String param = null;
        if(channel.equals("wx")){
            param  = "Departure=" + depCode + "&Arrival=" +
                    arrCode + "&DepartureDate=" + depDate +
                    "&userIp=012345&flat=174&ProductType=1&gettype=0&Force=2";
        }
        else if(channel.equals("touch")){
            param = "Departure=" + depCode + "&Arrival=" +
                    arrCode + "&DepartureDate=" + depDate +
                    "&userIp=123456&flat=&ProductType=0&gettype=0&Force=2";
        }
        else if(channel.equals("app")){
            param=null;
        }
        else if (channel.equals("qq")) {
            param = null;
        }


        return param;
    }


}

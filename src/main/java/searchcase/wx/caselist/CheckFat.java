package searchcase.wx.caselist;

import com.alibaba.fastjson.JSON;
import model.flightrequestmodel.FlightInfo;
import model.flightresponsemodel.Cabins;
import model.flightresponsemodel.FlightInfoSimpleList;
import model.flightresponsemodel.WxSreachBean;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import util.ExcelUtil;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class CheckFat {
    public static final Logger log = Logger.getLogger(CheckFat.class);
    public boolean check(String channel) throws FileNotFoundException {
        Jedis jedis = new Jedis("127.0.0.1");
        List<FlightInfo> list = ExcelUtil.getExcelData(channel);
        Map<String,List<String>> map = new HashMap<>();

        for(int i = 0; i < list.size() ; i++){
            List<Integer> fatList = new ArrayList<>();
            String key =channel+list.get(i).getDepCode()+list.get(i).getDepCode();
            String value = jedis.get(key);
            WxSreachBean json = JSON.parseObject(value,WxSreachBean.class);
            List<FlightInfoSimpleList> flightInfoSimpleLists = json.getFlightInfoSimpleList();
            List<Cabins> cabinsList = flightInfoSimpleLists.get(i).getCabins();

            for(int j = 0; j<cabinsList.size();j++){

                int fat = cabinsList.get(j).getFat();
                fatList.add(fat);

            }



        }
        return true;

    }

    public boolean isFatTrue(String key,List<Integer> list){
        boolean flag = false;
        boolean flag1,flag21,flag45,flag60;


        if(list.contains(1)){
            flag1 = true;
        }else {
            flag1 = false;
            log.error(key+"1政策缺失,请排查");
        }


        if(list.contains(21)){
            flag21 = true;

        }else {
            flag21 = false;
            log.error(key+"21政策缺失,请排查");
        }


        if(list.contains(45)){
            flag45 = true;

        }else {
            flag45 = false;
            log.error(key+"45政策缺失,请排查");
        }


        if(list.contains(60)){
            flag60 = true;

        }else{
            flag60 = false;
            log.error(key+"60政策缺失,请排查");
        }

        if(flag1 == true && flag21 == true && flag45 == true && flag60==true){
            flag = true;
        }else{
            flag = false;
        }

        return flag;
    }
}

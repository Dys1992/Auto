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
    public static boolean check(String channel) throws FileNotFoundException {
        boolean flag=false;
        Jedis jedis = new Jedis("127.0.0.1");
        List<FlightInfo> list = ExcelUtil.getExcelData(channel);
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();

        for(int i = 0; i < list.size() ; i++){
            List<Integer> fatList = new ArrayList<>();
            String key =channel+list.get(i).getDepCode()+list.get(i).getDepCode();
            String value = jedis.get(key);

            //解析JSON
            WxSreachBean json = JSON.parseObject(value,WxSreachBean.class);
            List<FlightInfoSimpleList> flightInfoSimpleLists =  json.getFlightInfoSimpleList();
            List<Cabins> cabinsList = new ArrayList<>();
            cabinsList                 =        flightInfoSimpleLists.get(i).getCabins();

            for(int j = 0; j<cabinsList.size();j++){
                int fat = cabinsList.get(j).getFat();

                log.info(fat);
                fatList.add(fat);

            }
            map.put(key,fatList);

        }



        return isFatTrue(map);

    }




    public static boolean isFatTrue(Map<String, List<Integer>> map){
        boolean flag = false;
        boolean flag1,flag21,flag45,flag60;
        for (Map.Entry<String,List<Integer>> entry: map.entrySet()){
            if( entry.getValue().contains(1)){
                flag1 = true;
            }else {
                flag1 = false;
                log.error(entry.getKey()+"1政策缺失,请排查");
            }


            if( entry.getValue().contains(21)){
                flag21 = true;

            }else {
                flag21 = false;
                log.error(entry.getKey()+"21政策缺失,请排查");
            }


            if( entry.getValue().contains(45)){
                flag45 = true;

            }else {
                flag45 = false;
                log.error(entry.getKey()+"45政策缺失,请排查");
            }


            if( entry.getValue().contains(60)){
                flag60 = true;

            }else{
                flag60 = false;
                log.error(entry.getKey()+"60政策缺失,请排查");
            }


            if(flag1 == true && flag21 == true && flag45 == true && flag60==true){
                flag = true;
            }else{
                flag = false;
            }
        }

        return flag;
    }
}

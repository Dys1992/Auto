package searchcase.wx.caselist;

import com.alibaba.fastjson.JSON;
import model.flightrequestmodel.FlightInfo;
import model.flightresponsemodel.Cabins;
import model.flightresponsemodel.FlightInfoSimpleList;
import model.flightresponsemodel.WxSreachBean;
import org.apache.log4j.Logger;
import util.ExcelUtil;
import util.RedisUtil;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * @author fy39919
 */
public class CheckFat {

    private static final Logger log = Logger.getLogger(CheckFat.class);
    public static boolean checkFat(String channel) throws FileNotFoundException {
        boolean flag=false;

        List<FlightInfo> list = ExcelUtil.getExcelData(channel);
        Map<String, List<Integer>> map = new HashMap<>();
        String value = null;
        try{
            for(int i = 0; i < list.size() ; i++){
                List<Integer> fatList = new ArrayList<>();
                String key =channel+list.get(i).getDepCode()+list.get(i).getDepCode();
                if(key != null){
                    value = RedisUtil.getJedis().get(key);
                }else{
                    log.error("获取redis key失败");
                }


                //解析JSON
                WxSreachBean json = JSON.parseObject(value,WxSreachBean.class);
                List<FlightInfoSimpleList> flightInfoSimpleLists =  json.getFlightInfoSimpleList();
                List<Cabins> cabinsList;
                cabinsList                 =        flightInfoSimpleLists.get(i).getCabins();

                for (Cabins aCabinsList : cabinsList) {
                    int fat = aCabinsList.getFat();

                    log.info(fat);
                    fatList.add(fat);

                }
                map.put(key,fatList);

            }
        }finally {
            RedisUtil.getJedis().close();
        }

        return isFatTrue(map);

    }




    private static boolean isFatTrue(Map<String, List<Integer>> map){
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


            flag = flag1 == true && flag21 == true && flag45 == true && flag60 == true;
        }

        return flag;
    }





    private static boolean checkFat1(String key){
        String value =  RedisUtil.getJedis().get(key);

        //FastJson解析
        WxSreachBean json = JSON.parseObject(value,WxSreachBean.class);

        //获取FlightSimple,航班信息
        List<FlightInfoSimpleList>  flightInfoList;
        flightInfoList = json.getFlightInfoSimpleList();

        for (FlightInfoSimpleList aFlightInfoList : flightInfoList) {
            //获取舱位信息
            List<Cabins> cabinList;
            cabinList = aFlightInfoList.getCabins();
            for (Cabins aCabinList : cabinList) {
                int fat = aCabinList.getFat();
                if (fat == 1) {
                }

                if (fat == 31) {

                }

                if (fat == 45) {

                }
                if (fat == 60) {

                }

            }


        }


        return true;
    }
}

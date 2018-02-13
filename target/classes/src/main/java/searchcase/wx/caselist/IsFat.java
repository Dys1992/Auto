package searchcase.wx.caselist;

import com.alibaba.fastjson.JSON;
import model.flightrequestmodel.FlightInfo;
import model.flightresponsemodel.Cabins;
import model.flightresponsemodel.FlightInfoSimpleList;
import model.flightresponsemodel.WxSreachBean;
import redis.clients.jedis.Jedis;
import util.ExcelUtil;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wyy32641
 * @version Id: IsFat, v 0.1 18/2/13 上午10:46 wyy32641 Exp $
 */
public class IsFat {

    public Map<String,List<String>> getFlat(String channel) throws FileNotFoundException {
        Jedis jedis = new Jedis("127.0.0.1");
        List<FlightInfo> list = ExcelUtil.getExcelData(channel);
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0;i<list.size();i++){
            String key=list.get(i).getDepCode()+list.get(i).getArrCode();
            String value = jedis.get(key);
            WxSreachBean json = JSON.parseObject(value, WxSreachBean.class);
            List<FlightInfoSimpleList> flightInfoList = json.getFlightInfoSimpleList();

            for(int j=0;j<flightInfoList.size();j++){
                //
                String key1 = flightInfoList.get(i).getOriginAirportCode()+
                        flightInfoList.get(i).getArriveAirportCode()+
                        flightInfoList.get(i).getFlightNo();
                List<Cabins> cabinsList = flightInfoList.get(i).getCabins();
                List<String>  list1 = new ArrayList<>();
                    for(int m=0;m<cabinsList.size();m++){
                        list1.add(String.valueOf(cabinsList.get(m).getFat()));
                    }
                map.put(key1,list1);

            }


        }


        return map;
    }



    public String isFatTrue(Map<String,List<String>> map) throws FileNotFoundException {
        map = getFlat("wx");

        for(Map.Entry<String,List<String>> entry: map.entrySet()){
            String key = entry.getKey();
            List<String> value = entry.getValue();



        }

    return " ";

    }



}

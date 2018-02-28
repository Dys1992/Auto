import model.httpparammodel.Params;
import util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

public class TestLog {

    public static void main(String[] args) {
//        Jedis jedis = new Jedis("127.0.0.1");
//        System.out.println(jedis.get("wxSHAPEK"));

//        System.out.println(HttpUtil.senGet("http://cnzhxsrvweixin.17u.cn/FlightWeiXinQueryInfo.ashx","Departure=SHA&Arrival=PEK&DepartureDate=2018-02-26&userIp=012345&flat=174&ProductType=1&gettype=0&Force=2"));

        Params params = new Params();
        params.setKey("Content-Type");
        params.setValue("application/json");
        List<Params> list = new ArrayList<>();
        list.add(params);
        String url = "http://flightadminapi.t.17usoft.com/querydataservice/api/queryprice/querycomapnylowestpriceInLines";
        String param = "{\"Token\":\"myProjectName\",\"Requests\":[{\"RefId\":\"id1\",\"From\":\"SZX\",\"To\":\"SHA\",\"DateFrom\":\"2017-11-07\",\"DateEnd\":\"2017-11-09\",\"Channel\":2,\"Companys\":[\"CA\",\"MU\",\"CZ\",\"HU\"],\"CabinCodes\":[]}]}";
        System.out.println( HttpUtil.sendPost(url,param));

//        SaveSearchResponse saveSearchResponse = new SaveSearchResponse();
//        saveSearchResponse.saveResponse("wx");
    }

}

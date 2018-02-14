import common.SaveSearchResponse;
import redis.clients.jedis.Jedis;

public class TestLog {

    public static void main(String[] args) {
//        Jedis jedis = new Jedis("127.0.0.1");
//        System.out.println(jedis.get("wxSHAPEK"));


        SaveSearchResponse saveSearchResponse = new SaveSearchResponse();
        saveSearchResponse.saveResponse("wx");
    }

}

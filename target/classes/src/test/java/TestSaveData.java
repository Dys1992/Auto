import common.SaveResponse;
import common.SaveSearchResponse;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.text.ParseException;

public class TestSaveData {
    public static void main(String[] args) throws IOException, ParseException {
        Jedis jedis = new Jedis("127.0.0.1");
        System.out.println(jedis.get("SHAPEK"));
    }
}

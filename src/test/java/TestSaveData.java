import common.SaveResponse;
import common.SaveSearchResponse;
import redis.clients.jedis.Jedis;
import searchcase.wx.caselist.CheckFat;

import java.io.IOException;
import java.text.ParseException;

public class TestSaveData {
    public static void main(String[] args) throws IOException, ParseException {
        CheckFat.check("wx");
    }
}

import common.DateUtil;
import common.SaveResponse;
import common.SaveSearchResponse;
import redis.clients.jedis.Jedis;
import searchcase.wx.caselist.CheckFat;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class TestSaveData {
    public static void main(String[] args) throws IOException, ParseException {
        System.out.println(DateUtil.getNoSecondTime());
    }
}

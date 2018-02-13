package searchcase.wx.caselist;

import org.testng.annotations.Test;

import java.text.ParseException;

public class WxBaseTest {

    @Test
    public void testCompareTime() throws ParseException {
        SearchTestCompareTime.compareTime("wx");
    }
}

package searchcase.common;

/**
 * 获取Param
 * @author fy39919
 */
public class GetParam {

    public String getParam(String depCode,String arrCode,String depDate,String userIp,String flat,String productType){
        String param = "Departure=" + depCode + "&Arrival=" +
                arrCode + "&DepartureDate=" + depDate +
                "&userIp="+userIp+"&flat="+flat+"&ProductType="+productType+"&gettype=0&Force=2";


        return param;
    }
}

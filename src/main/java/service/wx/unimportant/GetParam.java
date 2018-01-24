package service.wx;

/**
 * 获取Param
 * @author fy39919
 */
public class GetParam {

    public String getParam(String depcode,String arrcode,String depdate){
        String param = "Departure=" + depcode + "&Arrival=" +
                arrcode + "&DepartureDate=" + depdate +
                "&userIp=1234567&flat=174&ProductType=1&gettype=0&Force=2";


        return param;
    }
}

package common;

public class RequestParam {


    public static String wxParam(String depCode, String arrCode, String depDate) {
        String param = "Departure=" + depCode + "&Arrival=" +
                arrCode + "&DepartureDate=" + depDate +
                "&userIp=012345&flat=174&ProductType=1&gettype=0&Force=2";
        return param;
    }


    public static String touchParam(String depCode, String arrCode, String depDate) {
        String param = "Departure=" + depCode + "&Arrival=" +
                arrCode + "&DepartureDate=" + depDate +
                "&userIp=123456&flat=&ProductType=0&gettype=0&Force=2";
        return param;
    }



    public String appParam() {
        return null;
    }


    public String qqParam() {
        return null;
    }
}

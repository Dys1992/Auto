package common.imp;

import common.RequestParam;

public class RequestParamImpl implements RequestParam{

    @Override
    public String wxParam(String depCode, String arrCode, String depDate, String userIp, String flat, String productType) {
        String param = "Departure=" + depCode + "&Arrival=" +
                arrCode + "&DepartureDate=" + depDate +
                "&userIp="+userIp+"&flat="+flat+"&ProductType="+productType+"&gettype=0&Force=2";
        return param;
    }

    @Override
    public String touchParam(String depCode, String arrCode, String depDate, String userIp, String flat, String productType) {
        String param = "Departure=" + depCode + "&Arrival=" +
                arrCode + "&DepartureDate=" + depDate +
                "&userIp="+userIp+"&flat="+flat+"&ProductType="+productType+"&gettype=0&Force=2";
        return param;
    }


    @Override
    public String appParam() {
        return null;
    }

    @Override
    public String qqParam() {
        return null;
    }
}

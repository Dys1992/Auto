package service.wx;

//import common.DepDate;
import common.FlightOffTime;
import common.HttpRequests;
import service.common.GetUrl;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author fy39919
 */
public class GetTFlightSearchResponse {

    public  String getResponse(HashMap<String, String> data) throws IOException {
       //获取url
        GetUrl url= new GetUrl();
        String urlTouchStr= url.geturl("touch");
        //获取请求参数

        FlightOffTime dataTouch= new FlightOffTime();
        String DepartureDate=dataTouch.getDate();
        String Departure=data.get("Departure");
        String Arrival=data.get("Arrival");
        String userIp=data.get("userIp");
        String flat=data.get("flat");
        String producttype=data.get("producttype");
        String params="Departure=" + Departure + "&Arrival=" +
                Arrival + "&DepartureDate=" +DepartureDate+"&userIp="
                +userIp+"&flat="+flat+"&producttype=" + producttype;
        System.out.println("Touchrequest请求参数:--->>>"+params);
        System.out.println("Touchrequest请求报文:--->>>"+urlTouchStr+"?"+params);
        //获取响应报文
        HttpRequests HttpRequest = new HttpRequests();
        String  responseTouch =HttpRequest.getRequests(urlTouchStr,params);
        System.out.println("Touchrequestxi响应报文:--->>>"+responseTouch);
        return  responseTouch;
    }
}

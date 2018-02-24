package util;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class HttpUtils {

    private static final Logger log = Logger.getLogger(HttpUtils.class);
    private static InputStreamReader isr;
    private static BufferedReader br;


    public static String senGet(String url){

        StringBuffer sb = new StringBuffer();

            try {
                URL realUrl = new URL(url);
                URLConnection urlConnection = realUrl.openConnection();
                urlConnection.setAllowUserInteraction(false);

                isr = new InputStreamReader(realUrl.openStream());
                br = new BufferedReader(isr);
                String line;

                while ((line = br.readLine()) != null)
                {
                    sb.append(line);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return sb.toString();

    }

    public static String sendGet(String url, Map<StringBuilder,StringBuilder> param){
        StringBuilder realUrl = new StringBuilder(url);
        realUrl.append("?");
        if(param != null){
            for (Map.Entry<StringBuilder,StringBuilder> key: param.entrySet()){
                realUrl.append(key.getKey().append("=").append(key.getValue()));
            }
        }


    return realUrl.toString();
    }



}

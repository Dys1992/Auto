package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
    *@Author:fy39919
    *@Description:
    *@Date:Created in 11:09 2018/1/25
 **/   
public class HttpResquestUtil {
    /**
     * @param url
     * @param param
     * @return
     */
    public static String postRequests(String url,String param){
        PrintWriter out = null;
        String result = "";
        BufferedReader in = null;

        try{
            //拼接URL
            String urlString = url + "?"+param;
            URL realurl = new URL(urlString);

            //打开HTTP连接
            URLConnection urlConnection = realurl.openConnection();
            urlConnection.setRequestProperty("accept", "*/*");
            urlConnection.setRequestProperty("connection", "Keep-Alive");
            urlConnection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            urlConnection.setRequestProperty("Content-Type","application/json");

            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);

            out = new PrintWriter(urlConnection.getOutputStream());
            out.print(param);
            out.flush();

            in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while((line = in.readLine()) != null){
                result +=line;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            try{
                if(out != null){
                    out.close();
                }
                if(in  != null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return result;
    }


    public static String getRequests(String url,String param){

        String result = "";
        BufferedReader in = null;

        try {
            //拼接URL
            String urlString = url + "?" + param;
            URL realurl = new URL(urlString);

            //打开HTTP连接
            URLConnection urlConnection = realurl.openConnection();
            urlConnection.setRequestProperty("accept", "*/*");
            urlConnection.setRequestProperty("connection", "Keep-Alive");
            urlConnection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            urlConnection.setRequestProperty("Content-Type", "application/json");

            in = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}

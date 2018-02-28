package util;

import model.httpparammodel.Params;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

/**
 * @author fy39919
 */
public class HttpUtil {

    private static final Logger log = Logger.getLogger(HttpUtil.class);
    private static RequestConfig requestConfig = null;

    static {
        requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectionRequestTimeout(2000).build();
    }


    /**
     * 发送get请求
     * @url url 路径
     * @param param 参数
     * @return
     */
    public static String senGet(String url,String param) {
        String realUrl = url+"?"+param;
        String result = null ;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(realUrl);
        request.setConfig(requestConfig);

        try{
            CloseableHttpResponse response = client.execute(request);

            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                //读取服务器返回的字符串
                HttpEntity entity = response.getEntity();
                result = EntityUtils.toString(entity,"utf-8");
            }else{
                log.error("get请求提交失败："+realUrl);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            log.error("get请求提交失败："+realUrl);
            e.printStackTrace();
        } finally {
            request.releaseConnection();
        }


        return result;
    }


    public static String sendPost(String url, String strParam){

        CloseableHttpClient client = HttpClients.createDefault();
        String  result = null;
        HttpPost httpPost = new HttpPost(url);
        try{
            if(null != strParam){

                StringEntity entity = new StringEntity(strParam,"UTF-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                httpPost.setEntity(entity);
            }
            CloseableHttpResponse result1 = client.execute(httpPost);

            if (result1.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                try{
                    result = EntityUtils.toString(result1.getEntity(),"UTF-8");
                }catch (Exception e){
                    log.error("post请求提交失败:" + url, e);
                }
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            log.error("post请求提交失败:" + url, e);
            e.printStackTrace();
        }

        return result;

    }

    public static String sendPost(String url,String strParam,List<Params> connectType){

        CloseableHttpClient client = HttpClients.createDefault();
        String result = null;
        HttpPost httpPost = new HttpPost(url);
        try{
            if(null != strParam){

                StringEntity entity = new StringEntity(strParam,"UTF-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                httpPost.setEntity(entity);
                for (Params param : connectType){
                    httpPost.setHeader(param.getKey().toString(),param.getValue().toString());
                }
            }
            CloseableHttpResponse result1 = client.execute(httpPost);

            if (result1.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                try{
                    result = EntityUtils.toString(result1.getEntity(),"UTF-8");
                }catch (Exception e){
                    log.error("post请求提交失败:" + url, e);
                }
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            log.error("post请求提交失败:" + url, e);
            e.printStackTrace();
        }

        return result;

    }



}

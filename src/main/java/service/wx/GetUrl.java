package service.wx;

import java.io.*;
import java.util.Properties;

public class GetUrl {
    public String geturl(String channel) throws IOException {
        Properties prop = new Properties();
        InputStream in = null;
        File file = new File("src//main//java//common//url.properties");
        try {

            in = new BufferedInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        prop.load(in);
        String url = prop.getProperty(channel).trim();

        return url;
    }

}
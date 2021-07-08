
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.io.IOUtils;

public class Haker {
    //抓取Cookie內 sessionID資料
    public static void main(String[] args) throws Exception {
        String path = "http://localhost:8080/JavaWebTest/controller/bmi_session";
        String session = "JSESSIONID=D9C945C4DF1C4DD265B7613C8EAF768D";
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //塞入一個header
        conn.setRequestProperty("Cookie", session);
        conn.connect();
        InputStream is = conn.getInputStream();
        System.out.println(IOUtils.toString(is,"utf-8"));
        

    }
}

package network;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UrlTest {

    public static void doIt (String site) {

        try {
            /***/
            URL url = new URL(site);

            url.getProtocol(); // протокол соединения (http)
            url.getPort();
            url.getHost();
            url.getFile(); // файл расположения страницы ( "www.yandex.ru/cart", file = "/cart" )

            /***/
            URLConnection urlConnection = url.openConnection();

            urlConnection.getContentEncoding();
            urlConnection.getContentLength();
            urlConnection.getDate();

            /***/
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;

            httpURLConnection.getRequestMethod();
            httpURLConnection.getResponseCode();

            Map<String, List<String>> hMap = httpURLConnection.getHeaderFields();
            Set<String> hField = hMap.keySet();

            for (String k: hField) {
                System.out.println("Key: " + k + " Result: ");
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

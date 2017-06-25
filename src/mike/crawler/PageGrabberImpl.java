package mike.crawler;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Page grabber class to get web pages using jsoup
 *
 * Created by msett on 6/24/2017.
 */
public class PageGrabberImpl implements PageGrabber {
    // Act like a browser
    private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";

    public Document getPage(String url) {
        Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
        Document htmlDocument = new Document("");
        try {
            htmlDocument = connection.get();
        } catch (IOException e) {
            System.out.println("Connection failure retrieving url " + url);
        }

        if(connection.response().statusCode() != 200)
        {
            System.out.println("Failed to retrieve url " + url);
        }

        return htmlDocument;
    }
}

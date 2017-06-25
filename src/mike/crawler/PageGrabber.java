package mike.crawler;

import org.jsoup.nodes.Document;

/**
 * CLass to get a web page
 *
 * Created by msett on 6/24/2017.
 */
public interface PageGrabber {
    /**
     * Retrieve a web page
     *
     * @param url web page url to get
     * @return web page as a DOcument
     */
    Document getPage(String url);
}

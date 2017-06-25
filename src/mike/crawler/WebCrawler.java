package mike.crawler;

/**
 * Webcrawler main class
 * Created by msett on 6/23/2017.
 */
public class WebCrawler
{
    /**
     * Main method to run Webcrawler
     *
     * @param args
     *            - not used
     */
    public static void main(String[] args)
    {
        String url;
        if (args.length > 0) {
            url = args[0];
        }
        else {
            url = "http://wiprodigital.com";
        }
        DomainCrawler domainCrawler = new DomainCrawler();
        domainCrawler.crawlDomain(url);
    }
}

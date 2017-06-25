package mike.crawler;

/**
 * Class to crawl an entire domain and generate a sitemap.
 *
 * Created by msett on 6/23/2017.
 */

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DomainCrawler
{
    /**
     * Scan a domain for links to generate a sitemap.
     *
     * @param url top level url for the domain
     */
    public void crawlDomain(String url)
    {
        URL topUrl = null;
        try {
            topUrl = new URL(url);
        } catch (MalformedURLException e) {
            System.out.println("Failure parsing url " + url);
            return;
        }
        String domain = topUrl.getHost();

        Map<String, PageContent> pagesCrawled = new LinkedHashMap<>(); // stores processed pages and content
        List<String> pagesToProcess = new LinkedList<>(); // LinkedList to process pages in the order found.
        
        pagesToProcess.add(url);

        while(pagesToProcess.size() > 0) {
            String currentUrl = pagesToProcess.get(0);
            pagesToProcess.remove(0);
            pagesCrawled.put(currentUrl, new PageContent());
            PageCrawler leg = new PageCrawler(new PageGrabberImpl());

                System.out.println("Crawled page " + currentUrl);

            leg.crawlPage(currentUrl, domain, pagesCrawled, pagesToProcess);
            System.out.println("To scan: " + pagesToProcess.size() + ", scanned: " + pagesCrawled.size());
        }
        System.out.println("\nCrawled " + pagesCrawled.size() + " web pages");
        
        printPrettyReport(pagesCrawled);
    }

    /**
     * Create a formatted report written to the console
     *
     * @param pagesCrawled Map of pages scanned
     */
    private void printPrettyReport(Map<String, PageContent> pagesCrawled) {
        for (Map.Entry<String, PageContent> entry : pagesCrawled.entrySet()) {
            PageContent pageContent = entry.getValue();
            System.out.println("\nPage: " + entry.getKey());
            System.out.println("  Internal Links:");

            for (String link : pageContent.getDomainLinks()) {
                System.out.println("    " + link);
            }

            System.out.println("  External Links:");

            for (String link : pageContent.getExternalLinks()) {
                System.out.println("    " + link);
            }

            System.out.println("  Images:");

            for (String link : pageContent.getImages()) {
                System.out.println("    " + link);
            }
        }

            

    }
}
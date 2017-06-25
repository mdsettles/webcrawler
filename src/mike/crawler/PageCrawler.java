package mike.crawler;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Parse a single web page, gathering all the links and images contained within.
 *
 * Created by msett on 6/23/2017.
 */
public class PageCrawler
{
    private static final String SEPARATOR = "/";
    private PageGrabber pageGrabber;


    public PageCrawler(PageGrabber pageGrabber) {
        this.pageGrabber = pageGrabber;
    }

    public void crawlPage(String url, String domain, Map<String, PageContent> crawled, List<String> pagesToProcess)
    {
        try
        {
            Set<String> domainLinks = new HashSet<>();
            Set<String> externalLinks = new HashSet<>();

            Document htmlDocument = pageGrabber.getPage(url);
            Elements links = htmlDocument.select("a[href]");
            System.out.println("Found " + links.size() + " links");
            int newLinks = 0;
            for(Element link : links)
            {
                // Don't want to include images in page links
                if (isImage(link)) {
                    continue;
                }

                // Format the url to exclude duplicates
                String href = link.absUrl("href");
                URL newUrl = new URL(href);
                String baseUrl = newUrl.getProtocol() + "://" + newUrl.getHost() + newUrl.getPath();
                if (baseUrl.lastIndexOf(SEPARATOR) == baseUrl.length()-1) {
                    baseUrl = baseUrl.substring(0,baseUrl.length()-1);
                }

                if (newUrl.getHost().contains(domain)) {
                    // Store domain links for this page
                    domainLinks.add(baseUrl);
                    // Add to the page to process, excluding duplicates
                    if (!crawled.containsKey(baseUrl) && !pagesToProcess.contains(baseUrl)) {
                        pagesToProcess.add(baseUrl);
                        newLinks++;
                    }
                }
                else {
                    // Add external links for the page
                    externalLinks.add(baseUrl);
                }
            }

            System.out.println("Added " + newLinks + " new links");

            Set<String> imageSet = new HashSet<>();
            Elements images = htmlDocument.select("img");
            for (Element image : images) {
                imageSet.add(image.attr("abs:src"));
            }

            // Now save the information gathered for later processing
            crawled.get(url).setDomainLinks(domainLinks);
            crawled.get(url).setExternalLinks(externalLinks);
            crawled.get(url).setImages(imageSet);

        }
        catch(IOException e)
        {
            System.out.println("Failed to crawlPage URL " + url);
        }
    }

    /**
     * Determine if a link is for an image
     *
     * @param link link to check
     * @return true if the link is an image link
     */
    private boolean isImage(Element link) {
        boolean isImage = false;
        for (Node node : link.childNodes()) {
            if (node.nodeName().equals("img")) {
                isImage = true;
                break;
            }
        }

        return isImage;
    }
}

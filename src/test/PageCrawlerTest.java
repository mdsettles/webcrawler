package test;

import mike.crawler.PageContent;
import mike.crawler.PageCrawler;
import mike.crawler.PageGrabber;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Tests for PageCrawler class
 * Created by msett on 6/24/2017.
 */
public class PageCrawlerTest {
    private static final String DOMAIN = "www.w3schools.com";
    // Run once, e.g. Database connection, connection pool

    @Test
    public void testPageCrawler() {
        PageGrabber pageGrabber = new TestPageGrabberImpl();
        PageCrawler pageCrawler = new PageCrawler(pageGrabber);
        Map<String, PageContent> crawled = new LinkedHashMap<>();
        List<String> pagesToProcess = new LinkedList<>();

        String url = "https://" + DOMAIN;
        crawled.put(url, new PageContent());

        pageCrawler.crawlPage(url, DOMAIN, crawled, pagesToProcess);
        Assert.assertEquals(1, crawled.size());

        Set<String> domainLinks = crawled.get(url).getDomainLinks();
        Assert.assertEquals(3, domainLinks.size());
        Assert.assertTrue(domainLinks.contains(url));
        Assert.assertTrue(domainLinks.contains(url + "/test1"));
        Assert.assertTrue(domainLinks.contains(url + "/test2"));

        Set<String> externalLinks = crawled.get(url).getExternalLinks();
        Assert.assertEquals(2, externalLinks.size());
        Assert.assertTrue(externalLinks.contains("http://www.google.com"));
        Assert.assertTrue(externalLinks.contains("http://www.yahoo.com/test2"));

        Set<String> images = crawled.get(url).getImages();
        Assert.assertEquals(3, images.size());
        Assert.assertTrue(images.contains("http://www.test.com/logo.png"));
        Assert.assertTrue(images.contains("http://www.test.com/logo2.png"));
    }
}

package test;

import mike.crawler.PageGrabber;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Created by msett on 6/24/2017.
 */
public class TestPageGrabberImpl implements PageGrabber {

    public Document getPage(String url) {
        String HTMLSTring = "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<title>JSoup Example</title>"
                + "</head>"
                + "<body>"
                + "<table><tr><td><h1>HelloWorld</h1></tr>"
                + "</table>"
                + "<a href=\"https://www.w3schools.com\">Visit W3Schools</a> "
                + "<a href=\"https://www.w3schools.com\">Visit W3Schools</a> "
                + "<a href=\"https://www.w3schools.com/test1\">Visit W3Schools</a> "
                + "<a href=\"https://www.w3schools.com/test1\">Visit W3Schools duplicate</a> "
                + "<a href=\"https://www.w3schools.com/test1/\">Visit W3Schools duplicate 2</a> "
                + "<a href=\"https://www.w3schools.com/test2\">Visit W3Schools</a> "
                + "<a href=\"https://www.w3schools.com/test2/#testing\">Visit W3Schools extra duplicate</a> "
                + "<a href=\"http://www.google.com/\">Google</a> "
                + "<a href=\"http://www.yahoo.com/test2\">Yahoo</a> "
                + "<a href=\"http://wiprodigital.com\"> <img src=\"http://www.test.com/logo.png\"> </a> "
                + "<a href=\"http://wiprodigital.com\"> <img src=\"http://www.test.com/logo2.png\"> </a> "
                + "<img src=\"smiley2.gif\"> "
                + "</body>"
                + "</html>";

        Document htmlDocument = Jsoup.parse(HTMLSTring);;

        return htmlDocument;
    }
}

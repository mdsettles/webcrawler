package mike.crawler;

import java.util.Set;

/**
 * Class to hold the references found within a web page.
 *
 * Created by msett on 6/24/2017.
 */
public class PageContent {
    private Set<String> domainLinks;
    private Set<String> externalLinks;
    private Set<String> images;

    public Set<String> getDomainLinks() {
        return domainLinks;
    }

    public void setDomainLinks(Set<String> domainLinks) {
        this.domainLinks = domainLinks;
    }

    public Set<String> getExternalLinks() {
        return externalLinks;
    }

    public void setExternalLinks(Set<String> externalLinks) {
        this.externalLinks = externalLinks;
    }

    public Set<String> getImages() {
        return images;
    }

    public void setImages(Set<String> images) {
        this.images = images;
    }
}

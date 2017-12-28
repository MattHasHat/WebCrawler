package hayworth_brighton_final.webcrawler;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matt Hayworth
 * @author Sam Brighton
 */
public class WebPageTest {

    String test = "https://www.unca.edu/";
    WebPage wp = new WebPage(test);

    @Test
    public void testWebPage() throws Exception {
        assertNotNull(wp);
        assertEquals(wp.getURL(), test);
    }

    @Test
    public void testGetURL() {
        assertEquals(wp.getURL(), test);
    }

    @Test
    public void testGetAllImages() {
        wp.crawl();
        assertNotNull(wp.getAllImages());
    }

    @Test
    public void testGetAllFiles() {
        wp.crawl();
        assertNotNull(wp.getAllFiles());
    }

    @Test
    public void testGetContainedURL() {
        wp.crawl();
        assertNotNull(wp.getContainedURL(1));
    }

    @Test
    public void testGetPagesSize() {
        wp.crawl();
        assertTrue(wp.getPagesSize() > 0);
    }

    @Test
    public void testSetURL() {
        wp.setURL("New URL");
        assertEquals(wp.getURL(), "New URL");
    }

    @Test
    public void testCrawl() {
        wp.crawl();
        assertTrue(wp.getAllImages().size() > 0);
        assertTrue(wp.getAllFiles().size() > 0);
        assertTrue(wp.getPagesSize() > 0);
    }

    @Test
    public void testGetImages() {
        wp.crawl();
        assertTrue(wp.getAllImages().size() > 0);
    }

    @Test
    public void testGetFiles() {
        wp.crawl();
        assertTrue(wp.getAllFiles().size() > 0);
    }

    @Test
    public void testWebPages() {
        wp.crawl();
        assertTrue(wp.getPagesSize() > 0);
    }
}

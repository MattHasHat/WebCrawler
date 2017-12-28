package webcrawler;

import webcrawler.WebFile;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matt Hayworth
 * @author Sam Brighton
 */
public class WebFileTest {

    String test = "https://www.unca.edu/";
    WebFile wf = new WebFile(test);

    @Test
    public void testWebFile() {
        assertNotNull(wf);
        assertEquals(wf.getURL(), test);
    }

    @Test
    public void testGetURL() {
        assertEquals(wf.getURL(), test);
    }

    @Test
    public void tesSetURL() {
        wf.setURL("New URL");
        assertEquals(wf.getURL(), "New URL");
    }
}

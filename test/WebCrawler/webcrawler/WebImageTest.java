package hayworth_brighton_final.webcrawler;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matt Hayworth
 * @author Sam Brighton
 */
public class WebImageTest {

    String test = "<img 'Test'>";
    WebImage wi = new WebImage(test);

    @Test
    public void testWebFile() {
        assertNotNull(wi);
        assertEquals(wi.getTag(), test);
    }

    @Test
    public void testGetURL() {
        assertEquals(wi.getTag(), test);
    }

    @Test
    public void testSetURL() {
        wi.setTag("<img 'New Tag'>");
        assertEquals(wi.getTag(), "<img 'New Tag'>");
    }
}

package hayworth_brighton_final.webcrawler;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author matth
 */
public class DownloadRepositoryTest {

    @Test
    public void testGetInstance() {
        assertNotNull(DownloadRepository.getInstance());
        assertEquals(DownloadRepository.getInstance(), DownloadRepository.getInstance());
    }
}

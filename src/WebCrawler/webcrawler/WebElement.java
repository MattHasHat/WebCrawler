package hayworth_brighton_final.webcrawler;

import java.io.File;

/**
 *
 * @author Matt Hayworth
 * @author Sam Brighton
 */
public interface WebElement {

    /**
     * Writes the contents of passed to object to a given File.
     *
     * @param file File that is being written to.
     */
    public void saveToFile(File file);
}

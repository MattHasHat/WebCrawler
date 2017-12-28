package webcrawler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matt Hayworth
 * @author Sam Brighton
 */
public class WebFile implements WebElement {

    private String url;

    /**
     * Writes the contents of passed to object to a given file.
     *
     * @param file File that is being written to.
     */
    @Override
    public void saveToFile(File file) {

        try {
            FileWriter stuff = new FileWriter(file, true);
            try (BufferedWriter bw = new BufferedWriter(stuff)) {
                bw.write(this.getURL());
                bw.write("\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(WebImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Constructor for WebFile Class that initializes the URL variable.
     *
     * @param url String representation of the URL for the file.
     */
    public WebFile(String url) {
        this.url = url;
    }

    /**
     * Getter method for the URL variable.
     *
     * @return String representation of the URL for the file.
     */
    public String getURL() {
        return url;
    }

    /**
     * Setter method for the URL variable.
     *
     * @param url String that can be used as URL for a file.
     */
    public void setURL(String url) {
        this.url = url;
    }
}

package hayworth_brighton_final.webcrawler;

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
public class WebImage implements WebElement {

    private String tag;

    /**
     * Writes the contents of passed to object to a given File.
     *
     * @param file File that is being written to.
     */
    @Override
    public void saveToFile(File file) {

        try {
            FileWriter stuff = new FileWriter(file, true);
            try (BufferedWriter bw = new BufferedWriter(stuff)) {
                bw.write(this.getTag());
                bw.write("\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(WebImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Constructor for WebImage Class that initializes the tag variable.
     *
     * @param tag String representation of the HTML for the image.
     */
    public WebImage(String tag) {
        this.tag = tag;
    }

    /**
     * Getter method for the tag variable.
     *
     * @return String representation of the HTML of the image.
     */
    public String getTag() {
        return tag;
    }

    /**
     * Setter method for the tag variable.
     *
     * @param tag String that can be used as HTML for an image.
     */
    public void setTag(String tag) {
        this.tag = tag;
    }
}

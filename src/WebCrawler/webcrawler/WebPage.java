package hayworth_brighton_final.webcrawler;

import java.util.ArrayList;
import java.net.URL;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Matt Hayworth
 * @author Sam Brighton
 */
public class WebPage implements WebElement {

    private String url;
    private String contents;
    private ArrayList<WebImage> images;
    private ArrayList<WebFile> files;
    private ArrayList<WebPage> pages;

    /**
     * Constructor for the WebPage Class that initialize URL and constructs an
     * empty String for contents and empty ArrayLists for images, files, and
     * pages
     *
     * @param url String representation of the URL for the web page.
     */
    public WebPage(String url) {
        this.url = url;
        this.contents = "";
        this.images = new ArrayList<>();
        this.files = new ArrayList<>();
        this.pages = new ArrayList<>();
    }

    /**
     * Writes the contents of passed to object to a given File.
     *
     * @param file File that is being written to.
     */
    @Override
    public void saveToFile(File file) {

    }

    /**
     * Getter method for the URL variable.
     *
     * @return String representation of the URL for the web page.
     */
    public String getURL() {
        return url;
    }

    /**
     * Getter method for the images ArrayList.
     *
     * @return ArrayList containing all image tags for a web page.
     */
    public ArrayList getAllImages() {
        return images;
    }

    /**
     * Getter method for the files ArrayList.
     *
     * @return ArrayList containing all file URLs on a web page.
     */
    public ArrayList getAllFiles() {
        return files;
    }

    /**
     * Getter method to return a specified URL link from a web page.
     *
     * @param i the index of the web page URL being accessed.
     * @return String representation of a URL in the web page.
     */
    public String getContainedURL(int i) {
        return pages.get(i).getURL();
    }

    /**
     * Finds the size of the pages ArrayList.
     *
     * @return Integer representing how many web pages were linked from the web
     * page.
     */
    public int getPagesSize() {
        return pages.size();
    }

    /**
     * Setter method for the URL variable.
     *
     * @param url String that can be used as URL for a file.
     */
    public void setURL(String url) {
        this.url = url;
    }

    /**
     * Creates a URL from the URL variable and then reads in the contents of the
     * corresponding web page; concatenating it together as the String HTML and
     * then passes that to WebPages content variable. Then it calls the methods
     * getImages(), getFiles, and getWebPages() to parse the content and find
     * the appropriate returns.
     */
    public void crawl() {
        String html = "";
        try {
            URL inputURL = new URL(url);
            BufferedReader in = new BufferedReader(new InputStreamReader(inputURL.openStream()));
            String s;
            while ((s = in.readLine()) != null) {
                html += s;
            }
        } catch (MalformedURLException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        contents = html;

        getImages();
        getFiles();
        getWebPages();

    }

    /**
     * Pattern matches the contents of a WebPage to find the HTML tags for
     * images.
     */
    public void getImages() {
        Pattern p = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
        Matcher m = p.matcher(contents);

        while (m.find()) {
            images.add(new WebImage(contents.substring(m.start(), m.end())));
        }
    }

    /**
     * Pattern matches the contents of a WebPage to find the URL for non web
     * page file links.
     */
    public void getFiles() {
        Pattern p = Pattern.compile("\\b((https?|ftp|file):/)?/[-a-zA-Z0-9+&@#/%?=~_|!:,.;]+\\.(cs|exe|html|java|js|pdf|php|txt|zip)");
        Matcher m = p.matcher(contents);

        while (m.find()) {
            files.add(new WebFile(contents.substring(m.start(), m.end())));
        }
    }

    /**
     * Pattern matches the contents of a WebPage to find the URL for links to
     * other web pages.
     */
    public void getWebPages() {
        Pattern p = Pattern.compile("\\b(https?|ftps?)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]+\\.(com|edu|mil|net|org)");
        Matcher m = p.matcher(contents);

        while (m.find()) {
            pages.add(new WebPage(contents.substring(m.start(), m.end())));
        }
    }
}

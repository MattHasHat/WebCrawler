package hayworth_brighton_final.webcrawler;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Matt Hayworth
 * @author Sam Brighton
 */
public class WebCrawler {

    /**
     * Main method for the package to be run from.
     *
     * @param args The three arguments read from the command line which are the
     * starting URL, the depth of the search, and the file location to be
     * written to.
     */
    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Web Crawler Accepts 3 command line Arguements in the form :");
            System.out.println("startingUrl depthOfCrawl localRepository");
            return;
        }

        String startingURL = args[0];
        int depth = Integer.parseInt(args[1]);
        String localDirectory = args[2];

        DownloadRepository repo = DownloadRepository.getInstance();
        File currRepo = repo.openFile(localDirectory);

        ArrayList<String> URLsToSearch = new ArrayList<>();
        ArrayList<String> searchedURLs = new ArrayList<>();

        URLsToSearch.add(startingURL);
        while (!URLsToSearch.isEmpty()) {
            for (int i = 0; i < URLsToSearch.size(); i++) {
                String url = URLsToSearch.remove(0);
                if (!searchedURLs.contains(url)) {
                    WebPage wp = new WebPage(url);
                    wp.crawl();

                    ArrayList<WebImage> images = new ArrayList(wp.getAllImages());
                    ArrayList<WebFile> files = new ArrayList(wp.getAllFiles());

                    while (!images.isEmpty()) {
                        images.remove(0).saveToFile(currRepo);
                    }
                    while (!files.isEmpty()) {
                        files.remove(0).saveToFile(currRepo);
                    }

                    for (int j = 0; j < wp.getPagesSize(); j++) {
                        URLsToSearch.add(wp.getContainedURL(j));
                    }
                    searchedURLs.add(url);
                }
                if (searchedURLs.size() >= depth) {
                    break;
                }
            }
            if (searchedURLs.size() >= depth) {
                break;
            }
        }
    }
}

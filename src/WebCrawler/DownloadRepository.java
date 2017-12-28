package webcrawler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Matt Hayworth
 * @author Sam Brighton
 */
public class DownloadRepository {

    private DownloadRepository() {

    }

    /**
     * Method to get an instance of the DownloadRepository singleton.
     *
     * @return Instance of this class.
     */
    public static DownloadRepository getInstance() {
        return DownloadRepositoryHolder.INSTANCE;
    }

    private static class DownloadRepositoryHolder {

        private static final DownloadRepository INSTANCE = new DownloadRepository();
    }

    /**
     * Opens a given file or creates on in a given path and then opens it to be
     * written to.
     *
     * @param localDirectory String representation of the path to the directory
     * that is to be written to.
     * @return File that will be written to.
     */
    public File openFile(String localDirectory) {

        File file = new File(localDirectory);

        try (FileOutputStream fos = new FileOutputStream(file)) {

            if (!file.exists()) {
                file.createNewFile();
                System.out.println("Repository File Created");
            } else {
                System.out.println("Repository File already exists");
            }
        } catch (IOException e) {

            System.out.println("Error" + e.getMessage());

        }

        return file;
    }
}

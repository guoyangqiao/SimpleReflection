package exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/13/16.
 */
public class FileException {

    private BufferedReader bufferedReader;

    public FileException(String fileName) {
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            try {
                bufferedReader.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            throw e;
        } finally {

        }
    }
}

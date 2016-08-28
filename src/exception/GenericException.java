package exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/13/16.
 */
public class GenericException {


    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader(args[0]);
            //在创立一个需要之后被清理的对象后, 马上进入try-finally
            try {
                int read = fileReader.read();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

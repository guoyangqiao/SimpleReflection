package IO;

import java.io.File;
import java.io.IOException;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 6/20/16.
 */
public class IterationFile {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/guoyangqiao/dump.rdb");
        System.out.println(file.canExecute());
        System.out.println(file.setExecutable(true));
        System.out.println(file.canExecute());
    }

    static void iter(File file, String space) {
        if (file.isDirectory()) {
            space += " ";
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    System.out.println(space + f.getName());
                    if (f.isDirectory()) {
                        iter(f, space);
                    }
                }
            }
        }
    }
}
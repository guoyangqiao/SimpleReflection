package system_command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 8/23/16.
 */
public class Did {
    public static void main(String[] args) {
        String command = "/bin/sh,-c,ps -ef | grep java";
        Process process = null;
        try {
            process = new ProcessBuilder(command.split(",")).start();
            BufferedReader standardReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader errReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            standardReader.lines().forEach(e -> System.out.println(e));
            errReader.lines().forEach(e -> System.out.println(e));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

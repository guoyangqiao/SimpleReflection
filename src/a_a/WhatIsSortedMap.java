package a_a;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 6/20/16.
 */
public class WhatIsSortedMap {
    public static void main(String[] args) {
        File file = new File("/Users/guoyangqiao");
        String[] list = file.list(new DirFilter("^[1-9]+[0-9]*$"));
        for(String x:list){
            System.out.println(x);
        }

    }
}

class DirFilter implements FilenameFilter {
    private Pattern pattern;

    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
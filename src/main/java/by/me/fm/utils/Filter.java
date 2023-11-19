package by.me.fm.utils;

import java.io.File;
import java.io.FileFilter;

public class Filter implements FileFilter {
    @Override
    public boolean accept(File file) {
        return false;
    }
}
package me.yaccamc.clipack.api;

import java.io.File;

@FunctionalInterface
public interface FileFilter {
    boolean accept(File file);
}

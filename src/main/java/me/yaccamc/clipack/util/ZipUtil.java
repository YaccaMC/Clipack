package me.yaccamc.clipack.util;

import me.yaccamc.clipack.api.Catcher;
import me.yaccamc.clipack.api.FileFilter;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.CompressionMethod;

import java.io.File;
import java.io.IOException;

public class ZipUtil {
    public static void addFile(ZipFile zip, File file, Catcher catcher) {
        if (!file.isFile()) {
            throw catcher.catches(new IOException("This is not a file."));
        }

        if (!file.exists()) {
            throw catcher.catches(new IOException("File does not exist."));
        }

        try {
            zip.addFile(file, parameters());
        } catch (ZipException e) {
            throw catcher.catches(e);
        }
    }

    public static void addFile(ZipFile zip, File file, String path, Catcher catcher) {
        if (!file.isFile()) {
            throw catcher.catches(new IOException("This is not a file."));
        }

        if (!file.exists()) {
            throw catcher.catches(new IOException("File does not exist."));
        }

        ZipParameters parameters = parameters();
        parameters.setFileNameInZip(path);

        try {
            zip.addFile(file, parameters);
        } catch (ZipException e) {
            throw catcher.catches(e);
        }
    }

    public static void addFolder(ZipFile zip, File folder, Catcher catcher, FileFilter filter) {
        if (!folder.isDirectory()) {
            throw catcher.catches(new IOException("This is not a directory."));
        }

        if (!folder.exists()) {
            throw catcher.catches(new IOException("Folder does not exist."));
        }

        if (folder.listFiles() == null || folder.listFiles().length == 0) {
            return;
        }

        ZipParameters parameters = parameters();
        parameters.setExcludeFileFilter((f) -> !(filter.accept(f)));
        try {
            zip.addFolder(folder, parameters);
        } catch (ZipException e) {
            throw catcher.catches(e);
        }
    }

    private static ZipParameters parameters() {
        ZipParameters parameters = new ZipParameters();
        parameters.setCompressionMethod(CompressionMethod.DEFLATE);
        parameters.setCompressionLevel(CompressionLevel.NORMAL);
        return parameters;
    }
}

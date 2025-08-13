package me.yaccamc.clipack.util;

import me.yaccamc.clipack.api.Catcher;
import me.yaccamc.clipack.api.FileFilter;

import java.io.File;

public class LambdaUtil {
    public static final Catcher DEFAULT_CATCHER = new DefaultCatcher();
    public static final FileFilter DEFAULT_FILE_FILTER = new DefaultFileFilter();

    private static final class DefaultCatcher implements Catcher {
        @Override
        public RuntimeException catches(Exception e) {
            return new RuntimeException(e);
        }
    }

    private static final class DefaultFileFilter implements FileFilter {
        @Override
        public boolean accept(File ignore) {
            return true;
        }
    }
}

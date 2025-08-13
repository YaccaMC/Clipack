package me.yaccamc.clipack;

import me.yaccamc.clipack.api.Catcher;
import me.yaccamc.clipack.api.FileFilter;
import me.yaccamc.clipack.util.LambdaUtil;
import me.yaccamc.clipack.util.ZipUtil;
import net.lingala.zip4j.ZipFile;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

public class Clipack implements Closeable {
    private final ZipFile file;
    private final Catcher catcher;

    private Clipack(File file, Catcher catcher) throws IOException {
        this.file = new ZipFile(file);
        this.catcher = catcher;
    }

    public static Clipack create(File file, Catcher catcher) {
        try {
            return new Clipack(file, catcher);
        } catch (IOException e) {
            throw catcher.catches(e);
        }
    }

    public static Clipack create(File file) {
        Catcher catcher = LambdaUtil.DEFAULT_CATCHER;
        try {
            return new Clipack(file, catcher);
        } catch (IOException e) {
            throw catcher.catches(e);
        }
    }

    public Clipack addFile(File file) {
        ZipUtil.addFile(this.file, file, catcher);
        return this;
    }

    public Clipack addFile(File file, String path) {
        ZipUtil.addFile(this.file, file, path, catcher);
        return this;
    }

    public Clipack addFolder(File folder, FileFilter filter) {
        ZipUtil.addFolder(this.file, folder, catcher, filter);
        return this;
    }

    public Clipack addFolder(File folder) {
        return this.addFolder(folder, LambdaUtil.DEFAULT_FILE_FILTER);
    }

    @Override
    public void close() {
        try {
            this.file.close();
        } catch (IOException e) {
            throw catcher.catches(e);
        }
    }
}

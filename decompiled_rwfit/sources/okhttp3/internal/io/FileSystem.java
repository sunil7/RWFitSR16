package okhttp3.internal.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;
import kotlin.jvm.internal.e;
import wh.a0;
import wh.c;
import wh.c0;
import wh.d;
import wh.f0;
import wh.t;

/* loaded from: classes2.dex */
public interface FileSystem {
    public static final Companion Companion = new Companion(null);
    public static final FileSystem SYSTEM = new Companion.SystemFileSystem();

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        public static final class SystemFileSystem implements FileSystem {
            @Override // okhttp3.internal.io.FileSystem
            public a0 appendingSink(File file) throws FileNotFoundException {
                e.f(file, "file");
                try {
                    Logger logger = t.f19667a;
                    return new c(1, new FileOutputStream(file, true), new f0());
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    Logger logger2 = t.f19667a;
                    return new c(1, new FileOutputStream(file, true), new f0());
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public void delete(File file) throws IOException {
                e.f(file, "file");
                if (file.delete() || !file.exists()) {
                    return;
                }
                throw new IOException("failed to delete " + file);
            }

            @Override // okhttp3.internal.io.FileSystem
            public void deleteContents(File directory) throws IOException {
                e.f(directory, "directory");
                File[] listFiles = directory.listFiles();
                if (listFiles == null) {
                    throw new IOException("not a readable directory: " + directory);
                }
                for (File file : listFiles) {
                    e.e(file, "file");
                    if (file.isDirectory()) {
                        deleteContents(file);
                    }
                    if (!file.delete()) {
                        throw new IOException("failed to delete " + file);
                    }
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public boolean exists(File file) {
                e.f(file, "file");
                return file.exists();
            }

            @Override // okhttp3.internal.io.FileSystem
            public void rename(File from, File to) throws IOException {
                e.f(from, "from");
                e.f(to, "to");
                delete(to);
                if (from.renameTo(to)) {
                    return;
                }
                throw new IOException("failed to rename " + from + " to " + to);
            }

            @Override // okhttp3.internal.io.FileSystem
            public a0 sink(File file) throws FileNotFoundException {
                e.f(file, "file");
                try {
                    Logger logger = t.f19667a;
                    return new c(1, new FileOutputStream(file, false), new f0());
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    Logger logger2 = t.f19667a;
                    return new c(1, new FileOutputStream(file, false), new f0());
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public long size(File file) {
                e.f(file, "file");
                return file.length();
            }

            @Override // okhttp3.internal.io.FileSystem
            public c0 source(File file) throws FileNotFoundException {
                e.f(file, "file");
                Logger logger = t.f19667a;
                return new d(1, new FileInputStream(file), new f0());
            }

            public String toString() {
                return "FileSystem.SYSTEM";
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.c cVar) {
            this();
        }
    }

    a0 appendingSink(File file) throws FileNotFoundException;

    void delete(File file) throws IOException;

    void deleteContents(File file) throws IOException;

    boolean exists(File file);

    void rename(File file, File file2) throws IOException;

    a0 sink(File file) throws FileNotFoundException;

    long size(File file);

    c0 source(File file) throws FileNotFoundException;
}

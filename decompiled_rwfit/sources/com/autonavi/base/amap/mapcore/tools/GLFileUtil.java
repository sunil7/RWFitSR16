package com.autonavi.base.amap.mapcore.tools;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public class GLFileUtil {
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void copy(Context context, String str, File file) throws Exception {
        file.delete();
        InputStream open = context.getAssets().open(str);
        byte[] bArr = new byte[open.available()];
        try {
            open.read(bArr);
            closeQuietly(open);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr);
            } finally {
                closeQuietly(fileOutputStream);
            }
        } catch (Throwable th2) {
            closeQuietly(open);
            throw th2;
        }
    }

    public static void deleteFile(File file) {
        if (file == null) {
            return;
        }
        File[] listFiles = file.listFiles();
        if (file.isDirectory() && listFiles != null) {
            for (File file2 : listFiles) {
                deleteFile(file2);
            }
        }
        file.delete();
    }

    public static File getCacheDir(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            cacheDir = context.getDir("cache", 0);
        }
        if (cacheDir == null) {
            cacheDir = new File("/data/data/" + context.getPackageName() + "/app_cache");
        }
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        return cacheDir;
    }

    public static File getFilesDir(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            filesDir = context.getDir("files", 0);
        }
        if (filesDir == null) {
            filesDir = new File("/data/data/" + context.getPackageName() + "/app_files");
        }
        if (!filesDir.exists()) {
            filesDir.mkdirs();
        }
        return filesDir;
    }

    public static byte[] readFileContents(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                closeQuietly(null);
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        byteArrayOutputStream.close();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        closeQuietly(fileInputStream);
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } catch (Exception unused) {
                closeQuietly(fileInputStream);
                return null;
            } catch (Throwable th2) {
                fileInputStream2 = fileInputStream;
                th = th2;
                closeQuietly(fileInputStream2);
                throw th;
            }
        } catch (Exception unused2) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static void writeDatasToFile(String str, byte[] bArr) {
        Throwable th2;
        ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
        writeLock.lock();
        FileOutputStream fileOutputStream = null;
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    File file = new File(str);
                    File parentFile = file.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(bArr);
                        fileOutputStream2.flush();
                        writeLock.unlock();
                        closeQuietly(fileOutputStream2);
                        return;
                    } catch (Exception unused) {
                        fileOutputStream = fileOutputStream2;
                        writeLock.unlock();
                        closeQuietly(fileOutputStream);
                        return;
                    } catch (Throwable th3) {
                        th2 = th3;
                        fileOutputStream = fileOutputStream2;
                        writeLock.unlock();
                        closeQuietly(fileOutputStream);
                        throw th2;
                    }
                }
            } catch (Exception unused2) {
            } catch (Throwable th4) {
                th2 = th4;
            }
        }
        writeLock.unlock();
        closeQuietly(null);
    }
}

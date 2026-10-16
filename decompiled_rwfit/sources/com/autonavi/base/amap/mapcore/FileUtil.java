package com.autonavi.base.amap.mapcore;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.amap.api.col.p0003sl.ka;
import com.amap.api.col.p0003sl.v4;
import com.amap.api.col.p0003sl.y4;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.amap.mapcore.tools.GLFileUtil;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import r5.a;

/* loaded from: classes.dex */
public class FileUtil {
    private static final int BUFFER = 1024;
    private static final String FILE_PATH_ENTRY_BACK = "..";
    private static final String FILE_PATH_ENTRY_SEPARATOR1 = "\\";
    private static final String FILE_PATH_ENTRY_SEPARATOR2 = "%";
    private static final String TAG = "FileUtil";
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';

    public static class UnZipFileBrake {
        public boolean mIsAborted = false;
    }

    public interface ZipCompressProgressListener {
        void onFinishProgress(long j4);
    }

    public static boolean checkCanWrite(File file) {
        if (file == null || !file.canWrite()) {
            return false;
        }
        File file2 = new File(file, "amap.tmp");
        try {
            file2.createNewFile();
            if (!file2.exists()) {
                return false;
            }
            try {
                file2.delete();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } catch (IOException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static byte[] compress(String str, String str2) {
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            } catch (IOException e) {
                e = e;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            gZIPOutputStream.write(str.getBytes(str2));
            gZIPOutputStream.close();
        } catch (IOException e10) {
            e = e10;
            gZIPOutputStream2 = gZIPOutputStream;
            Log.e("gzip compress error.", e.getMessage());
            gZIPOutputStream = gZIPOutputStream2;
            safelyCloseFile(gZIPOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th3) {
            th = th3;
            gZIPOutputStream2 = gZIPOutputStream;
            safelyCloseFile(gZIPOutputStream2);
            throw th;
        }
        safelyCloseFile(gZIPOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static void createNoMediaFileIfNotExist(String str) {
    }

    public static void decompress(InputStream inputStream, String str) throws Exception {
        decompress(inputStream, str, 0L, null);
    }

    private static int decompressFile(File file, ZipInputStream zipInputStream, long j4, long j10, ZipCompressProgressListener zipCompressProgressListener, UnZipFileBrake unZipFileBrake) throws Exception {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        byte[] bArr = new byte[1024];
        int i3 = 0;
        while (true) {
            int read = zipInputStream.read(bArr, 0, 1024);
            if (read == -1) {
                bufferedOutputStream.close();
                return i3;
            }
            if (unZipFileBrake != null && unZipFileBrake.mIsAborted) {
                bufferedOutputStream.close();
                return i3;
            }
            bufferedOutputStream.write(bArr, 0, read);
            i3 += read;
            if (j10 > 0 && zipCompressProgressListener != null) {
                long j11 = ((i3 + j4) * 100) / j10;
                if (unZipFileBrake == null || !unZipFileBrake.mIsAborted) {
                    zipCompressProgressListener.onFinishProgress(j11);
                }
            }
        }
    }

    public static boolean deleteFile(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (int i3 = 0; i3 < listFiles.length; i3++) {
                if (listFiles[i3].isFile()) {
                    if (!listFiles[i3].delete()) {
                        return false;
                    }
                } else {
                    if (!deleteFile(listFiles[i3])) {
                        return false;
                    }
                    listFiles[i3].delete();
                }
            }
        }
        file.delete();
        return true;
    }

    private static void fileProber(File file) {
        File parentFile = file.getParentFile();
        if (parentFile.exists()) {
            return;
        }
        fileProber(parentFile);
        parentFile.mkdir();
    }

    public static String getExternalStroragePath(Context context) {
        if (context == null) {
            return null;
        }
        return context.getExternalFilesDir("").getAbsolutePath() + File.separatorChar;
    }

    public static String getMapBaseStorage(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("base_path", 0);
        String str2 = MapsInitializer.sdcardDir;
        if (str2 == null || str2.trim().length() <= 0) {
            String string = sharedPreferences.getString("map_base_path_v44", "");
            String externalStroragePath = getExternalStroragePath(context);
            if (string == null || string.contains(externalStroragePath)) {
                str = string;
            }
        } else {
            str = MapsInitializer.sdcardDir + File.separatorChar;
        }
        if (str != null && str.length() > 2) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
            if (file.isDirectory()) {
                if (checkCanWrite(file)) {
                    return str;
                }
                String str3 = context.getCacheDir().toString() + AeUtil.ROOTPATH;
                if (str3 != null && str3.length() > 2) {
                    File file2 = new File(str3);
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    if (file2.isDirectory()) {
                        return str3;
                    }
                }
            }
        }
        String str4 = getExternalStroragePath(context) + AeUtil.ROOTPATH;
        if (str4 != null && str4.length() > 2) {
            File file3 = new File(str4);
            if (!file3.exists()) {
                file3.mkdir();
            }
            if (file3.isDirectory() && file3.canWrite()) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("map_base_path_v44", str4);
                edit.commit();
                createNoMediaFileIfNotExist(str4);
                return str4;
            }
        }
        String str5 = context.getCacheDir().toString() + AeUtil.ROOTPATH;
        if (str5 != null && str5.length() > 2) {
            File file4 = new File(str5);
            if (!file4.exists()) {
                file4.mkdir();
            }
            file4.isDirectory();
        }
        return str5;
    }

    public static String getName(String str) {
        if (str == null) {
            return null;
        }
        return str.substring(indexOfLastSeparator(str) + 1);
    }

    private static InputStream getZipInputStream(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return isGzip(bArr) ? new GZIPInputStream(byteArrayInputStream) : new ZipInputStream(byteArrayInputStream);
    }

    public static int indexOfLastSeparator(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static boolean isGzip(byte[] bArr) {
        return ((bArr[1] & 255) | (bArr[0] << 8)) == 8075;
    }

    public static boolean isSafeEntryName(String str) {
        return (str.contains(FILE_PATH_ENTRY_BACK) || str.contains(FILE_PATH_ENTRY_SEPARATOR1) || str.contains(FILE_PATH_ENTRY_SEPARATOR2)) ? false : true;
    }

    private static byte[] readByteByStream(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        safelyCloseFile(byteArrayOutputStream);
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (IOException e) {
                    throw e;
                }
            } catch (Throwable th2) {
                safelyCloseFile(byteArrayOutputStream);
                throw th2;
            }
        }
    }

    public static byte[] readFileContents(String str) {
        Throwable th2;
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            File file = new File(str);
            if (!file.exists()) {
                safelyCloseFile((OutputStream) null);
                safelyCloseFile((InputStream) null);
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            return byteArrayOutputStream.toByteArray();
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } catch (Throwable th3) {
                        th2 = th3;
                        try {
                            ka.a(th2, TAG, "readFileContents");
                            v4.a(th2);
                            y4.a("[map][function][res]", "read file from disk failed " + th2.getMessage());
                            return null;
                        } finally {
                            safelyCloseFile(byteArrayOutputStream);
                            safelyCloseFile(fileInputStream);
                        }
                    }
                }
            } catch (Throwable th4) {
                th2 = th4;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th5) {
            th2 = th5;
            fileInputStream = null;
            byteArrayOutputStream = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public static byte[] readFileContentsFromAssets(Context context, String str) {
        InputStream inputStream;
        AssetManager assets = context.getAssets();
        ?? r22 = 0;
        try {
            try {
                inputStream = assets.open(str);
                try {
                    int available = inputStream.available();
                    if (available == 0) {
                        safelyCloseFile(inputStream);
                        return null;
                    }
                    byte[] bArr = new byte[available];
                    for (int i3 = 0; i3 < available; i3 += inputStream.read(bArr, i3, available - i3)) {
                    }
                    safelyCloseFile(inputStream);
                    return bArr;
                } catch (IOException e) {
                    e = e;
                    y4.a("[map][function][res]", "read file from assets failed " + e.getMessage());
                    safelyCloseFile(inputStream);
                    return null;
                } catch (OutOfMemoryError e10) {
                    e = e10;
                    y4.a("[map][function][res]", "read file from assets failed " + e.getMessage());
                    safelyCloseFile(inputStream);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                r22 = assets;
                safelyCloseFile((InputStream) r22);
                throw th;
            }
        } catch (IOException e11) {
            e = e11;
            inputStream = null;
        } catch (OutOfMemoryError e12) {
            e = e12;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            safelyCloseFile((InputStream) r22);
            throw th;
        }
    }

    public static byte[] readFileContentsFromAssetsByPreName(Context context, String str, String str2) {
        if (context != null && str != null && str2 != null) {
            try {
                String[] list = context.getAssets().list(str);
                if (list == null) {
                    return null;
                }
                for (String str3 : list) {
                    if (str3 != null && str3.contains(str2)) {
                        return readFileContentsFromAssets(context, str + "/" + str3);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static void safelyCloseFile(InputStream inputStream) {
        if (inputStream != null) {
            try {
                if (inputStream instanceof ZipInputStream) {
                    ((ZipInputStream) inputStream).closeEntry();
                }
                inputStream.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void saveFileContents(String str, byte[] bArr) {
        Throwable th2;
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(new File(str));
            try {
                fileOutputStream.write(bArr);
            } catch (Throwable th3) {
                th2 = th3;
                try {
                    ka.a(th2, TAG, "saveFileContents");
                    v4.a(th2);
                    y4.a("[map][function][res]", "save file from disk failed " + th2.getMessage());
                } finally {
                    safelyCloseFile(fileOutputStream);
                }
            }
        } catch (Throwable th4) {
            th2 = th4;
            fileOutputStream = null;
        }
    }

    public static byte[] uncompress(byte[] bArr) {
        InputStream inputStream;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inputStream = getZipInputStream(bArr);
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr2 = new byte[256];
            while (true) {
                int read = inputStream.read(bArr2);
                if (read < 0) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                Log.e("gzip compress error.", th.getMessage());
                return null;
            } finally {
                safelyCloseFile(inputStream);
            }
        }
    }

    public static Pair<String, byte[]> uncompressToByte(byte[] bArr) {
        InputStream inputStream;
        String str;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inputStream = getZipInputStream(bArr);
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
        try {
            if (inputStream instanceof ZipInputStream) {
                str = ((ZipInputStream) inputStream).getNextEntry().getName();
                if (!isSafeEntryName(str)) {
                    Log.e("gzip compress error.", "gzip name contains ../ " + str);
                    return null;
                }
            } else {
                str = "";
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                Log.e("gzip compress error.", th.getMessage());
                return null;
            } finally {
                safelyCloseFile(inputStream);
            }
        }
        if (inputStream == null) {
            return null;
        }
        byte[] bArr2 = new byte[256];
        while (true) {
            int read = inputStream.read(bArr2);
            if (read < 0) {
                return new Pair<>(str, byteArrayOutputStream.toByteArray());
            }
            byteArrayOutputStream.write(bArr2, 0, read);
        }
    }

    public static byte[] uncompressToByteArray(byte[] bArr) {
        Throwable th2;
        GZIPInputStream gZIPInputStream;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                byte[] bArr2 = new byte[256];
                while (true) {
                    int read = gZIPInputStream.read(bArr2);
                    if (read < 0) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
            } catch (Throwable th3) {
                th2 = th3;
                try {
                    v4.a(th2);
                    th2.printStackTrace();
                    return null;
                } finally {
                    GLFileUtil.closeQuietly(byteArrayOutputStream);
                    GLFileUtil.closeQuietly(byteArrayInputStream);
                    GLFileUtil.closeQuietly(gZIPInputStream);
                }
            }
        } catch (Throwable th4) {
            th2 = th4;
            gZIPInputStream = null;
        }
    }

    public static Map<String, byte[]> uncompressToByteWithKeys(byte[] bArr, String[] strArr) {
        HashMap hashMap = new HashMap();
        if (bArr != null && bArr.length != 0) {
            InputStream inputStream = null;
            try {
                InputStream zipInputStream = getZipInputStream(bArr);
                try {
                    if (zipInputStream instanceof ZipInputStream) {
                        ZipInputStream zipInputStream2 = (ZipInputStream) zipInputStream;
                        while (true) {
                            ZipEntry nextEntry = zipInputStream2.getNextEntry();
                            if (nextEntry == null) {
                                break;
                            }
                            if (!nextEntry.isDirectory()) {
                                try {
                                    String name = nextEntry.getName();
                                    if (!isSafeEntryName(name)) {
                                        Log.e("gzip compress error.", "gzip name contains ../ " + name);
                                        safelyCloseFile(zipInputStream);
                                        return null;
                                    }
                                    if (strArr == null) {
                                        byte[] readByteByStream = readByteByStream(zipInputStream2);
                                        if (readByteByStream != null) {
                                            hashMap.put(name, readByteByStream);
                                        }
                                    } else {
                                        int length = strArr.length;
                                        int i3 = 0;
                                        while (true) {
                                            if (i3 < length) {
                                                String str = strArr[i3];
                                                if (name.equals(str)) {
                                                    byte[] readByteByStream2 = readByteByStream(zipInputStream2);
                                                    if (readByteByStream2 != null) {
                                                        hashMap.put(str, readByteByStream2);
                                                    }
                                                } else {
                                                    i3++;
                                                }
                                            }
                                        }
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            zipInputStream2.closeEntry();
                        }
                    }
                    safelyCloseFile(zipInputStream);
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = zipInputStream;
                    try {
                        Log.e("gzip compress error.", th.getMessage());
                        return hashMap;
                    } finally {
                        safelyCloseFile(inputStream);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return hashMap;
    }

    public static String uncompressToString(byte[] bArr) {
        return uncompressToString(bArr, "UTF-8");
    }

    public static void writeDatasToFile(String str, byte[] bArr) {
        Throwable th2;
        Exception e;
        ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
        writeLock.lock();
        FileOutputStream fileOutputStream = null;
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    File file = new File(str);
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(bArr);
                        fileOutputStream2.flush();
                        writeLock.unlock();
                        safelyCloseFile(fileOutputStream2);
                        return;
                    } catch (Exception e10) {
                        e = e10;
                        fileOutputStream = fileOutputStream2;
                        try {
                            e.printStackTrace();
                            writeLock.unlock();
                            safelyCloseFile(fileOutputStream);
                            return;
                        } catch (Throwable th3) {
                            th2 = th3;
                            writeLock.unlock();
                            safelyCloseFile(fileOutputStream);
                            throw th2;
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        fileOutputStream = fileOutputStream2;
                        writeLock.unlock();
                        safelyCloseFile(fileOutputStream);
                        throw th2;
                    }
                }
            } catch (Exception e11) {
                e = e11;
            } catch (Throwable th5) {
                th2 = th5;
            }
        }
        writeLock.unlock();
        safelyCloseFile((OutputStream) null);
    }

    private static void decompress(InputStream inputStream, String str, long j4, ZipCompressProgressListener zipCompressProgressListener) throws Exception {
        CheckedInputStream checkedInputStream = new CheckedInputStream(inputStream, new CRC32());
        ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
        decompress(null, new File(str), zipInputStream, j4, zipCompressProgressListener, null);
        zipInputStream.close();
        checkedInputStream.close();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    public static String uncompressToString(byte[] bArr, String str) {
        InputStream inputStream;
        ?? r02 = 0;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                inputStream = getZipInputStream(bArr);
            } catch (Throwable th2) {
                th = th2;
                r02 = bArr;
                safelyCloseFile((InputStream) r02);
                throw th;
            }
        } catch (IOException e) {
            e = e;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            safelyCloseFile((InputStream) r02);
            throw th;
        }
        if (inputStream == null) {
            safelyCloseFile(inputStream);
            return null;
        }
        try {
            byte[] bArr2 = new byte[256];
            while (true) {
                int read = inputStream.read(bArr2);
                if (read < 0) {
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString(str);
                    safelyCloseFile(inputStream);
                    return byteArrayOutputStream2;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (IOException e10) {
            e = e10;
            Log.e("gzip compress error.", e.getMessage());
            safelyCloseFile(inputStream);
            return null;
        }
    }

    private static void safelyCloseFile(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Throwable unused) {
            }
        }
    }

    private static void decompress(File file, File file2, ZipInputStream zipInputStream, long j4, ZipCompressProgressListener zipCompressProgressListener, UnZipFileBrake unZipFileBrake) throws Exception {
        int i3 = 0;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                return;
            }
            if (unZipFileBrake != null && unZipFileBrake.mIsAborted) {
                zipInputStream.closeEntry();
                return;
            }
            String name = nextEntry.getName();
            if (TextUtils.isEmpty(name) || !isSafeEntryName(name)) {
                break;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(file2.getPath());
            File file3 = new File(a.f(sb2, File.separator, name));
            fileProber(file3);
            if (nextEntry.isDirectory()) {
                file3.mkdirs();
            } else {
                i3 += decompressFile(file3, zipInputStream, i3, j4, zipCompressProgressListener, unZipFileBrake);
            }
            zipInputStream.closeEntry();
        }
        if (file != null) {
            try {
                file.delete();
            } catch (Exception unused) {
            }
        }
    }

    public static byte[] compress(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
        } catch (IOException e10) {
            e = e10;
            gZIPOutputStream2 = gZIPOutputStream;
            Log.e("gzip compress error.", e.getMessage());
            gZIPOutputStream = gZIPOutputStream2;
            safelyCloseFile(gZIPOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th3) {
            th = th3;
            gZIPOutputStream2 = gZIPOutputStream;
            safelyCloseFile(gZIPOutputStream2);
            throw th;
        }
        safelyCloseFile(gZIPOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}

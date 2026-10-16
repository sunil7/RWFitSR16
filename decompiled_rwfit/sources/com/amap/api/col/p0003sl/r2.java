package com.amap.api.col.p0003sl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class r2 {

    public interface a {
        void a(String str, String str2);

        void a(String str, String str2, float f2);

        void a(String str, String str2, int i3);
    }

    public long a(File file, File file2, long j4, long j10, a aVar) {
        long j11;
        if (j4 == 0) {
            if (aVar != null) {
                aVar.a("", "", -1);
            }
            return 0L;
        }
        String absolutePath = file.getAbsolutePath();
        String absolutePath2 = file2.getAbsolutePath();
        try {
            if (file.isDirectory()) {
                if (!file2.exists() && !file2.mkdirs()) {
                    throw new IOException("Cannot create dir " + file2.getAbsolutePath());
                }
                String[] list = file.list();
                if (list == null) {
                    return j4;
                }
                j11 = j4;
                for (int i3 = 0; i3 < list.length; i3++) {
                    try {
                        j11 = a(new File(file, list[i3]), new File(new File(file2, file.getName()), list[i3]), j11, j10, aVar);
                    } catch (Exception e) {
                        e = e;
                    }
                }
                return j11;
            }
            File parentFile = file2.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                throw new IOException("Cannot create dir " + parentFile.getAbsolutePath());
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            long j12 = j4;
            while (true) {
                try {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                    j12 += read;
                    if (aVar != null) {
                        aVar.a(absolutePath, absolutePath2, (j12 / j10) * 100.0f);
                    }
                } catch (Exception e10) {
                    e = e10;
                    j11 = j12;
                }
            }
            fileInputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            if (aVar != null && j12 >= j10 - 1) {
                aVar.a(absolutePath, absolutePath2);
            }
            return j12;
        } catch (Exception e11) {
            e = e11;
            j11 = j4;
        }
        e.printStackTrace();
        if (aVar != null) {
            aVar.a(absolutePath, absolutePath2, -1);
        }
        return j11;
    }
}

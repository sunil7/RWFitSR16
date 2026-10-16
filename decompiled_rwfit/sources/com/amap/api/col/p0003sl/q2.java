package com.amap.api.col.p0003sl;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes.dex */
class q2 {

    /* renamed from: a, reason: collision with root package name */
    RandomAccessFile f4889a;

    public q2(String str, long j4) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (IOException e) {
                ka.a(e, "FileAccessI", "create");
                e.printStackTrace();
            }
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
        this.f4889a = randomAccessFile;
        randomAccessFile.seek(j4);
    }
}

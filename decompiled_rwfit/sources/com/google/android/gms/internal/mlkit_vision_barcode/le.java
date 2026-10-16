package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class le {
    public static byte[] a(File file) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i3 = (int) length;
            byte[] bArr = new byte[i3];
            int i10 = i3;
            int i11 = 0;
            while (i10 > 0) {
                int read = fileInputStream.read(bArr, i11, i10);
                if (read < 0) {
                    break;
                }
                i10 -= read;
                i11 += read;
            }
            if (i10 > 0) {
                bArr = Arrays.copyOf(bArr, i11);
                kotlin.jvm.internal.e.e(bArr, "copyOf(this, newSize)");
            } else {
                int read2 = fileInputStream.read();
                if (read2 != -1) {
                    mh.a aVar = new mh.a(8193);
                    aVar.write(read2);
                    je.a(fileInputStream, aVar);
                    int size = aVar.size() + i3;
                    if (size < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] b3 = aVar.b();
                    bArr = Arrays.copyOf(bArr, size);
                    kotlin.jvm.internal.e.e(bArr, "copyOf(this, newSize)");
                    kotlin.collections.g.c(b3, i3, 0, bArr, aVar.size());
                }
            }
            fileInputStream.close();
            return bArr;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                ke.a(fileInputStream, th2);
                throw th3;
            }
        }
    }
}

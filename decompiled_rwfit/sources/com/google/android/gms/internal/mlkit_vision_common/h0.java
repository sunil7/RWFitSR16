package com.google.android.gms.internal.mlkit_vision_common;

import java.io.Closeable;
import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class h0 {
    public static String a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b3 : bArr) {
            sb2.append(String.format("%02x", Byte.valueOf(b3)));
        }
        return sb2.toString();
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static long[] c(Serializable serializable) {
        if (!(serializable instanceof int[])) {
            if (serializable instanceof long[]) {
                return (long[]) serializable;
            }
            return null;
        }
        int[] iArr = (int[]) serializable;
        long[] jArr = new long[iArr.length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            jArr[i3] = iArr[i3];
        }
        return jArr;
    }
}

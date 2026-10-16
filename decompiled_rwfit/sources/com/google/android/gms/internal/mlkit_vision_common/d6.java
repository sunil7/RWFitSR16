package com.google.android.gms.internal.mlkit_vision_common;

/* loaded from: classes.dex */
public abstract class d6 {
    public static final boolean a(byte[] a3, int i3, int i10, byte[] bArr, int i11) {
        kotlin.jvm.internal.e.f(a3, "a");
        for (int i12 = 0; i12 < i11; i12++) {
            if (a3[i12 + i3] != bArr[i12 + i10]) {
                return false;
            }
        }
        return true;
    }

    public static final void b(long j4, long j10, long j11) {
        if ((j10 | j11) < 0 || j10 > j4 || j4 - j10 < j11) {
            throw new ArrayIndexOutOfBoundsException("size=" + j4 + " offset=" + j10 + " byteCount=" + j11);
        }
    }

    public static final String c(byte b3) {
        char[] cArr = xh.b.f19828a;
        return new String(new char[]{cArr[(b3 >> 4) & 15], cArr[b3 & 15]});
    }
}

package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer;

/* loaded from: classes.dex */
public abstract class ua {
    public static int a(byte[] bArr, int i3, com.google.android.gms.internal.mlkit_vision_barcode_bundled.s sVar) {
        int f2 = f(bArr, i3, sVar);
        int i10 = sVar.f9823a;
        if (i10 < 0) {
            throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i10 > bArr.length - f2) {
            throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i10 == 0) {
            sVar.f9825c = zzdf.zzb;
            return f2;
        }
        sVar.f9825c = zzdf.zzr(bArr, f2, i10);
        return f2 + i10;
    }

    public static int b(int i3, byte[] bArr) {
        int i10 = bArr[i3] & 255;
        int i11 = bArr[i3 + 1] & 255;
        int i12 = bArr[i3 + 2] & 255;
        return ((bArr[i3 + 3] & 255) << 24) | (i11 << 8) | i10 | (i12 << 16);
    }

    public static int c(com.google.android.gms.internal.mlkit_vision_barcode_bundled.m1 m1Var, int i3, byte[] bArr, int i10, int i11, com.google.android.gms.internal.mlkit_vision_barcode_bundled.r0 r0Var, com.google.android.gms.internal.mlkit_vision_barcode_bundled.s sVar) {
        Object e = m1Var.e();
        com.google.android.gms.internal.mlkit_vision_barcode_bundled.m1 m1Var2 = m1Var;
        byte[] bArr2 = bArr;
        int i12 = i11;
        com.google.android.gms.internal.mlkit_vision_barcode_bundled.s sVar2 = sVar;
        int k10 = k(e, m1Var2, bArr2, i10, i12, sVar2);
        m1Var2.a(e);
        sVar2.f9825c = e;
        r0Var.add(e);
        while (k10 < i12) {
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.s sVar3 = sVar2;
            int i13 = i12;
            int f2 = f(bArr2, k10, sVar3);
            if (i3 != sVar3.f9823a) {
                break;
            }
            byte[] bArr3 = bArr2;
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.m1 m1Var3 = m1Var2;
            Object e10 = m1Var3.e();
            k10 = k(e10, m1Var3, bArr3, f2, i13, sVar3);
            m1Var2 = m1Var3;
            bArr2 = bArr3;
            i12 = i13;
            sVar2 = sVar3;
            m1Var2.a(e10);
            sVar2.f9825c = e10;
            r0Var.add(e10);
        }
        return k10;
    }

    public static int d(byte[] bArr, int i3, com.google.android.gms.internal.mlkit_vision_barcode_bundled.r0 r0Var, com.google.android.gms.internal.mlkit_vision_barcode_bundled.s sVar) {
        com.google.android.gms.internal.mlkit_vision_barcode_bundled.m0 m0Var = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.m0) r0Var;
        int f2 = f(bArr, i3, sVar);
        int i10 = sVar.f9823a + f2;
        while (f2 < i10) {
            f2 = f(bArr, f2, sVar);
            m0Var.d(sVar.f9823a);
        }
        if (f2 == i10) {
            return f2;
        }
        throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int e(int i3, byte[] bArr, int i10, int i11, com.google.android.gms.internal.mlkit_vision_barcode_bundled.s1 s1Var, com.google.android.gms.internal.mlkit_vision_barcode_bundled.s sVar) {
        if ((i3 >>> 3) == 0) {
            throw new zzer("Protocol message contained an invalid tag (zero).");
        }
        int i12 = i3 & 7;
        if (i12 == 0) {
            int i13 = i(bArr, i10, sVar);
            s1Var.c(i3, Long.valueOf(sVar.f9824b));
            return i13;
        }
        if (i12 == 1) {
            s1Var.c(i3, Long.valueOf(m(i10, bArr)));
            return i10 + 8;
        }
        if (i12 == 2) {
            int f2 = f(bArr, i10, sVar);
            int i14 = sVar.f9823a;
            if (i14 < 0) {
                throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i14 > bArr.length - f2) {
                throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i14 == 0) {
                s1Var.c(i3, zzdf.zzb);
            } else {
                s1Var.c(i3, zzdf.zzr(bArr, f2, i14));
            }
            return f2 + i14;
        }
        if (i12 != 3) {
            if (i12 != 5) {
                throw new zzer("Protocol message contained an invalid tag (zero).");
            }
            s1Var.c(i3, Integer.valueOf(b(i10, bArr)));
            return i10 + 4;
        }
        int i15 = (i3 & (-8)) | 4;
        com.google.android.gms.internal.mlkit_vision_barcode_bundled.s1 b3 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.s1.b();
        int i16 = sVar.e + 1;
        sVar.e = i16;
        if (i16 >= 100) {
            throw new zzer("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int i17 = 0;
        while (true) {
            if (i10 >= i11) {
                break;
            }
            int f10 = f(bArr, i10, sVar);
            int i18 = sVar.f9823a;
            if (i18 == i15) {
                i17 = i18;
                i10 = f10;
                break;
            }
            i10 = e(i18, bArr, f10, i11, b3, sVar);
            i17 = i18;
        }
        sVar.e--;
        if (i10 > i11 || i17 != i15) {
            throw new zzer("Failed to parse the message.");
        }
        s1Var.c(i3, b3);
        return i10;
    }

    public static int f(byte[] bArr, int i3, com.google.android.gms.internal.mlkit_vision_barcode_bundled.s sVar) {
        int i10 = i3 + 1;
        byte b3 = bArr[i3];
        if (b3 < 0) {
            return g(b3, bArr, i10, sVar);
        }
        sVar.f9823a = b3;
        return i10;
    }

    public static int g(int i3, byte[] bArr, int i10, com.google.android.gms.internal.mlkit_vision_barcode_bundled.s sVar) {
        byte b3 = bArr[i10];
        int i11 = i10 + 1;
        int i12 = i3 & 127;
        if (b3 >= 0) {
            sVar.f9823a = i12 | (b3 << 7);
            return i11;
        }
        int i13 = i12 | ((b3 & Byte.MAX_VALUE) << 7);
        int i14 = i10 + 2;
        byte b10 = bArr[i11];
        if (b10 >= 0) {
            sVar.f9823a = i13 | (b10 << 14);
            return i14;
        }
        int i15 = i13 | ((b10 & Byte.MAX_VALUE) << 14);
        int i16 = i10 + 3;
        byte b11 = bArr[i14];
        if (b11 >= 0) {
            sVar.f9823a = i15 | (b11 << 21);
            return i16;
        }
        int i17 = i15 | ((b11 & Byte.MAX_VALUE) << 21);
        int i18 = i10 + 4;
        byte b12 = bArr[i16];
        if (b12 >= 0) {
            sVar.f9823a = i17 | (b12 << 28);
            return i18;
        }
        int i19 = i17 | ((b12 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i20 = i18 + 1;
            if (bArr[i18] >= 0) {
                sVar.f9823a = i19;
                return i20;
            }
            i18 = i20;
        }
    }

    public static int h(int i3, byte[] bArr, int i10, int i11, com.google.android.gms.internal.mlkit_vision_barcode_bundled.r0 r0Var, com.google.android.gms.internal.mlkit_vision_barcode_bundled.s sVar) {
        com.google.android.gms.internal.mlkit_vision_barcode_bundled.m0 m0Var = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.m0) r0Var;
        int f2 = f(bArr, i10, sVar);
        m0Var.d(sVar.f9823a);
        while (f2 < i11) {
            int f10 = f(bArr, f2, sVar);
            if (i3 != sVar.f9823a) {
                break;
            }
            f2 = f(bArr, f10, sVar);
            m0Var.d(sVar.f9823a);
        }
        return f2;
    }

    public static int i(byte[] bArr, int i3, com.google.android.gms.internal.mlkit_vision_barcode_bundled.s sVar) {
        long j4 = bArr[i3];
        int i10 = i3 + 1;
        if (j4 >= 0) {
            sVar.f9824b = j4;
            return i10;
        }
        int i11 = i3 + 2;
        byte b3 = bArr[i10];
        long j10 = (j4 & 127) | ((b3 & Byte.MAX_VALUE) << 7);
        int i12 = 7;
        while (b3 < 0) {
            int i13 = i11 + 1;
            i12 += 7;
            j10 |= (r10 & Byte.MAX_VALUE) << i12;
            b3 = bArr[i11];
            i11 = i13;
        }
        sVar.f9824b = j10;
        return i11;
    }

    public static int j(Object obj, com.google.android.gms.internal.mlkit_vision_barcode_bundled.m1 m1Var, byte[] bArr, int i3, int i10, int i11, com.google.android.gms.internal.mlkit_vision_barcode_bundled.s sVar) {
        com.google.android.gms.internal.mlkit_vision_barcode_bundled.d1 d1Var = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.d1) m1Var;
        int i12 = sVar.e + 1;
        sVar.e = i12;
        if (i12 >= 100) {
            throw new zzer("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int t8 = d1Var.t(obj, bArr, i3, i10, i11, sVar);
        sVar.e--;
        sVar.f9825c = obj;
        return t8;
    }

    public static int k(Object obj, com.google.android.gms.internal.mlkit_vision_barcode_bundled.m1 m1Var, byte[] bArr, int i3, int i10, com.google.android.gms.internal.mlkit_vision_barcode_bundled.s sVar) {
        int i11 = i3 + 1;
        int i12 = bArr[i3];
        if (i12 < 0) {
            i11 = g(i12, bArr, i11, sVar);
            i12 = sVar.f9823a;
        }
        int i13 = i11;
        if (i12 < 0 || i12 > i10 - i13) {
            throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i14 = sVar.e + 1;
        sVar.e = i14;
        if (i14 >= 100) {
            throw new zzer("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int i15 = i13 + i12;
        m1Var.b(obj, bArr, i13, i15, sVar);
        sVar.e--;
        sVar.f9825c = obj;
        return i15;
    }

    public static int l(int i3, byte[] bArr, int i10, int i11, com.google.android.gms.internal.mlkit_vision_barcode_bundled.s sVar) {
        if ((i3 >>> 3) == 0) {
            throw new zzer("Protocol message contained an invalid tag (zero).");
        }
        int i12 = i3 & 7;
        if (i12 == 0) {
            return i(bArr, i10, sVar);
        }
        if (i12 == 1) {
            return i10 + 8;
        }
        if (i12 == 2) {
            return f(bArr, i10, sVar) + sVar.f9823a;
        }
        if (i12 != 3) {
            if (i12 == 5) {
                return i10 + 4;
            }
            throw new zzer("Protocol message contained an invalid tag (zero).");
        }
        int i13 = (i3 & (-8)) | 4;
        int i14 = 0;
        while (i10 < i11) {
            i10 = f(bArr, i10, sVar);
            i14 = sVar.f9823a;
            if (i14 == i13) {
                break;
            }
            i10 = l(i14, bArr, i10, i11, sVar);
        }
        if (i10 > i11 || i14 != i13) {
            throw new zzer("Failed to parse the message.");
        }
        return i10;
    }

    public static long m(int i3, byte[] bArr) {
        return (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16) | ((bArr[i3 + 3] & 255) << 24) | ((bArr[i3 + 4] & 255) << 32) | ((bArr[i3 + 5] & 255) << 40) | ((bArr[i3 + 6] & 255) << 48) | ((bArr[i3 + 7] & 255) << 56);
    }
}

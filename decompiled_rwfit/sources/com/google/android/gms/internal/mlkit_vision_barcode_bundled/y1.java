package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public abstract class y1 {

    /* renamed from: a, reason: collision with root package name */
    public static final g0 f9849a;

    static {
        if (x1.e && x1.f9844d) {
            int i3 = r.f9821a;
        }
        f9849a = new g0(7);
    }

    public static int a(int i3, int i10, byte[] bArr) {
        int i11 = i10 - i3;
        byte b3 = bArr[i3 - 1];
        if (i11 == 0) {
            if (b3 > -12) {
                return -1;
            }
            return b3;
        }
        if (i11 == 1) {
            return d(b3, bArr[i3]);
        }
        if (i11 != 2) {
            throw new AssertionError();
        }
        byte b10 = bArr[i3];
        byte b11 = bArr[i3 + 1];
        if (b3 > -12 || b10 > -65 || b11 > -65) {
            return -1;
        }
        return (b11 << 16) ^ ((b10 << 8) ^ b3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
    
        return r10 + r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int b(java.lang.String r8, byte[] r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.y1.b(java.lang.String, byte[], int, int):int");
    }

    public static int c(String str) {
        int length = str.length();
        int i3 = 0;
        int i10 = 0;
        while (i10 < length && str.charAt(i10) < 128) {
            i10++;
        }
        int i11 = length;
        while (true) {
            if (i10 >= length) {
                break;
            }
            char charAt = str.charAt(i10);
            if (charAt < 2048) {
                i11 += (127 - charAt) >>> 31;
                i10++;
            } else {
                int length2 = str.length();
                while (i10 < length2) {
                    char charAt2 = str.charAt(i10);
                    if (charAt2 < 2048) {
                        i3 += (127 - charAt2) >>> 31;
                    } else {
                        i3 += 2;
                        if (charAt2 >= 55296 && charAt2 <= 57343) {
                            if (Character.codePointAt(str, i10) < 65536) {
                                throw new zzhd(i10, length2);
                            }
                            i10++;
                        }
                    }
                    i10++;
                }
                i11 += i3;
            }
        }
        if (i11 >= length) {
            return i11;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i11 + 4294967296L));
    }

    public static int d(int i3, int i10) {
        if (i3 > -12 || i10 > -65) {
            return -1;
        }
        return i3 ^ (i10 << 8);
    }
}

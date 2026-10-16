package jd;

import com.google.zxing.FormatException;
import sc.i;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f15407a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    public static void a(sc.c cVar, StringBuilder sb2, int i3, boolean z5) {
        while (i3 > 1) {
            if (cVar.a() < 11) {
                throw FormatException.getFormatInstance();
            }
            int b3 = cVar.b(11);
            sb2.append(e(b3 / 45));
            sb2.append(e(b3 % 45));
            i3 -= 2;
        }
        if (i3 == 1) {
            if (cVar.a() < 6) {
                throw FormatException.getFormatInstance();
            }
            sb2.append(e(cVar.b(6)));
        }
        if (z5) {
            for (int length = sb2.length(); length < sb2.length(); length++) {
                if (sb2.charAt(length) == '%') {
                    if (length < sb2.length() - 1) {
                        int i10 = length + 1;
                        if (sb2.charAt(i10) == '%') {
                            sb2.deleteCharAt(i10);
                        }
                    }
                    sb2.setCharAt(length, (char) 29);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x013a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(sc.c r29, java.lang.StringBuilder r30, int r31, com.google.zxing.common.CharacterSetECI r32, java.util.ArrayList r33, java.util.EnumMap r34) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: jd.c.b(sc.c, java.lang.StringBuilder, int, com.google.zxing.common.CharacterSetECI, java.util.ArrayList, java.util.EnumMap):void");
    }

    public static void c(sc.c cVar, StringBuilder sb2, int i3) {
        if (i.f18255c == null) {
            throw FormatException.getFormatInstance();
        }
        if (i3 * 13 > cVar.a()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i3 * 2];
        int i10 = 0;
        while (i3 > 0) {
            int b3 = cVar.b(13);
            int i11 = (b3 % 96) | ((b3 / 96) << 8);
            int i12 = i11 + (i11 < 2560 ? 41377 : 42657);
            bArr[i10] = (byte) ((i12 >> 8) & 255);
            bArr[i10 + 1] = (byte) (i12 & 255);
            i10 += 2;
            i3--;
        }
        sb2.append(new String(bArr, i.f18255c));
    }

    public static void d(sc.c cVar, StringBuilder sb2, int i3) {
        while (i3 >= 3) {
            if (cVar.a() < 10) {
                throw FormatException.getFormatInstance();
            }
            int b3 = cVar.b(10);
            if (b3 >= 1000) {
                throw FormatException.getFormatInstance();
            }
            sb2.append(e(b3 / 100));
            sb2.append(e((b3 / 10) % 10));
            sb2.append(e(b3 % 10));
            i3 -= 3;
        }
        if (i3 == 2) {
            if (cVar.a() < 7) {
                throw FormatException.getFormatInstance();
            }
            int b10 = cVar.b(7);
            if (b10 >= 100) {
                throw FormatException.getFormatInstance();
            }
            sb2.append(e(b10 / 10));
            sb2.append(e(b10 % 10));
            return;
        }
        if (i3 == 1) {
            if (cVar.a() < 4) {
                throw FormatException.getFormatInstance();
            }
            int b11 = cVar.b(4);
            if (b11 >= 10) {
                throw FormatException.getFormatInstance();
            }
            sb2.append(e(b11));
        }
    }

    public static char e(int i3) {
        char[] cArr = f15407a;
        if (i3 < cArr.length) {
            return cArr[i3];
        }
        throw FormatException.getFormatInstance();
    }
}

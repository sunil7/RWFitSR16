package ld;

import com.google.zxing.WriterException;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final int[][] f15856a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* renamed from: b, reason: collision with root package name */
    public static final int[][] f15857b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* renamed from: c, reason: collision with root package name */
    public static final int[][] f15858c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, WebSocketProtocol.PAYLOAD_SHORT, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, WebSocketProtocol.PAYLOAD_SHORT, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    /* renamed from: d, reason: collision with root package name */
    public static final int[][] f15859d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    public static int a(i6.a aVar, boolean z5) {
        int i3 = aVar.f14359c;
        int i10 = aVar.f14360d;
        int i11 = z5 ? i10 : i3;
        if (!z5) {
            i3 = i10;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            byte b3 = -1;
            int i14 = 0;
            for (int i15 = 0; i15 < i3; i15++) {
                byte[][] bArr = (byte[][]) aVar.f14358b;
                byte b10 = z5 ? bArr[i13][i15] : bArr[i15][i13];
                if (b10 == b3) {
                    i14++;
                } else {
                    if (i14 >= 5) {
                        i12 += i14 - 2;
                    }
                    i14 = 1;
                    b3 = b10;
                }
            }
            if (i14 >= 5) {
                i12 = (i14 - 2) + i12;
            }
        }
        return i12;
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x022f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(sc.a r26, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r27, jd.f r28, int r29, i6.a r30) {
        /*
            Method dump skipped, instructions count: 702
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ld.c.b(sc.a, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, jd.f, int, i6.a):void");
    }

    public static int c(int i3, int i10) {
        if (i10 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i10);
        int i11 = 32 - numberOfLeadingZeros;
        int i12 = i3 << (31 - numberOfLeadingZeros);
        while (32 - Integer.numberOfLeadingZeros(i12) >= i11) {
            i12 ^= i10 << ((32 - Integer.numberOfLeadingZeros(i12)) - i11);
        }
        return i12;
    }

    public static void d(int i3, int i10, i6.a aVar) {
        for (int i11 = 0; i11 < 8; i11++) {
            int i12 = i3 + i11;
            if (!g(aVar.a(i12, i10))) {
                throw new WriterException();
            }
            aVar.b(i12, i10, 0);
        }
    }

    public static void e(int i3, int i10, i6.a aVar) {
        for (int i11 = 0; i11 < 7; i11++) {
            int[] iArr = f15856a[i11];
            for (int i12 = 0; i12 < 7; i12++) {
                aVar.b(i3 + i12, i10 + i11, iArr[i12]);
            }
        }
    }

    public static void f(int i3, int i10, i6.a aVar) {
        for (int i11 = 0; i11 < 7; i11++) {
            int i12 = i10 + i11;
            if (!g(aVar.a(i3, i12))) {
                throw new WriterException();
            }
            aVar.b(i3, i12, 0);
        }
    }

    public static boolean g(int i3) {
        return i3 == -1;
    }
}

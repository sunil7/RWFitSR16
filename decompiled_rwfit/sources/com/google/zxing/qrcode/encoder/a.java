package com.google.zxing.qrcode.encoder;

import androidx.recyclerview.widget.e1;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import jd.f;
import sc.i;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f11274a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f11275b = StandardCharsets.ISO_8859_1;

    /* JADX WARN: Removed duplicated region for block: B:18:0x004f A[LOOP:0: B:11:0x0024->B:18:0x004f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(java.lang.String r8, com.google.zxing.qrcode.decoder.Mode r9, sc.a r10, java.nio.charset.Charset r11) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.a.a(java.lang.String, com.google.zxing.qrcode.decoder.Mode, sc.a, java.nio.charset.Charset):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:242:0x05db, code lost:
    
        if ((r3 >= 0 && r3 < 8) != false) goto L261;
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x06ae, code lost:
    
        if (r6 == false) goto L331;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x072c, code lost:
    
        if (r5 == false) goto L377;
     */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0503 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:301:0x068c  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x06bb  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x070b  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x072f  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0737  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static f8.f b(java.lang.String r30, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r31, java.util.Hashtable r32) {
        /*
            Method dump skipped, instructions count: 2099
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.a.b(java.lang.String, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, java.util.Hashtable):f8.f");
    }

    public static boolean c(String str) {
        byte[] bytes = str.getBytes(i.f18254b);
        int length = bytes.length;
        if (length % 2 != 0) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3 += 2) {
            int i10 = bytes[i3] & 255;
            if ((i10 < 129 || i10 > 159) && (i10 < 224 || i10 > 235)) {
                return false;
            }
        }
        return true;
    }

    public static boolean d(int i3, f fVar, ErrorCorrectionLevel errorCorrectionLevel) {
        int i10 = fVar.f15415d;
        d6.a aVar = fVar.f15414c[errorCorrectionLevel.ordinal()];
        int i11 = 0;
        for (e1 e1Var : (e1[]) aVar.f12306b) {
            i11 += e1Var.f2554b;
        }
        return i10 - (i11 * aVar.f12305a) >= (i3 + 7) / 8;
    }
}

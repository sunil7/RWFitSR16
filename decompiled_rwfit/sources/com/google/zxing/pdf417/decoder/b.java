package com.google.zxing.pdf417.decoder;

import com.autonavi.base.ae.gmap.glyph.FontStyle;
import com.google.zxing.FormatException;
import java.math.BigInteger;
import sc.f;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f11257a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f11258b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();

    /* renamed from: c, reason: collision with root package name */
    public static final BigInteger[] f11259c;

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        f11259c = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = valueOf;
        int i3 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = f11259c;
            if (i3 >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i3] = bigIntegerArr2[i3 - 1].multiply(valueOf);
            i3++;
        }
    }

    public static String a(int i3, int[] iArr) {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i10 = 0; i10 < i3; i10++) {
            bigInteger = bigInteger.add(f11259c[(i3 - i10) - 1].multiply(BigInteger.valueOf(iArr[i10])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052 A[FALL_THROUGH, PHI: r3 r4
      0x0052: PHI (r3v10 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode) = 
      (r3v1 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode)
      (r3v1 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode)
      (r3v2 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode)
      (r3v1 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode)
      (r3v1 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode)
      (r3v3 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode)
      (r3v1 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode)
      (r3v1 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode)
      (r3v5 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode)
      (r3v12 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode)
     binds: [B:69:0x00db, B:65:0x00ca, B:66:0x00ce, B:59:0x00b7, B:54:0x00a7, B:56:0x00ad, B:47:0x0093, B:42:0x0081, B:43:0x0085, B:25:0x0050] A[DONT_GENERATE, DONT_INLINE]
      0x0052: PHI (r4v13 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode) = 
      (r4v1 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode)
      (r4v1 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode)
      (r4v3 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode)
      (r4v1 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode)
      (r4v1 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode)
      (r4v6 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode)
      (r4v1 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode)
      (r4v1 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode)
      (r4v9 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode)
      (r4v1 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode)
     binds: [B:69:0x00db, B:65:0x00ca, B:66:0x00ce, B:59:0x00b7, B:54:0x00a7, B:56:0x00ad, B:47:0x0093, B:42:0x0081, B:43:0x0085, B:25:0x0050] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode b(int[] r16, int[] r17, int r18, sc.f r19, com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r20) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.b.b(int[], int[], int, sc.f, com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode):com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
    
        ((java.lang.StringBuilder) r10.f18241b).append(a(r3, r0));
        r3 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003c A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(int[] r8, int r9, sc.f r10) {
        /*
            r0 = 15
            int[] r0 = new int[r0]
            r1 = 0
            r2 = r1
            r3 = r2
        L7:
            r4 = r8[r1]
            if (r9 >= r4) goto L4b
            if (r2 != 0) goto L4b
            int r5 = r9 + 1
            r6 = r8[r9]
            r7 = 1
            if (r5 != r4) goto L15
            r2 = r7
        L15:
            r4 = 900(0x384, float:1.261E-42)
            if (r6 >= r4) goto L1f
            r0[r3] = r6
            int r3 = r3 + 1
        L1d:
            r9 = r5
            goto L32
        L1f:
            if (r6 == r4) goto L31
            r4 = 901(0x385, float:1.263E-42)
            if (r6 == r4) goto L31
            r4 = 927(0x39f, float:1.299E-42)
            if (r6 == r4) goto L31
            r4 = 928(0x3a0, float:1.3E-42)
            if (r6 == r4) goto L31
            switch(r6) {
                case 922: goto L31;
                case 923: goto L31;
                case 924: goto L31;
                default: goto L30;
            }
        L30:
            goto L1d
        L31:
            r2 = r7
        L32:
            int r4 = r3 % 15
            if (r4 == 0) goto L3c
            r4 = 902(0x386, float:1.264E-42)
            if (r6 == r4) goto L3c
            if (r2 == 0) goto L7
        L3c:
            if (r3 <= 0) goto L7
            java.lang.String r3 = a(r3, r0)
            java.lang.Object r4 = r10.f18241b
            java.lang.StringBuilder r4 = (java.lang.StringBuilder) r4
            r4.append(r3)
            r3 = r1
            goto L7
        L4b:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.b.c(int[], int, sc.f):int");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:28:0x0036. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x0039. Please report as an issue. */
    public static int d(int[] iArr, int i3, f fVar) {
        int i10 = (iArr[0] - i3) * 2;
        int[] iArr2 = new int[i10];
        int[] iArr3 = new int[i10];
        DecodedBitStreamParser$Mode decodedBitStreamParser$Mode = DecodedBitStreamParser$Mode.ALPHA;
        boolean z5 = false;
        int i11 = 0;
        while (i3 < iArr[0] && !z5) {
            int i12 = i3 + 1;
            int i13 = iArr[i3];
            if (i13 < 900) {
                iArr2[i11] = i13 / 30;
                iArr2[i11 + 1] = i13 % 30;
                i11 += 2;
            } else if (i13 == 913) {
                iArr2[i11] = 913;
                i3 += 2;
                iArr3[i11] = iArr[i12];
                i11++;
            } else if (i13 != 927) {
                if (i13 != 928) {
                    switch (i13) {
                        case FontStyle.WEIGHT_BLACK /* 900 */:
                            iArr2[i11] = 900;
                            i11++;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i13) {
                            }
                    }
                }
                z5 = true;
            } else {
                DecodedBitStreamParser$Mode b3 = b(iArr2, iArr3, i11, fVar, decodedBitStreamParser$Mode);
                i3 += 2;
                fVar.b(iArr[i12]);
                int i14 = iArr[0];
                if (i3 > i14) {
                    throw FormatException.getFormatInstance();
                }
                int i15 = (i14 - i3) * 2;
                decodedBitStreamParser$Mode = b3;
                iArr3 = new int[i15];
                iArr2 = new int[i15];
                i11 = 0;
            }
            i3 = i12;
        }
        b(iArr2, iArr3, i11, fVar, decodedBitStreamParser$Mode);
        return i3;
    }
}

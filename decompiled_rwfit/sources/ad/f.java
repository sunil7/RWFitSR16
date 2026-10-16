package ad;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.EnumMap;

/* loaded from: classes.dex */
public final class f extends h {

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f242b = {6, 8, 10, 12, 14};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f243c = {1, 1, 1, 1};

    /* renamed from: d, reason: collision with root package name */
    public static final int[][] f244d = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};
    public static final int[][] e = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* renamed from: a, reason: collision with root package name */
    public int f245a = -1;

    public static int h(int[] iArr) {
        float f2 = 0.38f;
        int i3 = -1;
        for (int i10 = 0; i10 < 20; i10++) {
            float e10 = h.e(iArr, e[i10], 0.5f);
            if (e10 < f2) {
                i3 = i10;
                f2 = e10;
            } else if (e10 == f2) {
                i3 = -1;
            }
        }
        if (i3 >= 0) {
            return i3 % 10;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int[] i(int i3, sc.a aVar, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int i10 = aVar.f18220b;
        int i11 = i3;
        boolean z5 = false;
        int i12 = 0;
        while (i3 < i10) {
            if (aVar.d(i3) != z5) {
                iArr2[i12] = iArr2[i12] + 1;
            } else {
                if (i12 != length - 1) {
                    i12++;
                } else {
                    if (h.e(iArr2, iArr, 0.5f) < 0.38f) {
                        return new int[]{i11, i3};
                    }
                    i11 += iArr2[0] + iArr2[1];
                    int i13 = i12 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i13);
                    iArr2[i13] = 0;
                    iArr2[i12] = 0;
                    i12--;
                }
                iArr2[i12] = 1;
                z5 = !z5;
            }
            i3++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // ad.h
    public final com.google.zxing.g c(int i3, sc.a aVar, EnumMap enumMap) {
        int[] i10;
        boolean z5;
        int i11 = aVar.f18220b;
        int e10 = aVar.e(0);
        if (e10 == i11) {
            throw NotFoundException.getNotFoundInstance();
        }
        int[] i12 = i(e10, aVar, f243c);
        int i13 = i12[1];
        int i14 = i12[0];
        this.f245a = (i13 - i14) / 4;
        j(aVar, i14);
        int[][] iArr = f244d;
        aVar.i();
        try {
            int i15 = aVar.f18220b;
            int e11 = aVar.e(0);
            if (e11 == i15) {
                throw NotFoundException.getNotFoundInstance();
            }
            try {
                i10 = i(e11, aVar, iArr[0]);
            } catch (NotFoundException unused) {
                i10 = i(e11, aVar, iArr[1]);
            }
            j(aVar, i10[0]);
            int i16 = i10[0];
            int i17 = aVar.f18220b;
            i10[0] = i17 - i10[1];
            i10[1] = i17 - i16;
            aVar.i();
            StringBuilder sb2 = new StringBuilder(20);
            int i18 = i12[1];
            int i19 = i10[0];
            int[] iArr2 = new int[10];
            int[] iArr3 = new int[5];
            int[] iArr4 = new int[5];
            while (i18 < i19) {
                h.f(i18, aVar, iArr2);
                for (int i20 = 0; i20 < 5; i20++) {
                    int i21 = i20 * 2;
                    iArr3[i20] = iArr2[i21];
                    iArr4[i20] = iArr2[i21 + 1];
                }
                sb2.append((char) (h(iArr3) + 48));
                sb2.append((char) (h(iArr4) + 48));
                for (int i22 = 0; i22 < 10; i22++) {
                    i18 += iArr2[i22];
                }
            }
            String sb3 = sb2.toString();
            int[] iArr5 = enumMap != null ? (int[]) enumMap.get(DecodeHintType.ALLOWED_LENGTHS) : null;
            if (iArr5 == null) {
                iArr5 = f242b;
            }
            int length = sb3.length();
            int length2 = iArr5.length;
            int i23 = 0;
            int i24 = 0;
            while (true) {
                if (i23 >= length2) {
                    z5 = false;
                    break;
                }
                int i25 = iArr5[i23];
                if (length == i25) {
                    z5 = true;
                    break;
                }
                if (i25 > i24) {
                    i24 = i25;
                }
                i23++;
            }
            if (!z5 && length > i24) {
                z5 = true;
            }
            if (!z5) {
                throw FormatException.getFormatInstance();
            }
            float f2 = i3;
            com.google.zxing.g gVar = new com.google.zxing.g(sb3, null, new com.google.zxing.h[]{new com.google.zxing.h(i12[1], f2), new com.google.zxing.h(i10[0], f2)}, BarcodeFormat.ITF);
            gVar.b(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]I0");
            return gVar;
        } catch (Throwable th2) {
            aVar.i();
            throw th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(sc.a r3, int r4) {
        /*
            r2 = this;
            int r0 = r2.f245a
            int r0 = r0 * 10
            int r0 = java.lang.Math.min(r0, r4)
            int r4 = r4 + (-1)
        La:
            if (r0 <= 0) goto L1a
            if (r4 < 0) goto L1a
            boolean r1 = r3.d(r4)
            if (r1 == 0) goto L15
            goto L1a
        L15:
            int r0 = r0 + (-1)
            int r4 = r4 + (-1)
            goto La
        L1a:
            if (r0 != 0) goto L1d
            return
        L1d:
            com.google.zxing.NotFoundException r3 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ad.f.j(sc.a, int):void");
    }
}

package ad;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.EnumMap;

/* loaded from: classes.dex */
public final class c extends h {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f229d = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 168, 162, 138, 42};

    /* renamed from: a, reason: collision with root package name */
    public final boolean f230a;

    /* renamed from: b, reason: collision with root package name */
    public final StringBuilder f231b = new StringBuilder(20);

    /* renamed from: c, reason: collision with root package name */
    public final int[] f232c = new int[9];

    public c(boolean z5) {
        this.f230a = z5;
    }

    public static int h(int[] iArr) {
        int length = iArr.length;
        int i3 = 0;
        while (true) {
            int i10 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            for (int i11 : iArr) {
                if (i11 < i10 && i11 > i3) {
                    i10 = i11;
                }
            }
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            for (int i15 = 0; i15 < length; i15++) {
                int i16 = iArr[i15];
                if (i16 > i10) {
                    i13 |= 1 << ((length - 1) - i15);
                    i12++;
                    i14 += i16;
                }
            }
            if (i12 == 3) {
                for (int i17 = 0; i17 < length && i12 > 0; i17++) {
                    int i18 = iArr[i17];
                    if (i18 > i10) {
                        i12--;
                        if (i18 * 2 >= i14) {
                            return -1;
                        }
                    }
                }
                return i13;
            }
            if (i12 <= 3) {
                return -1;
            }
            i3 = i10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r21v4 */
    /* JADX WARN: Type inference failed for: r21v5 */
    /* JADX WARN: Type inference failed for: r21v8 */
    @Override // ad.h
    public final com.google.zxing.g c(int i3, sc.a aVar, EnumMap enumMap) {
        int i10;
        ?? r21;
        char c9;
        int[] iArr = this.f232c;
        Arrays.fill(iArr, 0);
        StringBuilder sb2 = this.f231b;
        sb2.setLength(0);
        int i11 = aVar.f18220b;
        int e = aVar.e(0);
        int length = iArr.length;
        boolean z5 = false;
        int i12 = 0;
        int i13 = e;
        while (e < i11) {
            boolean z6 = true;
            if (aVar.d(e) != z5) {
                iArr[i12] = iArr[i12] + 1;
            } else {
                if (i12 == length - 1) {
                    int i14 = 148;
                    if (h(iArr) == 148 && aVar.h(Math.max(0, i13 - ((e - i13) / 2)), i13)) {
                        int e10 = aVar.e(new int[]{i13, e}[1]);
                        int i15 = aVar.f18220b;
                        while (true) {
                            h.f(e10, aVar, iArr);
                            int h4 = h(iArr);
                            if (h4 < 0) {
                                throw NotFoundException.getNotFoundInstance();
                            }
                            int i16 = 0;
                            while (true) {
                                if (i16 < 43) {
                                    boolean z8 = z6;
                                    if (f229d[i16] == h4) {
                                        c9 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i16);
                                        r21 = z8;
                                        break;
                                    }
                                    i16++;
                                    z6 = z8 ? 1 : 0;
                                } else {
                                    r21 = z6;
                                    if (h4 != i14) {
                                        throw NotFoundException.getNotFoundInstance();
                                    }
                                    c9 = '*';
                                }
                            }
                            sb2.append(c9);
                            int i17 = e10;
                            for (int i18 : iArr) {
                                i17 += i18;
                            }
                            int e11 = aVar.e(i17);
                            if (c9 == '*') {
                                sb2.setLength(sb2.length() - 1);
                                int i19 = 0;
                                for (int i20 : iArr) {
                                    i19 += i20;
                                }
                                int i21 = (e11 - e10) - i19;
                                if (e11 != i15 && i21 * 2 < i19) {
                                    throw NotFoundException.getNotFoundInstance();
                                }
                                if (this.f230a) {
                                    int length2 = sb2.length() - 1;
                                    int i22 = 0;
                                    for (int i23 = 0; i23 < length2; i23++) {
                                        i22 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(sb2.charAt(i23));
                                    }
                                    if (sb2.charAt(length2) != "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i22 % 43)) {
                                        throw ChecksumException.getChecksumInstance();
                                    }
                                    sb2.setLength(length2);
                                }
                                if (sb2.length() == 0) {
                                    throw NotFoundException.getNotFoundInstance();
                                }
                                float f2 = (r5[r21] + r5[0]) / 2.0f;
                                float f10 = (i19 / 2.0f) + e10;
                                float f11 = i3;
                                com.google.zxing.g gVar = new com.google.zxing.g(sb2.toString(), null, new com.google.zxing.h[]{new com.google.zxing.h(f2, f11), new com.google.zxing.h(f10, f11)}, BarcodeFormat.CODE_39);
                                gVar.b(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]A0");
                                return gVar;
                            }
                            z6 = r21;
                            e10 = e11;
                            i14 = 148;
                        }
                    } else {
                        i10 = 1;
                        i13 += iArr[0] + iArr[1];
                        int i24 = i12 - 1;
                        System.arraycopy(iArr, 2, iArr, 0, i24);
                        iArr[i24] = 0;
                        iArr[i12] = 0;
                        i12--;
                    }
                } else {
                    i10 = 1;
                    i12++;
                }
                iArr[i12] = i10;
                z5 = !z5;
            }
            e++;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}

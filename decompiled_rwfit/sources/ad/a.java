package ad;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.EnumMap;

/* loaded from: classes.dex */
public final class a extends h {

    /* renamed from: d, reason: collision with root package name */
    public static final char[] f223d = "0123456789-$:/.+ABCD".toCharArray();
    public static final int[] e = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* renamed from: f, reason: collision with root package name */
    public static final char[] f224f = {'A', 'B', 'C', 'D'};

    /* renamed from: a, reason: collision with root package name */
    public final StringBuilder f225a = new StringBuilder(20);

    /* renamed from: b, reason: collision with root package name */
    public int[] f226b = new int[80];

    /* renamed from: c, reason: collision with root package name */
    public int f227c = 0;

    public static boolean h(char[] cArr, char c9) {
        if (cArr != null) {
            for (char c10 : cArr) {
                if (c10 == c9) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // ad.h
    public final com.google.zxing.g c(int i3, sc.a aVar, EnumMap enumMap) {
        int i10;
        int[] iArr;
        int i11;
        Arrays.fill(this.f226b, 0);
        this.f227c = 0;
        int f2 = aVar.f(0);
        int i12 = aVar.f18220b;
        if (f2 >= i12) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i13 = 1;
        int i14 = 0;
        boolean z5 = true;
        while (f2 < i12) {
            if (aVar.d(f2) != z5) {
                i14++;
            } else {
                int[] iArr2 = this.f226b;
                int i15 = this.f227c;
                iArr2[i15] = i14;
                int i16 = i15 + 1;
                this.f227c = i16;
                if (i16 >= iArr2.length) {
                    int[] iArr3 = new int[i16 * 2];
                    System.arraycopy(iArr2, 0, iArr3, 0, i16);
                    this.f226b = iArr3;
                }
                z5 = !z5;
                i14 = 1;
            }
            f2++;
        }
        int[] iArr4 = this.f226b;
        int i17 = this.f227c;
        iArr4[i17] = i14;
        int i18 = i17 + 1;
        this.f227c = i18;
        if (i18 >= iArr4.length) {
            int[] iArr5 = new int[i18 * 2];
            System.arraycopy(iArr4, 0, iArr5, 0, i18);
            this.f226b = iArr5;
        }
        int i19 = 1;
        while (i19 < this.f227c) {
            int i20 = i(i19);
            if (i20 != -1) {
                char[] cArr = f223d;
                char c9 = cArr[i20];
                char[] cArr2 = f224f;
                if (h(cArr2, c9)) {
                    int i21 = 0;
                    for (int i22 = i19; i22 < i19 + 7; i22++) {
                        i21 += this.f226b[i22];
                    }
                    if (i19 == i13 || this.f226b[i19 - 1] >= i21 / 2) {
                        StringBuilder sb2 = this.f225a;
                        sb2.setLength(0);
                        int i23 = i19;
                        while (true) {
                            int i24 = i(i23);
                            if (i24 == -1) {
                                throw NotFoundException.getNotFoundInstance();
                            }
                            sb2.append((char) i24);
                            i10 = i23 + 8;
                            if ((sb2.length() <= i13 || !h(cArr2, cArr[i24])) && i10 < this.f227c) {
                                i23 = i10;
                                i13 = i13;
                            }
                        }
                        int i25 = i23 + 7;
                        int i26 = this.f226b[i25];
                        int i27 = 0;
                        for (int i28 = -8; i28 < -1; i28++) {
                            i27 += this.f226b[i10 + i28];
                        }
                        int i29 = 2;
                        if (i10 < this.f227c && i26 < i27 / 2) {
                            throw NotFoundException.getNotFoundInstance();
                        }
                        int[] iArr6 = new int[4];
                        iArr6[0] = 0;
                        iArr6[i13] = 0;
                        iArr6[2] = 0;
                        iArr6[3] = 0;
                        int[] iArr7 = new int[4];
                        iArr7[0] = 0;
                        iArr7[i13] = 0;
                        iArr7[2] = 0;
                        iArr7[3] = 0;
                        int length = sb2.length() - i13;
                        int i30 = i19;
                        int i31 = 0;
                        while (true) {
                            int i32 = 6;
                            iArr = e;
                            if (i31 > length) {
                                break;
                            }
                            int i33 = iArr[sb2.charAt(i31)];
                            while (i32 >= 0) {
                                int i34 = ((i33 & 1) * 2) + (i32 & 1);
                                iArr6[i34] = iArr6[i34] + this.f226b[i30 + i32];
                                iArr7[i34] = iArr7[i34] + 1;
                                i33 >>= 1;
                                i32--;
                                i13 = i13;
                            }
                            i30 += 8;
                            i31++;
                        }
                        float[] fArr = new float[4];
                        float[] fArr2 = new float[4];
                        int i35 = 0;
                        while (i35 < i29) {
                            fArr2[i35] = 0.0f;
                            int i36 = i35 + 2;
                            int i37 = i29;
                            float f10 = iArr6[i36];
                            float f11 = iArr7[i36];
                            float f12 = ((f10 / f11) + (iArr6[i35] / iArr7[i35])) / 2.0f;
                            fArr2[i36] = f12;
                            fArr[i35] = f12;
                            fArr[i36] = ((f10 * 2.0f) + 1.5f) / f11;
                            i35++;
                            i29 = i37;
                        }
                        int i38 = i19;
                        for (int i39 = 0; i39 <= length; i39++) {
                            int i40 = iArr[sb2.charAt(i39)];
                            for (int i41 = 6; i41 >= 0; i41--) {
                                int i42 = ((i40 & 1) * 2) + (i41 & 1);
                                float f13 = this.f226b[i38 + i41];
                                if (f13 < fArr2[i42] || f13 > fArr[i42]) {
                                    throw NotFoundException.getNotFoundInstance();
                                }
                                i40 >>= 1;
                            }
                            i38 += 8;
                        }
                        for (int i43 = 0; i43 < sb2.length(); i43++) {
                            sb2.setCharAt(i43, cArr[sb2.charAt(i43)]);
                        }
                        if (!h(cArr2, sb2.charAt(0))) {
                            throw NotFoundException.getNotFoundInstance();
                        }
                        if (!h(cArr2, sb2.charAt(sb2.length() - 1))) {
                            throw NotFoundException.getNotFoundInstance();
                        }
                        if (sb2.length() <= 3) {
                            throw NotFoundException.getNotFoundInstance();
                        }
                        if (enumMap == null || !enumMap.containsKey(DecodeHintType.RETURN_CODABAR_START_END)) {
                            sb2.deleteCharAt(sb2.length() - 1);
                            i11 = 0;
                            sb2.deleteCharAt(0);
                        } else {
                            i11 = 0;
                        }
                        int i44 = i11;
                        while (i11 < i19) {
                            i44 += this.f226b[i11];
                            i11++;
                        }
                        float f14 = i44;
                        while (i19 < i25) {
                            i44 += this.f226b[i19];
                            i19++;
                        }
                        float f15 = i3;
                        com.google.zxing.g gVar = new com.google.zxing.g(sb2.toString(), null, new com.google.zxing.h[]{new com.google.zxing.h(f14, f15), new com.google.zxing.h(i44, f15)}, BarcodeFormat.CODABAR);
                        gVar.b(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]F0");
                        return gVar;
                    }
                }
            }
            i19 += 2;
            i13 = i13;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final int i(int i3) {
        int i10 = i3 + 7;
        if (i10 >= this.f227c) {
            return -1;
        }
        int[] iArr = this.f226b;
        int i11 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        int i12 = 0;
        int i13 = Integer.MAX_VALUE;
        int i14 = 0;
        for (int i15 = i3; i15 < i10; i15 += 2) {
            int i16 = iArr[i15];
            if (i16 < i13) {
                i13 = i16;
            }
            if (i16 > i14) {
                i14 = i16;
            }
        }
        int i17 = (i13 + i14) / 2;
        int i18 = 0;
        for (int i19 = i3 + 1; i19 < i10; i19 += 2) {
            int i20 = iArr[i19];
            if (i20 < i11) {
                i11 = i20;
            }
            if (i20 > i18) {
                i18 = i20;
            }
        }
        int i21 = (i11 + i18) / 2;
        int i22 = 128;
        int i23 = 0;
        for (int i24 = 0; i24 < 7; i24++) {
            i22 >>= 1;
            if (iArr[i3 + i24] > ((i24 & 1) == 0 ? i17 : i21)) {
                i23 |= i22;
            }
        }
        while (true) {
            int[] iArr2 = e;
            if (i12 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i12] == i23) {
                return i12;
            }
            i12++;
        }
    }
}

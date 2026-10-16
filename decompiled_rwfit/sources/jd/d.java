package jd;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name */
    public static final int[][] f15408c = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* renamed from: a, reason: collision with root package name */
    public final ErrorCorrectionLevel f15409a;

    /* renamed from: b, reason: collision with root package name */
    public final byte f15410b;

    public d(int i3) {
        this.f15409a = ErrorCorrectionLevel.forBits((i3 >> 3) & 3);
        this.f15410b = (byte) (i3 & 7);
    }

    public static d a(int i3, int i10) {
        int bitCount;
        int[][] iArr = f15408c;
        int i11 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        int i12 = 0;
        for (int i13 = 0; i13 < 32; i13++) {
            int[] iArr2 = iArr[i13];
            int i14 = iArr2[0];
            if (i14 == i3 || i14 == i10) {
                return new d(iArr2[1]);
            }
            int bitCount2 = Integer.bitCount(i3 ^ i14);
            if (bitCount2 < i11) {
                i12 = iArr2[1];
                i11 = bitCount2;
            }
            if (i3 != i10 && (bitCount = Integer.bitCount(i14 ^ i10)) < i11) {
                i12 = iArr2[1];
                i11 = bitCount;
            }
        }
        if (i11 <= 3) {
            return new d(i12);
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f15409a == dVar.f15409a && this.f15410b == dVar.f15410b;
    }

    public final int hashCode() {
        return (this.f15409a.ordinal() << 3) | this.f15410b;
    }
}

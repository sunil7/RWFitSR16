package com.google.zxing;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes.dex */
public final class e extends b {

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f11241c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11242d;
    public final int e;

    public e(int[] iArr, int i3, int i10) {
        super(i3, i10);
        this.f11242d = i3;
        this.e = i10;
        int i11 = i3 * i10;
        this.f11241c = new byte[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = iArr[i12];
            this.f11241c[i12] = (byte) (((((i13 >> 16) & 255) + ((i13 >> 7) & 510)) + (i13 & 255)) / 4);
        }
    }

    @Override // com.google.zxing.b
    public final byte[] a() {
        int i3 = this.f11242d;
        byte[] bArr = this.f11241c;
        int i10 = this.f11226a;
        int i11 = this.f11227b;
        if (i10 == i3 && i11 == this.e) {
            return bArr;
        }
        int i12 = i10 * i11;
        byte[] bArr2 = new byte[i12];
        if (i10 == i3) {
            System.arraycopy(bArr, 0, bArr2, 0, i12);
            return bArr2;
        }
        int i13 = 0;
        for (int i14 = 0; i14 < i11; i14++) {
            System.arraycopy(bArr, i13, bArr2, i14 * i10, i10);
            i13 += i3;
        }
        return bArr2;
    }

    @Override // com.google.zxing.b
    public final byte[] b(int i3, byte[] bArr) {
        if (i3 < 0 || i3 >= this.f11227b) {
            throw new IllegalArgumentException(l0.j(i3, "Requested row is outside the image: "));
        }
        int i10 = this.f11226a;
        if (bArr == null || bArr.length < i10) {
            bArr = new byte[i10];
        }
        System.arraycopy(this.f11241c, i3 * this.f11242d, bArr, 0, i10);
        return bArr;
    }
}

package com.google.zxing;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes.dex */
public final class d extends b {

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f11234c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11235d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final int f11236f;

    /* renamed from: g, reason: collision with root package name */
    public final int f11237g;

    public d(byte[] bArr, int i3, int i10, int i11, int i12, int i13, int i14) {
        super(i13, i14);
        if (i13 + i11 > i3 || i14 + i12 > i10) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f11234c = bArr;
        this.f11235d = i3;
        this.e = i10;
        this.f11236f = i11;
        this.f11237g = i12;
    }

    @Override // com.google.zxing.b
    public final byte[] a() {
        int i3 = this.f11235d;
        byte[] bArr = this.f11234c;
        int i10 = this.f11226a;
        int i11 = this.f11227b;
        if (i10 == i3 && i11 == this.e) {
            return bArr;
        }
        int i12 = i10 * i11;
        byte[] bArr2 = new byte[i12];
        int i13 = (this.f11237g * i3) + this.f11236f;
        if (i10 == i3) {
            System.arraycopy(bArr, i13, bArr2, 0, i12);
            return bArr2;
        }
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
        System.arraycopy(this.f11234c, ((i3 + this.f11237g) * this.f11235d) + this.f11236f, bArr, 0, i10);
        return bArr;
    }
}

package com.google.zxing;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f11226a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11227b;

    public b(int i3, int i10) {
        this.f11226a = i3;
        this.f11227b = i10;
    }

    public abstract byte[] a();

    public abstract byte[] b(int i3, byte[] bArr);

    public final String toString() {
        int i3 = this.f11226a;
        byte[] bArr = new byte[i3];
        int i10 = this.f11227b;
        StringBuilder sb2 = new StringBuilder((i3 + 1) * i10);
        for (int i11 = 0; i11 < i10; i11++) {
            bArr = b(i11, bArr);
            for (int i12 = 0; i12 < i3; i12++) {
                int i13 = bArr[i12] & 255;
                sb2.append(i13 < 64 ? '#' : i13 < 128 ? '+' : i13 < 192 ? '.' : ' ');
            }
            sb2.append('\n');
        }
        return sb2.toString();
    }
}

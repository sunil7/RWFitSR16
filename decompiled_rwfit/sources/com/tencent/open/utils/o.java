package com.tencent.open.utils;

/* loaded from: classes2.dex */
public final class o implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private int f12126a;

    public o(byte[] bArr) {
        this(bArr, 0);
    }

    public byte[] a() {
        int i3 = this.f12126a;
        return new byte[]{(byte) (i3 & 255), (byte) ((i3 & 65280) >> 8)};
    }

    public int b() {
        return this.f12126a;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof o) && this.f12126a == ((o) obj).b();
    }

    public int hashCode() {
        return this.f12126a;
    }

    public o(byte[] bArr, int i3) {
        int i10 = (bArr[i3 + 1] << 8) & 65280;
        this.f12126a = i10;
        this.f12126a = i10 + (bArr[i3] & 255);
    }

    public o(int i3) {
        this.f12126a = i3;
    }
}

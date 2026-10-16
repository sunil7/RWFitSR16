package com.tencent.open.utils;

/* loaded from: classes2.dex */
public final class n implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private long f12125a;

    public n(long j4) {
        this.f12125a = j4;
    }

    public byte[] a() {
        long j4 = this.f12125a;
        return new byte[]{(byte) (255 & j4), (byte) ((65280 & j4) >> 8), (byte) ((16711680 & j4) >> 16), (byte) ((j4 & 4278190080L) >> 24)};
    }

    public long b() {
        return this.f12125a;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof n) && this.f12125a == ((n) obj).b();
    }

    public int hashCode() {
        return (int) this.f12125a;
    }
}

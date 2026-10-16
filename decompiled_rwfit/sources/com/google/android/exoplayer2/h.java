package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final long f8859a;

    public h(long j4) {
        this.f8859a = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        hVar.getClass();
        return this.f8859a == hVar.f8859a;
    }

    public final int hashCode() {
        long j4 = this.f8859a;
        return ((((int) 0) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 29791;
    }
}

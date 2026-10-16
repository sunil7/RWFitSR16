package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final long f8860a;

    /* renamed from: b, reason: collision with root package name */
    public final long f8861b;

    /* renamed from: c, reason: collision with root package name */
    public final long f8862c;

    /* renamed from: d, reason: collision with root package name */
    public final float f8863d;
    public final float e;

    public i(long j4, long j10, long j11, float f2, float f10) {
        this.f8860a = j4;
        this.f8861b = j10;
        this.f8862c = j11;
        this.f8863d = f2;
        this.e = f10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f8860a == iVar.f8860a && this.f8861b == iVar.f8861b && this.f8862c == iVar.f8862c && this.f8863d == iVar.f8863d && this.e == iVar.e;
    }

    public final int hashCode() {
        long j4 = this.f8860a;
        long j10 = this.f8861b;
        int i3 = ((((int) (j4 ^ (j4 >>> 32))) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.f8862c;
        int i10 = (i3 + ((int) ((j11 >>> 32) ^ j11))) * 31;
        float f2 = this.f8863d;
        int floatToIntBits = (i10 + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31;
        float f10 = this.e;
        return floatToIntBits + (f10 != 0.0f ? Float.floatToIntBits(f10) : 0);
    }
}

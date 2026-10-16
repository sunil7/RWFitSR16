package com.liulishuo.filedownloader.download;

import java.util.Locale;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final long f11400a;

    /* renamed from: b, reason: collision with root package name */
    public final long f11401b;

    /* renamed from: c, reason: collision with root package name */
    public final long f11402c;

    /* renamed from: d, reason: collision with root package name */
    public final long f11403d;
    public final boolean e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f11404f;

    public b() {
        this.f11400a = 0L;
        this.f11401b = 0L;
        this.f11402c = 0L;
        this.f11403d = 0L;
        this.e = false;
        this.f11404f = true;
    }

    public final String toString() {
        int i3 = ye.e.f20123a;
        Locale locale = Locale.ENGLISH;
        StringBuilder sb2 = new StringBuilder("range[");
        sb2.append(this.f11400a);
        sb2.append(", ");
        sb2.append(this.f11402c);
        sb2.append(") current offset[");
        return android.support.v4.media.session.e.n(sb2, this.f11401b, "]");
    }

    public b(long j4, long j10, long j11, long j12, boolean z5) {
        if ((j4 == 0 && j11 == 0) || !z5) {
            this.f11400a = j4;
            this.f11401b = j10;
            this.f11402c = j11;
            this.f11403d = j12;
            this.e = z5;
            this.f11404f = false;
            return;
        }
        throw new IllegalArgumentException();
    }
}

package org.joda.time.tz;

import org.joda.time.DateTimeZone;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final long f17262a;

    /* renamed from: b, reason: collision with root package name */
    public final DateTimeZone f17263b;

    /* renamed from: c, reason: collision with root package name */
    public a f17264c;

    /* renamed from: d, reason: collision with root package name */
    public String f17265d;
    public int e = Integer.MIN_VALUE;

    /* renamed from: f, reason: collision with root package name */
    public int f17266f = Integer.MIN_VALUE;

    public a(DateTimeZone dateTimeZone, long j4) {
        this.f17262a = j4;
        this.f17263b = dateTimeZone;
    }

    public final String a(long j4) {
        a aVar = this.f17264c;
        if (aVar != null && j4 >= aVar.f17262a) {
            return aVar.a(j4);
        }
        if (this.f17265d == null) {
            this.f17265d = this.f17263b.getNameKey(this.f17262a);
        }
        return this.f17265d;
    }

    public final int b(long j4) {
        a aVar = this.f17264c;
        if (aVar != null && j4 >= aVar.f17262a) {
            return aVar.b(j4);
        }
        if (this.e == Integer.MIN_VALUE) {
            this.e = this.f17263b.getOffset(this.f17262a);
        }
        return this.e;
    }

    public final int c(long j4) {
        a aVar = this.f17264c;
        if (aVar != null && j4 >= aVar.f17262a) {
            return aVar.c(j4);
        }
        if (this.f17266f == Integer.MIN_VALUE) {
            this.f17266f = this.f17263b.getStandardOffset(this.f17262a);
        }
        return this.f17266f;
    }
}

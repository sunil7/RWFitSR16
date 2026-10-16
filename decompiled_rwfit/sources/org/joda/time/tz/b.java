package org.joda.time.tz;

import org.joda.time.chrono.ISOChronology;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final char f17267a;

    /* renamed from: b, reason: collision with root package name */
    public final int f17268b;

    /* renamed from: c, reason: collision with root package name */
    public final int f17269c;

    /* renamed from: d, reason: collision with root package name */
    public final int f17270d;
    public final boolean e;

    /* renamed from: f, reason: collision with root package name */
    public final int f17271f;

    public b(char c9, int i3, int i10, int i11, boolean z5, int i12) {
        if (c9 != 'u' && c9 != 'w' && c9 != 's') {
            throw new IllegalArgumentException("Unknown mode: " + c9);
        }
        this.f17267a = c9;
        this.f17268b = i3;
        this.f17269c = i10;
        this.f17270d = i11;
        this.e = z5;
        this.f17271f = i12;
    }

    public final long a(ISOChronology iSOChronology, long j4) {
        int i3 = this.f17269c;
        if (i3 >= 0) {
            return iSOChronology.dayOfMonth().set(j4, i3);
        }
        return iSOChronology.dayOfMonth().add(iSOChronology.monthOfYear().add(iSOChronology.dayOfMonth().set(j4, 1), 1), i3);
    }

    public final long b(ISOChronology iSOChronology, long j4) {
        try {
            return a(iSOChronology, j4);
        } catch (IllegalArgumentException e) {
            if (this.f17268b != 2 || this.f17269c != 29) {
                throw e;
            }
            while (!iSOChronology.year().isLeap(j4)) {
                j4 = iSOChronology.year().add(j4, 1);
            }
            return a(iSOChronology, j4);
        }
    }

    public final long c(ISOChronology iSOChronology, long j4) {
        try {
            return a(iSOChronology, j4);
        } catch (IllegalArgumentException e) {
            if (this.f17268b != 2 || this.f17269c != 29) {
                throw e;
            }
            while (!iSOChronology.year().isLeap(j4)) {
                j4 = iSOChronology.year().add(j4, -1);
            }
            return a(iSOChronology, j4);
        }
    }

    public final long d(ISOChronology iSOChronology, long j4) {
        int i3 = this.f17270d - iSOChronology.dayOfWeek().get(j4);
        if (i3 == 0) {
            return j4;
        }
        if (this.e) {
            if (i3 < 0) {
                i3 += 7;
            }
        } else if (i3 > 0) {
            i3 -= 7;
        }
        return iSOChronology.dayOfWeek().add(j4, i3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f17267a == bVar.f17267a && this.f17268b == bVar.f17268b && this.f17269c == bVar.f17269c && this.f17270d == bVar.f17270d && this.e == bVar.e && this.f17271f == bVar.f17271f) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("[OfYear]\nMode: ");
        sb2.append(this.f17267a);
        sb2.append("\nMonthOfYear: ");
        sb2.append(this.f17268b);
        sb2.append("\nDayOfMonth: ");
        sb2.append(this.f17269c);
        sb2.append("\nDayOfWeek: ");
        sb2.append(this.f17270d);
        sb2.append("\nAdvanceDayOfWeek: ");
        sb2.append(this.e);
        sb2.append("\nMillisOfDay: ");
        return android.support.v4.media.session.e.m(sb2, this.f17271f, '\n');
    }
}

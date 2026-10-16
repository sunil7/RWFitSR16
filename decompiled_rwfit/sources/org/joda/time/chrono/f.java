package org.joda.time.chrono;

import org.joda.time.DateTimeZone;
import org.joda.time.Instant;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final DateTimeZone f17085a;

    /* renamed from: b, reason: collision with root package name */
    public final Instant f17086b;

    /* renamed from: c, reason: collision with root package name */
    public final int f17087c;

    public f(DateTimeZone dateTimeZone, Instant instant, int i3) {
        this.f17085a = dateTimeZone;
        this.f17086b = instant;
        this.f17087c = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        Instant instant = fVar.f17086b;
        Instant instant2 = this.f17086b;
        if (instant2 == null) {
            if (instant != null) {
                return false;
            }
        } else if (!instant2.equals(instant)) {
            return false;
        }
        if (this.f17087c != fVar.f17087c) {
            return false;
        }
        DateTimeZone dateTimeZone = fVar.f17085a;
        DateTimeZone dateTimeZone2 = this.f17085a;
        if (dateTimeZone2 == null) {
            if (dateTimeZone != null) {
                return false;
            }
        } else if (!dateTimeZone2.equals(dateTimeZone)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Instant instant = this.f17086b;
        int hashCode = ((((instant == null ? 0 : instant.hashCode()) + 31) * 31) + this.f17087c) * 31;
        DateTimeZone dateTimeZone = this.f17085a;
        return hashCode + (dateTimeZone != null ? dateTimeZone.hashCode() : 0);
    }
}

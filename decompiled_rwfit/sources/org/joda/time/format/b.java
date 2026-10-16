package org.joda.time.format;

import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.joda.time.chrono.ISOChronology;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final z f17152a;

    /* renamed from: b, reason: collision with root package name */
    public final x f17153b;

    /* renamed from: c, reason: collision with root package name */
    public final Locale f17154c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f17155d;
    public final org.joda.time.a e;

    /* renamed from: f, reason: collision with root package name */
    public final DateTimeZone f17156f;

    public b(z zVar, x xVar) {
        this.f17152a = zVar;
        this.f17153b = xVar;
        this.f17154c = null;
        this.f17155d = false;
        this.e = null;
        this.f17156f = null;
    }

    public final DateTime a(String str) {
        Integer num;
        x xVar = this.f17153b;
        if (xVar == null) {
            throw new UnsupportedOperationException("Parsing not supported");
        }
        org.joda.time.a g10 = g(null);
        s sVar = new s(g10, this.f17154c);
        int parseInto = xVar.parseInto(sVar, str, 0);
        if (parseInto < 0) {
            parseInto = ~parseInto;
        } else if (parseInto >= str.length()) {
            long b3 = sVar.b(str);
            if (!this.f17155d || (num = sVar.e) == null) {
                DateTimeZone dateTimeZone = sVar.f17220d;
                if (dateTimeZone != null) {
                    g10 = g10.withZone(dateTimeZone);
                }
            } else {
                g10 = g10.withZone(DateTimeZone.forOffsetMillis(num.intValue()));
            }
            DateTime dateTime = new DateTime(b3, g10);
            DateTimeZone dateTimeZone2 = this.f17156f;
            return dateTimeZone2 != null ? dateTime.withZone(dateTimeZone2) : dateTime;
        }
        throw new IllegalArgumentException(u.e(parseInto, str));
    }

    public final LocalDateTime b(String str) {
        x xVar = this.f17153b;
        if (xVar == null) {
            throw new UnsupportedOperationException("Parsing not supported");
        }
        org.joda.time.a withUTC = g(null).withUTC();
        s sVar = new s(withUTC, this.f17154c);
        int parseInto = xVar.parseInto(sVar, str, 0);
        if (parseInto < 0) {
            parseInto = ~parseInto;
        } else if (parseInto >= str.length()) {
            long b3 = sVar.b(str);
            Integer num = sVar.e;
            if (num != null) {
                withUTC = withUTC.withZone(DateTimeZone.forOffsetMillis(num.intValue()));
            } else {
                DateTimeZone dateTimeZone = sVar.f17220d;
                if (dateTimeZone != null) {
                    withUTC = withUTC.withZone(dateTimeZone);
                }
            }
            return new LocalDateTime(b3, withUTC);
        }
        throw new IllegalArgumentException(u.e(parseInto, str));
    }

    public final long c(String str) {
        x xVar = this.f17153b;
        if (xVar == null) {
            throw new UnsupportedOperationException("Parsing not supported");
        }
        s sVar = new s(g(this.e), this.f17154c);
        int parseInto = xVar.parseInto(sVar, str, 0);
        if (parseInto < 0) {
            parseInto = ~parseInto;
        } else if (parseInto >= str.length()) {
            return sVar.b(str);
        }
        throw new IllegalArgumentException(u.e(parseInto, str.toString()));
    }

    public final String d(ai.c cVar) {
        z zVar = this.f17152a;
        if (zVar == null) {
            throw new UnsupportedOperationException("Printing not supported");
        }
        StringBuilder sb2 = new StringBuilder(zVar.estimatePrintedLength());
        try {
            AtomicReference atomicReference = org.joda.time.c.f17022a;
            f(sb2, cVar.getMillis(), org.joda.time.c.c(cVar));
        } catch (IOException unused) {
        }
        return sb2.toString();
    }

    public final String e(org.joda.time.j jVar) {
        z zVar = this.f17152a;
        if (zVar == null) {
            throw new UnsupportedOperationException("Printing not supported");
        }
        StringBuilder sb2 = new StringBuilder(zVar.estimatePrintedLength());
        if (zVar == null) {
            throw new UnsupportedOperationException("Printing not supported");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("The partial must not be null");
        }
        zVar.printTo(sb2, jVar, this.f17154c);
        return sb2.toString();
    }

    public final void f(Appendable appendable, long j4, org.joda.time.a aVar) {
        long j10 = j4;
        z zVar = this.f17152a;
        if (zVar == null) {
            throw new UnsupportedOperationException("Printing not supported");
        }
        org.joda.time.a g10 = g(aVar);
        DateTimeZone zone = g10.getZone();
        int offset = zone.getOffset(j10);
        long j11 = offset;
        long j12 = j10 + j11;
        if ((j10 ^ j12) >= 0 || (j11 ^ j10) < 0) {
            j10 = j12;
        } else {
            zone = DateTimeZone.UTC;
            offset = 0;
        }
        zVar.printTo(appendable, j10, g10.withUTC(), offset, zone, this.f17154c);
    }

    public final org.joda.time.a g(org.joda.time.a aVar) {
        AtomicReference atomicReference = org.joda.time.c.f17022a;
        if (aVar == null) {
            aVar = ISOChronology.getInstance();
        }
        org.joda.time.a aVar2 = this.e;
        if (aVar2 != null) {
            aVar = aVar2;
        }
        DateTimeZone dateTimeZone = this.f17156f;
        return dateTimeZone != null ? aVar.withZone(dateTimeZone) : aVar;
    }

    public final b h(org.joda.time.a aVar) {
        if (this.e == aVar) {
            return this;
        }
        return new b(this.f17152a, this.f17153b, this.f17154c, this.f17155d, aVar, this.f17156f);
    }

    public final b i(Locale locale) {
        Locale locale2 = this.f17154c;
        if (locale == locale2 || (locale != null && locale.equals(locale2))) {
            return this;
        }
        return new b(this.f17152a, this.f17153b, locale, this.f17155d, this.e, this.f17156f);
    }

    public final b j() {
        if (this.f17155d) {
            return this;
        }
        return new b(this.f17152a, this.f17153b, this.f17154c, true, this.e, null);
    }

    public final b k() {
        DateTimeZone dateTimeZone = DateTimeZone.UTC;
        if (this.f17156f == dateTimeZone) {
            return this;
        }
        return new b(this.f17152a, this.f17153b, this.f17154c, false, this.e, dateTimeZone);
    }

    public b(z zVar, x xVar, Locale locale, boolean z5, org.joda.time.a aVar, DateTimeZone dateTimeZone) {
        this.f17152a = zVar;
        this.f17153b = xVar;
        this.f17154c = locale;
        this.f17155d = z5;
        this.e = aVar;
        this.f17156f = dateTimeZone;
    }
}

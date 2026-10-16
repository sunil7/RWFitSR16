package ai;

import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.convert.ToString;
import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.Instant;
import org.joda.time.MutableDateTime;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.v;

/* loaded from: classes2.dex */
public abstract class c implements org.joda.time.h {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof org.joda.time.h)) {
            return false;
        }
        org.joda.time.h hVar = (org.joda.time.h) obj;
        return getMillis() == hVar.getMillis() && nf.a(getChronology(), hVar.getChronology());
    }

    @Override // org.joda.time.h
    public int get(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType != null) {
            return dateTimeFieldType.getField(getChronology()).get(getMillis());
        }
        throw new IllegalArgumentException("The DateTimeFieldType must not be null");
    }

    public DateTimeZone getZone() {
        return getChronology().getZone();
    }

    public int hashCode() {
        return getChronology().hashCode() + ((int) (getMillis() ^ (getMillis() >>> 32)));
    }

    public boolean isAfter(long j4) {
        return getMillis() > j4;
    }

    public boolean isAfterNow() {
        AtomicReference atomicReference = org.joda.time.c.f17022a;
        return isAfter(System.currentTimeMillis());
    }

    public boolean isBefore(long j4) {
        return getMillis() < j4;
    }

    public boolean isBeforeNow() {
        AtomicReference atomicReference = org.joda.time.c.f17022a;
        return isBefore(System.currentTimeMillis());
    }

    public boolean isEqual(long j4) {
        return getMillis() == j4;
    }

    public boolean isEqualNow() {
        AtomicReference atomicReference = org.joda.time.c.f17022a;
        return isEqual(System.currentTimeMillis());
    }

    public boolean isSupported(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null) {
            return false;
        }
        return dateTimeFieldType.getField(getChronology()).isSupported();
    }

    public Date toDate() {
        return new Date(getMillis());
    }

    public DateTime toDateTime() {
        return new DateTime(getMillis(), getZone());
    }

    public DateTime toDateTimeISO() {
        return new DateTime(getMillis(), ISOChronology.getInstance(getZone()));
    }

    @Override // org.joda.time.h
    public Instant toInstant() {
        return new Instant(getMillis());
    }

    public MutableDateTime toMutableDateTime() {
        return new MutableDateTime(getMillis(), getZone());
    }

    public MutableDateTime toMutableDateTimeISO() {
        return new MutableDateTime(getMillis(), ISOChronology.getInstance(getZone()));
    }

    public String toString(org.joda.time.format.b bVar) {
        return bVar == null ? toString() : bVar.d(this);
    }

    @Override // java.lang.Comparable
    public int compareTo(org.joda.time.h hVar) {
        if (this == hVar) {
            return 0;
        }
        long millis = hVar.getMillis();
        long millis2 = getMillis();
        if (millis2 == millis) {
            return 0;
        }
        return millis2 < millis ? -1 : 1;
    }

    public boolean isAfter(org.joda.time.h hVar) {
        return isAfter(org.joda.time.c.d(hVar));
    }

    @Override // org.joda.time.h
    public boolean isBefore(org.joda.time.h hVar) {
        return isBefore(org.joda.time.c.d(hVar));
    }

    public boolean isEqual(org.joda.time.h hVar) {
        return isEqual(org.joda.time.c.d(hVar));
    }

    public DateTime toDateTime(DateTimeZone dateTimeZone) {
        org.joda.time.a chronology = getChronology();
        AtomicReference atomicReference = org.joda.time.c.f17022a;
        if (chronology == null) {
            chronology = ISOChronology.getInstance();
        }
        return new DateTime(getMillis(), chronology.withZone(dateTimeZone));
    }

    public MutableDateTime toMutableDateTime(DateTimeZone dateTimeZone) {
        org.joda.time.a chronology = getChronology();
        AtomicReference atomicReference = org.joda.time.c.f17022a;
        if (chronology == null) {
            chronology = ISOChronology.getInstance();
        }
        return new MutableDateTime(getMillis(), chronology.withZone(dateTimeZone));
    }

    public int get(org.joda.time.b bVar) {
        if (bVar != null) {
            return bVar.get(getMillis());
        }
        throw new IllegalArgumentException("The DateTimeField must not be null");
    }

    @ToString
    public String toString() {
        return v.E.d(this);
    }

    public DateTime toDateTime(org.joda.time.a aVar) {
        return new DateTime(getMillis(), aVar);
    }

    public MutableDateTime toMutableDateTime(org.joda.time.a aVar) {
        return new MutableDateTime(getMillis(), aVar);
    }
}

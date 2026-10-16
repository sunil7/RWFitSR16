package org.joda.time.chrono;

import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationFieldType;
import org.joda.time.field.DelegatedDateTimeField;
import org.joda.time.field.SkipUndoDateTimeField;
import org.joda.time.field.UnsupportedDurationField;

/* loaded from: classes2.dex */
public final class BuddhistChronology extends AssembledChronology {
    public static final int BE = 1;
    public static final i K = new i();
    public static final ConcurrentHashMap L = new ConcurrentHashMap();
    public static final BuddhistChronology M = getInstance(DateTimeZone.UTC);
    private static final long serialVersionUID = -3474595157769370126L;

    public static BuddhistChronology getInstance() {
        return getInstance(DateTimeZone.getDefault());
    }

    public static BuddhistChronology getInstanceUTC() {
        return M;
    }

    private Object readResolve() {
        org.joda.time.a base = getBase();
        return base == null ? getInstanceUTC() : getInstance(base.getZone());
    }

    @Override // org.joda.time.chrono.AssembledChronology
    public void assemble(a aVar) {
        if (getParam() == null) {
            aVar.f17067l = UnsupportedDurationField.getInstance(DurationFieldType.eras());
            org.joda.time.field.f fVar = new org.joda.time.field.f(new SkipUndoDateTimeField(this, aVar.E), 543);
            aVar.E = fVar;
            aVar.F = new DelegatedDateTimeField(fVar, aVar.f17067l, DateTimeFieldType.yearOfEra());
            aVar.B = new org.joda.time.field.f(new SkipUndoDateTimeField(this, aVar.B), 543);
            org.joda.time.field.d dVar = new org.joda.time.field.d(new org.joda.time.field.f(aVar.F, 99), aVar.f17067l, DateTimeFieldType.centuryOfEra());
            aVar.H = dVar;
            aVar.f17066k = dVar.f17133d;
            aVar.G = new org.joda.time.field.f(new org.joda.time.field.i(dVar), DateTimeFieldType.yearOfCentury(), 1);
            aVar.C = new org.joda.time.field.f(new org.joda.time.field.i(aVar.B, aVar.f17066k, DateTimeFieldType.weekyearOfCentury()), DateTimeFieldType.weekyearOfCentury(), 1);
            aVar.I = K;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BuddhistChronology) {
            return getZone().equals(((BuddhistChronology) obj).getZone());
        }
        return false;
    }

    public int hashCode() {
        return getZone().hashCode() + 499287079;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public String toString() {
        DateTimeZone zone = getZone();
        if (zone == null) {
            return "BuddhistChronology";
        }
        return "BuddhistChronology[" + zone.getID() + ']';
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public org.joda.time.a withUTC() {
        return M;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public org.joda.time.a withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        return dateTimeZone == getZone() ? this : getInstance(dateTimeZone);
    }

    public static BuddhistChronology getInstance(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        ConcurrentHashMap concurrentHashMap = L;
        BuddhistChronology buddhistChronology = (BuddhistChronology) concurrentHashMap.get(dateTimeZone);
        if (buddhistChronology != null) {
            return buddhistChronology;
        }
        BuddhistChronology buddhistChronology2 = new BuddhistChronology(GJChronology.getInstance(dateTimeZone, null), null);
        BuddhistChronology buddhistChronology3 = new BuddhistChronology(LimitChronology.getInstance(buddhistChronology2, new DateTime(1, 1, 1, 0, 0, 0, 0, buddhistChronology2), null), "");
        BuddhistChronology buddhistChronology4 = (BuddhistChronology) concurrentHashMap.putIfAbsent(dateTimeZone, buddhistChronology3);
        return buddhistChronology4 != null ? buddhistChronology4 : buddhistChronology3;
    }
}

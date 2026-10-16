package org.joda.time.chrono;

import com.google.android.exoplayer2.Format;
import java.util.HashMap;
import org.joda.time.DateTimeZone;
import org.joda.time.IllegalInstantException;
import org.joda.time.field.BaseDurationField;

/* loaded from: classes2.dex */
public final class ZonedChronology extends AssembledChronology {
    private static final long serialVersionUID = -1079258847191166848L;

    public static ZonedChronology getInstance(org.joda.time.a aVar, DateTimeZone dateTimeZone) {
        if (aVar == null) {
            throw new IllegalArgumentException("Must supply a chronology");
        }
        org.joda.time.a withUTC = aVar.withUTC();
        if (withUTC == null) {
            throw new IllegalArgumentException("UTC chronology must not be null");
        }
        if (dateTimeZone != null) {
            return new ZonedChronology(withUTC, dateTimeZone);
        }
        throw new IllegalArgumentException("DateTimeZone must not be null");
    }

    public static boolean useTimeArithmetic(org.joda.time.e eVar) {
        return eVar != null && eVar.getUnitMillis() < 43200000;
    }

    @Override // org.joda.time.chrono.AssembledChronology
    public void assemble(a aVar) {
        HashMap hashMap = new HashMap();
        aVar.f17067l = c(aVar.f17067l, hashMap);
        aVar.f17066k = c(aVar.f17066k, hashMap);
        aVar.f17065j = c(aVar.f17065j, hashMap);
        aVar.f17064i = c(aVar.f17064i, hashMap);
        aVar.f17063h = c(aVar.f17063h, hashMap);
        aVar.f17062g = c(aVar.f17062g, hashMap);
        aVar.f17061f = c(aVar.f17061f, hashMap);
        aVar.e = c(aVar.e, hashMap);
        aVar.f17060d = c(aVar.f17060d, hashMap);
        aVar.f17059c = c(aVar.f17059c, hashMap);
        aVar.f17058b = c(aVar.f17058b, hashMap);
        aVar.f17057a = c(aVar.f17057a, hashMap);
        aVar.E = b(aVar.E, hashMap);
        aVar.F = b(aVar.F, hashMap);
        aVar.G = b(aVar.G, hashMap);
        aVar.H = b(aVar.H, hashMap);
        aVar.I = b(aVar.I, hashMap);
        aVar.f17078x = b(aVar.f17078x, hashMap);
        aVar.f17079y = b(aVar.f17079y, hashMap);
        aVar.f17080z = b(aVar.f17080z, hashMap);
        aVar.D = b(aVar.D, hashMap);
        aVar.A = b(aVar.A, hashMap);
        aVar.B = b(aVar.B, hashMap);
        aVar.C = b(aVar.C, hashMap);
        aVar.f17068m = b(aVar.f17068m, hashMap);
        aVar.f17069n = b(aVar.f17069n, hashMap);
        aVar.f17070o = b(aVar.f17070o, hashMap);
        aVar.f17071p = b(aVar.f17071p, hashMap);
        aVar.f17072q = b(aVar.f17072q, hashMap);
        aVar.r = b(aVar.r, hashMap);
        aVar.f17073s = b(aVar.f17073s, hashMap);
        aVar.f17075u = b(aVar.f17075u, hashMap);
        aVar.f17074t = b(aVar.f17074t, hashMap);
        aVar.f17076v = b(aVar.f17076v, hashMap);
        aVar.f17077w = b(aVar.f17077w, hashMap);
    }

    public final org.joda.time.b b(org.joda.time.b bVar, HashMap hashMap) {
        if (bVar == null || !bVar.isSupported()) {
            return bVar;
        }
        if (hashMap.containsKey(bVar)) {
            return (org.joda.time.b) hashMap.get(bVar);
        }
        o oVar = new o(bVar, getZone(), c(bVar.getDurationField(), hashMap), c(bVar.getRangeDurationField(), hashMap), c(bVar.getLeapDurationField(), hashMap));
        hashMap.put(bVar, oVar);
        return oVar;
    }

    public final org.joda.time.e c(org.joda.time.e eVar, HashMap hashMap) {
        if (eVar == null || !eVar.isSupported()) {
            return eVar;
        }
        if (hashMap.containsKey(eVar)) {
            return (org.joda.time.e) hashMap.get(eVar);
        }
        ZonedDurationField zonedDurationField = new ZonedDurationField(eVar, getZone());
        hashMap.put(eVar, zonedDurationField);
        return zonedDurationField;
    }

    public final long d(long j4) {
        if (j4 == Format.OFFSET_SAMPLE_RELATIVE) {
            return Format.OFFSET_SAMPLE_RELATIVE;
        }
        if (j4 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        DateTimeZone zone = getZone();
        int offsetFromLocal = zone.getOffsetFromLocal(j4);
        long j10 = j4 - offsetFromLocal;
        if (j4 > 604800000 && j10 < 0) {
            return Format.OFFSET_SAMPLE_RELATIVE;
        }
        if (j4 < -604800000 && j10 > 0) {
            return Long.MIN_VALUE;
        }
        if (offsetFromLocal == zone.getOffset(j10)) {
            return j10;
        }
        throw new IllegalInstantException(j4, zone.getID());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZonedChronology)) {
            return false;
        }
        ZonedChronology zonedChronology = (ZonedChronology) obj;
        return getBase().equals(zonedChronology.getBase()) && getZone().equals(zonedChronology.getZone());
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public long getDateTimeMillis(int i3, int i10, int i11, int i12) throws IllegalArgumentException {
        return d(getBase().getDateTimeMillis(i3, i10, i11, i12));
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public DateTimeZone getZone() {
        return (DateTimeZone) getParam();
    }

    public int hashCode() {
        return (getBase().hashCode() * 7) + (getZone().hashCode() * 11) + 326565;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public String toString() {
        return "ZonedChronology[" + getBase() + ", " + getZone().getID() + ']';
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public org.joda.time.a withUTC() {
        return getBase();
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public org.joda.time.a withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        return dateTimeZone == getParam() ? this : dateTimeZone == DateTimeZone.UTC ? getBase() : new ZonedChronology(getBase(), dateTimeZone);
    }

    public static class ZonedDurationField extends BaseDurationField {
        private static final long serialVersionUID = -485345310999208286L;
        final org.joda.time.e iField;
        final boolean iTimeField;
        final DateTimeZone iZone;

        public ZonedDurationField(org.joda.time.e eVar, DateTimeZone dateTimeZone) {
            super(eVar.getType());
            if (!eVar.isSupported()) {
                throw new IllegalArgumentException();
            }
            this.iField = eVar;
            this.iTimeField = ZonedChronology.useTimeArithmetic(eVar);
            this.iZone = dateTimeZone;
        }

        public final int a(long j4) {
            int offsetFromLocal = this.iZone.getOffsetFromLocal(j4);
            long j10 = offsetFromLocal;
            if (((j4 - j10) ^ j4) >= 0 || (j4 ^ j10) >= 0) {
                return offsetFromLocal;
            }
            throw new ArithmeticException("Subtracting time zone offset caused overflow");
        }

        @Override // org.joda.time.e
        public long add(long j4, int i3) {
            int b3 = b(j4);
            long add = this.iField.add(j4 + b3, i3);
            if (!this.iTimeField) {
                b3 = a(add);
            }
            return add - b3;
        }

        public final int b(long j4) {
            int offset = this.iZone.getOffset(j4);
            long j10 = offset;
            if (((j4 + j10) ^ j4) >= 0 || (j4 ^ j10) < 0) {
                return offset;
            }
            throw new ArithmeticException("Adding time zone offset caused overflow");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ZonedDurationField) {
                ZonedDurationField zonedDurationField = (ZonedDurationField) obj;
                if (this.iField.equals(zonedDurationField.iField) && this.iZone.equals(zonedDurationField.iZone)) {
                    return true;
                }
            }
            return false;
        }

        @Override // org.joda.time.field.BaseDurationField, org.joda.time.e
        public int getDifference(long j4, long j10) {
            return this.iField.getDifference(j4 + (this.iTimeField ? r0 : b(j4)), j10 + b(j10));
        }

        @Override // org.joda.time.e
        public long getDifferenceAsLong(long j4, long j10) {
            return this.iField.getDifferenceAsLong(j4 + (this.iTimeField ? r0 : b(j4)), j10 + b(j10));
        }

        @Override // org.joda.time.e
        public long getMillis(int i3, long j4) {
            return this.iField.getMillis(i3, this.iZone.convertUTCToLocal(j4));
        }

        @Override // org.joda.time.e
        public long getUnitMillis() {
            return this.iField.getUnitMillis();
        }

        @Override // org.joda.time.field.BaseDurationField, org.joda.time.e
        public int getValue(long j4, long j10) {
            return this.iField.getValue(j4, this.iZone.convertUTCToLocal(j10));
        }

        @Override // org.joda.time.e
        public long getValueAsLong(long j4, long j10) {
            return this.iField.getValueAsLong(j4, this.iZone.convertUTCToLocal(j10));
        }

        public int hashCode() {
            return this.iField.hashCode() ^ this.iZone.hashCode();
        }

        @Override // org.joda.time.e
        public boolean isPrecise() {
            return this.iTimeField ? this.iField.isPrecise() : this.iField.isPrecise() && this.iZone.isFixed();
        }

        @Override // org.joda.time.e
        public long add(long j4, long j10) {
            int b3 = b(j4);
            long add = this.iField.add(j4 + b3, j10);
            if (!this.iTimeField) {
                b3 = a(add);
            }
            return add - b3;
        }

        @Override // org.joda.time.e
        public long getMillis(long j4, long j10) {
            return this.iField.getMillis(j4, this.iZone.convertUTCToLocal(j10));
        }
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public long getDateTimeMillis(int i3, int i10, int i11, int i12, int i13, int i14, int i15) throws IllegalArgumentException {
        return d(getBase().getDateTimeMillis(i3, i10, i11, i12, i13, i14, i15));
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public long getDateTimeMillis(long j4, int i3, int i10, int i11, int i12) throws IllegalArgumentException {
        return d(getBase().getDateTimeMillis(getZone().getOffset(j4) + j4, i3, i10, i11, i12));
    }
}

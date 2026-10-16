package org.joda.time.chrono;

import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import java.io.IOException;
import java.util.HashMap;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.MutableDateTime;
import org.joda.time.field.DecoratedDurationField;
import org.joda.time.format.v;

/* loaded from: classes2.dex */
public final class LimitChronology extends AssembledChronology {
    private static final long serialVersionUID = 7670866536893052522L;
    public transient LimitChronology K;
    final DateTime iLowerLimit;
    final DateTime iUpperLimit;

    public class LimitException extends IllegalArgumentException {
        private static final long serialVersionUID = -5924689995607498581L;
        private final boolean iIsLow;

        public LimitException(String str, boolean z5) {
            super(str);
            this.iIsLow = z5;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            StringBuffer stringBuffer = new StringBuffer(85);
            stringBuffer.append("The");
            String message = super.getMessage();
            if (message != null) {
                stringBuffer.append(' ');
                stringBuffer.append(message);
            }
            stringBuffer.append(" instant is ");
            org.joda.time.format.b h4 = v.E.h(LimitChronology.this.getBase());
            try {
                if (this.iIsLow) {
                    stringBuffer.append("below the supported minimum of ");
                    h4.f(stringBuffer, LimitChronology.this.getLowerLimit().getMillis(), null);
                } else {
                    stringBuffer.append("above the supported maximum of ");
                    h4.f(stringBuffer, LimitChronology.this.getUpperLimit().getMillis(), null);
                }
            } catch (IOException unused) {
            }
            stringBuffer.append(" (");
            stringBuffer.append(LimitChronology.this.getBase());
            stringBuffer.append(')');
            return stringBuffer.toString();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "IllegalArgumentException: " + getMessage();
        }
    }

    public LimitChronology(org.joda.time.a aVar, DateTime dateTime, DateTime dateTime2) {
        super(aVar, null);
        this.iLowerLimit = dateTime;
        this.iUpperLimit = dateTime2;
    }

    public static LimitChronology getInstance(org.joda.time.a aVar, org.joda.time.f fVar, org.joda.time.f fVar2) {
        if (aVar == null) {
            throw new IllegalArgumentException("Must supply a chronology");
        }
        DateTime dateTime = fVar == null ? null : fVar.toDateTime();
        DateTime dateTime2 = fVar2 != null ? fVar2.toDateTime() : null;
        if (dateTime == null || dateTime2 == null || dateTime.isBefore(dateTime2)) {
            return new LimitChronology(aVar, dateTime, dateTime2);
        }
        throw new IllegalArgumentException("The lower limit must be come before than the upper limit");
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
        n nVar = new n(this, bVar, c(bVar.getDurationField(), hashMap), c(bVar.getRangeDurationField(), hashMap), c(bVar.getLeapDurationField(), hashMap));
        hashMap.put(bVar, nVar);
        return nVar;
    }

    public final org.joda.time.e c(org.joda.time.e eVar, HashMap hashMap) {
        if (eVar == null || !eVar.isSupported()) {
            return eVar;
        }
        if (hashMap.containsKey(eVar)) {
            return (org.joda.time.e) hashMap.get(eVar);
        }
        LimitDurationField limitDurationField = new LimitDurationField(eVar);
        hashMap.put(eVar, limitDurationField);
        return limitDurationField;
    }

    public void checkLimits(long j4, String str) {
        DateTime dateTime = this.iLowerLimit;
        if (dateTime != null && j4 < dateTime.getMillis()) {
            throw new LimitException(str, true);
        }
        DateTime dateTime2 = this.iUpperLimit;
        if (dateTime2 != null && j4 >= dateTime2.getMillis()) {
            throw new LimitException(str, false);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LimitChronology)) {
            return false;
        }
        LimitChronology limitChronology = (LimitChronology) obj;
        return getBase().equals(limitChronology.getBase()) && nf.a(getLowerLimit(), limitChronology.getLowerLimit()) && nf.a(getUpperLimit(), limitChronology.getUpperLimit());
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public long getDateTimeMillis(int i3, int i10, int i11, int i12) throws IllegalArgumentException {
        long dateTimeMillis = getBase().getDateTimeMillis(i3, i10, i11, i12);
        checkLimits(dateTimeMillis, "resulting");
        return dateTimeMillis;
    }

    public DateTime getLowerLimit() {
        return this.iLowerLimit;
    }

    public DateTime getUpperLimit() {
        return this.iUpperLimit;
    }

    public int hashCode() {
        return (getBase().hashCode() * 7) + (getLowerLimit() != null ? getLowerLimit().hashCode() : 0) + 317351877 + (getUpperLimit() != null ? getUpperLimit().hashCode() : 0);
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public String toString() {
        StringBuilder sb2 = new StringBuilder("LimitChronology[");
        sb2.append(getBase().toString());
        sb2.append(", ");
        sb2.append(getLowerLimit() == null ? "NoLimit" : getLowerLimit().toString());
        sb2.append(", ");
        sb2.append(getUpperLimit() != null ? getUpperLimit().toString() : "NoLimit");
        sb2.append(']');
        return sb2.toString();
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public org.joda.time.a withUTC() {
        return withZone(DateTimeZone.UTC);
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public org.joda.time.a withZone(DateTimeZone dateTimeZone) {
        LimitChronology limitChronology;
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        if (dateTimeZone == getZone()) {
            return this;
        }
        DateTimeZone dateTimeZone2 = DateTimeZone.UTC;
        if (dateTimeZone == dateTimeZone2 && (limitChronology = this.K) != null) {
            return limitChronology;
        }
        DateTime dateTime = this.iLowerLimit;
        if (dateTime != null) {
            MutableDateTime mutableDateTime = dateTime.toMutableDateTime();
            mutableDateTime.setZoneRetainFields(dateTimeZone);
            dateTime = mutableDateTime.toDateTime();
        }
        DateTime dateTime2 = this.iUpperLimit;
        if (dateTime2 != null) {
            MutableDateTime mutableDateTime2 = dateTime2.toMutableDateTime();
            mutableDateTime2.setZoneRetainFields(dateTimeZone);
            dateTime2 = mutableDateTime2.toDateTime();
        }
        LimitChronology limitChronology2 = getInstance(getBase().withZone(dateTimeZone), dateTime, dateTime2);
        if (dateTimeZone == dateTimeZone2) {
            this.K = limitChronology2;
        }
        return limitChronology2;
    }

    public class LimitDurationField extends DecoratedDurationField {
        private static final long serialVersionUID = 8049297699408782284L;

        public LimitDurationField(org.joda.time.e eVar) {
            super(eVar, eVar.getType());
        }

        @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.e
        public long add(long j4, int i3) {
            LimitChronology.this.checkLimits(j4, null);
            long add = getWrappedField().add(j4, i3);
            LimitChronology.this.checkLimits(add, "resulting");
            return add;
        }

        @Override // org.joda.time.field.BaseDurationField, org.joda.time.e
        public int getDifference(long j4, long j10) {
            LimitChronology.this.checkLimits(j4, "minuend");
            LimitChronology.this.checkLimits(j10, "subtrahend");
            return getWrappedField().getDifference(j4, j10);
        }

        @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.e
        public long getDifferenceAsLong(long j4, long j10) {
            LimitChronology.this.checkLimits(j4, "minuend");
            LimitChronology.this.checkLimits(j10, "subtrahend");
            return getWrappedField().getDifferenceAsLong(j4, j10);
        }

        @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.e
        public long getMillis(int i3, long j4) {
            LimitChronology.this.checkLimits(j4, null);
            return getWrappedField().getMillis(i3, j4);
        }

        @Override // org.joda.time.field.BaseDurationField, org.joda.time.e
        public int getValue(long j4, long j10) {
            LimitChronology.this.checkLimits(j10, null);
            return getWrappedField().getValue(j4, j10);
        }

        @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.e
        public long getValueAsLong(long j4, long j10) {
            LimitChronology.this.checkLimits(j10, null);
            return getWrappedField().getValueAsLong(j4, j10);
        }

        @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.e
        public long getMillis(long j4, long j10) {
            LimitChronology.this.checkLimits(j10, null);
            return getWrappedField().getMillis(j4, j10);
        }

        @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.e
        public long add(long j4, long j10) {
            LimitChronology.this.checkLimits(j4, null);
            long add = getWrappedField().add(j4, j10);
            LimitChronology.this.checkLimits(add, "resulting");
            return add;
        }
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public long getDateTimeMillis(int i3, int i10, int i11, int i12, int i13, int i14, int i15) throws IllegalArgumentException {
        long dateTimeMillis = getBase().getDateTimeMillis(i3, i10, i11, i12, i13, i14, i15);
        checkLimits(dateTimeMillis, "resulting");
        return dateTimeMillis;
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public long getDateTimeMillis(long j4, int i3, int i10, int i11, int i12) throws IllegalArgumentException {
        checkLimits(j4, null);
        long dateTimeMillis = getBase().getDateTimeMillis(j4, i3, i10, i11, i12);
        checkLimits(dateTimeMillis, "resulting");
        return dateTimeMillis;
    }
}

package ai;

import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.joda.time.MutableInterval;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.v;
import org.joda.time.i;

/* loaded from: classes2.dex */
public abstract class d implements i {
    public void checkInterval(long j4, long j10) {
        if (j10 < j4) {
            throw new IllegalArgumentException("The end instant must be greater than the start instant");
        }
    }

    public boolean contains(long j4) {
        return j4 >= getStartMillis() && j4 < getEndMillis();
    }

    public boolean containsNow() {
        AtomicReference atomicReference = org.joda.time.c.f17022a;
        return contains(System.currentTimeMillis());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return getStartMillis() == iVar.getStartMillis() && getEndMillis() == iVar.getEndMillis() && nf.a(getChronology(), iVar.getChronology());
    }

    @Override // org.joda.time.i
    public DateTime getEnd() {
        return new DateTime(getEndMillis(), getChronology());
    }

    @Override // org.joda.time.i
    public DateTime getStart() {
        return new DateTime(getStartMillis(), getChronology());
    }

    public int hashCode() {
        long startMillis = getStartMillis();
        long endMillis = getEndMillis();
        return getChronology().hashCode() + ((((3007 + ((int) (startMillis ^ (startMillis >>> 32)))) * 31) + ((int) (endMillis ^ (endMillis >>> 32)))) * 31);
    }

    public boolean isAfter(long j4) {
        return getStartMillis() > j4;
    }

    public boolean isAfterNow() {
        AtomicReference atomicReference = org.joda.time.c.f17022a;
        return isAfter(System.currentTimeMillis());
    }

    public boolean isBefore(long j4) {
        return getEndMillis() <= j4;
    }

    public boolean isBeforeNow() {
        AtomicReference atomicReference = org.joda.time.c.f17022a;
        return isBefore(System.currentTimeMillis());
    }

    public boolean isEqual(i iVar) {
        return getStartMillis() == iVar.getStartMillis() && getEndMillis() == iVar.getEndMillis();
    }

    public boolean overlaps(i iVar) {
        long startMillis = getStartMillis();
        long endMillis = getEndMillis();
        if (iVar != null) {
            return startMillis < iVar.getEndMillis() && iVar.getStartMillis() < endMillis;
        }
        AtomicReference atomicReference = org.joda.time.c.f17022a;
        long currentTimeMillis = System.currentTimeMillis();
        return startMillis < currentTimeMillis && currentTimeMillis < endMillis;
    }

    public Duration toDuration() {
        long durationMillis = toDurationMillis();
        return durationMillis == 0 ? Duration.ZERO : new Duration(durationMillis);
    }

    @Override // org.joda.time.i
    public long toDurationMillis() {
        return nf.i(getEndMillis(), getStartMillis());
    }

    public Interval toInterval() {
        return new Interval(getStartMillis(), getEndMillis(), getChronology());
    }

    public MutableInterval toMutableInterval() {
        return new MutableInterval(getStartMillis(), getEndMillis(), getChronology());
    }

    public Period toPeriod() {
        return new Period(getStartMillis(), getEndMillis(), getChronology());
    }

    public String toString() {
        org.joda.time.format.b h4 = v.E.h(getChronology());
        StringBuffer stringBuffer = new StringBuffer(48);
        try {
            h4.f(stringBuffer, getStartMillis(), null);
        } catch (IOException unused) {
        }
        stringBuffer.append('/');
        try {
            h4.f(stringBuffer, getEndMillis(), null);
        } catch (IOException unused2) {
        }
        return stringBuffer.toString();
    }

    public boolean isAfter(org.joda.time.h hVar) {
        return hVar == null ? isAfterNow() : isAfter(hVar.getMillis());
    }

    public boolean isBefore(org.joda.time.h hVar) {
        return hVar == null ? isBeforeNow() : isBefore(hVar.getMillis());
    }

    @Override // org.joda.time.i
    public Period toPeriod(PeriodType periodType) {
        return new Period(getStartMillis(), getEndMillis(), periodType, getChronology());
    }

    public boolean contains(org.joda.time.h hVar) {
        if (hVar == null) {
            return containsNow();
        }
        return contains(hVar.getMillis());
    }

    public boolean isAfter(i iVar) {
        long endMillis;
        if (iVar == null) {
            AtomicReference atomicReference = org.joda.time.c.f17022a;
            endMillis = System.currentTimeMillis();
        } else {
            endMillis = iVar.getEndMillis();
        }
        return getStartMillis() >= endMillis;
    }

    public boolean isBefore(i iVar) {
        if (iVar == null) {
            return isBeforeNow();
        }
        return isBefore(iVar.getStartMillis());
    }

    public boolean contains(i iVar) {
        if (iVar == null) {
            return containsNow();
        }
        long startMillis = iVar.getStartMillis();
        long endMillis = iVar.getEndMillis();
        long startMillis2 = getStartMillis();
        long endMillis2 = getEndMillis();
        return startMillis2 <= startMillis && startMillis < endMillis2 && endMillis <= endMillis2;
    }
}
